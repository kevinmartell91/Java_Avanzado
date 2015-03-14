package pe.edu.upc.demo.service;

import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.service.base.BaseService;
import pe.edu.upc.demo.util.SystemException;

public interface UsuarioService 
        extends BaseService<Categoria, Integer>{
    
    Usuario validarUsuario(String usuario, String clave) 
            throws SystemException;
}
