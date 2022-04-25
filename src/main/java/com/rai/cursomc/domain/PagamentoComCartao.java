package com.rai.cursomc.domain;

import javax.persistence.Entity;

import com.rai.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{

	private static final long serialVersionUID = 1L;
	
	private Integer numerosDeparcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerosDeparcelas) {
		super(id, estado, pedido);
		this.numerosDeparcelas = numerosDeparcelas;
	}

	public Integer getNumerosDeparcelas() {
		return numerosDeparcelas;
	}

	public void setNumerosDeparcelas(Integer numerosDeparcelas) {
		this.numerosDeparcelas = numerosDeparcelas;
	}
	
	
}
