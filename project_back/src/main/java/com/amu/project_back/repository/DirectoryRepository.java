package com.amu.project_back.repository;

import com.amu.project_back.models.Annuaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<Annuaire, Long> {


}
