package com.amu.project_back.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the lis_comites database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="lis_comites")
@NamedQuery(name="LisComite.findAll", query="SELECT l FROM LisComite l")
public class LisComite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lis_com_id")
	private String lisComId;

	@Column(name="lis_com_acronyme")
	private String lisComAcronyme;

	@Column(name="lis_com_label")
	private String lisComLabel;

	//bi-directional many-to-many association to Annuaire
	@ManyToMany
	@JoinTable(
		name="lis_comites_has_annuaire"
		, joinColumns={
			@JoinColumn(name="lis_comites_lis_com_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="annuaire_ann_id")
			}
		)
	private List<Annuaire> annuaires;


}