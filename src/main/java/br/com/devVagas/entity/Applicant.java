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
	
	@Column(name ="NOME")
	private String name;
	
	@Column(name ="DT_NASCIMENTO")
	private LocalDateTime birthday;
	
	@Column(name ="SEXO")
	private String gender;
	
	@Column(name ="NACIONALIDADE")
	private String nationality;
	
	@Column(name ="ESTADO_CIVIL")
	private String maritalstatus;
	
	@Column(name ="RG")
	private String rg;
	
	@Column(name ="CPF")
	private String cpf;
	
	@Column(name ="IMAGEM")
	private Byte image;
	
	@Column(name ="TELEFONE_RECADO")
	private String telephoneMessage;
	
	@Column(name ="PONTUACAO")
	private Integer score;
	
	@Column(name ="EMAIL")
	private String email;
		
	@Column(name = "DT_ATUALIZACAO")
	private Date updateDate;
	
	@Column(name = "DT_CRIACAO")
	private Date createDate;
	
	@Column(name = "DT_EXCLUSAO")
	private Date excluysionDate;
	
	@ManyToOne
	 @JoinColumn(name = "CRIADO", 
    referencedColumnName = "id")
	private Analyst createAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "ATUALIZADO", 
   referencedColumnName = "id")
	private Analyst modifyAnalyst;
	
	
	@ManyToOne
	@JoinColumn(name = "EXCLUIDO", 
   referencedColumnName = "id")
	private Analyst exclusionAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "analyst_id")
	private Analyst analyst;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id",referencedColumnName = "id")
	private List<Address> address = new ArrayList<>();
	
	@OneToMany
	private List<Skill> skills = new ArrayList<>();	
	
	@ManyToMany(mappedBy = "applicanties",fetch = FetchType.LAZY)
	private List<SelectionProcess>selectionProcessies = new ArrayList<>();
	
}
