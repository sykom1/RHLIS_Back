package com.amu.project_back.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amu.project_back.models.AnnuaireEquipe;

public interface AnnuaireEquipeRepository extends JpaRepository<AnnuaireEquipe, Long> {

    List<AnnuaireEquipe> findAllByDateArrive(Date datea);
    List<AnnuaireEquipe> findAllByDateSortie(Date dated);

    List<AnnuaireEquipe> findByAnnuaireAnnId(Long id);
    List<AnnuaireEquipe> findByAnnuaireReferentUserId(Long id);
    
    @Query("Select a from AnnuaireEquipe a order by a.annuaireEquipesId Desc")
    List<AnnuaireEquipe> findAllOrderByAnnuairerquipesidDesc();
    
    List<AnnuaireEquipe> findByAnnuaireUserIsnewTrue();
    
    @Query("Select a from AnnuaireEquipe a where a.annuaireEquipesId = :id ")
    AnnuaireEquipe findOneByIdentifier(@Param("id")Long id);


}
