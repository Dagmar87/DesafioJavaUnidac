package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public boolean insercao(Usuario usuario) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Usuario usuBase = ent.find(Usuario.class, usuario.getCpf());

		if (usuBase == null) {

			ent.persist(usuario);
			trans.commit();

		} else {

			retorno = false;

		}

		return retorno;
	}

	@Override
	public boolean atualizacao(Usuario usuario) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Usuario usuBase = ent.find(Usuario.class, usuario.getCpf());

		if (usuBase == null) {

			ent.merge(usuario);
			trans.commit();

		} else {

			retorno = false;
			System.out.println("Usuario não localizado!");

		}

		return retorno;

	}

	@Override
	public boolean delecao(Usuario usuario) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Usuario usuBase = ent.find(Usuario.class, usuario.getCpf());

		if (usuBase == null) {

			ent.remove(usuario);
			trans.commit();

		} else {

			retorno = false;
			System.out.println("Usuario não localizado!");

		}

		return retorno;

	}

	@Override
	public Usuario consulta(String cpf) {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();
		Usuario retorno = ent.find(Usuario.class, cpf);

		return retorno;

	}

	@Override
	public List<Usuario> listarTodos() {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario usu");

		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();

		return usuarios;

	}

}
