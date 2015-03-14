package pe.edu.upc.demo.service.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, ID extends Serializable> {
    
    void guardar(E e) throws Exception;
    
    void eliminar(ID id)throws Exception;
    
    E obtener(ID id)throws Exception;
    
    List<E> listar() throws Exception;
    
}
