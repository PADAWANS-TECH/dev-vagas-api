package br.com.devVagas.service;

import java.util.Collection;
import java.util.List;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;

public interface AnalystService {

	AnalystResponseDTO update(Long id, AnalystRequestDTO request);

	List<Analyst> findAll();

	AnalystResponseDTO findById(Long id);

}
