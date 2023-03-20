package com.portafolioMorel.mgv.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolioMorel.mgv.Entity.Educacion;
import com.portafolioMorel.mgv.Entity.Experiencia;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
	
	public Optional<Educacion> findByNombreEd(String nombreEd);
	public boolean existsByNombreEd(String nombreEd);

}
