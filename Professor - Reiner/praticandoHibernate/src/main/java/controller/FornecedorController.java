package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Fornecedor;

public class FornecedorController {

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

	protected void exit() {
//		finalizar conexão
	}

	public void create(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public Fornecedor read(int fornecedorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Fornecedor fornecedor = session.get(Fornecedor.class, fornecedorId);

		session.close();
		return fornecedor;
	}

	public void update(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(int fornecedorId) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(fornecedorId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public List<Fornecedor> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Fornecedor> pessoas = session.createQuery("from Fornecedor", Fornecedor.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return pessoas;
	}

}
