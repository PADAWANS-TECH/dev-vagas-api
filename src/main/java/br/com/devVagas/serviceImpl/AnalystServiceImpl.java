package br.com.devVagas.serviceImpl;

import java.util.Optional;

import javax.script.Invocable;

import org.aopalliance.intercept.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.repository.AnalystRepository;
import br.com.devVagas.service.AnalystService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnalystServiceImpl implements AnalystService {

	@Autowired
	private AnalystRepository analystRepository;

	@Override
	public AnalystResponseDTO update(Long id, AnalystRequestDTO request) {
		Optional<Analyst> optionalAnalyst = analystRepository.findById(id);
		AnalystResponseDTO response = null;
		if (optionalAnalyst.isPresent())
			optionalAnalyst.get().setEmail(request.getEmail());
		optionalAnalyst.get().setName(request.getName());
		optionalAnalyst.get().setTelephone(request.getTelephone());
		response = new AnalystResponseDTO(optionalAnalyst.get());
		analystRepository.save(optionalAnalyst.get());
		log.info("\t\t\tAnalista salvo com sucesso!!!");
		return response;
	}

	@Override
	public void delete(Long id) {
		analystRepository.deleteById(id);
	}

}
