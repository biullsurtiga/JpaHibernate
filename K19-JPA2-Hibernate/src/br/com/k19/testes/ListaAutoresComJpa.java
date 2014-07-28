package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Autor;

public class ListaAutoresComJpa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPATeste");
		
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("SELECT a FROM Autor a");
		List<Autor> autores = query.getResultList();	
//Listar 		
		for(Autor a : autores){
			System.out.println("AUTOR: " + a.getNome());
		}
	}
}
