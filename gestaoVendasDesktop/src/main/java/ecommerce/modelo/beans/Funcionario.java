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
	private String cpf;
	private String rua;
	private String numerorua;
	private Cidade cidade;
	private List<PermissaoFuncionario> listaPermissao = new ArrayList<PermissaoFuncionario>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumerorua() {
		return numerorua;
	}
	public void setNumerorua(String numerorua) {
		this.numerorua = numerorua;
	}
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
}
