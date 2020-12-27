package dao;

import java.util.List;

import entidade.Usuario;

public interface UsuarioDAO {
	
	public boolean insercao(Usuario usuario);
	
	public boolean atualizacao(Usuario usuario);
	
	public boolean delecao(Usuario usuario);
	
	public Usuario consulta(String cpf);
	
	public List<Usuario> listarTodos();

}
