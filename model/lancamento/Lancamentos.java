package com.projeto.evoluasuasfinancas.model.lancamento;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lancamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Long id;
	private Date data;
	private double valor;
	private String patrimonio;
	private Date dataPgto;
	private String tipoLcto;
	private String grupo;
	private String classificacao;
	private String breveHistorico;
	private String tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public Date getDataPgto() {
		return dataPgto;
	}
	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}
	public String getTipoLcto() {
		return tipoLcto;
	}
	public void setTipoLcto(String tipoLcto) {
		this.tipoLcto = tipoLcto;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getBreveHistorico() {
		return breveHistorico;
	}
	public void setBreveHistorico(String breveHistorico) {
		this.breveHistorico = breveHistorico;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
