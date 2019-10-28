<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="editorial.nuevo"/></title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>

    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3><s:message code="editorial.nuevo"/></h3>
            </div>
            <div class="row">
                <div class=" col-md-7">
                    <f:form action="create" method="POST" 
                            modelAttribute="editorial"> 
                        <div class="well well-sm"><strong><span 
                                    class="glyphicon glyphicon-asterisk"></span><s:message code="requeridos"/></strong></div>
                        <div class="form-group">
                            <label for="codigoEditorial"><s:message code="editorial.codigo"/></label>
                            <div class="input-group">
                                <f:input path="codigoEditorial" 
                                         cssClass="form-control"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nombreEditorial"><s:message code="editorial.nombre"/></label>
                            <div class="input-group">
                                <f:input path="nombreEditorial" 
                                         cssClass="form-control"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contacto"><s:message code="editorial.contacto"/></label>
                            <div class="input-group">
                                <f:input path="contacto" cssClass="formcontrol"/>
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefono"><s:message code="editorial.telefono"/></label>
                            <div class="input-group">
                                <f:input path="telefono" cssClass="formcontrol"/> 
                                <span class="input-group-addon"><span 
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <f:button class="btn btninfo"><s:message code="guardar"/></f:button>

                        <a class="btn btn-danger" href="<s:url 
                           value="/editoriales/list"/>"><s:message code="cancelar"/></a>
                    </f:form>
                </div>
            </div> 
        </div>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>