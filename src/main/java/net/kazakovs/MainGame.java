package net.kazakovs;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by kazak on 3/2/2016.
 */
public class MainGame {
    public static String currentAnswer="";
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        IJavinator ja = new RegexpJavinator();
        System.out.println("Would you like to play a game? (yes/no): ");
        switch (Javinator.getAnswerID(scan.next())){
            case 1:
                System.exit(0);
            case 0:
                ja.startSession();
        }

        while(!currentAnswer.equalsIgnoreCase("exit") && !ja.haveGuess()){
            System.out.printf("Question %s : %s \n\t", ja.getStep(), ja.getCurrentQuestion());
            currentAnswer = scan.next();
            ja.sendAnswer(currentAnswer);
        }
        
        if(ja.haveGuess()){
            System.out.println("Here are some guesses: ");
            String[] guesses = ja.getAllGuesses();
            Arrays.sort(guesses);
            for(String str : guesses){
                System.out.println(str);
            }
        } else {
            System.out.println("Unfortunately, Nothing :( ");
        }
        ja.endSession();

    }

}
