package pe.edu.upc.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.repository.custom.CategoriaRepositoryCustom;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, 
        CategoriaRepositoryCustom{
    
    List<Categoria> findByNombre(String nombre) throws Exception;
    
    List<Categoria> findByNombreLike(String nombre) throws Exception;
    
    List<Categoria> findByNombreLikeOrderByIdCategoriaAsc(String nombre) throws Exception;
    
    @Query("From Categoria c inner join fetch c.productoList")
    List<Categoria> findByProductoList() throws Exception;
    
}
