package pe.edu.upc.demo.service;

import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.service.base.BaseService;

public interface CategoriaService 
        extends BaseService<Categoria, Integer>{
    
    int contarTotalRegistros() throws Exception;
}
