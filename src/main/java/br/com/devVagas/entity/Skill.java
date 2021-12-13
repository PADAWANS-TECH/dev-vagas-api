package br.com.devVagas.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@Data
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
    
    @ManyToOne
	@JoinColumn(name = "ANALISTA_CRIAÇÃO_ID", referencedColumnName = "id")
	private Analyst createAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_MODIFICAÇÃO_ID", referencedColumnName = "id")
	private Analyst modifyAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_EXCLUSÃO_ID", referencedColumnName = "id")
	private Analyst exclusionAnalyst;

    
}
