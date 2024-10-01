package com.projeto.evoluasuasfinancas.service.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.rendas.RendaPassiva;
import com.projeto.evoluasuasfinancas.repository.rendas.RendaPassivaRepository;

@Service
public class RendaPassivaService {
	
	@Autowired
	public RendaPassivaRepository rendaPassivaRepository;
	
	public List<RendaPassiva> getAllRendaPassiva(){
		return rendaPassivaRepository.findAll();
	}
	public Optional<RendaPassiva> getByIdRendaPassiva(Long id){
		return rendaPassivaRepository.findById(id);
	}
	public RendaPassiva saveRendaPassiva(RendaPassiva rendaPassiva) {
		return rendaPassivaRepository.save(rendaPassiva);
	}
	public void deleteByIdRendaPassiva(Long id) {
		rendaPassivaRepository.deleteById(id);
	}

}
