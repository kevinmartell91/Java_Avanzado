package pe.edu.upc.demo.service.impl;

import java.util.List;
import pe.edu.upc.demo.dao.CategoriaDao;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.service.CategoriaService;
import pe.edu.upc.demo.service.util.ServiceUtil;
import pe.edu.upc.demo.util.SystemException;

public class CategoriaServiceImpl implements CategoriaService{
    //Inicio singleton
    private final static CategoriaServiceImpl CATEGORIA_SERVICE_IMPL;
    private CategoriaDao categoriaDao;

    static{
        CATEGORIA_SERVICE_IMPL = new CategoriaServiceImpl();
    }
    
    private CategoriaServiceImpl(){
        categoriaDao = (CategoriaDao)ServiceUtil.obtenerDao("CATEGORIA");
    }
    
    public static CategoriaServiceImpl obtenerInstancia(){
        return CATEGORIA_SERVICE_IMPL;
    }
    //Fin singleton
    
    public List<Categoria> listarPorNombre(String nombre) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertar(Categoria e) throws SystemException {
        this.categoriaDao.insertar(e);
    }

    public void actualizar(Categoria e) throws SystemException {
        this.categoriaDao.actualizar(e);
    }

    public void eliminar(Integer id) throws SystemException {
        this.categoriaDao.eliminar(id);
    }

    public Categoria obtener(Integer id) throws SystemException {
        return this.categoriaDao.obtener(id);
    }

    public List<Categoria> listar() throws SystemException {
        return this.categoriaDao.listar();
    }
    
}
