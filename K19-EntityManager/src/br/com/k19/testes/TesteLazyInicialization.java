package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteLazyInicialization {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();
		
		//OBJETO CARREGADO EM MODO LAZY
		Pessoa p = manager.getReference(Pessoa.class, 1L);
		
		manager.close();
		factory.close();
		
		//TENTA USAR UM DADO DO OBJETO
		System.out.println(p.getNome());
	}
}
