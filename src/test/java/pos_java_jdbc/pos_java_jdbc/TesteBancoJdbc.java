package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() { // metodo de insert

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		//userposjava.setId(7L);
		userposjava.setNome("paulo");
		userposjava.setEmail("paulo@gmail.com");

		userPosDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {
		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(6L);
			
			objetoBanco.setNome("Nome mudado com metodo atualizar");
			
			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void initDeletar(){
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeCarregaFoneUser () {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(11L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------------------------");
		}	
	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(10L);
	}

}
