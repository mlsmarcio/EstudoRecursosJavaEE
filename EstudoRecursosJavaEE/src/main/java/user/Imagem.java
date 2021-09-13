package user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;

public class Imagem {
	private Long id;
	private String imagem;
	
	
	public Imagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imagem(Long id, String imagem) {
		this.id = id;
		this.imagem = imagem;
	}
	
	public InputStream gerarImagem() {
		byte[] imagemBytes;
		
		// REMOVE O TEXTO INICIAL ATÉ A VÍRGULA
		String img = imagem.split(",")[1];
		
		//CONVERTE BASE 64 EM BYTES
		imagemBytes = new Base64().decodeBase64(img);
		
		// RETORNA OS BYTES EM UM OBJETO DE ENTRADA PARA PROCESSAR
		return new ByteArrayInputStream(imagemBytes);
				
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
