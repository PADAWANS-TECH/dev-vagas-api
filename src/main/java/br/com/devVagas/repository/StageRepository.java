package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{

}
