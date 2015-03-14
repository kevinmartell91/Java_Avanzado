package pe.edu.upc.demo.dao.jdbc.base;

import java.util.List;
import pe.edu.upc.demo.util.SystemException;

public interface EntityDao<E,ID> {
    
    void insertar(E entity) throws SystemException;
    void actualizar(E entity) throws SystemException;
    void eliminar(ID id) throws SystemException;
    E obtener(ID id) throws SystemException;
    List<E> listar() throws SystemException;
}
