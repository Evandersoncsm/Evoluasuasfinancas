package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Lazer;
import com.projeto.evoluasuasfinancas.repository.gastos.LazerRepository;

@Service
public class LazerService {
	
	@Autowired
	private LazerRepository lazerRepository;
	
	public List<Lazer> getAllLazer(){
		return lazerRepository.findAll();
	}
	public Optional<Lazer> getByIdLazer(Long id){
		return lazerRepository.findById(id);
	}
	public Lazer SaveAllLazer(Lazer lazer) {
		return lazerRepository.save(lazer);
	}
	public void deleteByIdLazer(Long id) {
		lazerRepository.deleteById(id);
	}
}
