package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import user.Arquivo;
import user.Usuario;

public class DaoArquivo {
	private Connection connection;
	
	public DaoArquivo() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Arquivo arquivo, Long idUsuario){
		try {
			String sql = "INSERT INTO tbarquivo(file, idUsuario, tipo) values(?,?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, arquivo.getFile());
			insert.setLong(2, idUsuario);
			insert.setString(3, arquivo.getTipo());
			insert.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<Arquivo> listar(Long idUsuario) throws Exception{
		List<Arquivo> lista = new ArrayList<>();
		Arquivo arquivo = null;
		String sql = "SELECT * FROM tbarquivo WHERE idUsuario=? order by id";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			arquivo = new Arquivo();
			arquivo.setId(resultSet.getLong("id"));
			arquivo.setFile(resultSet.getString("file"));
			arquivo.setTipo(resultSet.getString("tipo"));
			
			lista.add(arquivo);
		}
		return lista;
	}

	public Arquivo getImagem (Long idImagem) throws Exception{
		Arquivo imagem = null;
		String sql = "SELECT * FROM tbarquivo WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, idImagem);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			imagem = new Arquivo();
			imagem.setId(resultSet.getLong("id"));
			imagem.setFile(resultSet.getString("file"));
			imagem.setTipo(resultSet.getString("tipo"));
		}
		return imagem;
	}
	
	/*
	public void delete (Long id){
		try {
			String sql = "delete from tbUsuario where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	public Usuario consultar(Long id) {
		Usuario user= new Usuario();
		try {
			String sql = "select * from tbUsuario where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultado = statement.executeQuery();
			
			if (resultado.next()) {
				user.setId(resultado.getLong("id"));
				user.setLogin(resultado.getString("login"));
				user.setSenha(resultado.getString("senha"));
				user.setImagem(resultado.getString("imagem"));
			}
			
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return user;
	}

	public boolean validarLogin(String login) {
		boolean retorno = false;
		try {
			String sql = "select count(1) as qtd from tbUsuario where login=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				retorno = resultado.getInt("qtd") == 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return retorno;
	}

	public boolean validarLoginUpdate(Long id, String login) {
		boolean retorno = false;
		try {
			String sql = "select count(1) as qtd from tbUsuario where login=? AND id <> ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setLong(2, id);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				retorno = resultado.getInt("qtd") == 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return retorno;
	}

	public void atualizar(Usuario usuario) {
		try {
			String sql = "UPDATE tbUsuario SET login=?, senha=?, imagem=? WHERE id=?";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, usuario.getLogin());
			update.setString(2, usuario.getSenha());
			update.setString(3, usuario.getImagem());
			update.setLong(4, usuario.getId());
			update.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	// QUANDO ADICIONAR A IMAGEM, GUARDAR NA TABELA DE IMAGENS, CADA USUÁRIO TERÁ UMA OU MAIS IMAGENS

	public void gravarImagem(Usuario usuario) {
		try {
			String sql = "UPDATE 'tbUsuario' SET login=?, senha=?, imagem=? WHERE id=?";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, usuario.getLogin());
			update.setString(2, usuario.getSenha());
			update.setString(3, usuario.getImagem());
			update.setLong(4, usuario.getId());
			update.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
*/
}
