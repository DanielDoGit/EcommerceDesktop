package ecommerce.modelo.beans;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private String celular;
	private String telefone;
	private String cpfCnpj;
	private String rua;
	private String numerodaRua;
	private Cidade cidade;
	private List<PermissaoFuncionario> listaPermissao = new ArrayList<PermissaoFuncionario>();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<PermissaoFuncionario> getListaPermissao() {
		return listaPermissao;
	}

	public void setListaPermissao(List<PermissaoFuncionario> listaPermissao) {
		this.listaPermissao = listaPermissao;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
