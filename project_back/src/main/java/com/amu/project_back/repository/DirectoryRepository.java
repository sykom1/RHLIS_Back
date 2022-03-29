package com.amu.project_back.repository;

import com.amu.project_back.models.Annuaire;
import com.amu.project_back.models.enume.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface DirectoryRepository extends JpaRepository<Annuaire, Long> {

   /* @Query("SELECT a from Annuaire a, AnnuaireEquipe ae, LisEquipe e where a.annId = ae.annuaire.annId and e.equipesId = ae.lisEquipe.equipesId and e.equipesLabel = :name")
    List<Annuaire> findAllByAnnuaireEquipes_Label(@Param("name") String name);


    @Query("SELECT a from Annuaire a, AnnuaireEquipe ae, LisEquipe e join e.lisPoles pole  where a.annId = ae.annuaire.annId " +
            "and e.equipesId = ae.lisEquipe.equipesId  and pole.name = :name")
    List<Annuaire> findAllByAnnuairePole(@Param("name") String name);

    List<Annuaire> findAllByUser_RoleLike(UserRole name);


    @Query("SELECT a from Annuaire a join a.annuaireEquipes eq where eq.lisStatut = :name")
    List<Annuaire> findAllByStatus(@Param("name") String name);

    @Query("SELECT a from Annuaire a join a.annuaireEquipes eq where eq.dateArrive = :name")
    List<Annuaire> findAllByDateA(@Param("name") Date name);

    @Query("SELECT a from Annuaire a join a.annuaireEquipes eq where eq.dateSortie = :name")
    List<Annuaire> findAllByDateD(@Param("name") Date name);*/
	
	


}
