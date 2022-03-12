package com.amu.project_back.dto;

public class LisPaysDTO {
    private String paysNotionaliteFr;
    private String paysLabelFr;
    private String paysLabelUs;
    private String paysIso;
    private String paysTelephone;
    private Integer paysId;

    public String getPaysNotionaliteFr() {
        return this.paysNotionaliteFr;
    }

    public void setPaysNotionaliteFr(String paysNotionaliteFr) {
        this.paysNotionaliteFr = paysNotionaliteFr;
    }

    public String getPaysLabelFr() {
        return this.paysLabelFr;
    }

    public void setPaysLabelFr(String paysLabelFr) {
        this.paysLabelFr = paysLabelFr;
    }

    public String getPaysLabelUs() {
        return this.paysLabelUs;
    }

    public void setPaysLabelUs(String paysLabelUs) {
        this.paysLabelUs = paysLabelUs;
    }

    public String getPaysIso() {
        return this.paysIso;
    }

    public void setPaysIso(String paysIso) {
        this.paysIso = paysIso;
    }

    public String getPaysTelephone() {
        return this.paysTelephone;
    }

    public void setPaysTelephone(String paysTelephone) {
        this.paysTelephone = paysTelephone;
    }

    public Integer getPaysId() {
        return this.paysId;
    }

    public void setPaysId(Integer paysId) {
        this.paysId = paysId;
    }
}
