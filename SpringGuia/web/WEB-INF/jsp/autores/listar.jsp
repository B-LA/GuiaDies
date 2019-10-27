<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de autores</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Lista Autores</h3>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <a class="btn btn-primary btn-md" href="<s:url 
                       value="/autores/create"/>"> Nuevo Autor</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" 
                           id="tabla">
                        <thead>
                            <tr>
                                <th>Codigo del autor</th>
                                <th>Nombre del autor</th>
                                <th>Nacionalidad</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${listarAutores}" var="autor">
                            <tr>
                                <td>${autor.codigoAutor}</td>
                                <td>${autor.nombreAutor}</td>
                                <td>${autor.nacionalidad}</td>
                                
                                <td> 
                                   <a class="btn btn-primary" href="<s:url value="/autores/edit/${autor.codigoAutor}"/>">
                                       <span class="glyphicon glyphicon-edit"></span>Editar</a>
                                       <a class="btn btn-primary" href="javascript:eliminar('${autor.codigoAutor}')">
                                       <span class="glyphicon glyphicon-trash"></span>Editar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div> 
        </div> 
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
        <script>
            $(document).ready(function () {
                $('#tabla').dataTable({
                    "language": {
                        "url": "cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    }
                });
                
                function eliminar(id){
                    alertify.confirm("Realmente desea eliminar este autor?",function(e){
                        if(e){
                            location.href = "delete/"+id;
                        }
                    })
                }

            });
        </script>
    </body>
</html>
