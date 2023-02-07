package com.portafolioMorel.mgv.Security.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolioMorel.mgv.Security.Entity.Rol;
import com.portafolioMorel.mgv.Security.Enums.RolNombre;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
	
	Optional<Rol>findByRolNombre(RolNombre rolNombre);
	

}
