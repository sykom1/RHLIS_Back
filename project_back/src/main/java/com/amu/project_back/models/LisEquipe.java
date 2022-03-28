package com.amu.project_back.models;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the lis_equipes database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="lis_equipes")
@NamedQuery(name="LisEquipe.findAll", query="SELECT l FROM LisEquipe l")
public class LisEquipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="equipes_id")
	private String equipesId;

	@Column(name="equipes_label")
	private String equipesLabel;

	@Column(name="equipes_nom_long")
	private String equipesNomLong;

	@JsonIgnore
	//bi-directional one-to-one association to AnnuaireEquipe
	@OneToMany(mappedBy="lisEquipe")
	private List<AnnuaireEquipe> annuaireEquipe;

	@JsonIgnore
	//bi-directional many-to-many association to LisPole
	@ManyToMany(mappedBy = "lisEquipes")
	private List<LisPole> lisPoles;


}