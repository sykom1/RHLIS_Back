package com.amu.project_back.repository;

import com.amu.project_back.models.LisPole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LisPoleRepository extends JpaRepository<LisPole, Long> {

    List<LisPole> findAllByName(String name);
}
