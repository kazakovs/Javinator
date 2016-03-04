package net.kazakovs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kazak on 3/3/2016.
 */
public class RegexpJavinator implements IJavinator {

    private Integer step;
    private String currentQuestion;
    private String currentAnswer;
    private Integer session;
    private Integer signature;

    private final String CORE_URL = "http://api-en1.akinator.com/ws/";

    public Integer startSession() {

        String url = CORE_URL+"new_session?partner=1&player=Javinator";
        String request = sendRequest(url);
        System.out.println("response: " +  request );

        this.session = Integer.parseInt(extractString("session", request));
        this.step=0;
        this.signature = Integer.parseInt(extractString("signature", request));
        this.currentQuestion=extractString("question", request);
        System.out.println("question: " + currentQuestion);
        return 0;
    }

    private String extractString(String prop, String str) {

        Pattern patt = Pattern.compile("\"" + prop + "\"\\s*:\\s*\"([^,]*)\"");
        Matcher matcher = patt.matcher(str);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public String sendAnswer(String answer) {
        String url = CORE_URL+"answer?session=" + this.session +
                "&signature=" + this.signature +
                "&step=" + (this.step++) +
                "&answer=" + getAnswerID(answer);
        String resp = sendRequest(url);
        this.currentQuestion = extractString("question", resp);

        return this.currentQuestion;
    }

    private Integer getAnswerID(String answer) {
        return Javinator.getAnswerID(answer);
    }

    public Integer endSession() {
        return null;
    }

    public String[] getAllGuesses() {
        return new String[0];
    }

    public Boolean haveGuess() {
        return Boolean.FALSE;
    }

    public Integer getStep() {
        return step;
    }

    public String getCurrentQuestion() {
        return currentQuestion;
    }

    private String sendRequest(String url){
        StringBuilder sb = new StringBuilder();
        try {
            URL reqURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) reqURL.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
