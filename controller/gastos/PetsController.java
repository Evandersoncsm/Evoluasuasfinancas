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

import com.projeto.evoluasuasfinancas.model.gastos.Pets;
import com.projeto.evoluasuasfinancas.service.gastos.PetsService;

@RestController
@RequestMapping("/api/pets")
public class PetsController {
	
	@Autowired
	private PetsService petsService;
	
	@GetMapping
	public ResponseEntity<List<Pets>> getAllPets(){
		List<Pets> pets = petsService.getAllPets();
		System.out.println("Busca realizada!");
		System.out.println("Total de disponibilidades encontrado: " + pets.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(petsService.getAllPets());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pets>> getByIdPets(@PathVariable Long id){
		Optional<Pets> pets = petsService.getByIdPets(id);
		if(pets.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(pets);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Pets> createAllPets(@RequestBody Pets pets){
		System.out.println("Disponibilidades salvo com sucesso!");
		System.out.println("Descrição: " + pets.getDescricao());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(petsService.saveAllPets(pets), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pets> updateByIdPets(@PathVariable Long id, @RequestBody Pets pets){
		Optional<Pets> existingPets = petsService.getByIdPets(id);
		if(existingPets.isPresent()) {
			pets.setId(id);
			Pets updateByIdPets = petsService.saveAllPets(pets);
			System.out.println("Disponibilidade salvo com sucesso!");
			System.out.println("Descrição: "+pets.getDescricao());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateByIdPets);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletByIdPets(@PathVariable Long id){
		Optional<Pets> existingPets = petsService.getByIdPets(id);
		if(existingPets.isPresent()) {
			petsService.deleteByIdPets(id);
			System.out.println("Disponibilidade excluída com sucesso!");
			System.out.println("Descrição: " + existingPets.get().getDescricao());
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
