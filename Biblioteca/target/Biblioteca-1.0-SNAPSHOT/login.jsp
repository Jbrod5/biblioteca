<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Biblioteca</title>
        <!-- Importar bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        
    </head>
    
    
    <body>

        <!-- Inlcuir barra de navegacion -->
        <!-- Incluir elementos de la sesion -->
        
    
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        
                        <div class="card-body">
                            <h3 class="card-title text-center">Inicia sesión</h3>
                            
                            
                            <form id="form-login" action="${pageContext.request.contextPath}/login" method="POST">
                                
                                
                                <div class="mb-3">
                                    <label for="username" class="form-label">Username</label>
                                    <input type="text" class="form-control" id="username" name="username">
                                </div>
                                
                                
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                
                                <div class="text-center d-grid gap-2">
                                    <button type="submit" class="btn btn-primary ">Iniciar sesión</button>
                                </div>
                                
                                
                            </form>
                            
                            
                            <div class="text-center mt-3">
                                <p>¿No tienes una cuenta? <a href="${pageContext.request.contextPath}/registro.jsp">Registrate como cliente</a></p>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        
                
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
    
</html>

