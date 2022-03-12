package com.amu.project_back.dto;

public class AnnuaireEquipesDTO {
    private Long annuaireEquipesId;
    private Long annuaireEquipesAnnId;
    private Integer annuaireEquipesEqId;
    private String annTelPro1;
    private String annTelPro2;
    private String annLisGrade;
    private String annBureau;
    private java.sql.Date dateArrive;
    private java.sql.Date dateSortie;
    private String lisResponsabilité;
    private String lisStatut;

    public Long getAnnuaireEquipesId() {
        return this.annuaireEquipesId;
    }

    public void setAnnuaireEquipesId(Long annuaireEquipesId) {
        this.annuaireEquipesId = annuaireEquipesId;
    }

    public Long getAnnuaireEquipesAnnId() {
        return this.annuaireEquipesAnnId;
    }

    public void setAnnuaireEquipesAnnId(Long annuaireEquipesAnnId) {
        this.annuaireEquipesAnnId = annuaireEquipesAnnId;
    }

    public Integer getAnnuaireEquipesEqId() {
        return this.annuaireEquipesEqId;
    }

    public void setAnnuaireEquipesEqId(Integer annuaireEquipesEqId) {
        this.annuaireEquipesEqId = annuaireEquipesEqId;
    }

    public String getAnnTelPro1() {
        return this.annTelPro1;
    }

    public void setAnnTelPro1(String annTelPro1) {
        this.annTelPro1 = annTelPro1;
    }

    public String getAnnTelPro2() {
        return this.annTelPro2;
    }

    public void setAnnTelPro2(String annTelPro2) {
        this.annTelPro2 = annTelPro2;
    }

    public String getAnnLisGrade() {
        return this.annLisGrade;
    }

    public void setAnnLisGrade(String annLisGrade) {
        this.annLisGrade = annLisGrade;
    }

    public String getAnnBureau() {
        return this.annBureau;
    }

    public void setAnnBureau(String annBureau) {
        this.annBureau = annBureau;
    }

    public java.sql.Date getDateArrive() {
        return this.dateArrive;
    }

    public void setDateArrive(java.sql.Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public java.sql.Date getDateSortie() {
        return this.dateSortie;
    }

    public void setDateSortie(java.sql.Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getLisResponsabilité() {
        return this.lisResponsabilité;
    }

    public void setLisResponsabilité(String lisResponsabilité) {
        this.lisResponsabilité = lisResponsabilité;
    }

    public String getLisStatut() {
        return this.lisStatut;
    }

    public void setLisStatut(String lisStatut) {
        this.lisStatut = lisStatut;
    }
}
