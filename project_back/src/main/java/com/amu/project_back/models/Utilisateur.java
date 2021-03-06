package com.amu.project_back.models;

import com.amu.project_back.models.enume.UserRole;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateurs database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="utilisateurs")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "uti_id")
	private long id;


	@Basic
	@Column(name = "uti_login")
	@NotBlank(message = "L'email est obligatoire !")
	@Email(message = "Veuillez respecter le format du mail !")
	private String email;

	@NotBlank(message = "Le mot de passe est obligatoire !")
	@JsonIgnore
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@NotBlank(message = "Le nom est obligatoire !")
	private String lastname;

	@NotBlank(message = "Le prenom est obligatoire !")
	private String firstname;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Pattern(regexp="(^$|[0-9]{10})",message = "le numéro de téléphone doit contenir 10 chiffres")
	@NotBlank(message = "Le numero de telephone est obligatoire !")
	private String phoneNumber;

	@OneToOne
	private Annuaire directory;

	@OneToMany(mappedBy="destinataire",fetch = FetchType.LAZY)
	private List<Notification> notifications;

	private boolean isnew = true;


	public Utilisateur(@NotBlank(message = "L'email est obligatoire !") String email,
					   @NotBlank(message = "Le mot de passe est obligatoire !") String password, UserRole role,
					   @NotBlank(message = "Le nom est obligatoire !") String lastname,
					   @NotBlank(message = "Le prenom est obligatoire !") String firstname, Date birthday,
					   @Pattern(regexp = "(^$|[0-9]{10})", message = "le numéro de téléphone doit contenir 10 chiffres") @NotBlank(message = "Le numero de telephone est obligatoire !") String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}


	public void setUser(Utilisateur user){
		this.id = user.id;
		this.email = user.email;
		this.password = user.password;
		this.role = user.role;
	}

}