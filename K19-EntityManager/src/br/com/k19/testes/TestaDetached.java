package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TestaDetached {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// OBJETO NO ESTADO MANAGED
		Pessoa p = manager.find(Pessoa.class, 1L);

		// OBJETO NO ESTADO DETACHED
		manager.detach(p);

		// ALTERANDO O CONTEUDO DO OBJETO
		p.setNome("Jonas Hirata");

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
