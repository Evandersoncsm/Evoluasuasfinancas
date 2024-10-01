package com.projeto.evoluasuasfinancas.repository.passivos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.passivos.Emprestimos;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long>{

}
