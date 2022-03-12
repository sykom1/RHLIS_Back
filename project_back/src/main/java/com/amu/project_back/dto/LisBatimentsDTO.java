package com.amu.project_back.dto;

public class LisBatimentsDTO {
    private Long batId;
    private String batLabel;
    private String batCode;
    private Long batSiteId;

    public Long getBatId() {
        return this.batId;
    }

    public void setBatId(Long batId) {
        this.batId = batId;
    }

    public String getBatLabel() {
        return this.batLabel;
    }

    public void setBatLabel(String batLabel) {
        this.batLabel = batLabel;
    }

    public String getBatCode() {
        return this.batCode;
    }

    public void setBatCode(String batCode) {
        this.batCode = batCode;
    }

    public Long getBatSiteId() {
        return this.batSiteId;
    }

    public void setBatSiteId(Long batSiteId) {
        this.batSiteId = batSiteId;
    }
}
