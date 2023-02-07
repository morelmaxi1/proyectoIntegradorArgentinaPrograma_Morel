package com.portafolioMorel.mgv.Security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolioMorel.mgv.Security.Entity.Usuario;
import com.portafolioMorel.mgv.Security.Repository.IUsuarioRepository;

@Service
//@Transactional
public class UsuarioService {

	@Autowired
	IUsuarioRepository isuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return isuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return isuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {
		return isuarioRepository.existsByEmail(email);
	}

	public void save(Usuario usuario) {
		isuarioRepository.save(usuario);
	}
}
