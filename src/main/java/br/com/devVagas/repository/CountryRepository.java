package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}