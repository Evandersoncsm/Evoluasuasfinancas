package com.projeto.evoluasuasfinancas.service.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.rendas.OutrasRendas;
import com.projeto.evoluasuasfinancas.repository.rendas.OutrasRendasRepository;

@Service
public class OutrasRendasService {
	
	@Autowired
	private OutrasRendasRepository outrasRendasRepository;
	
	public List<OutrasRendas> getAllOutrasRendas(){
		return outrasRendasRepository.findAll();
	}
	public Optional<OutrasRendas> getByIdOutrasRendas(long id){
		return outrasRendasRepository.findById(id);
	}
	public OutrasRendas saveAllOutrasRendas(OutrasRendas outrasRendas) {
		return outrasRendasRepository.save(outrasRendas);
	}
	public void deleteByIdOutrasRendas(long id) {
		outrasRendasRepository.deleteById(id);
	}
}
