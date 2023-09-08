<%@page import="com.jbrod.biblioteca.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control usuarios - Biblioteca</title>
        <!-- Importar bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        
    </head>
    
    <body>

        
        
        <!-- IMPORTAMOS BARRA DE NAVEGACION --> 
        <jsp:include page="/WEB-INF/navBar.jsp"/>

            <!-- Listado de usuarios -->
            <div class="container-fluid mb-5">
                
                
                
                            
                            
                <div class="row">
                    <div class="col-10">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de usuarios</h4>
                                <a href="${pageContext.request.contextPath}/registro.jsp"
                                            class="btn btn-danger btn-sm">Agregar usuario</a>
                            </div>
                            
                            
                            
                            <table border="1">
                                <tr>
                                    <td>No.</td>
                                    <td>Username</td>
                                    <td>Nombre</td>
                                    <td>Tipo</td>
                                    <td> </td>
                                    <td> </td>
                                </tr>
                               <%
                                    List<Usuario> listaUsuarios = (List) request.getAttribute("usuarios");
                                    //Como vamos a imprimir html, no podemos cerrar el for aquí
                                    int cont = 1; 
                                    String tipo;
                                    for (Usuario usuario : listaUsuarios) {
                                    switch(usuario.getTipo()){
                                        case 0: tipo = "admin"; break;
                                        case 1: tipo =  "recepcionista"; break;
                                        case 2: tipo =  "transportista"; break;
                                        default: tipo =  "cliente";
                                   };   
                                %>

                                <tr>
                                    <!-- Aquí vamos imprimiendo html -->
                                    <td><%=cont%></td>
                                    <td><%= usuario.getUserName()%></td>
                                    <td><%= usuario.getNombre()%> </td>
                                    <td><%= tipo%></td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/controlUsuarios?accion=editarusuario&idedit=<%=usuario.getUserName()%>"
                                            class="btn btn-info btn-sm">Editar</a>
                                        <a href="${pageContext.request.contextPath}/controlUsuarios?accion=eliminar&iddelete=<%=usuario.getUserName()%>"
                                            class="btn btn-danger btn-sm">Eliminar</a>
                                    </td>

                                </tr>


                                <% 
                                    cont++;
                                    } //cerramos el for aqui
                                %>
                            </table>
                                 
                        </div>
                    </div>
                </div>
            </div>
    
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
    
</html>
