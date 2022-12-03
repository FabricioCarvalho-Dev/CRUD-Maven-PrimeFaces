package mz.co.fabriciodev.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import mz.co.fabriciodev.dao.UsuarioDao;
import mz.co.fabriciodev.model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped

public class PesquisaUsuarioBean {

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuarioSelecionado;
	private Usuario buscUsuario;
	private UsuarioDao usuarioEncontrado;

	@PostConstruct
	public void inicializar() {

		try {
			this.usuarios = usuarioDao.buscarTodos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog("PesquisaUsuario", opcoes, null);
	}

	public void selecionar(Usuario usuario) {

	}

	public void excluir() {
		try {

			this.usuarioDao.excluir(usuarioSelecionado.getId());
			this.usuarios.remove(usuarioSelecionado);
			Messages.addGlobalInfo("Usuario " + usuarioSelecionado.getNome() + " excluido com sucesso!");

		} catch (Exception e) {
			Messages.addGlobalError("Não foi possivel excluir o usuario" + e.getMessage());
			e.printStackTrace();
		}
	}

	public UsuarioDao buscUsuario() {
		
		try {
			this.usuarioEncontrado.buscUsuario(usuarioSelecionado.getCpf(), getNome(), getData_cadastro());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return this.usuarioEncontrado;

	}

	private String getData_cadastro() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> getUsuarios() {
		System.out.println("todos-pesquisaUsuarioBean" + this.usuarios);
		return usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public Usuario getBuscUsuario() {
		return buscUsuario;
	}

	public void setBuscUsuario(Usuario buscUsuario) {
		this.buscUsuario = buscUsuario;
	}

}
