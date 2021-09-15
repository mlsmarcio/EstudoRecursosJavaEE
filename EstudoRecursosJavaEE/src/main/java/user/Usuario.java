package user;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private Long id;
	private String login;
	private String senha;
	private List<Arquivo> arquivo = new ArrayList<>();
	
	public Usuario() {
		super();
		
	}

	public Usuario(Long id, String login, String senha, List<Arquivo> arquivo) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.arquivo = arquivo;
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Arquivo> getArquivos() {
		return arquivo;
	}

	public void setArquivos(List<Arquivo> arquivo) {
		this.arquivo = arquivo;
	}
	
	public void addArquivo(Arquivo arquivo) {
		this.arquivo.add(arquivo);
	}
	
}
