package com.amu.project_back.models;
import com.amu.project_back.models.enume.TicketDomain;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private String ticketId;

	@Column(name="ticket_courriel")
	private String ticketCourriel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ticket_date")
	private Date ticketDate;

	@Lob
	@Column(name="ticket_description")
	private String ticketDescription;

	@Column(name="ticket_description_courte")
	private String ticketDescriptionCourte;

	@Column(name="ticket_domaine")
	private TicketDomain ticketDomaine;

	@Column(name="ticket_fichier")
	private String ticketFichier;

	@Column(name="ticket_nom_prenom")
	private String ticketNomPrenom;

	@Column(name="ticket_pole_id")
	private BigInteger ticketPoleId;

	//bi-directional many-to-one association to Annuaire
	@ManyToOne
	@JoinColumn(name="ticket_ann_id")
	private Annuaire annuaire;

	//bi-directional many-to-one association to AnnuaireEquipe
	@ManyToOne
	@JoinColumn(name="ticket_equipe_id")
	private AnnuaireEquipe annuaireEquipe;


}