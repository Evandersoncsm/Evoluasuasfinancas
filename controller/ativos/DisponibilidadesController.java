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

import com.projeto.evoluasuasfinancas.model.ativos.Disponibilidades;
import com.projeto.evoluasuasfinancas.service.ativos.DisponibilidadesService;

@RestController
@RequestMapping("/api/disponibilidades")
public class DisponibilidadesController {
	
	@Autowired
	private DisponibilidadesService disponibilidadesService;
	
	@GetMapping
	public ResponseEntity<List<Disponibilidades>> getAllDisponibilidades(){
		List<Disponibilidades> disponibilidades = disponibilidadesService.getAllDisponibilidades();
		System.out.println("Busca realizada!");
		System.out.println("Total de disponibilidades encontrado: "+disponibilidades.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(disponibilidadesService.getAllDisponibilidades());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Disponibilidades>> getByIdDisponibilidades(@PathVariable Long id){
		Optional<Disponibilidades> disponibilidades = disponibilidadesService.getByIdDisponibilidades(id);
		if(disponibilidades.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(disponibilidades);
	
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Disponibilidades> createAllDisponibilidades(@RequestBody Disponibilidades disponibilidades){
		System.out.println("Disponibilidades salvo com sucesso!");
		System.out.println("Descrição: "+disponibilidades.getDescricao());
		System.out.println("Valor: "+disponibilidades.getValor());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(disponibilidadesService.saveAllDisponibilidades(disponibilidades), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disponibilidades> updateDisponibilidades(@PathVariable Long id, @RequestBody Disponibilidades disponibilidades){
		Optional<Disponibilidades> existingDisponibilidades = disponibilidadesService.getByIdDisponibilidades(id);
		if(existingDisponibilidades.isPresent()) {
			disponibilidades.setId(id);
			Disponibilidades updateDisponibilidades = disponibilidadesService.saveAllDisponibilidades(disponibilidades);
			System.out.println("Disponibilidade salvo com sucesso!");
			System.out.println("Descrição: "+disponibilidades.getDescricao());
			System.out.println("Valor: "+disponibilidades.getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateDisponibilidades);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdDisponibilidades(@PathVariable Long id){
		Optional<Disponibilidades> existingDiponibilidades = disponibilidadesService.getByIdDisponibilidades(id);
		if(existingDiponibilidades.isPresent()) {
			disponibilidadesService.deleteByIdDisponibilidades(id);
			System.out.println("Disponibilidade excluída com sucesso!");
			System.out.println("Descrição: "+existingDiponibilidades.get().getDescricao());
			System.out.println("Valor: "+existingDiponibilidades.get().getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.noContent().build();
		}
		else {
			System.err.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
}
