package pe.edu.upc.demo.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.service.CategoriaService;
import pe.edu.upc.demo.service.impl.CategoriaServiceImpl;


@WebService(serviceName = "CategoriaWs")
public class CategoriaWs {

    private CategoriaService categoriaService = 
            CategoriaServiceImpl.obtenerInstancia();
    
    @WebMethod(operationName = "insertar")
    public String insertar(@WebParam(name = "nombre02") String nombre) {
        String mensaje = "";
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre(nombre);
            categoriaService.insertar(categoria);
            mensaje = "Se inserto la categoria con código: " + categoria.getIdCategoria();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = e.getMessage();
        }
        return mensaje;
    }
}
