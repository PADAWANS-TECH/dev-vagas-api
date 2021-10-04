package br.com.devVagas.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.repository.SkillRepository;
import br.com.devVagas.service.SkillService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public SkillResponseDTO update(Long id, SkillRequestDTO request) {
		Optional<Skill> skill= skillRepository.findById(id);
		SkillResponseDTO response = null;
		
		if(skill.isPresent()) {
			skill.get().setId(request.getId());
			skill.get().setName(request.getName());
			skill.get().setColor(request.getColor());
			skill.get().setKnowledgeLevel(request.getKnowledgeLevel());
		}else {
			log.info("Falha em alterar Skill.");
		}
		log.info("Skill alterado com sucesso!");
		response = new SkillResponseDTO(skill.get());
		skillRepository.save(skill.get());
		return response;
	}

}
