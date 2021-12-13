package br.com.devVagas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.repository.SkillRepository;
import br.com.devVagas.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;
/*
 
 */
	@Override
	public SkillResponseDTO findById(Long id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			return new SkillResponseDTO(optionalSkill.get());
		}
		return null;
	}

	public List<Skill> findAll() {
		return skillRepository.findAll();
	}

	@Override
	public SkillResponseDTO update(Long id, SkillRequestDTO requestUpdate) {
		Optional<Skill> skill = skillRepository.findById(id);
		SkillResponseDTO response = null;
		if (skill.isPresent()) {
			skill.get().setId(requestUpdate.getId());
			skill.get().setName(requestUpdate.getName());
			skill.get().setColor(requestUpdate.getColor());
			skill.get().setKnowledgeLevel(requestUpdate.getKnowledgeLevel());
		} else {
		}
		response = new SkillResponseDTO(skill.get());
		skillRepository.save(skill.get());
		return response;
	}

	public SkillResponseDTO create(SkillRequestDTO requestCreate) {
		if (requestCreate != null) {
			Skill skill = convertDTOToEntity(requestCreate);
			requestCreate.setId(requestCreate.getId());
			requestCreate.setName(requestCreate.getName());
			requestCreate.setColor(requestCreate.getColor());
			requestCreate.setKnowledgeLevel(requestCreate.getKnowledgeLevel());
			skillRepository.save(skill);
			return SkillResponseDTO.convertEntityToDTO(skill);
		}
		return null;
	}

	private Skill convertDTOToEntity(SkillRequestDTO requestCreate) {
		Skill skill = new Skill();
		skill.setId(requestCreate.getId());
		skill.setName(requestCreate.getName());
		skill.setColor(requestCreate.getColor());
		skill.setKnowledgeLevel(requestCreate.getKnowledgeLevel());
		return skill;
	}

	@Override
	public SkillResponseDTO delete(Long id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			skillRepository.deleteById(id);
			return new SkillResponseDTO(optionalSkill.get());
		} else {
			return null;
		}
	}
}
