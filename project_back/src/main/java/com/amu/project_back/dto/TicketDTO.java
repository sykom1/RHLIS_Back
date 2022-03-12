package com.amu.project_back.dto;

public class TicketDTO {
    private Long ticketId;
    private Long ticketAnnId;
    private String ticketNomPrenom;
    private String ticketCourriel;
    private Long ticketPoleId;
    private Long ticketEquipeId;
    private String ticketDescriptionCourte;
    private String ticketDescription;
    private String ticketFichier;
    private java.sql.Timestamp ticketDate;
    private String ticketDomaine;

    public Long getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketAnnId() {
        return this.ticketAnnId;
    }

    public void setTicketAnnId(Long ticketAnnId) {
        this.ticketAnnId = ticketAnnId;
    }

    public String getTicketNomPrenom() {
        return this.ticketNomPrenom;
    }

    public void setTicketNomPrenom(String ticketNomPrenom) {
        this.ticketNomPrenom = ticketNomPrenom;
    }

    public String getTicketCourriel() {
        return this.ticketCourriel;
    }

    public void setTicketCourriel(String ticketCourriel) {
        this.ticketCourriel = ticketCourriel;
    }

    public Long getTicketPoleId() {
        return this.ticketPoleId;
    }

    public void setTicketPoleId(Long ticketPoleId) {
        this.ticketPoleId = ticketPoleId;
    }

    public Long getTicketEquipeId() {
        return this.ticketEquipeId;
    }

    public void setTicketEquipeId(Long ticketEquipeId) {
        this.ticketEquipeId = ticketEquipeId;
    }

    public String getTicketDescriptionCourte() {
        return this.ticketDescriptionCourte;
    }

    public void setTicketDescriptionCourte(String ticketDescriptionCourte) {
        this.ticketDescriptionCourte = ticketDescriptionCourte;
    }

    public String getTicketDescription() {
        return this.ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public String getTicketFichier() {
        return this.ticketFichier;
    }

    public void setTicketFichier(String ticketFichier) {
        this.ticketFichier = ticketFichier;
    }

    public java.sql.Timestamp getTicketDate() {
        return this.ticketDate;
    }

    public void setTicketDate(java.sql.Timestamp ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketDomaine() {
        return this.ticketDomaine;
    }

    public void setTicketDomaine(String ticketDomaine) {
        this.ticketDomaine = ticketDomaine;
    }
}
