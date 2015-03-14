<%@page import="pe.edu.upc.demo.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = SystemUtil.validarNull(request.getParameter("mensaje"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Registrar Categoria</title>
    </head>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <h3><%= mensaje %></h3>
            <form id="frmPrincipal" method="post" 
                  action="<%= request.getContextPath() %>/CategoriaController">
                <input type="hidden" name="action" value="registrar" />
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
