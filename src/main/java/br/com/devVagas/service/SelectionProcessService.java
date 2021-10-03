package br.com.devVagas.service;

import br.com.devVagas.dto.SelectionProcessRequestDTO;
import br.com.devVagas.dto.SelectionProcessResponseDTO;
import br.com.devVagas.entity.SelectionProcess;

public interface SelectionProcessService {

	public SelectionProcessResponseDTO update(Long id, SelectionProcessRequestDTO request);
	
}
