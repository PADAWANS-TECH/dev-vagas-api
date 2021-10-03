package br.com.devVagas.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devVagas.dto.SelectionProcessRequestDTO;
import br.com.devVagas.dto.SelectionProcessResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.entity.Applicant;
import br.com.devVagas.entity.Company;
import br.com.devVagas.entity.SelectionProcess;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.entity.Vacancy;
import br.com.devVagas.repository.AnalystRepository;
import br.com.devVagas.repository.ApplicantRepository;
import br.com.devVagas.repository.CompanyRepository;
import br.com.devVagas.repository.SelectionProcessRepository;
import br.com.devVagas.repository.SkillRepository;
import br.com.devVagas.repository.VacancyRepository;
import br.com.devVagas.service.SelectionProcessService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SelectionProcessServiceImpl implements SelectionProcessService{

	@Autowired
	private SelectionProcessRepository selectionProcessRepository;
	
	@Autowired
	private AnalystRepository analystRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private VacancyRepository vacancyRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	@Transactional
	@Override
	public SelectionProcessResponseDTO update(Long id, SelectionProcessRequestDTO request) {
		Optional<SelectionProcess> obj = selectionProcessRepository.findById(id);

		SelectionProcessResponseDTO response = null;

		if (obj.isPresent()) {

			obj.get().setTitle(request.getTitle());
			obj.get().setDescription(request.getDescription());
			obj.get().setVacancyQuantity(request.getVacancyQuantity());
			obj.get().setBeginDate(request.getBeginDate());
			obj.get().setEndDate(request.getEndDate());
			obj.get().setModifyDate(request.getModifyDate());
			obj.get().setCreateDate(request.getCreateDate());
			obj.get().setExclusionDate(request.getExclusionDate());
			obj.get().getCreateAnalyst().setId(request.getCreateAnalyst());
			obj.get().getModifyAnalyst().setId(request.getModifyAnalyst());
			obj.get().getExclusionAnalyst().setId(request.getExclusionAnalyst());
			obj.get().getCompany().setId(request.getCompany());
			obj.get().getVacancy().setId(request.getVacancy());
			obj.get().getAnalyst().setId(request.getAnalyst());

			Optional<Applicant> applicant = applicantRepository.findById(request.getApplicant());
			if (applicant.isPresent()) {
				obj.get().getApplicanties().forEach(applicantDTO -> {
					applicantDTO.setId(request.getApplicant());
				});
			}

			Optional<Skill> skill = skillRepository.findById(request.getSkill());
			if (skill.isPresent()) {
				obj.get().getSkills().forEach(skillDTO -> {
					skillDTO.setId(request.getSkill());
				});
			}

			Optional<Analyst> analyst = analystRepository.findById(request.getAnalyst());
			if (analyst.isPresent()) {
				obj.get().getAnalyst().setId(request.getAnalyst());
			}

			Optional<Company> company = companyRepository.findById(request.getCompany());
			if (company.isPresent()) {
				obj.get().getCompany().setId(request.getCompany());
			}

			Optional<Vacancy> vacancy = vacancyRepository.findById(request.getVacancy());
			if (vacancy.isPresent()) {
				obj.get().getVacancy().setId(request.getVacancy());
			}

			response = new SelectionProcessResponseDTO(obj.get(), analyst.get(), company.get(), vacancy.get(),
					applicant.get(), skill.get());

			selectionProcessRepository.save(obj.get());
			
			log.info("Alteração realizada com sucesso!");

		}
		return response;
	}

}
