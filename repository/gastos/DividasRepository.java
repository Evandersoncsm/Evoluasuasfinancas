package com.projeto.evoluasuasfinancas.repository.gastos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.gastos.Dividas;

@Repository
public interface DividasRepository extends JpaRepository<Dividas, Long>{

}
