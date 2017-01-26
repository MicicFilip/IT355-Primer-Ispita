<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj mesto</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addMesto" value="/add_mesto" ></c:url>
        <form:form method="POST" action="${addMesto}" modelAttribute="mesto">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="nazivMesta">
                    Naziv meesta
                </form:label>
                <form:input type="nazivMesta" class="form-control" id="nazivMesta" placeholder="Naziv mesta" path="nazivMesta" />
            </div>

            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${!empty mesta}">

            <table class="table table-striped mojatabela">
                <thead>
                    <tr>
                        <th>Ime mesta</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${mesta}" var="mesto">

                        <tr>
                            <td>${mesto.nazivMesta}</td>
                            <td><a href="<c:url value='/edit_mesto/${mesto.id}' />">edit</a></td>
                            <td><a href="<c:url value='/delete_mesto/${mesto.id}' />">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp" %>