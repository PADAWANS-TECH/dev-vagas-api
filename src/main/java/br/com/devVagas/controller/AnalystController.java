package br.com.devVagas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.service.AnalystService;

@RestController
@RequestMapping("/analyst")
public class AnalystController {
	
	
	@Autowired
	private AnalystService analystService;

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AnalystRequestDTO request){
		AnalystResponseDTO response = analystService.update(id, request);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}	
	
	@GetMapping
	public ResponseEntity<List<AnalystResponseDTO>> findAll(){
		
		List<Analyst> analyst = analystService.findAll();
		
		if(analyst.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}else {
			List<AnalystResponseDTO>objDTO = analyst
					.stream()
					.map(obj -> new AnalystResponseDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok(objDTO);
			
			
		}
		
	}
}
