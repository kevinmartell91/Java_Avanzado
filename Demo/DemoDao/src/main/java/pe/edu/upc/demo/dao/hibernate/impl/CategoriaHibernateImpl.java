package pe.edu.upc.demo.dao.hibernate.impl;

import java.util.List;
import pe.edu.upc.demo.dao.CategoriaDao;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.dao.hibernate.base.BaseHibernate;
import pe.edu.upc.demo.util.SystemException;

public class CategoriaHibernateImpl extends BaseHibernate<Categoria, Integer> implements CategoriaDao{

    private static final CategoriaHibernateImpl CATEGORIA_HIBERNATE_IMPL;
    
    static {
        System.out.println("Inicio CategoriaHibernateImpl");
        CATEGORIA_HIBERNATE_IMPL = new CategoriaHibernateImpl();
    }
    
    private CategoriaHibernateImpl(){
        setClass(Categoria.class);
    }
    
    public static CategoriaHibernateImpl obtenerInstancia(){
        return CATEGORIA_HIBERNATE_IMPL;
    }
    
    public void insertar(Categoria entity) throws SystemException {
        super.guardar(entity);
    }

    public void actualizar(Categoria entity) throws SystemException {
        super.guardar(entity);
    }

   
}
