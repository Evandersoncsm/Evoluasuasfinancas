package com.projeto.evoluasuasfinancas.service.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.rendas.RendaExtra;
import com.projeto.evoluasuasfinancas.repository.rendas.RendaExtraRepository;

@Service
public class RendaExtraService {

	@Autowired
	private RendaExtraRepository rendaExtraRepository;
	
	public List<RendaExtra> getAllRendaExtra(){
		return rendaExtraRepository.findAll();
	}
	public Optional<RendaExtra> getByIdRendaExtra(Long id){
		return rendaExtraRepository.findById(id);
	}
	public RendaExtra saveAllRendaExtra(RendaExtra rendaExtra) {
		return rendaExtraRepository.save(rendaExtra);
	}
	public void deleteByIdRendaExtra(Long id) {
		rendaExtraRepository.deleteById(id);
	}
}
