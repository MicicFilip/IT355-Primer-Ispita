<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj rasu</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addRasa" value="/add_rasa" ></c:url>
        <form:form method="POST" accept-charset="UTF-8" action="${addRasa}" modelAttribute="rasa">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="ime">
                    Ime
                </form:label>
                <form:input type="ime" class="form-control" id="ime" placeholder="Ime" path="ime" />
            </div>
              <div class="form-group">
                <form:label for="zivotinjaId" path="zivotinjaId">Zivotinja</form:label>

                <form:select id="slcRole" class="form-control" path="zivotinjaId">
                      <form:option value="">SELECT</form:option>
                    <form:options items="${zivotinje}" itemValue="id" itemLabel="ime" />
                </form:select>
            </div>
            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
            <div class="col-md-8 col-md-offset-2">
            <c:if test="${!empty rase}">

                <table class="table table-striped mojatabela">
                    <thead>
                        <tr>
                            <th>Ime rase</th>
                            <th>Zivotinja</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${rase}" var="rasa">

                            <tr>
                                <td>${rasa.ime}</td>
                                <td>${rasa.zivotinjaId}</td>
                                <td><a href="<c:url value='/edit_rasa/${rasa.id}' />">edit</a></td>
                                <td><a href="<c:url value='/delete_rasa/${rasa.id}' />">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>      
        
  </div>
<%@include file="footer.jsp" %>