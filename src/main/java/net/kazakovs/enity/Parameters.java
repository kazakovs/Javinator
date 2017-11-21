package net.kazakovs.enity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Parameters {
    private Identification identification;
    @JsonProperty("step_information")
    private StepInformation stepInformation;
    private String question;
    private Answer[] answers;
    private Integer step;
    private Double progression;
    private Integer questionId;
    private Double infogain;
    private Elements[] elements;
    private Integer nbObjetsPertinents;
}
