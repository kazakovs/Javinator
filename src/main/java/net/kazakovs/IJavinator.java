package net.kazakovs;

public interface IJavinator {
    Integer startSession();
    String sendAnswer(String answer);
    Integer endSession();
    String[] getAllGuesses();
    Boolean haveGuess();
    Integer getStep();
    String getCurrentQuestion();
}
