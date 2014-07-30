package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteMenaged {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// OBJETO NO ESTADO MANAGED
		Pessoa p = manager.find(Pessoa.class, 1L);

		// ALTERANDO O CONTEUDO DO OBJETO
		p.setNome("Marcelo Martins");

		// SINCRONIZANDO E CONFIRMANDO A TRASACAO
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
