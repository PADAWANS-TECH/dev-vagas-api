package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.service.AnalystService;
import br.com.devVagas.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	
	@Autowired
	private SkillService skillService;

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SkillRequestDTO request){
		SkillResponseDTO response = skillService.update(id, request);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}	
	
}
