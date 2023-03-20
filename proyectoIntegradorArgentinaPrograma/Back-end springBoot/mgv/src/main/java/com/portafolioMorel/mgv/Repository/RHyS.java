package com.portafolioMorel.mgv.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolioMorel.mgv.Entity.HyS;

@Repository
public interface RHyS extends JpaRepository<HyS, Integer>{
	public Optional<HyS> findByNombre(String nombre);
	public boolean existsByNombre(String nombre);


}
