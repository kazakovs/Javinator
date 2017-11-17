package net.kazakovs.enity;

import lombok.Data;

import java.util.Arrays;

@Data
public class Parameters {
    private Identification identification;
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
