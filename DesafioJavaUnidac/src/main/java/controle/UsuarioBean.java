package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private String cpfUsuario;

	private List<Usuario> listaUsuarios;

	private UsuarioDAO usuarioDAO;

	private void iniciarCampor() {

		this.usuario = new Usuario();

	}

	public UsuarioBean() {

		this.iniciarCampor();

		this.usuarioDAO = new UsuarioDAOImpl();

	}

	public void salvar() {

		this.usuarioDAO.insercao(this.usuario);

		this.iniciarCampor();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario cadastrado!"));

	}

	public void pesquisar() {

		this.listaUsuarios = this.usuarioDAO.listarTodos();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario pesquisado!"));

	}

	public String remover() {

		Usuario usuarioRemover = null;

		for (Usuario usuarioLista : listaUsuarios) {

			usuarioRemover = usuarioLista;

		}

		if (usuarioRemover != null) {

			this.usuarioDAO.delecao(usuarioRemover);
			this.pesquisar();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario removido!"));

		}

		return "";

	}

	public void atualizar() {

		this.usuarioDAO.atualizacao(this.usuario);

		this.iniciarCampor();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario atualizado!"));

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

}
