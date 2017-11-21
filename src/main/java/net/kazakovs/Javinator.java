package net.kazakovs;

public interface Javinator {
    Integer startSession();
    String sendAnswer(String answer);
    Integer endSession();
    String[] getAllGuesses();
    Boolean haveGuess();
    Integer getStep();
    String getCurrentQuestion();
    static int getAnswerID(String ans){
        int id = 0;
        switch (ans.toLowerCase()){
            case "yes":
            case "y":{
                id = 0;
                break;
            }
            case "no":
            case "n":{
                id = 1;
                break;
            }
            case "dontknow":
            case "d":{
                id = 2;
                break;
            }
            case "probably":
            case "p":{
                id = 3;
                break;
            }
            case "probablynot":
            case "pn":{
                id = 4;
                break;
            }
        }
        return id;
    }

}
