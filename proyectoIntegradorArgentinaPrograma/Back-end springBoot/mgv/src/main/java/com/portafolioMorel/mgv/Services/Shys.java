package com.portafolioMorel.mgv.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolioMorel.mgv.Entity.HyS;
import com.portafolioMorel.mgv.Repository.RHyS;

@Service
@Transactional
public class Shys {

	@Autowired
	RHyS rHys;
	
	public List<HyS> list() {
		return rHys.findAll();
	}
	public Optional<HyS> getOne(int id) {
		return rHys.findById(id);
	}
	public Optional<HyS> getByNombre(String nombre) {
		return rHys.findByNombre(nombre);
	}

	public void save(HyS hys) {
		rHys.save(hys);
	}
	public void delete(int id) {
		rHys.deleteById(id);
	}
	public boolean existsByid(int id) {
		return rHys.existsById(id);
	}
	public boolean existsByNombre(String nombre) {
		return rHys.existsByNombre(nombre);
	}

	
	
	
}
