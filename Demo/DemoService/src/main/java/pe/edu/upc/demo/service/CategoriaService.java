package pe.edu.upc.demo.service;

import java.util.List;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.service.base.BaseService;
import pe.edu.upc.demo.util.SystemException;

public interface CategoriaService 
            extends BaseService<Categoria, Integer>{
    
    List<Categoria> listarPorNombre(String nombre) 
            throws SystemException;
}
