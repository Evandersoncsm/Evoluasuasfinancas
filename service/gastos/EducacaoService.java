package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Educacao;
import com.projeto.evoluasuasfinancas.repository.gastos.EducacaoRepository;

@Service
public class EducacaoService {
	
	@Autowired
	private EducacaoRepository educacaoRepository;
	
	public List<Educacao> getAllEducacao(){
		return educacaoRepository.findAll();
	}
	public Optional<Educacao> getByIdEducacao(Long id){
		return educacaoRepository.findById(id);
	}
	public Educacao saveAllEducacao(Educacao educacao) {
		return educacaoRepository.save(educacao);
	}
	public void deleteByIdEducacao(Long id) {
		educacaoRepository.deleteById(id);
	}
}
