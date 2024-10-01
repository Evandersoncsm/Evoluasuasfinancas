package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.OutrosGastos;
import com.projeto.evoluasuasfinancas.repository.gastos.OutrosGastosRepository;

@Service
public class OutrosGastosService {
	
	@Autowired
	private OutrosGastosRepository outrosGastosRepository;
	
	public List<OutrosGastos> getAllOutrosGastos(){
		return outrosGastosRepository.findAll();
	}
	public Optional<OutrosGastos> getByIdOutrosGastos(Long id){
		return outrosGastosRepository.findById(id);
	}
	public OutrosGastos saveAllOutrosGastos(OutrosGastos outrosGastos) {
		return outrosGastosRepository.save(outrosGastos);
	}
	public void deleteByIdOutrosGastos(Long id) {
		outrosGastosRepository.deleteById(id);
	}
}
