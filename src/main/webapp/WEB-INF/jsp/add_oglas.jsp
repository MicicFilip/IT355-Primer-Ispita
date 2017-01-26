<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj rasu</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addOglas" value="/add_oglas" ></c:url>
        <form:form method="POST" accept-charset="UTF-8" action="${addOglas}" modelAttribute="oglas">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="naslov">
                    Naslov
                </form:label>
                <form:input type="naslov" class="form-control" id="naslov" placeholder="Naslov" path="naslov" />
            </div>
             <div class="form-group">
                <form:label path="opis">
                    Opis
                </form:label>
                <form:textarea type="opis" class="form-control" id="opis" placeholder="Opis" path="opis" />
            </div>
              <div class="form-group">
                <form:label for="zivotinjaId" path="zivotinjaId">Zivotinja</form:label>

                <form:select id="slcRole" class="form-control" path="zivotinjaId">
                      <form:option value="">SELECT</form:option>
                    <form:options items="${zivotinje}" itemValue="id" itemLabel="ime" />
                </form:select>
            </div>
            <div class="form-group">
                <form:label for="rasaId" path="rasaId">Rasa</form:label>

                <form:select id="slcRole" class="form-control" path="rasaId">
                      <form:option value="">SELECT</form:option>
                    <form:options items="${rase}" itemValue="id" itemLabel="ime" />
                </form:select>
            </div>
            <div class="form-group">
                <form:label for="mestoId" path="mestoId">Mesto</form:label>

                <form:select id="slcRole" class="form-control" path="mestoId">
                      <form:option value="">SELECT</form:option>
                    <form:options items="${mesta}" itemValue="id" itemLabel="nazivMesta" />
                </form:select>
            </div>     
           <div class="form-group">
                <form:label path="cena">
                    Cena
                </form:label>
                <form:input type="price" class="form-control" id="cena" placeholder="Cena" path="cena" />
            </div>
            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
            <div class="col-md-8 col-md-offset-2">
            <c:if test="${!empty oglasi}">

                <table class="table table-striped mojatabela">
                    <thead>
                        <tr>
                            <th>Naslov</th>
                            <th>Zivotinja</th>
                            <th>Rasa</th>
                            <th>Mesto</th>
                            <th>Cena</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${oglasi}" var="oglas">

                            <tr>
                                <td>${oglas.naslov}</td>
                                <td>${oglas.zivotinjaId}</td>
                                <td>${oglas.rasaId}</td>
                                <td>${oglas.mestoId}</td>
                                <td>${oglas.cena}</td>
                                <td><a href="<c:url value='/edit_oglas/${oglas.id}' />">edit</a></td>
                                <td><a href="<c:url value='/delete_oglas/${oglas.id}' />">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>      
        
  </div>
<%@include file="footer.jsp" %>