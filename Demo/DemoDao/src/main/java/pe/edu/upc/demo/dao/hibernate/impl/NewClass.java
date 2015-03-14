
package pe.edu.upc.demo.dao.hibernate.impl;

import pe.edu.upc.demo.dao.entity.Categoria;


public class NewClass {
    
    public static void main(String[] args) {
        CategoriaHibernateImpl chi = CategoriaHibernateImpl.obtenerInstancia();
        try {
            Categoria c = new Categoria();
            c.setNombre("CATEGORIA HIBERNATE");
            chi.insertar(c);
            System.out.println("Se inserto la categoria con ID: " + c.getIdCategoria());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
