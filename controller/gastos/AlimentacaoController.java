package com.projeto.evoluasuasfinancas.controller.gastos;

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

import com.projeto.evoluasuasfinancas.model.gastos.Alimentacao;
import com.projeto.evoluasuasfinancas.service.gastos.AlimentacaoService;

@RestController
@RequestMapping("/api/alimentacao")
public class AlimentacaoController {

	@Autowired
	private AlimentacaoService alimentacaoService;
	
	@GetMapping
	public ResponseEntity<List<Alimentacao>> getAllAlimentacao(){
		return ResponseEntity.ok(alimentacaoService.getAlAlimentacao());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Alimentacao>> getByIdAlimentacao(@PathVariable Long id){
		Optional<Alimentacao> alimentacao = alimentacaoService.getByIdAlimentacao(id);
		if(alimentacao.isPresent()) {
			return ResponseEntity.ok(alimentacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Alimentacao> createAllAlimentacao(@RequestBody Alimentacao alimentacao){
		return new ResponseEntity<>(alimentacaoService.saveAllAlimentacao(alimentacao), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Alimentacao> updateByIdAlimentacao(@PathVariable Long id, @RequestBody Alimentacao alimentacao){
		Optional<Alimentacao> existingAlimentacao = alimentacaoService.getByIdAlimentacao(id);
		if(existingAlimentacao.isPresent()) {
			alimentacao.setId(id);
			Alimentacao updateAlimentacao = alimentacaoService.saveAllAlimentacao(alimentacao);
			return ResponseEntity.ok(updateAlimentacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdAlimentacao(@PathVariable Long id){
		Optional<Alimentacao> alimentacao = alimentacaoService.getByIdAlimentacao(id);
		if(alimentacao.isPresent()) {
			alimentacaoService.deleteByIdAlimentacao(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}







