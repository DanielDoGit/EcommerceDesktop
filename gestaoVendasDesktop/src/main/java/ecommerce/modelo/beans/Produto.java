package ecommerce.modelo.beans;

import java.math.BigDecimal;

public class Produto {
	
	private Integer id;
	private Fornecedor fornecedor;
	private String descricao;
	private BigDecimal precoCusto;
	private BigDecimal precoVenda;
	private BigDecimal estoque;
	private boolean permitirEstoqueNegativo;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	public BigDecimal getEstoque() {
		return estoque;
	}
	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}
	public boolean isPermitirEstoqueNegativo() {
		return permitirEstoqueNegativo;
	}
	public void setPermitirEstoqueNegativo(boolean permitirEstoqueNegativo) {
		this.permitirEstoqueNegativo = permitirEstoqueNegativo;
	}

}
