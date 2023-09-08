
<%@page import="com.jbrod.biblioteca.model.inventario.Biblioteca"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control bibliotecas - Biblioteca</title>
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
                                <h4>Listado de bibliotecas</h4>
                                
                                <form id= "form-agregar-biblioteca" action="${pageContext.request.contextPath}/controlBibliotecas" method = "POST">
                                
                                    <div class="mb-3">
                                        <br> Agregar biblioteca <br>
                                        <label for="direccion" class="form-label">Direccion:</label>
                                        <input type="text" class="form-control" name="direccion" id="direccion" required>
                                        <button type="submit" class="btn btn-primary" form="form-agregar-biblioteca">Agregar Biblioteca</button>
                                    </div>
                                    
                                    
                                </form>
                                    
                            </div>
                                    
                            
                            
                            
                            <table border="1">
                                <tr>
                                    <td>ID</td>
                                    <td>Direccion</td>
                                    <td> </td>
                                    <td> </td>
                                </tr>
                                
                               <%
                                    List<Biblioteca> listaBibliotecas = (List) request.getAttribute("bibliotecas");
                                    //Como vamos a imprimir html, no podemos cerrar el for aquí 
                                    String tipo;
                                    for (Biblioteca biblioteca : listaBibliotecas) {
                                %>

                                <tr>
                                    <!-- Aquí vamos imprimiendo html -->
                                    <td><%= biblioteca.getId()%></td>
                                    <td><%= biblioteca.getDireccion()%> </td>
                                    

                                    <td>
                                        <a href="${pageContext.request.contextPath}/controlBibliotecas?accion=editarusuario&idedit=<%=biblioteca.getId()%>"
                                            class="btn btn-info btn-sm">Editar</a>
                                        <a href="${pageContext.request.contextPath}/controlBibliotecas?accion=eliminar&iddelete=<%=biblioteca.getId()%>"
                                            class="btn btn-danger btn-sm">Eliminar</a>
                                    </td>

                                </tr>


                                <% 
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
