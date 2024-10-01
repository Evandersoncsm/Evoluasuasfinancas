package com.projeto.evoluasuasfinancas.service.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.ativos.Imobilizado;
import com.projeto.evoluasuasfinancas.repository.ativos.ImobilizadoRepository;

@Service
public class ImobilizadoService {
	
	@Autowired
	private ImobilizadoRepository imobilizadoRepository;
	
	public List<Imobilizado> getAllImobilizado(){
		return imobilizadoRepository.findAll();
	}
	public Optional<Imobilizado> getByIdImobilizado(Long id){
		return imobilizadoRepository.findById(id);
	}
	public Imobilizado saveAllImobilizado(Imobilizado imobilizado) {
		return imobilizadoRepository.save(imobilizado);
	}
	public void deleteByIdImobilizado(Long id) {
		imobilizadoRepository.deleteById(id);
	}

}
