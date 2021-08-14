package br.com.devVagas.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "TB_CANDIDATO")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String name;

	@Column(name = "TELEFONE", nullable = false)
	private String telephone;

	@Column(name = "DT_NASCIMENTO", nullable = false)
	private LocalDateTime birthday;

	@Column(name = "SEXO")
	private String gender;

	@Column(name = "NACIONALIDADE", nullable = false)
	private String nationality;

	@Column(name = "ESTADO_CIVIL", nullable = false)
	private String maritalstatus;

	@Column(name = "RG", nullable = false)
	private String rg;

	@Column(name = "CPF", nullable = false)
	private String cpf;

	@Column(name = "IMAGEM")
	private Byte image;

	@Column(name = "TELEFONE_RECADO")
	private String telephoneMessage;

	@Column(name = "PONTUACAO")
	private Integer score;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DT_ATUALIZACAO")
	private Date updateDate;

	@Column(name = "DT_CRIACAO")
	private Date createDate;

	@Column(name = "DT_EXCLUSAO")
	private Date excluysionDate;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_CRIAÇÃO_ID", referencedColumnName = "id")
	private Analyst createAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_MODIFICAÇÃO_ID", referencedColumnName = "id")
	private Analyst modifyAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_EXCLUSÃO_ID", referencedColumnName = "id")
	private Analyst exclusionAnalyst;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private List<Address> address = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "TB_CANDIDATO_SKILL", joinColumns = 
	@JoinColumn(name = "SKILL_ID"), inverseJoinColumns = 
	@JoinColumn(name = "CANDIDATO_ID"))
	private List<Skill> skills = new ArrayList<>();

	@ManyToMany(mappedBy = "applicanties", fetch = FetchType.LAZY)
	private List<SelectionProcess> selectionProcessies = new ArrayList<>();

}
