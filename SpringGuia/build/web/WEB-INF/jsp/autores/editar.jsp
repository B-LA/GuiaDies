<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar autor</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Editar autor</h3>
            </div>
            <div class="row">
                <div class=" col-md-7"> 
                    <f:form action="${action}" method="POST" 
                            modelAttribute="autor"> 
                        <div class="well well-sm"><strong><span 
                                    class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
                        <div class="form-group">
                            <label for="codigoAutor">Codigo del 
                                autor:</label>
                            <div class="input-group">
                                <f:input path="codigoAutor" 
                                         cssClass="form-control" readonly="true"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nombreAutor">Nombre del 
                                autor:</label>
                            <div class="input-group">
                                <f:input path="nombreAutor" 
                                         cssClass="form-control"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nacionalidad">Nacionalidad:</label>
                            <div class="input-group">
                                <f:input path="nacionalidad" cssClass="form?control"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <f:button class="btn btninfo">Guardar</f:button>
                        <a class="btn btn-danger" href="<s:url 
                               value="/autores/list"/>">Cancelar</a>
                    </f:form>
                </div>  
            </div> 
        </div>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>