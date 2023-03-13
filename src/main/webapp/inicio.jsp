<%-- 
    Document   : inicio
    Created on : 23/09/2022, 07:10:43 PM
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
            <div class="row">
                <div class="col-12 col-md-6">
                    <p class="display-5">Usuarios</p>
                    <div class="table-respondive">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>No cuenta</th>
                                    <th>Password</th>
                                    <th>Saldo</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${usuarios}" var="user">
                                <tr>
                                    <td>${user.idusers}</td>
                                    <td>${user.name}</td>
                                    <td>${user.noCuenta}</td>
                                    <td>${user.password}</td>
                                    <td>${user.saldo}</td>
                                    <td>
                                        <form action="UserServlet" class="d-flex justify-content-between" method="POST">
                                            <input type="hidden" name="userId" value="${user.idusers}">
                                            <button type="submit" name="action" value="eliminar" class="btn btn-outline-danger">Eliminar</button>
                                            <button type="submit" name="action" value="actualizar" class="btn btn-outline-primary">Actualizar</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-12 col-md-6">
                    <div class="card card-body">
                        <h3>Crear usuario</h3>
                        <form action="UserServlet" method="POST">
                            <c:if test="${userData != null}">
                                <input type="hidden" name="userId" value="${userData.idusers}">
                            </c:if>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input type="text" value="${userData.name}" name="nombre" class="form-control" placeholder="Nombre">
                                        <label>Nombre</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mt-3">
                                        <input type="text" value="${userData.noCuenta}" name="noCuenta" class="form-control" placeholder="No cuenta">
                                        <label>No cuenta</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mt-3">
                                        <input type="password" value="${userData.password}" name="password" class="form-control" placeholder="Contraseña">
                                        <label>Contraseña</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mt-3">
                                        <input type="number" value="${userData.saldo}" name="saldo" class="form-control" placeholder="Saldo">
                                        <label>Saldo</label>
                                    </div>
                                </div>
                                <div class="col-12 d-flex justify-content-center mt-3">
                                    <button type="submit" name="action" value="guardar" class="btn btn-outline-success">Guardar</button>
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
    </body>
</html>
