package com.portafolioMorel.mgv.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolioMorel.mgv.Entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

	List<Persona> findAll();

	void deleteById(Long id);

	Optional<Persona> findById(Long id);
	
	

}
