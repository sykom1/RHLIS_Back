package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the annuaire_documents database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="annuaire_documents")
@NamedQuery(name="AnnuaireDocument.findAll", query="SELECT a FROM AnnuaireDocument a")
public class AnnuaireDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ann_doc_id")
	private String annDocId;

	@Column(name="ann_doc_ann_id")
	private BigInteger annDocAnnId;

	@Column(name="ann_doc_ann_id_depo")
	private BigInteger annDocAnnIdDepo;

	@Temporal(TemporalType.DATE)
	@Column(name="ann_doc_date")
	private Date annDocDate;

	@Lob
	@Column(name="ann_doc_description")
	private String annDocDescription;

	@Column(name="ann_doc_etat")
	private byte annDocEtat;

	@Column(name="ann_doc_fichier")
	private String annDocFichier;

	@Column(name="ann_doc_titre")
	private String annDocTitre;

	//bi-directional many-to-one association to Annuaire
	@ManyToOne
	private Annuaire annuaire;



}