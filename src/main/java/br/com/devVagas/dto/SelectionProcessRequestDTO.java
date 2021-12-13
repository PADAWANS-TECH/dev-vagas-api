package br.com.devVagas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.devVagas.entity.Analyst;
import br.com.devVagas.entity.Applicant;
import br.com.devVagas.entity.Company;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.entity.Vacancy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectionProcessRequestDTO {
	private Long id;
    private String title;
    private String description;
    private Integer vacancyQuantity;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private LocalDateTime modifyDate;
    private LocalDateTime createDate;
	private LocalDateTime exclusionDate;
    private Analyst createAnalyst;
	private Analyst modifyAnalyst;	
	private Analyst exclusionAnalyst;
    private Company company;
    private Vacancy vacancy;
    private Analyst analyst;
    private List<Applicant> applicanties = new ArrayList<>();
	private List<Skill> skills = new ArrayList<>();

}
