package com.amu.project_back.models;

import com.amu.project_back.models.enume.Site;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the lis_batiments database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="lis_batiments")
@NamedQuery(name="LisBatiment.findAll", query="SELECT l FROM LisBatiment l")
public class LisBatiment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bat_id")
	private String batId;

	@Column(name="bat_code")
	private String batCode;

	@Column(name="bat_label")
	private String batLabel;

	@Column(name="bat_site_id")
	@Enumerated(EnumType.STRING)
	private Site batSite;

	//bi-directional many-to-one association to Annuaire
	@OneToMany(mappedBy="lisBatiment")
	private List<Annuaire> annuaires;





}