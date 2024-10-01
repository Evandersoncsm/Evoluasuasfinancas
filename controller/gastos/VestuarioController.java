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

import com.projeto.evoluasuasfinancas.model.gastos.Vestuario;
import com.projeto.evoluasuasfinancas.service.gastos.VestuarioService;

@RestController
@RequestMapping("/api/vestuario")
public class VestuarioController {

	@Autowired
	private VestuarioService vestuarioService;
	
	@GetMapping
	public ResponseEntity<List<Vestuario>> getAllVestuario(){
		return ResponseEntity.ok(vestuarioService.getAllVestuario());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Vestuario>> getByIdVestuario(@PathVariable Long id){
		Optional<Vestuario> vestuario = vestuarioService.getByIdVestuario(id);
		if(vestuario.isPresent()) {
			return ResponseEntity.ok(vestuario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Vestuario> createAllVestuario(@RequestBody Vestuario vestuario){
		return new ResponseEntity<>(vestuarioService.saveAllVestuario(vestuario),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Vestuario> updateVestuario(@PathVariable Long id, @RequestBody Vestuario vestuario){
		Optional<Vestuario> existingVestuario = vestuarioService.getByIdVestuario(id);
		if(existingVestuario.isPresent()) {
			vestuario.setId(id);
			Vestuario updateVestuario = vestuarioService.saveAllVestuario(vestuario);
			return ResponseEntity.ok(updateVestuario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdVestuario(@PathVariable Long id){
		Optional<Vestuario> vestuario = vestuarioService.getByIdVestuario(id);
		if(vestuario.isPresent()) {
			vestuarioService.deleteByIdVestuario(id);
			return ResponseEntity.noContent().build();
		}
		else return ResponseEntity.notFound().build();
	}
}
