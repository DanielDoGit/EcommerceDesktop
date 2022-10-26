package ecommerce.modelo.beans;

public class Estabelecimento {

	private Integer id;
	private String nomeFantasia;
	private String apelidoRazoSocial;
	private String rua;
	private String numeroRua;
	private String cpcnpj;
	private Cidade cidade;
	private String telefone;
	private String celular;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getApelidoRazoSocial() {
		return apelidoRazoSocial;
	}

	public void setApelidoRazoSocial(String apelidoRazoSocial) {
		this.apelidoRazoSocial = apelidoRazoSocial;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getCpcnpj() {
		return cpcnpj;
	}

	public void setCpcnpj(String cpcnpj) {
		this.cpcnpj = cpcnpj;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
