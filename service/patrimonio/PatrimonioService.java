package com.projeto.evoluasuasfinancas.service.patrimonio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.patrimonio.Patrimonio;
import com.projeto.evoluasuasfinancas.repository.patrimonio.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	public List<Patrimonio> getAllPatrimonio(){
		return patrimonioRepository.findAll();
	}
	public Optional<Patrimonio> getByIdPatrimonio(Long id){
		return patrimonioRepository.findById(id);
	}
}
