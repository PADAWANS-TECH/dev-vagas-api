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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CARGO")
public class Vacancy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DS_NOME", nullable = false)
	private String name;
	
	//verificar a utilização dessa anotação @CreationTimestamp
	@Column(name = "DT_CRIACAO")
	private LocalDateTime createDate;
	
	//verificar a utilização dessa anotação @UpdateTimestamp	
	@Column(name = "DT_MODIFICACAO")
	private LocalDateTime modifyDate;

	@Column(name = "DT_EXCLUSAO")
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
	
	@ManyToOne
	@JoinColumn(name = "EMPRESA_ID", referencedColumnName = "id", nullable = false)
	private Company company;
	
}
