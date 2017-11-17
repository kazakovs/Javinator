package net.kazakovs.enity;

import lombok.Data;

@Data
public class Identification {
    private Integer channel;
    private Integer session;
    private Integer signature;
}
