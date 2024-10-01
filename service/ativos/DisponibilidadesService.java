package com.projeto.evoluasuasfinancas.service.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.ativos.Disponibilidades;
import com.projeto.evoluasuasfinancas.repository.ativos.DisponibilidadesRepository;

@Service
public class DisponibilidadesService {

	@Autowired
	private DisponibilidadesRepository disponibilidadesRepository;
	
	public List<Disponibilidades> getAllDisponibilidades(){
		return disponibilidadesRepository.findAll();
	}
	public Optional<Disponibilidades> getByIdDisponibilidades(Long id){
		return disponibilidadesRepository.findById(id);
	}
	public Disponibilidades saveAllDisponibilidades(Disponibilidades disponibilidades) {
		return disponibilidadesRepository.save(disponibilidades);
	}
	public void deleteByIdDisponibilidades(Long id) {
		disponibilidadesRepository.deleteById(id);
	}
}
