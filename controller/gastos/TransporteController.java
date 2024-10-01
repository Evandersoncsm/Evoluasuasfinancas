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

import com.projeto.evoluasuasfinancas.model.gastos.Transporte;
import com.projeto.evoluasuasfinancas.service.gastos.TransporteService;

@RestController
@RequestMapping("/api/transporte")
public class TransporteController {
	
	@Autowired
	private TransporteService transporteService;
	
	@GetMapping
	public ResponseEntity<List<Transporte>> getAllTransporte(){
		return ResponseEntity.ok(transporteService.getAllTransporte());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Transporte>> getByIdTransporte(@PathVariable Long id){
		Optional<Transporte> transporte = transporteService.getByIdTransporte(id);
		if(transporte.isPresent()) {
			return ResponseEntity.ok(transporte);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Transporte> createAllTransporte(@RequestBody Transporte transporte){
		return new ResponseEntity<>(transporteService.saveAllTransporte(transporte), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Transporte> updateByIdTransporte(@PathVariable Long id, @RequestBody Transporte transporte){
		Optional<Transporte> existingTransporte = transporteService.getByIdTransporte(id);
		if(existingTransporte.isPresent()) {
			transporte.setId(id);
			Transporte updateTransporte = transporteService.saveAllTransporte(transporte);
			return ResponseEntity.ok(updateTransporte);	
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdDelete(@PathVariable Long id){
		Optional<Transporte> transporte = transporteService.getByIdTransporte(id);
		if(transporte.isPresent()) {
			transporteService.DeleteByIdTransporte(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

