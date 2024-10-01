package com.projeto.evoluasuasfinancas.service.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.ativos.Investimentos;
import com.projeto.evoluasuasfinancas.repository.ativos.InvestimentosRepository;

@Service
public class InvestimentosService {

	@Autowired
	private InvestimentosRepository investimentosRepository;
	
	public List<Investimentos> getAllInvestimentos(){
		return investimentosRepository.findAll();
	}
	public Optional<Investimentos> getByIdInvestimentos(Long id){
		return investimentosRepository.findById(id);
	}
	public Investimentos saveAllInvestimentos(Investimentos investimentos) {
		System.out.println(investimentos);
		return investimentosRepository.save(investimentos);
	}
	public void deleteByIdInvestimentos(Long id) {
		investimentosRepository.deleteById(id);
	}
}
