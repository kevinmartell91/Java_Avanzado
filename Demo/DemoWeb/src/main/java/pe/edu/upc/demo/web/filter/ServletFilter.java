package pe.edu.upc.demo.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import pe.edu.upc.demo.dao.entity.Menu;
import pe.edu.upc.demo.dao.entity.Usuario;

@WebFilter(filterName = "ServletFilter", urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(ServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("::::::: FILTER ::::::: ServletFilter --> metodo init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("::::::: FILTER ::::::: ServletFilter --> metodo doFilter");
        //Variable que servira para saber si tengo acceso a la pagina web
        boolean accesoPermitido = true;
        if (response instanceof HttpServletResponse
                && request instanceof HttpServletRequest) {
            HttpServletResponse responseTemp = (HttpServletResponse) response;
            HttpServletRequest requestTemp = (HttpServletRequest) request;
            HttpSession session = requestTemp.getSession(false);
            String paginaVisitada = requestTemp.getRequestURI();
            if (paginaVisitada.contains(".jsp")) {
                if (paginaVisitada.contains("index.jsp") || paginaVisitada.contains("error.jsp")) {
                    accesoPermitido = true;
                } else {
                    if (session != null && session.getAttribute("usuarioInicio") != null) {
                        //Inicio sesion en la aplicacion
                        accesoPermitido = false;
                        Usuario u = (Usuario) session.getAttribute("usuarioInicio");
                        List<Menu> menuOpciones = u.getIdRol().getMenuList();
                        for (Menu m : menuOpciones) {
                            if (paginaVisitada.contains(m.getUrl())) {
                                accesoPermitido = true;
                                break;
                            }
                        }
                    } else {
                        //No inicio sesion en la aplicacion
                        accesoPermitido = false;
                    }
                }
            }
            if (accesoPermitido == false) {
                responseTemp.sendRedirect(requestTemp.getContextPath()
                        + "/error.jsp?mensaje=No tiene acceso a dicha URL");
            }
        }
        if(accesoPermitido){
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        LOG.info("::::::: FILTER ::::::: ServletFilter --> metodo destroy");
    }

}
