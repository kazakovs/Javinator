package net.kazakovs;

import java.util.Arrays;
import java.util.Scanner;

public class MainGame {
    private static String currentAnswer="";

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Javinator javinator = new JavinatorImpl();
        System.out.println("Would you like to play a game? (yes/no): ");
        switch (Javinator.getAnswerID(scan.next())){
            case 1:
                System.exit(0);
            case 0:
                javinator.startSession();
        }

        while(!currentAnswer.equalsIgnoreCase("exit") && !javinator.haveGuess()){
            System.out.printf("Question %s : %s \n\t", javinator.getStep(), javinator.getCurrentQuestion());
            currentAnswer = scan.next();
            javinator.sendAnswer(currentAnswer);
        }
        
        if(javinator.haveGuess()){
            System.out.println("Here are some guesses: ");
            String[] guesses = javinator.getAllGuesses();
            Arrays.sort(guesses);
            for(String str : guesses){
                System.out.println(str);
            }
        } else {
            System.out.println("Unfortunately, Nothing :( ");
        }
        javinator.endSession();

    }

}
