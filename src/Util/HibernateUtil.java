/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Carvin
 */
public class HibernateUtil {
	 private static SessionFactory sessionFactory = null;
	    
	    static {
	    	  try {
		            Configuration configuration = new Configuration();
		            configuration.configure();
		            StandardServiceRegistryBuilder builder 
		                = new StandardServiceRegistryBuilder();
		            builder.applySettings(configuration.getProperties());
		            StandardServiceRegistry serviceRegistry = builder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		        } catch (Throwable ex) {
		            ex.printStackTrace();
		        }
	    }
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
