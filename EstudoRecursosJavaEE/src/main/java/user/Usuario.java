package user;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private Long id;
	private String login;
	private String senha;
	private List<Imagem> imagens = new ArrayList<>();
	
	public Usuario() {
		super();
		
	}

	public Usuario(Long id, String login, String senha, List<Imagem> imagens) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.imagens = imagens;
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

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
	public void addImagem(Imagem imagem) {
		this.imagens.add(imagem);
	}
	
}
