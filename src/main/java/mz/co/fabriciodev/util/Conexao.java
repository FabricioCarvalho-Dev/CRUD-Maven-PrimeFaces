package mz.co.fabriciodev.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private final String SERVIDOR = "";
	private final String PORTA = "";
	private final String BANCO_DE_DADO = "";
	private final String USUARIO = "";
	private final String SENHA = "";
	private final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADO;

	private Connection conexao;

	public Conexao() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		conexao.setAutoCommit(true);
	}

	public Connection getConexao() {
		return conexao;
	}

}
