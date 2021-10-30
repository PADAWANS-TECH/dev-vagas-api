package br.com.devVagas.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TB_PROCESSO_SELETIVO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class SelectionProcess {
   
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    private Long id;
    
	@Column(name="TITULO" , nullable = false)
    private String title;
    
	@Column(name="DESCRICAO" , nullable = false)
    private String description;
    
	@Column(name="QUANTIDADE_VAGAS", nullable = false)
    private Integer vacancyQuantity;
   
	@Column(name="DT_INICIO", nullable = false)
    private LocalDateTime beginDate;
   
	@Column(name="DT_TERMINO", nullable = false)
    private LocalDateTime endDate;
    
	@Column(name="DT_ATUALIZACAO")
    private LocalDateTime modifyDate;
    
	@Column(name="DT_CRIACAO")
    private LocalDateTime createDate;
	
    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    @ManyToOne
	 @JoinColumn(name = "ANALISTA_CRIAÇÃO_ID", 
   referencedColumnName = "id")
	private Analyst createAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "ANALISTA_MODIFICAÇÃO_ID", 
  referencedColumnName = "id")
	private Analyst modifyAnalyst;	
	
	@ManyToOne
	@JoinColumn(name = "ANALISTA_EXCLUSÃO_ID", 
  referencedColumnName = "id")
	private Analyst exclusionAnalyst;
    
    @ManyToOne
    @JoinColumn(name = "EMPRESA_ID")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name = "CARGO_ID")
    private Vacancy vacancy;
    
    @ManyToOne
    @JoinColumn(name = "ANALISTA_ID")
    private Analyst analyst;
    
	@ManyToMany
    @JoinTable(name = "TB_CANDIDATO_PROCESSO_SELETIVO", joinColumns = 
    @JoinColumn(name = "PROCESSO_SELETIVO_ID"), inverseJoinColumns = 
    @JoinColumn(name = "CANDIDATO_ID"))
    private List<Applicant> applicanties = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Skill>skills = new ArrayList<>();
}
	
