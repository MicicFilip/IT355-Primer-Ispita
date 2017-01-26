<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj vrstu zivotinje</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addZivotinja" value="/add_zivotinja" ></c:url>
        <form:form method="POST" action="${addZivotinja}" modelAttribute="zivotinja">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="ime">
                    Ime
                </form:label>
                <form:input type="ime" class="form-control" id="ime" placeholder="Ime" path="ime" />
            </div>

            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${!empty zivotinje}">

            <table class="table table-striped mojatabela">
                <thead>
                    <tr>
                        <th>Ime zivotinje</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${zivotinje}" var="zivotinja">

                        <tr>
                            <td>${zivotinja.ime}</td>
                            <td><a href="<c:url value='/edit_zivotinja/${zivotinja.id}' />">edit</a></td>
                            <td><a href="<c:url value='/delete_zivotinja/${zivotinja.id}' />">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>    
</div>
<%@include file="footer.jsp" %>