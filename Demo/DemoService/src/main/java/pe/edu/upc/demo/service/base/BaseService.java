package pe.edu.upc.demo.service.base;

import java.util.List;
import pe.edu.upc.demo.util.SystemException;

public interface BaseService<E,ID> {
    
    void insertar(E e) throws SystemException;
    
    void actualizar(E e) throws SystemException;
    
    void eliminar(ID id) throws SystemException;
    
    E obtener(ID id) throws SystemException;
    
    List<E> listar() throws SystemException;
}
