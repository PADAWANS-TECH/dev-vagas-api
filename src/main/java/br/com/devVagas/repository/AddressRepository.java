package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
