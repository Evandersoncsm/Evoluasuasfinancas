package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Dividas;
import com.projeto.evoluasuasfinancas.repository.gastos.DividasRepository;

@Service
public class DividasService {

	@Autowired
	private DividasRepository dividasRepository;
	
	public List<Dividas> getAllDividas(){
		return dividasRepository.findAll();
	}
	public Optional<Dividas> getByIdDividas(Long id){
		return dividasRepository.findById(id);
	}
	public Dividas saveAllDividas(Dividas dividas) {
		return dividasRepository.save(dividas);
	}
	public void deleteByIdDividas(Long id) {
		dividasRepository.deleteById(id);
	}
}
