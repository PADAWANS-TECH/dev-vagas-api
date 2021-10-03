package br.com.devVagas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.devVagas.entity.Analyst;
import br.com.devVagas.entity.Applicant;
import br.com.devVagas.entity.Company;
import br.com.devVagas.entity.SelectionProcess;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.entity.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SelectionProcessResponseDTO {

	private Long id;
	private String title;
	private String description;
	private Integer vacancyQuantity;
	private LocalDateTime beginDate;
	private LocalDateTime endDate;
	private LocalDateTime modifyDate;
	private LocalDateTime createDate;
	private LocalDateTime exclusionDate;
	private Long createAnalyst;
	private Long modifyAnalyst;
	private Long exclusionAnalyst;
	private Long company;
	private Long vacancy;
	private Long analyst;
	private Long applicant;
	private Long skill;

	public SelectionProcessResponseDTO(SelectionProcess selectionProcess, Analyst analyst, Company company,
			Vacancy vacancy, Applicant applicant, Skill skill) {
		
		this.id = selectionProcess.getId();
		this.title = selectionProcess.getTitle();
		this.description = selectionProcess.getDescription();
		this.vacancyQuantity = selectionProcess.getVacancyQuantity();
		this.beginDate = selectionProcess.getBeginDate();
		this.endDate = selectionProcess.getEndDate();
		this.modifyDate = selectionProcess.getModifyDate();
		this.createDate = selectionProcess.getCreateDate();
		this.exclusionDate = selectionProcess.getExclusionDate();
		this.createAnalyst = analyst.getId();
		this.modifyAnalyst = analyst.getId();;
		this.exclusionAnalyst = analyst.getId();;
		this.company = company.getId();
		this.vacancy = vacancy.getId();
		this.analyst = analyst.getId();
		this.applicant = applicant.getId();
		this.skill = skill.getId();
	}

}
