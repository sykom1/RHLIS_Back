package com.amu.project_back.repository;

import com.amu.project_back.models.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenEntityRepository extends JpaRepository<TokenEntity, Integer> {

	TokenEntity findByUserEmail(String username);
	
	TokenEntity findByJwt(String jwt);
}
