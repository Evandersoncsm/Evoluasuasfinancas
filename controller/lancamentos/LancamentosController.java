package com.projeto.evoluasuasfinancas.controller.lancamentos;

import java.util.List;

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

import com.projeto.evoluasuasfinancas.model.lancamento.Lancamentos;
import com.projeto.evoluasuasfinancas.service.lancamentos.LancamentosService;


@RestController
@RequestMapping("/api/lancamentos")
public class LancamentosController {

    @Autowired
    private LancamentosService lancamentosService;

    @GetMapping
    public ResponseEntity<List<Lancamentos>> getAllLancamentos() {
        return ResponseEntity.ok(lancamentosService.getAllLancamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamentos> getLancamentoById(@PathVariable Long id) {
        Lancamentos lancamento = lancamentosService.getLancamentoById(id);
        if (lancamento != null) {
            return ResponseEntity.ok(lancamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Lancamentos> addLancamento(@RequestBody Lancamentos lancamento) {
        return new ResponseEntity<>(lancamentosService.saveLancamento(lancamento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamentos> updateLancamento(@PathVariable Long id, @RequestBody Lancamentos lancamento) {
        if (lancamentosService.getLancamentoById(id) != null) {
            lancamento.setId(id);
            return ResponseEntity.ok(lancamentosService.saveLancamento(lancamento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long id) {
        if (lancamentosService.getLancamentoById(id) != null) {
            lancamentosService.deleteLancamento(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //DELETAR TUDO
    @DeleteMapping
    public ResponseEntity<Void> deleteAllLancamento(@RequestBody Lancamentos lancamentos){
    	lancamentosService.deleteAllLancamentos(lancamentos);
    	return ResponseEntity.noContent().build();
    }
	
}















