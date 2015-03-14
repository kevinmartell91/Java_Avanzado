package pe.edu.upc.demo.service.impl;

import java.util.List;
import pe.edu.upc.demo.dao.UsuarioDao;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.service.UsuarioService;
import pe.edu.upc.demo.service.util.ServiceUtil;
import pe.edu.upc.demo.util.SystemException;

public class UsuarioServiceImpl implements UsuarioService{
    //INICIO SINGLETON
    private final static UsuarioServiceImpl USUARIO_SERVICE_IMPL;
    private UsuarioDao usuarioDao;
    
    static{
        USUARIO_SERVICE_IMPL =  new UsuarioServiceImpl();
    }
    
    private UsuarioServiceImpl(){
        usuarioDao = (UsuarioDao)ServiceUtil.obtenerDao("USUARIO");
    }
    
    public static UsuarioServiceImpl obtenerInstancia(){
        return USUARIO_SERVICE_IMPL;
    }
    //FIN SINGLETON
    
    
    public Usuario validarUsuario(String usuario, String clave) throws SystemException {
        return usuarioDao.validarUsuario(usuario, clave);
    }

    public void insertar(Categoria e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizar(Categoria e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Categoria obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Categoria> listar() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
