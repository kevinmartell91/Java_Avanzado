package pe.edu.upc.demo.repository.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pe.edu.upc.demo.repository.custom.CategoriaRepositoryCustom;

public class CategoriaRepositoryImpl implements CategoriaRepositoryCustom{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int contarFilas() throws Exception {
        return jdbcTemplate.queryForInt("SELECT count(*) FROM Categoria");
    }
    
}
