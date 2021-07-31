package br.com.devVagas.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    //falta adicionar os relacionamentos para os atributos abaixo {
    // private Analyst createAnalyst
    // private Analyst exclusionAnalyst
    // private Analyst updateAnalyst
    
    //@ManyToOne
    // private Company company
    
    //@ManyToOne
    // private Vacancy vacancy
    
    //@ManyToOne
    // private Analyst analyst
//}
    
	@ManyToMany
    @JoinTable(name = "TB_CANDIDATO_PROCESSO_SELETIVO", joinColumns = 
    @JoinColumn(name = "selectionProcess_id"), inverseJoinColumns = 
    @JoinColumn(name = "applicant_id"))
    private List<Applicant> applicanties = new ArrayList<>();
}

