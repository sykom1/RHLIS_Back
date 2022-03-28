package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the lis_pays database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="lis_pays")
@NamedQuery(name="LisPay.findAll", query="SELECT l FROM LisPay l")
public class LisPay implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pays_id")
	private int paysId;

	@Column(name="pays_iso")
	private String paysIso;

	@Column(name="pays_label_fr")
	private String paysLabelFr;

	@Column(name="pays_label_us")
	private String paysLabelUs;

	@Column(name="pays_notionalite_fr")
	private String paysNotionaliteFr;

	@Column(name="pays_telephone")
	private String paysTelephone;

	@JsonIgnore
	//bi-directional many-to-one association to Annuaire
	@OneToMany(mappedBy="lisPay")
	private List<Annuaire> annuaires;



}