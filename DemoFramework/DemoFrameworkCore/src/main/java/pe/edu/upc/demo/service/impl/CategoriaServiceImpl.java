package pe.edu.upc.demo.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.repository.CategoriaRepository;
import pe.edu.upc.demo.service.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService, Serializable{

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public int contarTotalRegistros() throws Exception {
        return categoriaRepository.contarFilas();
    }

    public void guardar(Categoria e) throws Exception {
        categoriaRepository.save(e);
    }

    public void eliminar(Integer id) throws Exception {
        categoriaRepository.delete(id);
    }

    public Categoria obtener(Integer id) throws Exception {
        return categoriaRepository.findOne(id);
    }

    public List<Categoria> listar() throws Exception {
        return categoriaRepository.findAll();
    }
    
}
