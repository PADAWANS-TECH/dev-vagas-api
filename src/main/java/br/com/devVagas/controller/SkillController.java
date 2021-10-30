package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findSkillById(@PathVariable Long id) {
        SkillResponseDTO response = skillService.findSkillById(id);
        if(response != null) {
        	return ResponseEntity.ok(response);
        } else {
        	return ResponseEntity.notFound().build();        	
        }
    }
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?>deleteSkill(@PathVariable Long id){
		
		boolean response = skillService.deleteSkill(id);
		if(response) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}
