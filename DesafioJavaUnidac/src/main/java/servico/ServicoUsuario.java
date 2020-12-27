package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.RetornoUsuario;
import entidade.Usuario;

@Path("/usuario")
public class ServicoUsuario {

	UsuarioDAO usuarioDAO;

	public ServicoUsuario() {

		this.usuarioDAO = new UsuarioDAOImpl();

	}

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {

		return "Usuario PROJETO DESAFIO JAVA UNIDAC!!!";

	}

	@Path("/insercao")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoUsuario insercao(Usuario usuario) {

		RetornoUsuario retorno = new RetornoUsuario();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.usuarioDAO.insercao(usuario)) {

			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Usuario não inserido!!");

		}

		return retorno;

	}

	@Path("/atualizacao")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoUsuario atualizacao(Usuario usuario) {

		RetornoUsuario retorno = new RetornoUsuario();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.usuarioDAO.atualizacao(usuario)) {

			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Usuario não atualizado!!");

		}

		return retorno;

	}

	@Path("/delecao")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoUsuario delecao(Usuario usuario) {

		RetornoUsuario retorno = new RetornoUsuario();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.usuarioDAO.delecao(usuario)) {

			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Usuario não removido!!");

		}

		return retorno;

	}

	@Path("/consulta")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoUsuario consulta(Usuario usuario) {

		RetornoUsuario retorno = new RetornoUsuario();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (this.usuarioDAO.consulta(usuario.getCpf()) == null) {

			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Usuario não encontrado!!!!");

		}

		return retorno;

	}

	@Path("/listarTodos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoUsuario listarTodos() {

		RetornoUsuario retorno = new RetornoUsuario();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		retorno.setListaUsuario(this.usuarioDAO.listarTodos());

		return retorno;

	}

}
