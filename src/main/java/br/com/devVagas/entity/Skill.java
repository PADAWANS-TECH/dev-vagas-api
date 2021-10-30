package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
