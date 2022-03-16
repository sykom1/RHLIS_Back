package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;


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