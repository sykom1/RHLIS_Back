package com.amu.project_back.dto;

public class LisEquipesDTO {
    private Long equipesId;
    private String equipesLabel;
    private String equipesNomLong;

    public Long getEquipesId() {
        return this.equipesId;
    }

    public void setEquipesId(Long equipesId) {
        this.equipesId = equipesId;
    }

    public String getEquipesLabel() {
        return this.equipesLabel;
    }

    public void setEquipesLabel(String equipesLabel) {
        this.equipesLabel = equipesLabel;
    }

    public String getEquipesNomLong() {
        return this.equipesNomLong;
    }

    public void setEquipesNomLong(String equipesNomLong) {
        this.equipesNomLong = equipesNomLong;
    }
}
