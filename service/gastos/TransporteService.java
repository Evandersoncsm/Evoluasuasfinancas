package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Transporte;
import com.projeto.evoluasuasfinancas.repository.gastos.TransporteRepository;

@Service
public class TransporteService {
	
	@Autowired
	private TransporteRepository transporteRepository;
	
	
	public List<Transporte> getAllTransporte(){
		return transporteRepository.findAll();
	}
	public Optional<Transporte> getByIdTransporte(Long id){
		return transporteRepository.findById(id);
	}
	public Transporte saveAllTransporte(Transporte transporte) {
		return transporteRepository.save(transporte);
	}
	public void DeleteByIdTransporte(Long id) {
		transporteRepository.deleteById(id);
	}
}
