package com.java.hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BookManager {

	protected SessionFactory sessionFactory;

	protected void setup() {
		// code to load Hibernate Session factory
		// configures settings from hibernate.cfg.xml		
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();  
		try {
			sessionFactory = meta.getSessionFactoryBuilder().build();  
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} 
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
	// code to close Hibernate Session factory

		 sessionFactory.close();

	}

	protected void create() {
		// code to save a book
		
		Book book = new Book();
		book.setTitle("Effective python");
		book.setAuthor("Joshua Bloch");
		book.setPrice(32.59f);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		session.close();
		}

	protected void read() {
		// code to get a book

	}

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		manager.setup();
		manager.create();
		manager.exit();

		// create
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();  
		try {
//			SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			Book book = new Book();
			book.setTitle("Effective python");
			book.setAuthor("Joshua Bloch");
			book.setPrice(32.59f);

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(book);

			session.getTransaction().commit();
			session.close();

			sessionFactory.close();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
//		

		// read
		final StandardServiceRegistry registry2 = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();  
		try {
//			SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
			SessionFactory sessionFactory = new MetadataSources(registry2).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

		long bookId = 8;
		Book book = (Book) session.get(Book.class, bookId);
		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
				+ book.getPrice() + " |");
		long bookId1 = 9;
		Book book1 = (Book) session.get(Book.class, bookId);
		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
				+ book.getPrice() + " |");
		long bookId2 = 10;
		Book book2 = (Book) session.get(Book.class, bookId);
		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
				+ book.getPrice() + " |");
		
//		session.getTransaction().commit();
		session.close();

		sessionFactory.close();
		
		} 
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry2);
		}

		
		
		
		
		// read
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		long bookId = 8;
		Book book = (Book) session.get(Book.class, bookId);
		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
				+ book.getPrice() + " |");
//		long bookId1 = 9;
//		Book book1 = (Book) session.get(Book.class, bookId);
//		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
//				+ book.getPrice() + " |");
//		long bookId2 = 10;
//		Book book2 = (Book) session.get(Book.class, bookId);
//		System.out.println("|Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
//				+ book.getPrice() + " |");

//		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
