<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="resources/template/metaData.jsp" %>
        <title>Iniciar Sesión</title>
    </head>
    
    <%
        String usuario = "";
        String clave = "";
        if(request.getCookies()!=null){
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                if(c.getName().equalsIgnoreCase("usuarioCookie")){
                    usuario = c.getValue();
                }else if(c.getName().equalsIgnoreCase("claveCookie")){
                    clave = c.getValue();
                }
            }
        }
    %>
    
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" >
        <%@include file="resources/template/cabecera.jsp" %>
        <div id="divPrincipal">
            <form action="<%= request.getContextPath()+"/UsuarioController" %>" method="post">
                <table border="0">
                    <tr>
                        <td>Usuario: </td>
                        <td><input type="text" name="txtUsuario" value="<%= usuario%>" /></td>
                    </tr>
                    <tr>
                        <td>Clave: </td>
                        <td><input type="password" name="txtClave" value="<%= clave%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Iniciar Sesión" />
                            <input type="checkbox" name="chkRecordar" value="ON" />
                                Recordar Usuario
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%@include file="resources/template/pie.jsp" %>
    </body>
</html>
