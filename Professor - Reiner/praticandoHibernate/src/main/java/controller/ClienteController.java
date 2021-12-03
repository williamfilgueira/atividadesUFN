package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Cliente;

public class ClienteController {

	protected SessionFactory sessionFactory;

	public void setup() {
//		carregando o hibernate
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);

		}

	}

	public void exit() {
//		finalizar conexão
	}

	public void create(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(cliente);

		session.getTransaction().commit();
		session.close();
	}

	public Cliente read(int clienteId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Cliente cliente = session.get(Cliente.class, clienteId);

		session.close();
		return cliente;
	}

	public void update(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(cliente);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(int clienteId) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(cliente);

		session.getTransaction().commit();
		session.close();
	}
	
	public List<Cliente> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Cliente> cliente = session.createQuery("from Cliente", Cliente.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return cliente;
	}
	
	
	
}
