package com.projeto.evoluasuasfinancas.service.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.passivos.Fornecedores;
import com.projeto.evoluasuasfinancas.repository.passivos.FornecedoresRepository;

@Service
public class FornecedoresService {
	
	@Autowired
	private FornecedoresRepository fornecedoresRepository;
	
	public List<Fornecedores> getAllFornecedores(){
		return fornecedoresRepository.findAll();
	}
	public Optional<Fornecedores> getByIdFornecedores(Long id){
		return fornecedoresRepository.findById(id);
	}
	public Fornecedores saveAllFornecedores(Fornecedores fornecedores) {
		return fornecedoresRepository.save(fornecedores);
	}
	public void deleteByIdFornecedores(Long id) {
		fornecedoresRepository.deleteById(id);
	}
}
