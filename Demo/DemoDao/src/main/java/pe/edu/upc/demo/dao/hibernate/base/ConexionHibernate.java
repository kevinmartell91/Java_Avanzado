package pe.edu.upc.demo.dao.hibernate.base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexionHibernate {

    private static SessionFactory sessionFactory;
    
    static{
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new HibernateException(e);
        }
    }
  
    //Obtener la conexion con la base de datos
    protected Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }
    
    protected void closeSession(Session session){
        try {
            session.close();
        } catch (Exception e) {
        }
    }
    
    protected void rollbackSession(Session session){
        try {
            session.getTransaction().rollback();
        } catch (Exception e) {
        }
    }
    
}
