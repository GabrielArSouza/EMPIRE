package ufrn.sgl.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import ufrn.sgl.model.Address;
import ufrn.sgl.model.Bidding;
import ufrn.sgl.model.Company;
import ufrn.sgl.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static  SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				Configuration configuration = new Configuration();
				
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://database-1.cuhkml51q0qo.us-east-2.rds.amazonaws.com:3306/sgl?useSSL=false");
	            settings.put(Environment.USER, "admin");
	            settings.put(Environment.PASS, "12345678");
	            	settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				    
	            settings.put(Environment.SHOW_SQL, "false");
	            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	            settings.put(Environment.HBM2DDL_AUTO, "update");
	            
	            configuration.setProperties(settings);
	
	            configuration.addAnnotatedClass(Address.class);
	            configuration.addAnnotatedClass(User.class);
	            configuration.addAnnotatedClass(Company.class);
	            configuration.addAnnotatedClass(Bidding.class);
	            
	            
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

                sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
		}
		return sessionFactory;
	}
}
