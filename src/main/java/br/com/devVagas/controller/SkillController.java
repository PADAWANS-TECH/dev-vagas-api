package br.com.devVagas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.SkillRequestDTO;
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        SkillResponseDTO response = skillService.findById(id);
        if(response != null) {
        	return ResponseEntity.ok(response);
        } else {
        	return ResponseEntity.notFound().build();        	
        }
    }
	@GetMapping
	public ResponseEntity<List<SkillResponseDTO>>      findListAll() {
		List<SkillResponseDTO> responseListSkillDTO = skillService.findAll().stream().map(obj -> new SkillResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(responseListSkillDTO);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SkillRequestDTO requestUpdate){
		SkillResponseDTO response = skillService.update(id, requestUpdate);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
      SkillResponseDTO response = skillService.delete(id);
		if (response != null) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	private ResponseEntity<SkillResponseDTO> create(@RequestBody SkillRequestDTO requestCreate){
		 SkillResponseDTO response = skillService.create(requestCreate);
		 System.out.println("-Create Controller");

		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
}
