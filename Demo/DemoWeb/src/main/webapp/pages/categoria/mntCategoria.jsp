<%@page import="pe.edu.upc.demo.web.util.WebUtil"%>
<%@page import="pe.edu.upc.demo.dao.entity.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.demo.service.impl.CategoriaServiceImpl"%>
<%@page import="pe.edu.upc.demo.service.CategoriaService"%>
<%@page import="pe.edu.upc.demo.util.SystemUtil"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static final Logger LOGGER = Logger.getLogger("mntCategoria.jsp");
%>
<%
    String mensaje = SystemUtil.validarNull(request.getParameter("mensaje"));
    CategoriaService categoriaService = CategoriaServiceImpl.obtenerInstancia();
    List<Categoria> lista = null;
    try{
        lista = categoriaService.listar();
    }catch(Exception e){
        mensaje = WebUtil.controlarError(e, LOGGER);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Mantenimiento Categoria</title>
    </head>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <h3><%= mensaje%></h3>
            <table border="1">
                <thead>
                    <tr>
                        <td>Código</td>
                        <td>Nombre</td>
                        <td>Operaciones</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if(lista!=null){
                            for(Categoria c : lista){
                    %>
                                <tr>
                                    <td><%= c.getIdCategoria() %></td>
                                    <td><%= c.getNombre() %></td>
                                    
                                    <%
                                    
                                        String urlEli = request.getContextPath() + "/CategoriaController?";
                                        urlEli+="action=eliminar&txtId=" + c.getIdCategoria();
                                        
                                        String urlAct = request.getContextPath() + "/pages/categoria/";
                                        urlAct+="actCategoria.jsp?id="+ c.getIdCategoria();
                                    
                                    %>
                                    
                                    <td>
                                        <center>
                                            <a href="<%= urlEli %>">
                                                <img src="../../resources/img/delete.png" width="20" height="20" /> 
                                            </a>
                                            | 
                                            <a href="<%= urlAct %>">
                                                <img src="../../resources/img/edit.png" width="20" height="20" /> 
                                            </a>
                                        </center>
                                    </td>
                                    
                                </tr>
                    <%
                            }
                        }else{
                    %>
                            <tr>
                                <td colspan="3">No existe elementos</td>
                            </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
