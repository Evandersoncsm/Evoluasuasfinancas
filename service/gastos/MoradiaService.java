package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Moradia;
import com.projeto.evoluasuasfinancas.repository.gastos.MoradiaRepository;

@Service
public class MoradiaService {
	
	@Autowired
	private MoradiaRepository moradiaRepository;
	
	public List<Moradia> getAllMoradia(){
		return moradiaRepository.findAll();
	}
	public Optional<Moradia> getByIdMoradia(Long id){
		return moradiaRepository.findById(id);
	}
	public Moradia saveAllMoradia(Moradia moradia) {
		return moradiaRepository.save(moradia);
	}
	public void deleteByIdMoradia(Long id) {
		moradiaRepository.deleteById(id);
	}

}
