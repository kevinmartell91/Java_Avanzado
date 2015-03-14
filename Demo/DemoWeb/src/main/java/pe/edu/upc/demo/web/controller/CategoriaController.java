package pe.edu.upc.demo.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.edu.upc.demo.dao.entity.Categoria;
import pe.edu.upc.demo.service.CategoriaService;
import pe.edu.upc.demo.service.impl.CategoriaServiceImpl;
import pe.edu.upc.demo.web.util.WebUtil;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    private final Logger logger = Logger.getLogger(CategoriaController.class);
    private final CategoriaService categoriaService = CategoriaServiceImpl.obtenerInstancia();
    
    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        Categoria c = new Categoria();
        c.setNombre(request.getParameter("txtNombre").trim().toUpperCase());
        categoriaService.insertar(c);
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        Categoria c = new Categoria();
        c.setIdCategoria(Integer.parseInt(request.getParameter("txtId")));
        c.setNombre(request.getParameter("txtNombre").trim().toUpperCase());
        categoriaService.actualizar(c);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        categoriaService.eliminar(Integer.parseInt(request.getParameter("txtId")));
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("action");
        String mensaje = "";
        String pagina = "/pages/categoria/mntCategoria.jsp";
        try {
            if(accion!=null && accion.equalsIgnoreCase("registrar")){
                this.registrar(request, response);
                mensaje = "Se registro la categoria";
            }else if(accion!=null && accion.equalsIgnoreCase("actualizar")){
                this.actualizar(request, response);
                mensaje = "Se actualizo la categoria";
            }else if(accion!=null && accion.equalsIgnoreCase("eliminar")){
                this.eliminar(request, response);
                mensaje = "Se elimino la categoria";
            }
        } catch (Exception e) {
            mensaje = WebUtil.controlarError(e, logger);
            pagina = "/error.jsp";
        }
        pagina = request.getContextPath() + pagina + "?mensaje=" + mensaje;
        logger.info("Url --> " + pagina);
        response.sendRedirect(pagina);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
