package com.projeto.evoluasuasfinancas.service.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.ativos.TotalAtivos;
import com.projeto.evoluasuasfinancas.repository.ativos.TotalAtivosRepository;

@Service
public class TotalAtivosService {
	
	@Autowired
	private TotalAtivosRepository totalAtivosRepository;
	
	public List<TotalAtivos> getAllTotalAtivos(){
		return totalAtivosRepository.findAll();
	}
	public Optional<TotalAtivos> getByIdTotalAtivos(Long id){
		return totalAtivosRepository.findById(id);
	}

}
