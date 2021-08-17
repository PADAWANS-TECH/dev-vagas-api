package br.com.devVagas.service;

import java.util.Optional;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;

public interface AnalystService {

	AnalystResponseDTO update(Long id, AnalystRequestDTO request);

	Optional<Analyst> find(Long id);
}
