package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Saude;
import com.projeto.evoluasuasfinancas.repository.gastos.SaudeRepository;

@Service
public class SaudeService {
	
	@Autowired
	private SaudeRepository saudeRepository;
	
	public List<Saude> getAllSaude(){
		return saudeRepository.findAll();
	}
	public Optional<Saude> getByIdSaude(Long id){
		return saudeRepository.findById(id);
	}
	public Saude saveAllMoradia(Saude saude) {
		return saudeRepository.save(saude);
	}
	public void deleteByIdSaude(Long id) {
		saudeRepository.deleteById(id);
	}

}
