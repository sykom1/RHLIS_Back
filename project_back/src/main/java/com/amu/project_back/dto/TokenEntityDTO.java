package com.amu.project_back.dto;

public class TokenEntityDTO {
    private Integer id;
    private String jwt;
    private Long userUtiId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserUtiId() {
        return this.userUtiId;
    }

    public void setUserUtiId(Long userUtiId) {
        this.userUtiId = userUtiId;
    }
}
