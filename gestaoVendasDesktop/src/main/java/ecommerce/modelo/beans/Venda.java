package ecommerce.modelo.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private Integer id;
	private List<ItemVenda> listaitens = new ArrayList<ItemVenda>();
	private BigDecimal valorDesconto;
	private BigDecimal valorAcrescimo;
	private BigDecimal valorTotal;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<ItemVenda> getListaitens() {
		return listaitens;
	}
	public void setListaitens(List<ItemVenda> listaitens) {
		this.listaitens = listaitens;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public BigDecimal getValorAcrescimo() {
		return valorAcrescimo;
	}
	public void setValorAcrescimo(BigDecimal valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
