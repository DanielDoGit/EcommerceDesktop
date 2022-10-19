package ecommerce.modelo.beans;

public class FormaDePagamento {
	
	private Integer id;
	private String descricao;
	private boolean lancamentoCaixa;
	
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
	public boolean isLancamentoCaixa() {
		return lancamentoCaixa;
	}
	public void setLancamentoCaixa(boolean lancamentoCaixa) {
		this.lancamentoCaixa = lancamentoCaixa;
	}

}
