package br.com.k19.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPATeste");
		factory.close();
		
		
	}
}
