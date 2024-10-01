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

import com.projeto.evoluasuasfinancas.model.gastos.Saude;
import com.projeto.evoluasuasfinancas.service.gastos.SaudeService;

@RestController
@RequestMapping("/api/saude")
public class SaudeController {
	
	@Autowired
	private SaudeService saudeService;
	
	@GetMapping
	public ResponseEntity<List<Saude>> getAllSaude(){
		return ResponseEntity.ok(saudeService.getAllSaude());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Saude>> getByIdSaude(@PathVariable Long id){
		Optional<Saude> saude = saudeService.getByIdSaude(id);
		if(saude.isPresent()) {
			return ResponseEntity.ok(saude);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Saude> createAllSaude(@RequestBody Saude saude){
		return new ResponseEntity<>(saudeService.saveAllMoradia(saude), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Saude> updateSaude(@PathVariable Long id, @RequestBody Saude saude){
		Optional<Saude> existingSaude = saudeService.getByIdSaude(id);
		if(existingSaude.isPresent()) {
			saude.setId(id);
			Saude updateSaude = saudeService.saveAllMoradia(saude);
			return ResponseEntity.ok(updateSaude);
		}
		else{
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		Optional<Saude> saude = saudeService.getByIdSaude(id);
		if(saude.isPresent()) {
			saudeService.deleteByIdSaude(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
