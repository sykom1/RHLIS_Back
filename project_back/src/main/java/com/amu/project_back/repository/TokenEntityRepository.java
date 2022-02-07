package com.amu.project_back.repository;

import com.amu.project_back.models.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenEntityRepository extends JpaRepository<TokenEntity, Integer> {

	public TokenEntity findByUserUsername(String username);
	
	public TokenEntity findByJwt(String jwt);
}
