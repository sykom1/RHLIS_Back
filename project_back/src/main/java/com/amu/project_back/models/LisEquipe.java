package com.amu.project_back.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;


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

	//bi-directional one-to-one association to AnnuaireEquipe
	@OneToMany(mappedBy="lisEquipe")
	private List<AnnuaireEquipe> annuaireEquipe;

	//bi-directional many-to-many association to LisPole
	@ManyToMany(mappedBy = "lisEquipes")
	private List<LisPole> lisPoles;


}