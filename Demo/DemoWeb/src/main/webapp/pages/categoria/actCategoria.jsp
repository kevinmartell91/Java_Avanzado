<%@page import="pe.edu.upc.demo.web.util.WebUtil"%>
<%@page import="pe.edu.upc.demo.dao.entity.Categoria"%>
<%@page import="pe.edu.upc.demo.service.impl.CategoriaServiceImpl"%>
<%@page import="pe.edu.upc.demo.service.CategoriaService"%>
<%@page import="pe.edu.upc.demo.util.SystemUtil"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private final static Logger LOGGER = Logger.getLogger("actCategoria.jsp");
%>
<%
    String mensaje = SystemUtil.validarNull(request.getParameter("mensaje"));
    CategoriaService categoriaService = CategoriaServiceImpl.obtenerInstancia();
    Categoria c = null;
    try{
        c = categoriaService.obtener(Integer.parseInt(request.getParameter("id")));
    }catch(Exception e){
        mensaje = WebUtil.controlarError(e, LOGGER);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Actualizar Categoria</title>
    </head>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <form name="frmPrincipal" method="post" 
                  action="<%= request.getContextPath() %>\CategoriaController">
                <input type="hidden" name="action" value="actualizar" />
                <table>
                    <tr>
                        <td>Id: </td>
                        <td><input type="text" name="txtId" value="<%= c.getIdCategoria() %>" 
                                   readonly="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtNombre" value="<%= c.getNombre() %>" 
                                    /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Actualizar" /></td>
                    </tr>
                </table>
                
            </form>
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
