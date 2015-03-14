package pe.edu.upc.demo.service.util;

import pe.edu.upc.demo.dao.hibernate.impl.CategoriaHibernateImpl;
import pe.edu.upc.demo.dao.hibernate.impl.UsuarioHibernateImpl;
import pe.edu.upc.demo.dao.jdbc.base.EntityDao;
import pe.edu.upc.demo.dao.jdbc.impl.CategoriaJdbcImpl;
import pe.edu.upc.demo.dao.jdbc.impl.UsuarioJdbcImpl;

public final class ServiceUtil {

    private ServiceUtil() {

    }

    public static EntityDao obtenerDao(String clase) {
        EntityDao entityDao = null;
        //Tipo Conexion es 1 --> JDBC
        //Tipo Conexion es 2 --> HIBERNATE
        int tipoConexion = 2;
        if (clase.equalsIgnoreCase("CATEGORIA")) {
            switch (tipoConexion) {
                case 1:
                    System.out.println("Categoria JDBC");
                    entityDao = CategoriaJdbcImpl.obtenerInstancia();
                    break;
                case 2:
                    System.out.println("Categoria Hibernate");
                    entityDao = CategoriaHibernateImpl.obtenerInstancia();
                    break;
                default:
                    System.out.println("Categoria JDBC");
                    entityDao = CategoriaJdbcImpl.obtenerInstancia();
                    break;
            }
        } else if (clase.equalsIgnoreCase("USUARIO")) {
            switch (tipoConexion) {
                case 1:
                    System.out.println("Usuario JDBC");
                    entityDao = UsuarioJdbcImpl.obtenerInstancia();
                    break;
                case 2:
                    System.out.println("Usuario Hibernate");
                    entityDao = UsuarioHibernateImpl.obtenerInstancia();
                    break;
                default:
                    System.out.println("Usuario JDBC");
                    entityDao = UsuarioJdbcImpl.obtenerInstancia();
                    break;
            }
        }
        return entityDao;
    }

}
