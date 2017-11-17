package net.kazakovs.enity;

public class Answer {
    private String answer;

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                '}' + '\n';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}