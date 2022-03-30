package com.amu.project_back.repository;


import com.amu.project_back.models.Utilisateur;
import com.amu.project_back.models.enume.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);

    List<Utilisateur> findAllByRoleLike(UserRole role);

    List<Utilisateur> findAllByIsnewTrueAndRoleNot(UserRole role);

}
