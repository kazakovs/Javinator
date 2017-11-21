package net.kazakovs;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.kazakovs.enity.Elements;
import net.kazakovs.enity.Response;

public class JavinatorImpl implements Javinator {

    private Response currentResponse;
    private boolean started=false;
    private double threshold;

    private static final double DEFAULT_THRESHOLD=95.0;

    private String currentQuestion="";
    private Integer step;
    private Integer session;
    private Integer signature;

    public String getCurrentQuestion() {
        return currentQuestion;
    }

    private void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    private int getSession() {
        return session;
    }

    private int getSignature() {
        return signature;
    }

    private ObjectMapper mapper = new ObjectMapper();
    private final String USER_AGENT = "Mozilla/5.0";
    private final String CORE_URL = "http://api-en1.akinator.com/ws/";

    public JavinatorImpl(double threshold){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.threshold = threshold;
    }

    public JavinatorImpl(){
        this(DEFAULT_THRESHOLD);
    }


    private double getProgression() {
        if(getCurrentResponse().getParameters().getStepInformation()==null)
            return getCurrentResponse().getParameters().getProgression();
        else
            return getCurrentResponse().getParameters().getStepInformation().getProgression();
    }

    public Boolean haveGuess(){
        String[] g = null;
        if(getProgression() > threshold){
            g = getAllGuesses();
        }
        return g != null && g.length > 0 ;
    }

    public String[] getAllGuesses(){
        String url = buildGuessRetrieveUrl();

        Response response = sendRequest(url);

        return response == null ? null :
                extractGuessesFromResponse(response);
    }

    private String buildGuessRetrieveUrl(){
        return CORE_URL+"list?session=" + getSession() +
                "&signature=" + getSignature() +
                "&step=" + getStep() +
                "&mode_question=0";
    }

    private String[] extractGuessesFromResponse(Response response){
        List<Elements> guessElements = Arrays.asList(response.getParameters().getElements());
        return guessElements.stream()
                .map(s -> s.getElement().getName())
                .collect(Collectors.toList()).toArray(new String[guessElements.size()]);
    }

    public Integer getStep() {
        return step;
    }

    private Response getCurrentResponse() {
        return currentResponse;
    }

    public Integer startSession() {

        String url = CORE_URL+"new_session?partner=1&player=JavinatorImpl";
        Response response = sendRequest(url);
        currentResponse = Optional.ofNullable(response).orElse(new Response());
        session = currentResponse.getParameters().getIdentification().getSession();
        signature = currentResponse.getParameters().getIdentification().getSignature();
        started=true;
        step=0;
        currentQuestion=getQuestion();
        return 0;

    }

    private String getQuestion() {
        if(this.started) {
            return  currentResponse.getParameters().getQuestion() == null
                    ?
                    currentResponse.getParameters().getStepInformation().getQuestion()
                    :
                    currentResponse.getParameters().getQuestion();
        }
        return null;
    }

    public String sendAnswer(String answer) {

        String url = CORE_URL+"answer?session=" + getSession() +
                "&signature=" + getSignature() +
                "&step=" + getAndIncreaseStep() +
                "&answer=" + Javinator.getAnswerID(answer);
        currentResponse=sendRequest(url);
        setCurrentQuestion(getQuestion());
        return getCurrentQuestion();

    }

    private int getAndIncreaseStep(){
        return step++;
    }

    public Integer endSession() {
        session=null;
        step=null;
        return null;
    }

    private Response sendRequest(String url){
        try {
            return mapper.readValue(new URL(url), Response.class);
        } catch (IOException e) {
            System.out.println("ERROR!!!" + e.getLocalizedMessage());
        }
        return null;
    }

}
