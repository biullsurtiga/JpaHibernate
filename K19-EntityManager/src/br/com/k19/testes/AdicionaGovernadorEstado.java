package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class AdicionaGovernadorEstado {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Governador governador = new Governador();
		governador.setNome("Rafel Cosentino");

		Estado estado = new Estado();
		estado.setNome("São Paulo");

		governador.setEstado(estado);
		estado.setGovernador(governador);

		manager.persist(estado);
		manager.persist(governador);

		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
