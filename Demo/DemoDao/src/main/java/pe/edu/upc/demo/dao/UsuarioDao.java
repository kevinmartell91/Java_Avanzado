package pe.edu.upc.demo.dao;

import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.dao.jdbc.base.EntityDao;
import pe.edu.upc.demo.util.SystemException;

public interface UsuarioDao extends EntityDao<Usuario, Integer>{
    
    
    Usuario validarUsuario(String usuario, String clave) 
            throws SystemException;
    
}
