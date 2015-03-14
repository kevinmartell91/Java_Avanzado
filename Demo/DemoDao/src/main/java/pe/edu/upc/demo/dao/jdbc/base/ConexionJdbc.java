package pe.edu.upc.demo.dao.jdbc.base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import pe.edu.upc.demo.util.SystemException;
//
import static pe.edu.upc.demo.util.SystemUtil.obtenerPropiedad;

class ConexionJdbc {

    protected Connection cn = null;
    protected PreparedStatement pr = null;
    protected CallableStatement cl = null;
    protected ResultSet rs = null;
    private final String nombreArchivo = "propiedades";
    
    //Obtener la conexion
    protected Connection obtenerConexion() throws SystemException {
        try{
            if(obtenerPropiedad(nombreArchivo, "conexion.pool").equals("1")){
                Context ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(
                        obtenerPropiedad(nombreArchivo, "conexion.ds"));
                return ds.getConnection();
            }else{
                Class.forName(obtenerPropiedad(nombreArchivo, "conexion.driverClass"));
                String url = obtenerPropiedad(nombreArchivo, "conexion.url");
                String usuario = obtenerPropiedad(nombreArchivo, "conexion.usuario");
                String clave = obtenerPropiedad(nombreArchivo, "conexion.clave");
                return DriverManager.getConnection(url,usuario,clave);
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }
    }
    
    
    protected void cerrar(Connection cn){
        try {
            cn.close();
        } catch (Exception e) {
        }
    }
    
    protected void cerrar(PreparedStatement pr){
        try {
            pr.close();
        } catch (Exception e) {
        }
    }
    
    protected void cerrar(CallableStatement cl){
        try {
            cl.close();
        } catch (Exception e) {
        }
    }
    protected void cerrar(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
        }
    }
    
    protected void rollback(Connection cn){
        try {
            cn.rollback();
        } catch (Exception e) {
        }
    }
    
}
