package ecommerce.modelo.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Parcela {

	private Integer id;
	private String descricao;
	private Date datalancamento;
	private Date datavencimento;
	private Recebimento recebimento;
	private boolean compensado;
	private FormaDePagamento formaDePagamento;
	private BigDecimal valor;
	
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
	public Date getDatalancamento() {
		return datalancamento;
	}
	public void setDatalancamento(Date datalancamento) {
		this.datalancamento = datalancamento;
	}
	public Recebimento getRecebimento() {
		return recebimento;
	}
	public void setRecebimento(Recebimento recebimento) {
		this.recebimento = recebimento;
	}
	public boolean isCompensado() {
		return compensado;
	}
	public void setCompensado(boolean compensado) {
		this.compensado = compensado;
	}
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDatavencimento() {
		return datavencimento;
	}
	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}
}
