package com.amu.project_back.models.enume;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN, REFERENT, UTILISATEUR, SERVICE_ADMINISTRATIF_FINANCIER;



    @Override
    public String getAuthority() {
        return name();
    }
}
