package com.amu.project_back.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Time;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the lis_batiment_presence database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="lis_batiment_presence")
@NamedQuery(name="LisBatimentPresence.findAll", query="SELECT l FROM LisBatimentPresence l")
public class LisBatimentPresence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lis_pres_bat_id")
	private String lisPresBatId;

	@Column(name="lis_pres_bat_ann_id")
	private BigInteger lisPresBatAnnId;

	@Column(name="lis_pres_bat_arrivee")
	private Time lisPresBatArrivee;

	@Column(name="lis_pres_bat_bureau")
	private String lisPresBatBureau;

	@Column(name="lis_pres_bat_depart")
	private Time lisPresBatDepart;

	@Temporal(TemporalType.DATE)
	@Column(name="lis_pres_bat_jour")
	private Date lisPresBatJour;

	@Column(name="lis_pres_bat_nom")
	private String lisPresBatNom;

	@Column(name="lis_pres_bat_prenom")
	private String lisPresBatPrenom;

	@Column(name="lis_pres_bat_type")
	private String lisPresBatType;

	//bi-directional many-to-one association to LisBatiment
	@ManyToOne
	@JoinColumn(name="lis_pres_bat_bat_id")
	private LisBatiment lisBatiment;



}