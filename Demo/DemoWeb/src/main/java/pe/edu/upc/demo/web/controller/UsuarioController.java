package pe.edu.upc.demo.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import pe.edu.upc.demo.dao.entity.Usuario;
import pe.edu.upc.demo.service.UsuarioService;
import pe.edu.upc.demo.service.impl.UsuarioServiceImpl;
import pe.edu.upc.demo.util.SystemException;
import pe.edu.upc.demo.web.util.WebUtil;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private final Logger logger = Logger.getLogger(UsuarioController.class);
    private final UsuarioService usuarioService;
    
    public UsuarioController(){
        usuarioService = UsuarioServiceImpl.obtenerInstancia();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        context.setAttribute("mapUsuarios", new HashMap<String, HttpSession>());
                
    }
    //Valida el inicio de sesión
    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SystemException{
        String txtUsuario = request.getParameter("txtUsuario");
        String txtClave = request.getParameter("txtClave");
        Usuario usuario = usuarioService.validarUsuario(txtUsuario, txtClave);
        if(usuario != null){
            //Usuario y clave correcta
            HashMap<String, HttpSession> mapUsuarios = (HashMap<String, HttpSession>)
                    getServletContext().getAttribute("mapUsuarios");
            if(!mapUsuarios.containsKey(txtUsuario)){
                //El usuario no inicio sesión en otro navegador
                HttpSession session = request.getSession(true);
                session.setAttribute("usuarioInicio", usuario);
                mapUsuarios.put(txtUsuario, session);
                getServletContext().setAttribute("mapUsuarios", mapUsuarios);
                if(usuario.getIdRol().getIdRol() == 1){
                    response.sendRedirect("pages/producto/mntProducto.jsp");
                }else{
                    response.sendRedirect("pages/categoria/mntCategoria.jsp");
                }
            }else{
                //El usuario si inicio sesión en otro navegador
                StringBuilder sb = new StringBuilder();
                sb.append("error.jsp?mensaje=Ya tuvo un inicio de sesion en otro navegador");
                sb.append("&txtUsuario=");
                sb.append(txtUsuario);
                response.sendRedirect(sb.toString());
            }
        }else{
            response.sendRedirect("error.jsp?mensaje=Clave incorrecta");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            iniciarSesion(request, response);
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
