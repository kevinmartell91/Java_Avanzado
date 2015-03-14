package pe.edu.upc.demo.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pe.edu.upc.demo.domain.Categoria;
import pe.edu.upc.demo.service.CategoriaService;

@ManagedBean
@SessionScoped
public class CategoriaController implements Serializable{
    
    private Categoria categoria;
    private Categoria categoriaSeleccionada;
    private List<Categoria> listaCategorias;
    @ManagedProperty(value = "#{categoriaService}")
    private CategoriaService categoriaService;

    public CategoriaController() {
        categoria = new Categoria();
        categoriaSeleccionada = new Categoria();
        listaCategorias = new ArrayList<Categoria>();
    }
    
    @PostConstruct
    public void postConstruct(){
        this.listar();
    }
    
    public void guardar(){
        try {
            this.categoriaService.guardar(this.categoria);
            this.enviarMensaje("Se guardo la categoria correctamente");
            this.limpiar();
        } catch (Exception e) {
            e.printStackTrace();
            this.enviarMensaje("Error: " + e.getMessage());
        }
    }
    
    public void editar(){
        try {
            if(categoriaSeleccionada.getIdCategoria()!=null 
                    && categoriaSeleccionada.getIdCategoria()>0){
                this.categoria = this.categoriaSeleccionada;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.enviarMensaje("Error: " + e.getMessage());
        }
    }
    
    public void eliminar(){
        try {
            if(categoriaSeleccionada.getIdCategoria()!=null 
                    && categoriaSeleccionada.getIdCategoria()>0){
                this.categoriaService.eliminar(
                        categoriaSeleccionada.getIdCategoria());
                this.enviarMensaje("Se elimino la categoria correctamente");
                this.limpiar();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.enviarMensaje("Error: " + e.getMessage());
        }
    }
    
    public void limpiar(){
        this.categoria = new Categoria();
        this.categoriaSeleccionada = new Categoria();
        this.listar();
    }
    
    public void listar(){
        try {
            this.listaCategorias = categoriaService.listar();
        } catch (Exception e) {
            e.printStackTrace();
            this.enviarMensaje("Error: " + e.getMessage());
        }
    }

    public void enviarMensaje(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Información", mensaje));
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    
}
