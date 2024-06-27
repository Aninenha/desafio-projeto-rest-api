package com;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();

			// Configurações do Hibernate
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydatabase");
			configuration.setProperty("hibernate.connection.username", "username");
			configuration.setProperty("hibernate.connection.password", "password");
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

			// Configurações adicionais para evitar warnings
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");

			// Adicione as classes anotadas ou arquivos de mapeamento XML
			// configuration.addAnnotatedClass(YourEntityClass.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
