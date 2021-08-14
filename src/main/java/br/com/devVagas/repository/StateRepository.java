package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devVagas.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
