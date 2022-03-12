package com.amu.project_back.dto;

public class AnnuaireDiplomeDTO {
    private Long annDiplomeId;
    private Long annDiplomeAnnId;
    private Long annDiplomeTypeDiplomeId;
    private String annDiplomeCommentaire;
    private String annDiplomeTitre;
    private Integer annDiplomeAnnee;
    private String annDiplomeLieu;
    private String lisDiplome;
    private String lisSoutenance;
    private String annSoutTitre;
    private java.sql.Timestamp annSoutDate;
    private String annSoutFr;
    private String annSoutEn;

    public Long getAnnDiplomeId() {
        return this.annDiplomeId;
    }

    public void setAnnDiplomeId(Long annDiplomeId) {
        this.annDiplomeId = annDiplomeId;
    }

    public Long getAnnDiplomeAnnId() {
        return this.annDiplomeAnnId;
    }

    public void setAnnDiplomeAnnId(Long annDiplomeAnnId) {
        this.annDiplomeAnnId = annDiplomeAnnId;
    }

    public Long getAnnDiplomeTypeDiplomeId() {
        return this.annDiplomeTypeDiplomeId;
    }

    public void setAnnDiplomeTypeDiplomeId(Long annDiplomeTypeDiplomeId) {
        this.annDiplomeTypeDiplomeId = annDiplomeTypeDiplomeId;
    }

    public String getAnnDiplomeCommentaire() {
        return this.annDiplomeCommentaire;
    }

    public void setAnnDiplomeCommentaire(String annDiplomeCommentaire) {
        this.annDiplomeCommentaire = annDiplomeCommentaire;
    }

    public String getAnnDiplomeTitre() {
        return this.annDiplomeTitre;
    }

    public void setAnnDiplomeTitre(String annDiplomeTitre) {
        this.annDiplomeTitre = annDiplomeTitre;
    }

    public Integer getAnnDiplomeAnnee() {
        return this.annDiplomeAnnee;
    }

    public void setAnnDiplomeAnnee(Integer annDiplomeAnnee) {
        this.annDiplomeAnnee = annDiplomeAnnee;
    }

    public String getAnnDiplomeLieu() {
        return this.annDiplomeLieu;
    }

    public void setAnnDiplomeLieu(String annDiplomeLieu) {
        this.annDiplomeLieu = annDiplomeLieu;
    }

    public String getLisDiplome() {
        return this.lisDiplome;
    }

    public void setLisDiplome(String lisDiplome) {
        this.lisDiplome = lisDiplome;
    }

    public String getLisSoutenance() {
        return this.lisSoutenance;
    }

    public void setLisSoutenance(String lisSoutenance) {
        this.lisSoutenance = lisSoutenance;
    }

    public String getAnnSoutTitre() {
        return this.annSoutTitre;
    }

    public void setAnnSoutTitre(String annSoutTitre) {
        this.annSoutTitre = annSoutTitre;
    }

    public java.sql.Timestamp getAnnSoutDate() {
        return this.annSoutDate;
    }

    public void setAnnSoutDate(java.sql.Timestamp annSoutDate) {
        this.annSoutDate = annSoutDate;
    }

    public String getAnnSoutFr() {
        return this.annSoutFr;
    }

    public void setAnnSoutFr(String annSoutFr) {
        this.annSoutFr = annSoutFr;
    }

    public String getAnnSoutEn() {
        return this.annSoutEn;
    }

    public void setAnnSoutEn(String annSoutEn) {
        this.annSoutEn = annSoutEn;
    }
}
