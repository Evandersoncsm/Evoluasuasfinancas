package com.projeto.evoluasuasfinancas.controller.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.evoluasuasfinancas.model.rendas.RendaExtra;
import com.projeto.evoluasuasfinancas.service.rendas.RendaExtraService;

@RestController
@RequestMapping("/api/rendaextra")
public class RendaExtraController {

    @Autowired
    private RendaExtraService rendaExtraService;
    
    @GetMapping
    public ResponseEntity<List<RendaExtra>> getAllRendaExtra(){
    	List<RendaExtra> rendaExtra = rendaExtraService.getAllRendaExtra();
    	System.out.println("Busca realizada!");
    	System.out.println("Total de Renda Extra encontrado: "+rendaExtra.size());
    	System.out.println("HttpStatus 200");
        return ResponseEntity.ok(rendaExtraService.getAllRendaExtra());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RendaExtra>> getByIdRendaExtra(@PathVariable Long id){
        Optional<RendaExtra> rendaExtra = rendaExtraService.getByIdRendaExtra(id);
        if (rendaExtra.isPresent()) {
        	System.out.println("HttpStatus 200");
            return ResponseEntity.ok(rendaExtra);
        } else {
        	System.out.println("Erro 404");
        	System.err.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<RendaExtra> createRendaExtra(@RequestBody RendaExtra rendaExtra){
    	System.out.println("Renda Extra salva com sucesso!");
    	System.out.println("Descrição: "+rendaExtra.getDescricao());
    	System.out.println("HttpStatus 201");
        return new ResponseEntity<>(rendaExtraService.saveAllRendaExtra(rendaExtra), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")  // Corrigido o mapeamento, fechando corretamente o '{id}'
    public ResponseEntity<RendaExtra> updateRendaExtra(@PathVariable Long id, @RequestBody RendaExtra rendaExtra){
        Optional<RendaExtra> existingRendaExtra = rendaExtraService.getByIdRendaExtra(id);
        if (existingRendaExtra.isPresent()) {
            rendaExtra.setId(id);  // Define o ID da renda a ser atualizada
            RendaExtra updatedRendaExtra = rendaExtraService.saveAllRendaExtra(rendaExtra);
            System.out.println("Renda Extra atualizada com sucesso!");
            System.out.println("Descrição: "+existingRendaExtra.get().getDescricao());
            System.out.println("HttpStatus 200");
            return ResponseEntity.ok(updatedRendaExtra);
        } else {
        	System.out.println("Erro 404");
        	System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<RendaExtra> existingRendaExtra = rendaExtraService.getByIdRendaExtra(id);
        if (existingRendaExtra.isPresent()) {
            rendaExtraService.deleteByIdRendaExtra(id);
            System.out.println("Renda Extra deletada com sucesso!");
            System.out.println("Descrição: "+existingRendaExtra.get().getDescricao());
            System.out.println("HttpStatus 200");
            return ResponseEntity.noContent().build();
        } else {
        	System.out.println("Erro 404");
        	System.out.println("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
    }
}
