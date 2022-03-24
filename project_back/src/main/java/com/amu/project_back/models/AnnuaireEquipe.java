package com.amu.project_back.models;

import com.amu.project_back.models.enume.LisStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;


/**
 * The persistent class for the annuaire_equipes database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="annuaire_equipes")
@NamedQuery(name="AnnuaireEquipe.findAll", query="SELECT a FROM AnnuaireEquipe a")
public class AnnuaireEquipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="annuaire_equipes_id")
	private String annuaireEquipesId;

	@Column(name="ann_bureau")
	private String annBureau;


	@Column(name="ann_tel_pro1")
	private String annTelPro1;

	@Column(name="ann_tel_pro2")
	private String annTelPro2;

	@ManyToOne
	@JoinColumn(name="annuaire_equipes_eq_id")
	private LisEquipe lisEquipe;

	@Temporal(TemporalType.DATE)
	@Column(name="date_arrive")
	private Date dateArrive;

	@Temporal(TemporalType.DATE)
	@Column(name="date_sortie")
	private Date dateSortie;

	@Column(name="lis_responsabilité")
	private int lisResponsabilité;

	@Column(name="lis_statut")
	private LisStatus lisStatut;

	//bi-directional many-to-one association to Annuaire
	@ManyToOne
	@JoinColumn(name="annuaire_equipes_ann_id")
	private Annuaire annuaire;





}