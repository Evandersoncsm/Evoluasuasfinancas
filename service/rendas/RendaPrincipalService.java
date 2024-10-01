package com.projeto.evoluasuasfinancas.service.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.rendas.RendaPrincipal;
import com.projeto.evoluasuasfinancas.repository.rendas.RendaPrincipalRepository;

@Service
public class RendaPrincipalService {
	
	@Autowired
	private RendaPrincipalRepository rendaPrincipalRepository;
	
	public List<RendaPrincipal> getAllRendaPrincipal(){
		return rendaPrincipalRepository.findAll();
	}
	public Optional<RendaPrincipal> getByIdRendaPrincipal(Long id){
		return rendaPrincipalRepository.findById(id);
	}
	public RendaPrincipal saveAllRendaPrincipal(RendaPrincipal rendaPrincipal) {
		return rendaPrincipalRepository.save(rendaPrincipal);
	}
	public void deleteByIdRendaPrincipal(Long id) {
		rendaPrincipalRepository.deleteById(id);
	}

}
