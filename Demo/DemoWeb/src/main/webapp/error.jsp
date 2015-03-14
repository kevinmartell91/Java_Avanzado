<%@page import="pe.edu.upc.demo.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String nombreUsuario = request.getParameter("txtUsuario");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="resources/template/metaData.jsp" %>
        <title>Error</title>
    </head>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" >
        <%@include file="resources/template/cabecera.jsp" %>
        <div id="divPrincipal">
            <h4>ERROR</h4>
            <h3><%= SystemUtil.validarNull(request.getParameter("mensaje")) %></h3>
            <%
                if(nombreUsuario!=null){
            %>
                <div>Eliminar usuario: 
                <a href="CerrarSesionController?txtUsuario=<%= nombreUsuario %>">
                    <%= nombreUsuario %>
                </a>
                de la sesión iniciada
                </div>
            <%
                }
            %>
            <a href="<%= request.getContextPath() %>">Volver al inicio</a>
        </div>
        <%@include file="resources/template/pie.jsp" %>
    </body>
</html>
