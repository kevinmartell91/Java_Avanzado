/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.demo.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.upc.demo.dao.UsuarioDao;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.dao.hibernate.base.BaseHibernate;
import pe.edu.upc.demo.util.SystemException;

/**
 *
 * @author pcsihewo
 */
public class UsuarioHibernateImpl extends BaseHibernate<Usuario, Integer> implements UsuarioDao {

    private static final UsuarioHibernateImpl USUARIO_HIBERNATE_IMPL;

    static {
        System.out.println("Inicio UsuarioHibernateImpl");
        USUARIO_HIBERNATE_IMPL = new UsuarioHibernateImpl();
    }

    private UsuarioHibernateImpl() {
        setClass(Usuario.class);
    }

    public static UsuarioHibernateImpl obtenerInstancia() {
        return USUARIO_HIBERNATE_IMPL;
    }

    public Usuario validarUsuario(String usuario, String clave) throws SystemException {
        Usuario u = null;
        Session sesionBaseDatos = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            sesionBaseDatos = getSession();
            stringBuilder.append("FROM Usuario u join fetch u.idRol r  join fetch r.menuList m WHERE u.usuario = :usuario AND u.clave=:clave ");
            stringBuilder.append("ORDER BY m.idMenu");
            Query query = sesionBaseDatos.createQuery(stringBuilder.toString());
            query.setParameter("usuario", usuario);
            query.setParameter("clave", clave);
            List<Usuario> listaUsuarios = query.list();
            if (listaUsuarios != null) {
                u = listaUsuarios.get(0);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            closeSession(sesionBaseDatos);
        }
        return u;
    }

    public void insertar(Usuario entity) throws SystemException {
        super.guardar(entity);
    }

    public void actualizar(Usuario entity) throws SystemException {
        super.guardar(entity);
    }

}
