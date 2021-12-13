package br.com.devVagas.service;


import java.util.List;

import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.entity.Skill;


public interface SkillService {
    SkillResponseDTO findById(Long id);
	List<Skill> findAll();
	SkillResponseDTO update(Long id, SkillRequestDTO requestUpdate); 
	SkillResponseDTO create(SkillRequestDTO requestCreate);
	SkillResponseDTO delete(Long id);
}


