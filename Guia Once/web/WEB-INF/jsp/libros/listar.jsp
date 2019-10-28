<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de libros</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3><s:message code="libro.lista"/></h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-primary btn-md" href="<s:url value="/libros/create"/>"><s:message code="libro.crear"/></a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" id="tabla">
                        <thead>
                            <tr>
                                <th><s:message code="libro.codigo"/></th>
                                <th><s:message code="libro.nombre"/></th>
                                <th><s:message code="libro.existencias"/></th>
                                <th><s:message code="libro.precio"/></th>
                                <th><s:message code="libro.editorial"/></th>
                                <th><s:message code="libro.autor"/></th>
                                <th><s:message code="libro.genero"/></th>
                            </tr>
                        </thead>
                        <tbody> 
                        <c:forEach items="${requestScope.listaLibros}" var="libro">
                            <tr>
                                <td>${libro.codigoLibro}</td>
                                <td>${libro.nombreLibro}</td>
                                <td>${libro.existencias}</td>
                                <td>${libro.precio}</td>
                                <td>${libro.editoriales.nombreEditorial}</td>
                                <td>${libro.autores.nombreAutor}</td>
                                <td>${libro.generos.nombreGenero}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div> 
        </div> 
        <script>
            $(document).ready(function () {
                $('#tabla').DataTable();
            });
        </script>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>