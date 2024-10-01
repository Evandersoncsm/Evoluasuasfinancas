package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Pets;
import com.projeto.evoluasuasfinancas.repository.gastos.PetsRepository;

@Service
public class PetsService {

	@Autowired
	private PetsRepository petsRepository;
	
	public List<Pets> getAllPets(){
		return petsRepository.findAll();
	}
	public Optional<Pets> getByIdPets(Long id){
		return petsRepository.findById(id);
	}
	public Pets saveAllPets(Pets pets) {
		return petsRepository.save(pets);
	}
	public void deleteByIdPets(Long id) {
		petsRepository.deleteById(id);
	}
}
