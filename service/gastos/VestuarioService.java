package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Vestuario;
import com.projeto.evoluasuasfinancas.repository.gastos.VestuarioRepository;

@Service
public class VestuarioService {
	
	@Autowired
	private VestuarioRepository vestuarioRepository;
	
	public List<Vestuario> getAllVestuario(){
		return vestuarioRepository.findAll();
	}
	public Optional<Vestuario> getByIdVestuario(Long id){
		return vestuarioRepository.findById(id);
	}
	public Vestuario saveAllVestuario(Vestuario vestuario) {
		return vestuarioRepository.save(vestuario);
	}
	public void deleteByIdVestuario(Long id) {
		vestuarioRepository.deleteById(id);
	}
}
