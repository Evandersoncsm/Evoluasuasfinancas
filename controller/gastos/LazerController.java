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

import com.projeto.evoluasuasfinancas.model.gastos.Lazer;
import com.projeto.evoluasuasfinancas.service.gastos.LazerService;

@RestController
@RequestMapping("/api/lazer")
public class LazerController {

	@Autowired
	private LazerService lazerService;
	
	@GetMapping
	public ResponseEntity<List<Lazer>> getAllLazer(){
		return ResponseEntity.ok(lazerService.getAllLazer());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Lazer>> getByIdLazer(@PathVariable Long id){
		Optional<Lazer> lazer = lazerService.getByIdLazer(id);
		if(lazer.isPresent()) {
			return ResponseEntity.ok(lazer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Lazer> createAllLazer(@RequestBody Lazer lazer){
		return new ResponseEntity<>(lazerService.SaveAllLazer(lazer), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Lazer> updateLazer(@PathVariable Long id, @RequestBody Lazer lazer){
		Optional<Lazer> existingLazer = lazerService.getByIdLazer(id);
		if(existingLazer.isPresent()) {
			lazer.setId(id);
			Lazer updateLazer = lazerService.SaveAllLazer(lazer);
			return ResponseEntity.ok(updateLazer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdLazer(@PathVariable Long id){
	    System.out.println("Delete request received for ID: " + id);
	    Optional<Lazer> lazer = lazerService.getByIdLazer(id);
	    if(lazer.isPresent()) {
	        lazerService.deleteByIdLazer(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}







