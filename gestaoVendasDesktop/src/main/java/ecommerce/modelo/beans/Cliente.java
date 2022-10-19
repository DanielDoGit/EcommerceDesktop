package ecommerce.modelo.beans;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String celular;
	private String telefone;
	private String cpfCnpj;
	private String rua;
	private String numerodaRua;
	private Cidade cidade;
		
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumerodaRua() {
		return numerodaRua;
	}
	public void setNumerodaRua(String numerodaRua) {
		this.numerodaRua = numerodaRua;
	}
	

}
