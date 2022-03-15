package com.amu.project_back.repository;

import com.amu.project_back.models.LisEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LisEquipeRepository extends JpaRepository<LisEquipe, Long> {

    List<LisEquipe> findAllByEquipesLabel(String name);
}
