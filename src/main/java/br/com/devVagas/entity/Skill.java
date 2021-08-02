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
@Table(name="TB_SKILL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class Skill {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    private Long id;
    
    @Column(name="NOME" , nullable = false)
    private String name;
    
    @Column(name="COR" , nullable = false)
    private String color;
    
    @Column(name="NIVEL_CONHECIMENTO", nullable = false)
    private Integer knowledgeLevel;
    
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime modifyDate;
    
    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;
    
    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    //falta o mapeamento dos relacionamentos abaixo{
//    @ManyToOne
//    private Analyst createAnalyst
//    private Analist exclusionAnalyst
//    private Analist modifyAnalyst
//}
    @ManyToMany
    @JoinTable(name = "TB_CANDIDATO_SKILL", joinColumns = 
    @JoinColumn(name = "skill_id"), inverseJoinColumns = 
    @JoinColumn(name = "applicant_id"))
    private List<Applicant> applicanties = new ArrayList<>();
}
