package pe.edu.upc.demo.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.demo.dao.CategoriaDao;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.dao.jdbc.base.BaseJdbc;
import pe.edu.upc.demo.util.SystemException;

public final class CategoriaJdbcImpl 
                    extends BaseJdbc 
                    implements CategoriaDao{

    //Patron singleton
    private static final CategoriaJdbcImpl CATEGORIA_JDBC_IMPL;
    
    static{
        System.out.println("Inicio CategoriaJdbcImpl");
        CATEGORIA_JDBC_IMPL = new CategoriaJdbcImpl();
    }
    
    private CategoriaJdbcImpl(){
        
    }
    
    public static CategoriaJdbcImpl obtenerInstancia(){
        return CATEGORIA_JDBC_IMPL;
    }
    //
    
    public void insertar(Categoria entity) throws SystemException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO Categoria(nombre) VALUES(?)");
            cn = obtenerConexion();
            pr = cn.prepareStatement(sb.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, entity.getNombre().trim().toUpperCase());
            pr.executeUpdate();
            rs = pr.getGeneratedKeys();
            rs.next();
            entity.setIdCategoria(rs.getInt(1));
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(rs);
            cerrar(pr);
            cerrar(cn);
        }
    }

    public void actualizar(Categoria entity) throws SystemException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Categoria SET nombre = ? WHERE idCategoria =? ");
            cn = obtenerConexion();
            //Controlar el commit a la base de datos
            cn.setAutoCommit(false);
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, entity.getNombre().trim().toUpperCase());
            pr.setInt(2, entity.getIdCategoria());
            pr.executeUpdate();
            cn.commit();
        } catch (Exception e) {
            rollback(cn);
            throw new SystemException(e);
        }finally{
            cerrar(pr);
            cerrar(cn);
        }
    }

    public void eliminar(Integer id) throws SystemException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM Categoria WHERE idCategoria = ?");
            cn = obtenerConexion();
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(pr);
            cerrar(cn);
        }
    }

    public Categoria obtener(Integer id) throws SystemException {
        Categoria categoria = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Categoria WHERE idCategoria = ? ");
            cn = obtenerConexion();
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(rs);
            cerrar(pr);
            cerrar(cn);
        }
        return  categoria;
    }

    public List<Categoria> listar() throws SystemException {
        List<Categoria> lista = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Categoria ORDER BY nombre ");
            cn = obtenerConexion();
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            lista = new ArrayList<Categoria>();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
                lista.add(categoria);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(rs);
            cerrar(pr);
            cerrar(cn);
        }
        return lista;
    }
    
    
    
}
