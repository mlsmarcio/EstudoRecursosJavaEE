package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.Imagem;
import user.Usuario;
import connection.SingleConnection;

public class DaoUsuario {
	private Connection connection;
	private DaoImagem daoImagem;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
		this.daoImagem = new DaoImagem();
	}
	
	public void salvar(Usuario usuario){
		try {
			String sql = "INSERT INTO tbUsuario(login, senha) values(?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());

			insert.execute();
			ResultSet rs = insert.getResultSet();
			
			if (rs != null) {
				Long idUsuario = rs.getLong(1);
				
				for (Imagem imagem : usuario.getImagens()) {
					daoImagem.salvar(imagem, idUsuario);
				}
			}
			
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
	
	/*
	public List<Usuario> listar() throws Exception{
		List<Usuario> lista = new ArrayList<>();
		Usuario usuario  = null;
		String sql = "SELECT * FROM tbUsuario order by nome, id";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			usuario = new Usuario();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			
			lista.add(usuario);
		}
		
		return lista;
	}
	
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
	*/
	public Usuario consultar(Long id) throws Exception {
		Usuario user= new Usuario();
		try {
			String sql = "select * from public.tbUsuario where Id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultado = statement.executeQuery();
			
			if (resultado.next()) {
				user.setId(resultado.getLong("Id"));
				user.setLogin(resultado.getString("login"));
				user.setSenha(resultado.getString("senha"));
				user.setImagens(daoImagem.listar(user.getId()));
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
	/*
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
	*/
	
	public void gravarImagem(Usuario usuario) {
		for (Imagem imagem : usuario.getImagens()) {
			daoImagem.salvar(imagem, usuario.getId());
		}
			
	}
	
}
