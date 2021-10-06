package br.com.devVagas.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StageDTO {

	    private Long id;
	    private String name;
	    private String description;
	    private Integer quantityapplicant;
	    private LocalDateTime beginDate;
	    private LocalDateTime endDate;
	    private Integer approved;
	    private Integer failed;
}
