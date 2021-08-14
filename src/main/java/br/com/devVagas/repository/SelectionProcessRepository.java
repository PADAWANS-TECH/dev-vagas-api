package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devVagas.entity.SelectionProcess;

public interface SelectionProcessRepository extends JpaRepository<SelectionProcess, Long> {

}
