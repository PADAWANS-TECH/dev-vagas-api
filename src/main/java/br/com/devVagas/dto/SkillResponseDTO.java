package br.com.devVagas.dto;

import br.com.devVagas.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillResponseDTO {

    private Long id;
    private String name;
    private String color;
    private Integer knowledgeLevel;

    public static SkillResponseDTO convertEntityToDTO(Skill skill) {
	SkillResponseDTO skillResponseDTO = new SkillResponseDTO();
	skillResponseDTO.setId(skill.getId());
	skillResponseDTO.setName(skill.getName());
	skillResponseDTO.setColor(skill.getColor());
	skillResponseDTO.setKnowledgeLevel(skill.getKnowledgeLevel());
	return skillResponseDTO;
    }
    public SkillResponseDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.color = skill.getColor();
        this.knowledgeLevel = skill.getKnowledgeLevel();
    }
}
