package net.kazakovs.enity;

import lombok.Data;

@Data
public class StepInformation {
    private String question;
    private Answer[] answers;
    private Integer step;
    private Double progression;
    private Integer questionId;
    private Double infogain;
}

