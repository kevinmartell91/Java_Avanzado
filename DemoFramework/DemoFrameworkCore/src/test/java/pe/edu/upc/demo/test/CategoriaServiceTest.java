package pe.edu.upc.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.service.CategoriaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
        {"file:src/main/java//pe/edu/upc/demo/configuration/SpringContext.xml"})
public class CategoriaServiceTest {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Test
    public void probar(){
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre("Service");
            categoriaService.guardar(categoria);
            System.out.println("Categoria guardada: " + categoria.getIdCategoria());
            
            int cantidad = categoriaService.contarTotalRegistros();
            System.out.println("Total registros: " + cantidad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
