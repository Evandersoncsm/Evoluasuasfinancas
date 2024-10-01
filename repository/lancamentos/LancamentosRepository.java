package com.projeto.evoluasuasfinancas.repository.lancamentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.evoluasuasfinancas.model.lancamento.Lancamentos;

import java.math.BigDecimal;

public interface LancamentosRepository extends JpaRepository<Lancamentos, Long> {

    @Query("SELECT COALESCE(SUM(l.valor), 0) FROM Lancamentos l WHERE l.tipoLcto = :tipoLcto")
    BigDecimal sumByTipoLcto(@Param("tipoLcto") String tipoLcto);
}
