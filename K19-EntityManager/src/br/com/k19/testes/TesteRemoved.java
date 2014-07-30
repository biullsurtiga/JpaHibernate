package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteRemoved {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// OBJETO NO ESTADO MENAGED
		Pessoa p = manager.find(Pessoa.class, 1L);

		// OBJETO NO ESTADO REMOVED
		manager.remove(p);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
