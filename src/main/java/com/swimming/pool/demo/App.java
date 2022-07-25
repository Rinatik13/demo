package com.swimming.pool.demo;

import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.DateReg;
import com.swimming.pool.demo.factory.FactoryClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
//		BuilderDateRegistration build = new BuilderDateRegistration();
//		build.createDateRegistration();

		SessionFactory factory = new Configuration()
				.configure("123")
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(DateReg.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Client client = FactoryClient.create("Rinat","+79872422185", "fanar1313@yandex.ru");
		session.save(client);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
