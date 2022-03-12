package com.amu.project_back.dto;

public class LisComitesHasAnnuaireDTO {
    private Long lisComitesLisComId;
    private Long annuaireAnnId;

    public Long getLisComitesLisComId() {
        return this.lisComitesLisComId;
    }

    public void setLisComitesLisComId(Long lisComitesLisComId) {
        this.lisComitesLisComId = lisComitesLisComId;
    }

    public Long getAnnuaireAnnId() {
        return this.annuaireAnnId;
    }

    public void setAnnuaireAnnId(Long annuaireAnnId) {
        this.annuaireAnnId = annuaireAnnId;
    }
}
