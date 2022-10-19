package ecommerce.uteis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ecommerce.common.SistemaUtil;

public class ColetaPropriedades {

	private static String usuario;
	private static String senha;
	private static String url;
	private static String nomeDoBanco;
	private Properties propriedades;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		ColetaPropriedades.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		ColetaPropriedades.senha = senha;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		ColetaPropriedades.url = url;
	}

	public String getNomeDoBanco() {
		return nomeDoBanco;
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		ColetaPropriedades.nomeDoBanco = nomeDoBanco;
	}

	public Properties getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(Properties propriedades) {
		this.propriedades = propriedades;
	}

	public ColetaPropriedades()  {
		try {
			InputStream entrada = new FileInputStream("./FileConfiguration.tmp");
			propriedades = new Properties();
			propriedades.load(entrada);
			setUrl(propriedades.getProperty("url"));
			setNomeDoBanco(propriedades.getProperty("banco"));
			setUsuario(propriedades.getProperty("usuario"));
			setSenha(propriedades.getProperty("senha"));
			
		} catch (FileNotFoundException e) {
			SistemaUtil.gravarLog(e);
		} catch (IOException e) {
			SistemaUtil.gravarLog(e);
		}
		
	}
	
	
}
