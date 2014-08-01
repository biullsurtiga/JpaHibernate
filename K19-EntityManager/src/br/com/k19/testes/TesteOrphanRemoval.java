package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Topico;

public class TesteOrphanRemoval {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Topico topico = manager.find(Topico.class, 1L);
		//DA UMA ERRO DA PORRA
		topico.getComentarios().clear();
		
		manager.getTransaction().commit();
		factory.close();
	}
	
}
