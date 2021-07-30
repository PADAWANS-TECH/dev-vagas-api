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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "TB_RESPOSTA")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "TITULO")
	private String title;
	
	@Column(name = "DT_ATUALIZACAO")
	private LocalDateTime updateDate;
	
	@Column(name = "DT_CRIACAO")
	private LocalDateTime createDate;
	
	@Column(name = "DT_EXCLUSAO")
	private LocalDateTime excluysionDate;
	
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

	@ManyToMany(mappedBy = "answers")
	private List<Applicant>applicants = new ArrayList<>(); 
	
}
