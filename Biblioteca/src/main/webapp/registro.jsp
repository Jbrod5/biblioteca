
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro - Biblioteca</title>
        
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        
    </head>
    
    
    
    <body>
        
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            
                            
                            <h3 class="card-title text-center">Registro</h3>
                            
                            
                            <!-- Si es administrador, debe mandar a crear a nuevo usuario -->
                            <c:if test = "${user.getTipo() == 0}">
                                <form id="form-login" action="${pageContext.request.contextPath}/registro" method="POST">
                            </c:if>
                            

                            <!-- Si NO es admin, debe mandar a crear un nuevo CLIENTE -->
                            <c:if  test = "${user.getTipo() != 0}">
                                <form id="form-login" action="${pageContext.request.contextPath}/nuevocliente" method="POST">
                            </c:if>        
                                    
                                    
                                
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre</label>
                                    <input type="text" class="form-control" id="name" name="name">
                                </div>
                                
                                <div class="mb-3">
                                    <label for="username" class="form-label">Nombre de usuario</label>
                                    <input type="text" class="form-control" id="username" name="username">
                                </div>
                                
                                
                            
                                <c:if test = "${user.getTipo() != 0}">
                                    <div class="mb-3">
                                        <label for="correo" class="form-label">Correo</label>
                                        <input type="text" class="form-control" id="correo" name="correo">
                                    </div>
                                </c:if>
                                
                                <div class="mb-3">
                                    <label for="password" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                
                                        
                                
                                
                                <c:if test = "${user.getTipo() == 0}">
                                    <div class="mb-3">
                                        <label for="tipo" class="form-label">Tipo</label>
                                        <select id="tipo" name ="tipo" class="form-select">
                                            <option value="1">Recepcionista</option>
                                            <option value="2">Transportista</option>
                                        </select>    
                                    </div>
                                    
                                </c:if>
                                
                                    
                                    
                                <div class="text-center d-grid gap-2">
                                    <button type="submit" class="btn btn-primary ">Registrarse</button>
                                </div>

                            
                            </form>
                                        
                                        
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

<!--JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        
        
    </body>
</html>
