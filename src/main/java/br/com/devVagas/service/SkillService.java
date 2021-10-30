package br.com.devVagas.service;

import br.com.devVagas.dto.SkillResponseDTO;

public interface SkillService {
   
	SkillResponseDTO findSkillById(Long id);
	boolean deleteSkill(Long id);
	
}
