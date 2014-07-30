package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.k19.modelo.Pessoa;

public class TesteFind {
	
	public static void showFrame(String plaf) {
        try {
            UIManager.setLookAndFeel(plaf);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

	public static void main(String[] args) {
		showFrame(UIManager.getSystemLookAndFeelClassName());
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_bd");
		EntityManager manager = factory.createEntityManager();

		// OBJETO NO ESTADO MANAGED
		Pessoa p = manager.find(Pessoa.class, 1L);
		System.out.println("Id: " + p.getId());
		System.out.println("Nome: " + p.getNome());
		JOptionPane.showMessageDialog(null, p.getId()+" - "+p.getNome());
		
		manager.close();
		factory.close();

	}
}
