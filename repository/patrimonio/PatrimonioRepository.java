package com.projeto.evoluasuasfinancas.repository.patrimonio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.patrimonio.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long>{

}
