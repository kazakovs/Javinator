package net.kazakovs;

import java.util.Arrays;

/**
 * Created by kazak on 2/25/2016.
 */
public class Response {

    private String completion;

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    private Parameters parameters;

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Response{" +
                "completion='" + completion + '\'' +
                ", parameters=" + parameters +
                '}' + '\n';
    }
}



class Parameters {
    @Override
    public String toString() {
        return "Parameters{" +
                "identification=" + identification +
                ", step_information=" + step_information +
                ", question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", step=" + step +
                ", progression=" + progression +
                ", questionid=" + questionid +
                ", infogain=" + infogain +
                ", status_minibase=" + status_minibase +
                '}' + '\n';
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Step_Information getStep_information() {
        return step_information;
    }

    public void setStep_information(Step_Information step_information) {
        this.step_information = step_information;
    }

    private Identification identification;
    private Step_Information step_information;

    private String question;
    private Answer[] answers;
    private Integer step;
    private Double progression;
    private Integer questionid;
    private Double infogain;

    private Elements[] elements;
    private Integer NbObjetsPertinents;

    public Elements[] getElements() {
        return elements;
    }

    public void setElements(Elements[] elements) {
        this.elements = elements;
    }

    public Integer getNbObjetsPertinents() {
        return NbObjetsPertinents;
    }

    public void setNbObjetsPertinents(Integer nbObjetsPertinents) {
        this.NbObjetsPertinents = nbObjetsPertinents;
    }

    public Integer getStatus_minibase() {
        return status_minibase;
    }

    public void setStatus_minibase(Integer status_minibase) {
        this.status_minibase = status_minibase;
    }

    private Integer status_minibase;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Double getProgression() {
        return progression;
    }

    public void setProgression(Double progression) {
        this.progression = progression;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Double getInfogain() {
        return infogain;
    }

    public void setInfogain(Double infogain) {
        this.infogain = infogain;
    }

}

class Elements {
    private Element element;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}

class Element implements Comparable{

    private Integer id;
    private String name;
    private Integer id_base;
    private Double proba;
    private String description;
    private Integer valide_contrainte;
    private Integer ranking;
    private Integer minibase_addable;
    private Integer relative_id;
    private String pseudo;
    private String picture_path;
    private String absolute_picture_path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_base() {
        return id_base;
    }

    public void setId_base(Integer id_base) {
        this.id_base = id_base;
    }

    public Double getProba() {
        return proba;
    }

    public void setProba(Double proba) {
        this.proba = proba;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValide_contrainte() {
        return valide_contrainte;
    }

    public void setValide_contrainte(Integer valide_contrainte) {
        this.valide_contrainte = valide_contrainte;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getMinibase_addable() {
        return minibase_addable;
    }

    public void setMinibase_addable(Integer minibase_addable) {
        this.minibase_addable = minibase_addable;
    }

    public Integer getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(Integer relative_id) {
        this.relative_id = relative_id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public String getAbsolute_picture_path() {
        return absolute_picture_path;
    }

    public void setAbsolute_picture_path(String absolute_picture_path) {
        this.absolute_picture_path = absolute_picture_path;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_base=" + id_base +
                ", proba=" + proba +
                ", description='" + description + '\'' +
                ", valide_contrainte=" + valide_contrainte +
                ", ranking=" + ranking +
                ", minibase_addable=" + minibase_addable +
                ", relative_id=" + relative_id +
                ", pseudo='" + pseudo + '\'' +
                ", picture_path='" + picture_path + '\'' +
                ", absolute_picture_path='" + absolute_picture_path + '\'' +
                "}\n";
    }


    @Override
    public int compareTo(Object o) {
        return (this.getProba() - ((Element)o).getProba())>=0?1:-1;
    }
}

class Identification {
    private Integer channel;
    private Integer session;
    private Integer signature;

    @Override
    public String toString() {
        return "Identification{" +
                "channel=" + channel +
                ", session=" + session +
                ", signature=" + signature +
                '}' + '\n';
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }
}

class Step_Information {
    private String question;
    private Answer[] answers;
    private Integer step;
    private Double progression;
    private Integer questionid;
    private Double infogain;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Double getProgression() {
        return progression;
    }

    public void setProgression(Double progression) {
        this.progression = progression;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Double getInfogain() {
        return infogain;
    }

    public void setInfogain(Double infogain) {
        this.infogain = infogain;
    }

    @Override
    public String toString() {
        return "Step_Information{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", step=" + step +
                ", progression=" + progression +
                ", questionid=" + questionid +
                ", infogain=" + infogain +
                '}' + '\n';
    }
}

class Answer {
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
