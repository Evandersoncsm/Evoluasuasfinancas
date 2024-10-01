package com.projeto.evoluasuasfinancas.repository.passivos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.passivos.Fornecedores;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>{

}
