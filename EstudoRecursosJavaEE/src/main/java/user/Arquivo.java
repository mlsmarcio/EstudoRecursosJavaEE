package user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;

public class Arquivo {
	private Long id;
	private String file;
	private String tipo;
	
	
	public Arquivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arquivo(Long id, String arquivo) {
		this.id = id;
		this.file = arquivo;
		String tipoDeDados = file.split(",")[0].split("/")[1].split(";")[0];
		this.tipo = tipoDeDados;
	}
	
	public InputStream gerarImagem() {
		byte[] imagemBytes;
		
		// REMOVE O TEXTO INICIAL ATÉ A VÍRGULA
		String img = file.split(",")[1];
		
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

	public String getFile() {
		return file;
	}

	public void setFile(String arquivo) {
		this.file = arquivo;
		String tipoDeDados = file.split(",")[0].split("/")[1].split(";")[0];
		this.tipo = tipoDeDados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
