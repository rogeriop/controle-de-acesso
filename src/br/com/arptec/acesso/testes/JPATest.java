package br.com.arptec.acesso.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.arptec.acesso.modelo.Grupo;
import br.com.arptec.acesso.modelo.Usuario;

public class JPATest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("acesso");
		EntityManager manager = entityManagerFactory.createEntityManager();
		
		Grupo grupo = new Grupo();
		grupo.setNome("TESTE");
		
		Usuario usuario = new Usuario("Antônio Rogério Pinheiro", "rogeriop@arptec.com.br", "12345678", grupo);
		
	
		manager.getTransaction().begin();
		
		manager.persist(grupo);
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		manager.close();
		
	}

}
