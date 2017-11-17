package net.kazakovs.enity;

import lombok.Data;

@Data
public class Element implements Comparable{

    private Integer id;
    private String name;
    private Integer idBase;
    private Double proba;
    private String description;
    private Integer valideContrainte;
    private Integer ranking;
    private Integer minibaseAddable;
    private Integer relativeId;
    private String pseudo;
    private String picturePath;
    private String absolutePicturePath;

    @Override
    public int compareTo(Object o) {
        return this.getProba().compareTo(((Element)o).getProba());
    }
}
