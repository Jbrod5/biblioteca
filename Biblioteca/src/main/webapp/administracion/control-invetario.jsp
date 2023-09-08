
<%@page import="java.util.ArrayList"%>
<%@page import="com.jbrod.biblioteca.model.inventario.Biblioteca"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control inventario - Biblioteca</title>
         <!-- Importar bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  
    </head>
    
    <body>
        <!-- IMPORTAMOS BARRA DE NAVEGACION --> 
        <jsp:include page="/WEB-INF/navBar.jsp"/>
    <div style="display: flex; justify-content: center;">
        
        <div class="card" style="width: 90%; margin: 10px;">
            <div class="card-body">
                    <form action="${pageContext.request.contextPath}/controlInventario" method="POST">
                        
                        <h3>Datos del libro</h3> <br>
                        
                        <div class="mb-3">
                            <label for="isbn" class="form-label">ISBN</label>
                            <input type="text" class="form-control" id="isbn" name="isbn" required>
                        </div>

                        <div class="mb-3">
                            <label for="autor" class="form-label">Autor</label>
                            <input type="text" class="form-control" id="autor" name="autor" required>
                        </div>

                        <div class="mb-3">
                            <label for="titulo" class="form-label">Titulo</label>
                            <input type="text" class="form-control" id="titulo" name="titulo" required>
                        </div>

                        <div class="mb-3">
                            <label for="editorial" class="form-label">Editorial</label>
                            <input type="text" class="form-control" id="editorial" name="editorial" required>
                        </div>

                        <div class="mb-3">
                            <label for="costo" class="form-label">Costo</label>
                            <input type="text" class="form-control" id="costo" name="costo" required>
                        </div>

                        <div class="mb-3">
                            <label for="cantidad" class="form-label">Cantidad</label>
                            <input type="text" class="form-control" id="cantidad" name="cantidad" required>
                        </div>

                      

                        <h3>Reparto del libro</h3>
                        <div style="display: flex;">
                            
                                <%
                                    HttpSession sesion = request.getSession();
                                    List<Biblioteca> bibliotecas = (List) sesion.getAttribute("bibliotecas");
                                    
                                    for (Biblioteca biblioteca: bibliotecas) {    
                                %>

                                    <div class="card" style="width: 18rem; margin: 5px;">
                                        <div class="card-body">
                                                <h5 class="card-title"><%=biblioteca.getId()%></h5>
                                            <p class="card-text"><%=biblioteca.getDireccion()%></p>
                                            <div class="mb-3">
                                                <label for="cantidad" class="form-label">Cantidad:</label>
                                                <input type="text" class="form-control" id="cantidad" name="biblioteca_<%= biblioteca.getId() %>" required>
                                            </div>
                                        </div>
                                      </div>

                                <%
                                    
                                    }
                                %>

                            
                        </div>


                        <input type="submit" value="Guardar" class="btn btn-success"    />
                    </form>
            </div>
        </div>
        
    </div>    
    </body>
</html>
