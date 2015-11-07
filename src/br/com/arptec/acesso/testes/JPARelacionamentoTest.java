package br.com.arptec.acesso.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.arptec.acesso.modelo.Grupo;
import br.com.arptec.acesso.modelo.Usuario;

public class JPARelacionamentoTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("acesso");
		EntityManager manager = entityManagerFactory.createEntityManager();

		Grupo grupo1 = new Grupo();
		grupo1.setNome("TESTE");

		gravaGrupo(manager, grupo1);
		
		Grupo grupo2 = new Grupo();
		grupo2.setNome("ADMINISTRADOR");

		gravaGrupo(manager, grupo2);
		
		
		Usuario usuario1 = new Usuario("Antônio Rogério Pinheiro",
				"rogeriop@arptec.com.br", "12345678", grupo1);
		
		gravaUsuario(manager, usuario1);

		Usuario usuario2 = new Usuario("Rogério Ramos Pinheiro",
				"rogeriopxpinheiro@gmail.com", "12345678", grupo1);

		gravaUsuario(manager, usuario2);

		Usuario usuario3 = new Usuario("Filipe Ramos Pinheiro",
				"rogeriop@arptec.com.br", "12345678", grupo2);
		
		gravaUsuario(manager, usuario3);

		Usuario usuario4 = new Usuario("Newton Filipe Cabral Pinheiro",
				"newton@gmail.com", "12345678", grupo2);

		gravaUsuario(manager, usuario4);
		
		manager.close();

	}

	private static void gravaGrupo(EntityManager manager, Grupo grupo) {
		manager.getTransaction().begin();
		manager.persist(grupo);
		manager.getTransaction().commit();
	}

	private static void gravaUsuario(EntityManager manager, Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	
}
