package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

public class TesteJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		Usuario u = new Usuario();
		
		u.setCpf("000.000.000-00");
		u.setNome("Zero");
		Calendar data = new GregorianCalendar();
		data.set(Calendar.YEAR, 2000);
	    data.set(Calendar.MONTH, 01);
	    data.set(Calendar.DAY_OF_MONTH, 01);
		u.setDataNascimento(data.getTime());
		u.setSenha("00001");
		
		usuarioDAO.insercao(u);

	}

}
