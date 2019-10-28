<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo libro</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" 
              rel="stylesheet" />
        <script 
        src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3><s:message code="libro.crear"/></h3>
            </div>
            <div class="row">
                <div class=" col-md-7">
                    <f:form action="create" 
                            modelAttribute="libro" method="post">

                        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
                        <div class="form-group">
                            <label for="codigoLibro"><s:message code="libro.codigo"/>:</label>
                            <div class="input-group">
                                <f:input path="codigoLibro" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nombreLibro"><s:message code="libro.nombre"/>:</label>
                            <div class="input-group">
                                <f:input path="nombreLibro" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="existencias"><s:message code="libro.existencias"/></label>
                            <div class="input-group">
                                <f:input path="existencias" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="precio"><s:message code="libro.precio"/>:</label>
                            <div class="input-group">
                                <f:input path="precio" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="autor"><s:message code="libro.autor"/>:</label>
                            <div class="input-group">
                                <f:select path="autores.codigoAutor" cssClass="form-control" id="autor">
                                    <f:options items="${listaAutores}" 
                                               itemLabel="nombreAutor" itemValue="codigoAutor"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="editorial"><s:message code="libro.editorial"/>:</label>
                            <div class="input-group">
                                <f:select path="editoriales.codigoEditorial" cssClass="form-control">
                                    <f:options items="${listaEditoriales}" 
                                               itemLabel="nombreEditorial" 
                                               itemValue="codigoEditorial"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="genero"><s:message code="libro.genero"/>:</label>
                            <div class="input-group">
                                <f:select path="generos.idGenero" cssClass="form-control">
                                    <f:options items="${listaGeneros}" itemLabel="nombreGenero" 
                                               itemValue="idGenero"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <f:button class="btn btn-info"><s:message code="guardar"/></f:button>
                        <a class="btn btn-danger" href="<s:url 
                           value="/libros/list"/>"><s:message code="cancelar"/></a>
                    </f:form>
                </div>
            </div> 
        </div>
        <script>
            $('#autor').select2();
        </script>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>