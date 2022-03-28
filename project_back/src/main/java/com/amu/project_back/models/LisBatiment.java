package com.amu.project_back.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.amu.project_back.models.enume.Site;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;


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
	private Long batId;

	@Column(name="bat_code")
	private String batCode;

	@Column(name="bat_label")
	private String batLabel;

	@Column(name="bat_site")
	@Enumerated(EnumType.STRING)
	private Site batSite;

	//bi-directional many-to-one association to Annuaire
	@OneToMany(mappedBy="lisBatiment")
	private List<Annuaire> annuaires;





}