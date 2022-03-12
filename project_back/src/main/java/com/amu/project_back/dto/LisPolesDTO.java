package com.amu.project_back.dto;

public class LisPolesDTO {
    private Long polesId;
    private String polesLabel;
    private String equipesId;

    public Long getPolesId() {
        return this.polesId;
    }

    public void setPolesId(Long polesId) {
        this.polesId = polesId;
    }

    public String getPolesLabel() {
        return this.polesLabel;
    }

    public void setPolesLabel(String polesLabel) {
        this.polesLabel = polesLabel;
    }

    public String getEquipesId() {
        return this.equipesId;
    }

    public void setEquipesId(String equipesId) {
        this.equipesId = equipesId;
    }
}
