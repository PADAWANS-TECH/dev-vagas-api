package br.com.devVagas.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.repository.AnalystRepository;
import br.com.devVagas.service.AnalystService;

public class AnalystServiceImpl implements AnalystService{

	@Autowired
	private AnalystRepository analystRepository;

	@Override
	public AnalystResponseDTO update(Long id, AnalystRequestDTO request) {
		Optional<Analyst> optionalAnalyst = analystRepository.findById(id);
		AnalystResponseDTO response = null;
		if(optionalAnalyst.isPresent())
			optionalAnalyst.get().setEmail(request.getEmail());
			optionalAnalyst.get().setName(request.getName());
			optionalAnalyst.get().setTelephone(request.getTelephone());
			response = new AnalystResponseDTO(optionalAnalyst.get());
			analystRepository.save(optionalAnalyst.get());
		return response;
	}

}
