package pe.edu.upc.demo.dao.jdbc.impl;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.demo.dao.UsuarioDao;
import pe.edu.upc.demo.dao.entity.Menu;
import pe.edu.upc.demo.dao.entity.Rol;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.dao.jdbc.base.BaseJdbc;
import pe.edu.upc.demo.util.SystemException;


public class UsuarioJdbcImpl 
                            extends BaseJdbc
                            implements UsuarioDao{

    //INICIO SINGLETON
    private static final UsuarioJdbcImpl USUARIO_JDBC_IMPL;
    
    static{
        USUARIO_JDBC_IMPL = new UsuarioJdbcImpl();
    }
    
    private UsuarioJdbcImpl(){
        
    }
    
    public static UsuarioJdbcImpl obtenerInstancia(){
        return USUARIO_JDBC_IMPL;
    }
    //FIN SINGLETON
    
    
    public Usuario validarUsuario(String usuario, String clave) throws SystemException {
        Usuario u = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append("u.* , ");
            sb.append("r.nombre as nombreRol, ");
            sb.append("m.idMenu, ");
            sb.append("m.url, ");
            sb.append("m.esJsp, ");
            sb.append("m.descripcion as descripcionMenu ");
            sb.append("FROM ");
            sb.append("Usuario u INNER JOIN Rol r ON u.idRol = r.idRol INNER JOIN ");
            sb.append("Menu m ON r.idRol = m.idRol ");
            sb.append("WHERE ");
            sb.append("u.usuario = ? and ");
            sb.append("u.clave = ? ");
            sb.append("ORDER BY ");
            sb.append("m.idMenu ");
            cn = obtenerConexion();
            pr = cn.prepareCall(sb.toString());
            pr.setString(1, usuario);
            pr.setString(2, clave);
            rs = pr.executeQuery();
            while(rs.next()){
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setEsJsp(rs.getBoolean("esJsp"));
                menu.setUrl(rs.getString("url"));
                menu.setDescripcion(rs.getString("descripcionMenu"));
                if(u == null){
                    u = new Usuario();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setClave(rs.getString("clave"));
                    u.setIdRol(new Rol());
                    u.getIdRol().setIdRol(rs.getInt("idRol"));
                    u.getIdRol().setNombre(rs.getString("nombreRol"));
                    u.getIdRol().setMenuList(new ArrayList<Menu>());
                    u.getIdRol().getMenuList().add(menu);
                }else{
                    u.getIdRol().getMenuList().add(menu);
                }
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(rs);
            cerrar(pr);
            cerrar(cn);
        }
        return u;
    }

    public void insertar(Usuario entity) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizar(Usuario entity) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> listar() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

