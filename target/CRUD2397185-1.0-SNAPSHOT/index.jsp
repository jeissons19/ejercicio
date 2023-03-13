<%-- 
    Document   : index
    Created on : 22/09/2022, 08:48:44 PM
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center mt-5">
                <div class="col-12 col-md-4">
                    <div class="card card-body py-5">
                        <h3>Ingresar</h3>
                        <form action="LoginServlet" method="POST">
                            <div class="row mt-5">
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input type="text" name="name" placeholder="Nombre o No cuenta" class="form-control">
                                        <label>Nombre o No cuenta</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mt-3">
                                        <input type="password" name="password" placeholder="Contraseña" class="form-control">
                                        <label>Contraseña</label>
                                    </div>
                                </div>
                                <div class="col-12 d-flex justify-content-center mt-3">
                                    <button type="submit" class="btn btn-outline-success">Ingresar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <c:if test="${message != null}">
            <script>
                swal.fire('${message}', '', 'error');
            </script>
        </c:if>
    </body>
</html>
