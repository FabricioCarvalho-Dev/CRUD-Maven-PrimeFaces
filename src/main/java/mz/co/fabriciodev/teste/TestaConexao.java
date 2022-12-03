package mz.co.fabriciodev.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mz.co.fabriciodev.dao.UsuarioDao;
import mz.co.fabriciodev.model.Usuario;
import mz.co.fabriciodev.util.Conexao;

public class TestaConexao {

	public static void main(String args[]) {

		//buscar();
		//editar();
		buscUsuario();
	}

	public static void testar() {

		try {
			Conexao conexao = new Conexao();

			conexao.getConexao();

			System.out.println("Sucesso");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Erro " + e.getMessage());
		}
	}

	public static void editar() {

		try {

			Usuario p = new Usuario();

			//p.setCpf(124456454);
			p.setNome("goran");
			p.setEmail("GFGFHGJHJ");
			p.setEndereco("getrtaTR 14");
			p.setData_cadastro("2005-01-20");

			UsuarioDao dao = new UsuarioDao();

			dao.editar(p, 27);

			System.out.println("Sucesso1");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Erro " + e.getMessage());
		}
	}
	

	public static void eliminar() {

		UsuarioDao dao = new UsuarioDao();

		// dao.excluir(4);
	}

	public static void buscar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		UsuarioDao dao = new UsuarioDao();
		try {
			usuarios = dao.buscarTodos();
			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println("ID: " + usuarios.get(i).getId());
				System.out.println("Nome: " + usuarios.get(i).getNome());
				System.out.println("Email: " + usuarios.get(i).getEmail());
				System.out.println("endereço: " + usuarios.get(i).getEndereco());
				// System.out.println("Data: " +usuarios.get(i).getData_cadastro());
				System.out.println("______________________________________________");
			}

			System.out.println("SUCESSO");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public static void buscUsuario() {

		try {

			Usuario p = new Usuario();

			p.getCpf();
			p.getNome();
			p.getEmail();
			p.getEndereco();
			p.getData_cadastro();

			UsuarioDao dao = new UsuarioDao();

			//dao.buscUsuario(p, 27);

			System.out.println("Sucesso2");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Erro " + e.getMessage());
		}
	}

}
