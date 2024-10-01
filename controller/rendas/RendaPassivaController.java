package com.projeto.evoluasuasfinancas.controller.rendas;

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

import com.projeto.evoluasuasfinancas.model.rendas.RendaPassiva;
import com.projeto.evoluasuasfinancas.service.rendas.RendaPassivaService;

@RestController
@RequestMapping("/api/rendapassiva")
public class RendaPassivaController {
    
    @Autowired
    private RendaPassivaService rendaPassivaService;
    
    // Método para retornar todas as rendas passivas (correto sem @RequestBody)
    @GetMapping
    public ResponseEntity<List<RendaPassiva>> getAllRendaPassiva() {
    	List<RendaPassiva> rendaPassiva = rendaPassivaService.getAllRendaPassiva();
    	System.out.println("Busca realizada!");
    	System.out.println("Total de Renda Passiva encotrado! "+rendaPassiva.size());
    	System.out.println("HttpStatus 200");
        return ResponseEntity.ok(rendaPassivaService.getAllRendaPassiva());
    }
    
    // Método para buscar uma renda passiva pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RendaPassiva>> getByIdRendaPassiva(@PathVariable Long id) {
        Optional<RendaPassiva> rendaPassiva = rendaPassivaService.getByIdRendaPassiva(id);
        if(rendaPassiva.isPresent()) {
        	System.out.println("HttpStatus 200");
            return ResponseEntity.ok(rendaPassiva);
        } else {
        	System.out.println("Erro 404");
    		System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
    
    // Método para criar uma nova renda passiva
    @PostMapping
    public ResponseEntity<RendaPassiva> createRendaPassiva(@RequestBody RendaPassiva rendaPassiva) {
    	System.out.println("Renda Passiva salva com sucesso!");
    	System.out.println("Descrição: "+rendaPassiva.getDescricao());
    	System.out.println("HttpStatus 201");
        return new ResponseEntity<>(rendaPassivaService.saveRendaPassiva(rendaPassiva), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RendaPassiva> updateRendaPassiva(@RequestBody RendaPassiva rendaPassiva, @PathVariable Long id){
    	Optional<RendaPassiva> existingRenda = rendaPassivaService.getByIdRendaPassiva(id);
    	if(existingRenda.isPresent()) {
    		rendaPassiva.setId(id);
    		RendaPassiva updateRendaPassiva = rendaPassivaService.saveRendaPassiva(rendaPassiva);
    		System.out.println("Renda Passiva atualizada com sucesso!");
    		System.out.println("Descrição: "+rendaPassiva.getDescricao());
    		System.out.println("HttpStatus 200");
    		return ResponseEntity.ok(updateRendaPassiva);
    	}
    	else {
    		System.out.println("Erro 404!");
    		System.out.println("Não encontrado.");
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdRendaPassiva(@PathVariable Long id){
    	Optional<RendaPassiva> existingRenda = rendaPassivaService.getByIdRendaPassiva(id);
    	if(existingRenda.isPresent()) {
    		rendaPassivaService.deleteByIdRendaPassiva(id);
    		System.out.println("Renda Passiva excluída com sucesso!");
    		System.out.println("Descrição: "+existingRenda.get().getDescricao());
    		System.out.println("HttpStatus 200");
    		return ResponseEntity.noContent().build();
    	}
    	else {
    		System.out.println("Erro 404!");
    		System.out.println("Não encontrado.");
    		return ResponseEntity.notFound().build();
    	}
    }
}






















