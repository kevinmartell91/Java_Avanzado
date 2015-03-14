package pe.edu.upc.demo.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.web.util.WebUtil;

@WebServlet(name = "CerrarSesionController", urlPatterns = {"/CerrarSesionController"})
public class CerrarSesionController extends HttpServlet {

    private final Logger logger = Logger.getLogger(CerrarSesionController.class);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HashMap<String, HttpSession> mapUsuarios = (HashMap<String, HttpSession>)
                    getServletContext().getAttribute("mapUsuarios");
            String txtUsuario = request.getParameter("txtUsuario");
            if(txtUsuario != null){
                //Eliminar la sesion del hashmap
                if(mapUsuarios.get(txtUsuario).getAttribute("usuarioInicio")!=null){
                    mapUsuarios.get(txtUsuario).removeAttribute("usuarioInicio");
                    //mapUsuarios.get(txtUsuario).invalidate();
                    mapUsuarios.remove(txtUsuario);
                    getServletContext().setAttribute("mapUsuarios", mapUsuarios);
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }
            }else{
                //Eliminar mi propia sesion
                HttpSession session =request.getSession(false);
                if(session.getAttribute("usuarioInicio")!=null){
                    Usuario u = (Usuario)session.getAttribute("usuarioInicio");
                    mapUsuarios.remove(u.getUsuario());
                    getServletContext().setAttribute("mapUsuarios", mapUsuarios);
                }
                session.removeAttribute("usuarioInicio");
                session.invalidate();
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("error.jsp?mensaje=" + WebUtil.controlarError(e, logger));
        }
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
