package br.com.devVagas.service;

import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;

public interface SkillService {

	SkillResponseDTO update(Long id, SkillRequestDTO request);
}
