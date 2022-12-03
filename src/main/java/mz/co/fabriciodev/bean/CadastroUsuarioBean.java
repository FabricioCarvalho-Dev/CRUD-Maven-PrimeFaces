package mz.co.fabriciodev.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.RowEditEvent;

import mz.co.fabriciodev.dao.UsuarioDao;
import mz.co.fabriciodev.model.Usuario;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean {

	private Usuario usuario = new Usuario();

	private UsuarioDao usuarioDao = new UsuarioDao();
	
	

	public void salvar() {

		try {
			usuario.setData_cadastro(new String());

			this.usuarioDao.inserir(usuario);

			Messages.addGlobalInfo("Usuario salvo com sucesso!");

			this.limpar();

		} catch (Exception e) {

			Messages.addGlobalError("Impossivel cadastrar o usuario " + e.getMessage());
			e.printStackTrace();
			this.limpar();
		}
	}

	public void onRowEdit(RowEditEvent event) {
	
		usuario.setNome(String.valueOf(((Usuario) event.getObject()).getNome()));
		usuario.setEmail(String.valueOf(((Usuario)event.getObject()).getEmail()));
		usuario.setEndereco(String.valueOf(((Usuario)event.getObject()).getEndereco()));
		usuario.setData_cadastro(String.valueOf(((Usuario)event.getObject()).getData_cadastro()));

		try {

			usuarioDao.editar (usuario, Integer.valueOf(((Usuario) event.getObject()).getId()));
			Messages.addGlobalInfo("Alteração de Usuario Realizada!");
		} catch (Exception e) {
			Messages.addGlobalError("Alteração não realizada" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void onRowCancel(RowEditEvent event) {
		Messages.addGlobalInfo("Alteração Cancelada!");

	}

	public Usuario getUsuario() {

		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private void limpar() {

		this.usuario = new Usuario();
	}
}
