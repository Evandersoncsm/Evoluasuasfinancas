package com.projeto.evoluasuasfinancas.controller.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.evoluasuasfinancas.model.rendas.RendaPrincipal;
import com.projeto.evoluasuasfinancas.service.rendas.RendaPrincipalService;

@RestController
@RequestMapping("/api/rendaprincipal")  // Define o caminho básico para este controlador
public class RendaPrincipalController {
    
    @Autowired
    private RendaPrincipalService rendaPrincipalService;
    
    @GetMapping
    public ResponseEntity<List<RendaPrincipal>> getAllRendaPrincipal(){
    	List<RendaPrincipal> rendaPrincipal = rendaPrincipalService.getAllRendaPrincipal();
    	System.out.println("Busca realizada!");
    	System.out.println("Total de Renda Principal encontrada: "+rendaPrincipal.size());
    	System.out.println("HttpStatus 200");
        return ResponseEntity.ok(rendaPrincipalService.getAllRendaPrincipal());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RendaPrincipal>> getByIdRendaPrincipal(@PathVariable Long id){
        Optional<RendaPrincipal> rendaPrincipal = rendaPrincipalService.getByIdRendaPrincipal(id);
        if(rendaPrincipal.isPresent()) {  // Verifica se o valor está presente
        	System.out.println("HttpStatus 200");
            return ResponseEntity.ok(rendaPrincipal);
        } else {
        	System.out.println("Erro 404");
    		System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<RendaPrincipal> createRendaPrincipal(@RequestBody RendaPrincipal rendaPrincipal){
        System.out.println("Renda Principal salva com sucesso!");
        System.out.println("Descrição: "+rendaPrincipal.getDescricao());
        System.out.println("HttpStatus 201");
        return new ResponseEntity<>(rendaPrincipalService.saveAllRendaPrincipal(rendaPrincipal), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RendaPrincipal> updateRendaPrincipal(@PathVariable Long id, @RequestBody RendaPrincipal rendaPrincipal){
        Optional<RendaPrincipal> existingRenda = rendaPrincipalService.getByIdRendaPrincipal(id);
        if(existingRenda.isPresent()) {
            rendaPrincipal.setId(id);  // Define o ID da renda a ser atualizada
            RendaPrincipal updatedRendaPrincipal = rendaPrincipalService.saveAllRendaPrincipal(rendaPrincipal);
            System.out.println("Renda Principal atualizada!");
            System.out.println("Descrição: "+rendaPrincipal.getDescricao());
            System.out.println("HttpStatus 200");
            return ResponseEntity.ok(updatedRendaPrincipal);
        } else {
        	System.out.println("Erro 404!");
    		System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendaPrincipal(@PathVariable Long id){
        Optional<RendaPrincipal> existingRenda = rendaPrincipalService.getByIdRendaPrincipal(id);
        if(existingRenda.isPresent()) {
            rendaPrincipalService.deleteByIdRendaPrincipal(id);
            System.out.println("Renda Principal excluída com sucesso!");
            System.out.println("Descrição: "+existingRenda.get().getDescricao());
            System.out.println("HttpStatus 200");
            return ResponseEntity.noContent().build();
        } else {
        	System.out.println("Erro 404!");
    		System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
}
