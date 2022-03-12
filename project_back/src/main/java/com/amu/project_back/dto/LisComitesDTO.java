package com.amu.project_back.dto;

public class LisComitesDTO {
    private Long lisComId;
    private String lisComLabel;
    private String lisComAcronyme;

    public Long getLisComId() {
        return this.lisComId;
    }

    public void setLisComId(Long lisComId) {
        this.lisComId = lisComId;
    }

    public String getLisComLabel() {
        return this.lisComLabel;
    }

    public void setLisComLabel(String lisComLabel) {
        this.lisComLabel = lisComLabel;
    }

    public String getLisComAcronyme() {
        return this.lisComAcronyme;
    }

    public void setLisComAcronyme(String lisComAcronyme) {
        this.lisComAcronyme = lisComAcronyme;
    }
}
