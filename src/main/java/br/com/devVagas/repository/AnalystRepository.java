package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Analyst;
@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long>{

}
