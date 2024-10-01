package com.projeto.evoluasuasfinancas.service.gastos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.gastos.Alimentacao;
import com.projeto.evoluasuasfinancas.repository.gastos.AlimentaçãoRepositoty;

@Service
public class AlimentacaoService {
	
	@Autowired
	private AlimentaçãoRepositoty alimentaçãoRepositoty;
	
	public List<Alimentacao> getAlAlimentacao(){
		return alimentaçãoRepositoty.findAll();
	}
	public Optional<Alimentacao> getByIdAlimentacao(Long id){
		return alimentaçãoRepositoty.findById(id);
	}
	public Alimentacao saveAllAlimentacao(Alimentacao alimentacao) {
		return alimentaçãoRepositoty.save(alimentacao);
	}
	public void deleteByIdAlimentacao(Long id) {
		alimentaçãoRepositoty.deleteById(id);
	}
}
