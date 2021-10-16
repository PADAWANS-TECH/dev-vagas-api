package br.com.devVagas.service;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;

public interface AnalystService {

	AnalystResponseDTO update(Long id, AnalystRequestDTO request);

	void delete(Long id);
}
