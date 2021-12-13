package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{

}
