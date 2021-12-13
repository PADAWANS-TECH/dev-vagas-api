package br.com.devVagas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SelectionProcessResponseDTO {
	
	private Long id;
    private String title;
    private String description;
    private Integer vacancyQuantity;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Company company;
    private Vacancy vacancy;
    private Analyst analyst;
    private List<Applicant> applicanties = new ArrayList<>();
	private List<Skill> skills = new ArrayList<>();
	
	public SelectionProcessResponseDTO(SelectionProcess selectionProcess) {
		Analyst analyst = new Analyst();
		Company company = new Company();
		Vacancy vacancy = new Vacancy();
		
		this.id = selectionProcess.getId();
		this.title = selectionProcess.getTitle();
		this.description = selectionProcess.getDescription();
		this.vacancyQuantity = selectionProcess.getVacancyQuantity();
		this.beginDate = selectionProcess.getBeginDate();
		this.endDate = selectionProcess.getEndDate();
		
		this.company = selectionProcess.getCompany();
		this.vacancy = selectionProcess.getVacancy();
		this.analyst = selectionProcess.getAnalyst();
		
		this.applicanties = selectionProcess.getApplicanties();
		this.skills = selectionProcess.getSkills();
	}
}
