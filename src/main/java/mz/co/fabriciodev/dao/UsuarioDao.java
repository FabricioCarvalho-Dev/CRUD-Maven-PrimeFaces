package mz.co.fabriciodev.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mz.co.fabriciodev.model.Usuario;
import mz.co.fabriciodev.util.Conexao;

public class UsuarioDao {

	public void inserir(Usuario p) throws Exception {

		Conexao conexao = new Conexao();

		String sql = "INSERT INTO usuario (cpf, nome, email, endereco, endereco2, perfil, data_cadastro) value (?,?,?,?,?,?,?) ";

		PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

		ps.setLong(1, p.getCpf());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getEmail());
		ps.setString(4, p.getEndereco());
		ps.setString(5, p.getEndereco2());
		ps.setString(6, p.getPerfil());
		ps.setString(7, p.getData_cadastro());

		ps.execute();

	}

	public void editar(Usuario p, int id) throws Exception {
		
        try {
			
				Conexao conexao = new Conexao();
		
				String sql = "UPDATE usuario set nome=?, email=?, endereco=?, data_cadastro=? where id =?";
		
				PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
		
				//ps.setLong(1, p.getCpf());
				ps.setString(1, p.getNome());
				ps.setString(2, p.getEmail());
				ps.setString(3, p.getEndereco());
				ps.setString(4, p.getData_cadastro());
				ps.setInt(5, id);
		
				ps.execute();
        } catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void excluir(int id) throws Exception {

		Conexao conexao = new Conexao();

		String sql = "DELETE from usuario where id=?";
		PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
		ps.setInt(1, id);

		ps.execute();

	}

	public List<Usuario> buscarTodos() throws Exception {

		List<Usuario> usuarios = new ArrayList<>();

		Conexao conexao = new Conexao();
		String sql = "SELECT * from usuario";

		PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Usuario p = new Usuario();

			p.setCpf(rs.getLong("cpf"));
			p.setNome(rs.getString("nome"));
			p.setEmail(rs.getString("email"));
			p.setEndereco(rs.getString("endereco"));
			p.setEndereco2(rs.getString("endereco2"));
			p.setPerfil(rs.getString("perfil"));
			p.setData_cadastro(rs.getString("data_cadastro"));
			p.setId(rs.getInt("id"));

			usuarios.add(p);

		}

		return usuarios;
	}

	public List<Usuario> buscUsuario(Long cpf, String nome, String data_cadastro) throws Exception {
		Conexao conexao = new Conexao();
		List<Usuario> usuarioEncontrado = new ArrayList<>();
		//String sql = "SELECT nome, cpf, data_cadastro FROM usuario WHERE (nome LIKE '%') AND  (cpf LIKE '%') AND  (data_cadastro LIKE '%') where id =?";
		String sql = "select * from usuario"
				+ "where nome like '%"+nome+"%'";
				//+ "and (cpf like '%"+cpf+"%')"
				//+ "and (data_cadastro like '%"+data_cadastro+"%');";
		PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {

			Usuario p = new Usuario();

			//p.setCpf(rs.getLong("cpf"));
			p.setNome(rs.getString("nome"));
			//p.setEmail(rs.getString("email"));
			//p.setEndereco(rs.getString("endereco"));
			//p.setEndereco2(rs.getString("endereco2"));
			//p.setPerfil(rs.getString("perfil"));
			//p.setData_cadastro(rs.getString("data_cadastro"));
			//p.setId(rs.getInt("id"));

			usuarioEncontrado.add(p);

		}

		return usuarioEncontrado;
	}

}
