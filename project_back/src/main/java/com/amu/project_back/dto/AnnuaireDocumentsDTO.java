package com.amu.project_back.dto;

public class AnnuaireDocumentsDTO {
    private Long annDocId;
    private Long annDocAnnId;
    private String annDocTitre;
    private String annDocDescription;
    private String annDocFichier;
    private java.sql.Date annDocDate;
    private Long annDocAnnIdDepo;
    private Byte annDocEtat;
    private Long annuaireAnnId;

    public Long getAnnDocId() {
        return this.annDocId;
    }

    public void setAnnDocId(Long annDocId) {
        this.annDocId = annDocId;
    }

    public Long getAnnDocAnnId() {
        return this.annDocAnnId;
    }

    public void setAnnDocAnnId(Long annDocAnnId) {
        this.annDocAnnId = annDocAnnId;
    }

    public String getAnnDocTitre() {
        return this.annDocTitre;
    }

    public void setAnnDocTitre(String annDocTitre) {
        this.annDocTitre = annDocTitre;
    }

    public String getAnnDocDescription() {
        return this.annDocDescription;
    }

    public void setAnnDocDescription(String annDocDescription) {
        this.annDocDescription = annDocDescription;
    }

    public String getAnnDocFichier() {
        return this.annDocFichier;
    }

    public void setAnnDocFichier(String annDocFichier) {
        this.annDocFichier = annDocFichier;
    }

    public java.sql.Date getAnnDocDate() {
        return this.annDocDate;
    }

    public void setAnnDocDate(java.sql.Date annDocDate) {
        this.annDocDate = annDocDate;
    }

    public Long getAnnDocAnnIdDepo() {
        return this.annDocAnnIdDepo;
    }

    public void setAnnDocAnnIdDepo(Long annDocAnnIdDepo) {
        this.annDocAnnIdDepo = annDocAnnIdDepo;
    }

    public Byte getAnnDocEtat() {
        return this.annDocEtat;
    }

    public void setAnnDocEtat(Byte annDocEtat) {
        this.annDocEtat = annDocEtat;
    }

    public Long getAnnuaireAnnId() {
        return this.annuaireAnnId;
    }

    public void setAnnuaireAnnId(Long annuaireAnnId) {
        this.annuaireAnnId = annuaireAnnId;
    }
}
