package pe.edu.upc.demo.dao.hibernate.base;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import pe.edu.upc.demo.util.SystemException;

public class BaseHibernate<E, ID extends Serializable> extends ConexionHibernate{
    
    private Class<E> instancia;
    
    protected void setClass(Class<E> clase){
        this.instancia = clase;
    }
    
    
    public void guardar(E e) throws SystemException{
        BaseHibernate baseDao= new BaseHibernate(){};
        Session session = null;
        try {
            session = baseDao.getSession();
            session.saveOrUpdate(e);
            session.getTransaction().commit();
        } catch (Exception ex) {
            baseDao.rollbackSession(session);
            throw new SystemException(ex);
        } finally{
            baseDao.closeSession(session);
        }
    }
    
    
    public void eliminar(ID id) throws SystemException{
        BaseHibernate baseDao= new BaseHibernate(){};
        Session session = null;
        try {
            session = baseDao.getSession();
            session.delete((E)session.get(instancia, id));
            session.getTransaction().commit();
        } catch (Exception ex) {
            baseDao.rollbackSession(session);
            throw new SystemException(ex);
        } finally{
            baseDao.closeSession(session);
        }
    }
    
    public E obtener(ID id) throws SystemException{
        BaseHibernate baseDao= new BaseHibernate(){};
        Session session = null;
        E objeto = null;
        try {
            session = baseDao.getSession();
            objeto = (E)session.get(instancia,id);
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            baseDao.closeSession(session);
        }
        return objeto;
    }
    
    public List<E> listar() throws SystemException{
        BaseHibernate baseDao= new BaseHibernate(){};
        Session session = null;
        List<E> lista = null;
        try {
            session = baseDao.getSession();
            lista =session.createQuery("FROM " + instancia.getSimpleName()).list();
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            baseDao.closeSession(session);
        }
        return lista;
    }
    
}
