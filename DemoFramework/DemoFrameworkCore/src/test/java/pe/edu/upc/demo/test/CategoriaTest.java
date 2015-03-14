package pe.edu.upc.demo.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.domain.Producto;
import pe.edu.upc.demo.repository.CategoriaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
        {"file:src/main/java//pe/edu/upc/demo/configuration/SpringContext.xml"})
public class CategoriaTest {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Test
    public void prueba(){
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre("Categoria Spring");
            //Insertar
            categoriaRepository.save(categoria);
            System.out.println("Categoria insertada: " + categoria.getIdCategoria());
            //Actualizar
            categoria.setNombre("Chocolates");
            categoriaRepository.save(categoria);
            System.out.println("Categoria actualizada: " + categoria.getIdCategoria());
            //Listar
            System.out.println("\nLISTADO DE CATEGORIAS");
            System.out.println("=====================");
            List<Categoria> lista = categoriaRepository.findAll();
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
            }
            //Listar ordenado
            System.out.println("\nLISTADO DE CATEGORIAS DESC POR NOMBRE");
            System.out.println("====================================");
            lista = categoriaRepository.findAll(new Sort(Sort.Direction.DESC,"nombre"));
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
            }
            //Obtener uno
            System.out.println("\nBUSCAR UNA CATEGORIA");
            System.out.println("====================");
            Categoria categoriaBuscada = categoriaRepository.findOne(categoria.getIdCategoria());
            System.out.println("ID: " + categoriaBuscada.getIdCategoria());
            System.out.println("Nombre: " + categoriaBuscada.getNombre());
            //Eliminar
            System.out.println("\nELIMINAR CATEGORIA");
            System.out.println("====================");
            categoriaRepository.delete(categoriaBuscada.getIdCategoria());
            //findByNombre
            System.out.println("\nBUSCAR findByNombre");
            System.out.println("======================");
            lista = categoriaRepository.findByNombre("GASEOSAS");
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
            }
            //findByNombreLike
            System.out.println("\nBUSCAR findByNombreLike");
            System.out.println("======================");
            lista = categoriaRepository.findByNombreLike("Categoria%");
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
            }
             //findByNombreLikeOrderByIdCategoriaAsc
            System.out.println("\nBUSCAR findByNombreLikeOrderByIdCategoriaAsc");
            System.out.println("==========================");
            lista = categoriaRepository.findByNombreLikeOrderByIdCategoriaAsc("C%");
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
            }
            //Contar
            int cantidad = categoriaRepository.contarFilas();
            System.out.println("Cantidad Filas: " + cantidad);
            //Inner join
            lista= categoriaRepository.findByProductoList();
            for(Categoria c : lista){
                System.out.println("ID: " + c.getIdCategoria());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("LISTADO PRODUCTOS");
                System.out.println("=================");
                List<Producto> productos = c.getProductoList();
                if(productos!=null){
                    for(Producto p : productos){
                        System.out.println("Producto: " + p.getNombre());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
