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

import com.projeto.evoluasuasfinancas.model.gastos.OutrosGastos;
import com.projeto.evoluasuasfinancas.service.gastos.OutrosGastosService;

@RestController
@RequestMapping("/api/outrosgastos")
public class OutrosGastosController {
	
	@Autowired
	private OutrosGastosService outrosGastosService;
	
	@GetMapping
	public ResponseEntity<List<OutrosGastos>> getAllOutrosGastos(){
		return ResponseEntity.ok(outrosGastosService.getAllOutrosGastos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<OutrosGastos>> getByIdOutrosGastos(@PathVariable Long id){
		Optional<OutrosGastos> outrosGastos = outrosGastosService.getByIdOutrosGastos(id);
		if(outrosGastos.isPresent()) {
			return ResponseEntity.ok(outrosGastos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<OutrosGastos> createAllOutrosGastos(@RequestBody OutrosGastos outrosGastos){
		return new ResponseEntity<>(outrosGastosService.saveAllOutrosGastos(outrosGastos),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OutrosGastos> updateOutrosGastos(@PathVariable Long id, @RequestBody OutrosGastos outrosGastos){
		Optional<OutrosGastos> existingOutrosGastos = outrosGastosService.getByIdOutrosGastos(id);
		if(existingOutrosGastos.isPresent()) {
			outrosGastos.setId(id);
			OutrosGastos updateOutrosGastos = outrosGastosService.saveAllOutrosGastos(outrosGastos);
			return ResponseEntity.ok(updateOutrosGastos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdOutrosGastos(@PathVariable Long id){
		Optional<OutrosGastos> outrosGastos = outrosGastosService.getByIdOutrosGastos(id);
		if(outrosGastos.isPresent()) {
			outrosGastosService.deleteByIdOutrosGastos(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
