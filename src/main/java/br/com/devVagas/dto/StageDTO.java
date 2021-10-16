package br.com.devVagas.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.devVagas.entity.Analyst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StageDTO {

	private Long id;
	private String name;
	private String description;
	private int quantityapplicant;
	private LocalDateTime beginDate;
	private LocalDateTime endDate;
	private int approved;
	private int failed;
}
