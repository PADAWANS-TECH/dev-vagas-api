package br.com.devVagas.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.SelectionProcessResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.entity.Company;
import br.com.devVagas.entity.SelectionProcess;
import br.com.devVagas.entity.Vacancy;
import br.com.devVagas.repository.SelectionProcessRepository;
import br.com.devVagas.repository.VacancyRepository;
import br.com.devVagas.service.SelectionProcessService;

@Service
public class SelectionProcessServiceImpl implements SelectionProcessService{
	
	@Autowired
	private SelectionProcessRepository selectionProcessRepository;
	

	@Override
	public SelectionProcessResponseDTO findSelectionProcessById(Long id) {
		Optional<SelectionProcess> optionalSelectionProcess = selectionProcessRepository.findById(id);
		
		if(optionalSelectionProcess.isPresent()) {
			return new SelectionProcessResponseDTO(optionalSelectionProcess.get());
		}
		return null;
	}

}
