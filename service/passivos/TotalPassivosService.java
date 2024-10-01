package com.projeto.evoluasuasfinancas.service.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.passivos.TotalPassivos;
import com.projeto.evoluasuasfinancas.repository.passivos.TotalPassivosRepository;

@Service
public class TotalPassivosService {
	
	@Autowired
	private TotalPassivosRepository totalPassivosRepository;
	
	public List<TotalPassivos> getAllTotalPassivos(){
		return totalPassivosRepository.findAll();
	}
	public Optional<TotalPassivos> getByIdTotalPassivos(Long id){
		return totalPassivosRepository.findById(id);
	}
}
