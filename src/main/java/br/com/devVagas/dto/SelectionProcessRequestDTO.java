package br.com.devVagas.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SelectionProcessRequestDTO {
	
	private Long id;
	private String title;
	private String description;
	private Integer vacancyQuantity;
	private LocalDateTime beginDate;
	private LocalDateTime endDate;
	private LocalDateTime modifyDate;
	private LocalDateTime createDate;
	private LocalDateTime exclusionDate;
	private Long createAnalyst;
	private Long modifyAnalyst;
	private Long exclusionAnalyst;
	private Long company;
	private Long vacancy;
	private Long analyst;
	private Long applicant;
	private Long skill;
	
}
