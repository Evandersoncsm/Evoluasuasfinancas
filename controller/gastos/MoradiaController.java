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

import com.projeto.evoluasuasfinancas.model.gastos.Moradia;
import com.projeto.evoluasuasfinancas.service.gastos.MoradiaService;

@RestController
@RequestMapping("/api/moradia")
public class MoradiaController {
	
	@Autowired
	private MoradiaService moradiaService;
	
	
	@GetMapping
	public ResponseEntity<List<Moradia>> getAllMoradia(){
		return ResponseEntity.ok(moradiaService.getAllMoradia());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Moradia>> getByIdMoradia(@PathVariable Long id){
		Optional<Moradia> moradia = moradiaService.getByIdMoradia(id);
		if(moradia.isPresent()) {
			return ResponseEntity.ok(moradia);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Moradia> createAllMoradia(@RequestBody Moradia moradia){
		return new ResponseEntity<>(moradiaService.saveAllMoradia(moradia), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Moradia> updateMoradia(@PathVariable Long id, @RequestBody Moradia moradia){
		Optional<Moradia> existingMoradia = moradiaService.getByIdMoradia(id);
		if(existingMoradia.isPresent()) {
			moradia.setId(id);
			Moradia updateMoradia = moradiaService.saveAllMoradia(moradia);
			return ResponseEntity.ok(updateMoradia);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdMoradia(@PathVariable Long id){
		Optional<Moradia> moradia = moradiaService.getByIdMoradia(id);
		if(moradia.isPresent()) {
			moradiaService.deleteByIdMoradia(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
