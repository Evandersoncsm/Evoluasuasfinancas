package com.projeto.evoluasuasfinancas.controller.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.ativos.Investimentos;
import com.projeto.evoluasuasfinancas.service.ativos.InvestimentosService;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentosController {
	
	@Autowired
	private InvestimentosService investimentosService;
	
	@GetMapping
	public ResponseEntity<List<Investimentos>> getAllInvestimentos(){
		List<Investimentos> investimentos = investimentosService.getAllInvestimentos();
		System.out.println("Consulta realizada!");
		System.out.println("Total de investimentos encontrados: "+investimentos.size());
		return ResponseEntity.ok(investimentosService.getAllInvestimentos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Investimentos>> getByIdInvestimentos(@PathVariable Long id){
		Optional<Investimentos> investimentos = investimentosService.getByIdInvestimentos(id);
		if(investimentos.isPresent()) {
			return ResponseEntity.ok(investimentos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Investimentos> createInvestimentos(@RequestBody Investimentos investimentos){
		Investimentos saveAllInvestimentos = investimentosService.saveAllInvestimentos(investimentos);
		System.out.println("Investimento salvo!");
		System.out.println("Descrição: "+saveAllInvestimentos.getDescricao());
		System.out.println("valor: "+saveAllInvestimentos.getValor());
		return new ResponseEntity<>(saveAllInvestimentos, HttpStatus.CREATED);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Investimentos> updateInvestimentos(@PathVariable Long id, @RequestBody Investimentos investimentos){
		Optional<Investimentos> existingInvestimentos = investimentosService.getByIdInvestimentos(id);
		if(existingInvestimentos.isPresent()) {
			investimentos.setId(id);
			Investimentos updateInvestimentos = investimentosService.saveAllInvestimentos(investimentos);
			System.out.println("Investimento atualizado!");
			System.out.println("Descrição: " + updateInvestimentos.getDescricao());
			System.out.println("Valor: "+updateInvestimentos.getValor());
			return ResponseEntity.ok(updateInvestimentos);
		}
		else {
		    return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdInvestimentos(@PathVariable Long id){
		Optional<Investimentos> investimentos = investimentosService.getByIdInvestimentos(id);
		if(investimentos.isPresent()) {
			System.out.println("Investimento excluído!");
			System.out.println("Descrição: "+investimentos.get().getDescricao());
			System.out.println("Valor: "+investimentos.get().getValor());
			investimentosService.deleteByIdInvestimentos(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
