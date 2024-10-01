package com.projeto.evoluasuasfinancas.repository.ativos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.ativos.Imobilizado;

@Repository
public interface ImobilizadoRepository extends JpaRepository<Imobilizado, Long>{

}
