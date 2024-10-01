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

import com.projeto.evoluasuasfinancas.model.gastos.Dividas;
import com.projeto.evoluasuasfinancas.service.gastos.DividasService;

@RestController
@RequestMapping("/api/dividas")
public class DividasController {
	
	@Autowired
	private DividasService dividasService;
	
	@GetMapping
	public ResponseEntity<List<Dividas>> getAllDividas(){
		List<Dividas> dividas = dividasService.getAllDividas();
		System.out.println("Busca realizada!");
		System.out.println("Total de disponibilidades encontrado: " + dividas.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(dividasService.getAllDividas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Dividas>> getByIdDividas(@PathVariable Long id){
		Optional<Dividas> dividas = dividasService.getByIdDividas(id);
		if(dividas.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(dividas);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Dividas> createAllDividas(@RequestBody Dividas dividas){
		System.out.println("Disponibilidades salvo com sucesso!");
		System.out.println("Descrição: " + dividas.getDescricao());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(dividasService.saveAllDividas(dividas), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dividas> updateByIdDividas(@PathVariable Long id, @RequestBody Dividas dividas){
		Optional<Dividas> existingDividas = dividasService.getByIdDividas(id);
		if(existingDividas.isPresent()) {
			dividas.setId(id);
			Dividas updateByIdDividas = dividasService.saveAllDividas(dividas);
			System.out.println("Disponibilidade salvo com sucesso!");
			System.out.println("Descrição: " + dividas.getDescricao());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateByIdDividas);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdDividas(@PathVariable Long id){
		Optional<Dividas> existingDividas = dividasService.getByIdDividas(id);
		if(existingDividas.isPresent()) {
			dividasService.deleteByIdDividas(id);
			System.out.println("Disponibilidade salvo com sucesso!");
			System.out.println("Descrição: " + existingDividas.get().getDescricao());
			System.out.println("HttpStatus 200");
			return ResponseEntity.noContent().build();
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}	
}	
	
