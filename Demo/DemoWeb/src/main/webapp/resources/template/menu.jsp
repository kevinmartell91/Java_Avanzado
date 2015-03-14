<%@page import="java.util.HashMap"%>
<%@page import="pe.edu.upc.demo.web.listener.SessionListener"%>
<%@page import="pe.edu.upc.demo.dao.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.demo.dao.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = (Usuario)session.getAttribute("usuarioInicio");
    if(u!=null){
        int cantidadUsuario = 0;
        HashMap<String, HttpSession> mapUsuarios = (HashMap<String, HttpSession>)getServletContext().getAttribute("mapUsuarios");
        if(mapUsuarios!=null){
            cantidadUsuario = mapUsuarios.size();
        }
        List<Menu> listaOpciones = u.getIdRol().getMenuList();
%>
<br />
<div>
    Cantidad de usuarios conectados: <%= cantidadUsuario %>
</div>
<br />
<div>
    <%
        for(Menu m : listaOpciones){
            if(m.getDescripcion()!=null){
                String url = request.getContextPath()+ m.getUrl();
    %>
                |<a href="<%= url%>"><%= m.getDescripcion() %></a>
    <%
            }
        }
    %>
</div>
<%
    }
%>
<br />