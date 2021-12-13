package br.com.devVagas.service;

import br.com.devVagas.dto.SelectionProcessResponseDTO;

public interface SelectionProcessService {
	SelectionProcessResponseDTO findSelectionProcessById(Long id);

}
