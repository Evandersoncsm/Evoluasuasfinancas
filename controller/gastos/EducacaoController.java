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

import com.projeto.evoluasuasfinancas.model.gastos.Educacao;
import com.projeto.evoluasuasfinancas.service.gastos.EducacaoService;

@RestController
@RequestMapping("/api/educacao")
public class EducacaoController {

	@Autowired
	private EducacaoService educacaoService;
	
	@GetMapping
	public ResponseEntity<List<Educacao>> getAllEducacao(){
		return ResponseEntity.ok(educacaoService.getAllEducacao());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Educacao>> getByIdEducacao(@PathVariable Long id){
		Optional<Educacao> educacao = educacaoService.getByIdEducacao(id);
		if(educacao.isPresent()) {
			return ResponseEntity.ok(educacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Educacao> createAllEducacao(@RequestBody Educacao educacao){
		return new ResponseEntity<>(educacaoService.saveAllEducacao(educacao), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Educacao> updateEducacao(@PathVariable Long id, @RequestBody Educacao educacao){
		Optional<Educacao> existingEducacao = educacaoService.getByIdEducacao(id);
		if(existingEducacao.isPresent()) {
			educacao.setId(id);
			Educacao updateEducacao = educacaoService.saveAllEducacao(educacao);
			return ResponseEntity.ok(updateEducacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdEducacao(@PathVariable Long id){
		Optional<Educacao> educacao = educacaoService.getByIdEducacao(id);
		if(educacao.isPresent()) {
			educacaoService.deleteByIdEducacao(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
} 





