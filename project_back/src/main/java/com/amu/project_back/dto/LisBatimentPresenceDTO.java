package com.amu.project_back.dto;

import java.sql.Date;
import java.sql.Time;

public class LisBatimentPresenceDTO {
    private Long lisPresBatId;
    private Long lisPresBatAnnId;
    private Long lisPresBatBatId;
    private String lisPresBatNom;
    private String lisPresBatPrenom;
    private Date lisPresBatJour;
    private Time lisPresBatArrivee;
    private Time lisPresBatDepart;
    private String lisPresBatType;
    private String lisPresBatBureau;

    public Long getLisPresBatId() {
        return this.lisPresBatId;
    }

    public void setLisPresBatId(Long lisPresBatId) {
        this.lisPresBatId = lisPresBatId;
    }

    public Long getLisPresBatAnnId() {
        return this.lisPresBatAnnId;
    }

    public void setLisPresBatAnnId(Long lisPresBatAnnId) {
        this.lisPresBatAnnId = lisPresBatAnnId;
    }

    public Long getLisPresBatBatId() {
        return this.lisPresBatBatId;
    }

    public void setLisPresBatBatId(Long lisPresBatBatId) {
        this.lisPresBatBatId = lisPresBatBatId;
    }

    public String getLisPresBatNom() {
        return this.lisPresBatNom;
    }

    public void setLisPresBatNom(String lisPresBatNom) {
        this.lisPresBatNom = lisPresBatNom;
    }

    public String getLisPresBatPrenom() {
        return this.lisPresBatPrenom;
    }

    public void setLisPresBatPrenom(String lisPresBatPrenom) {
        this.lisPresBatPrenom = lisPresBatPrenom;
    }

    public java.sql.Date getLisPresBatJour() {
        return this.lisPresBatJour;
    }

    public void setLisPresBatJour(java.sql.Date lisPresBatJour) {
        this.lisPresBatJour = lisPresBatJour;
    }

    public Time getLisPresBatArrivee() {
        return this.lisPresBatArrivee;
    }

    public void setLisPresBatArrivee(Time lisPresBatArrivee) {
        this.lisPresBatArrivee = lisPresBatArrivee;
    }

    public Time getLisPresBatDepart() {
        return this.lisPresBatDepart;
    }

    public void setLisPresBatDepart(Time lisPresBatDepart) {
        this.lisPresBatDepart = lisPresBatDepart;
    }

    public String getLisPresBatType() {
        return this.lisPresBatType;
    }

    public void setLisPresBatType(String lisPresBatType) {
        this.lisPresBatType = lisPresBatType;
    }

    public String getLisPresBatBureau() {
        return this.lisPresBatBureau;
    }

    public void setLisPresBatBureau(String lisPresBatBureau) {
        this.lisPresBatBureau = lisPresBatBureau;
    }
}
