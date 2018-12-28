<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Dogs List</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Tahoma, sans-serif;
      font-size: 14px;
      font-weight: bold;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Tahoma, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>
</head>
<body>
<a href="../../index.jsp">Back to menu</a>

<br/>
<br/>

<h1>
  <tg>
    <tr>DOGS DATABASE</tr>
  </tg>
</h1>


<c:if test="${!empty listDogs}">
  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">Name</th>
      <th width="120">Weight</th>
      <th width="120">Height</th>
      <th width="120">Date of Birth</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listDogs}" var="dog">
      <tr>
        <td>${dog.id}</td>
        <td>${dog.dogName}</td>
        <td>${dog.dogWeight}</td>
        <td>${dog.dogHeight}</td>
        <td>${dog.dogBirth}</td>

        <td><a href="<c:url value='/edit/${dog.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${dog.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<h1>ADD NEW DOG</h1>

<c:url var="addAction" value="/dogs/add"/>

  <form:form action="${addAction}" modelAttribute="dog" method="POST">
    <table>
      <c:if test="${!empty dog.dogName}">
        <tr>
          <td>
            <form:label path="id">
              <spring:message text="ID"/>
            </form:label>
          </td>
          <td>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
          </td>
        </tr>
      </c:if>
      <tr>
        <td>
          <form:label path="dogName">
            <spring:message text="Name"/>
          </form:label>
        </td>
        <td>
          <form:input path="dogName"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="dogWeight">
            <spring:message text="Weight"/>
          </form:label>
        </td>
        <td>
          <form:input path="dogWeight"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="dogHeight">
            <spring:message text="Height"/>
          </form:label>
        </td>
        <td>
          <form:input path="dogHeight"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="dogBirth">
            <spring:message text="Date of Birth"/>
          </form:label>
        </td>
        <td>
          <form:input path="dogBirth"/>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <c:if test="${!empty dog.dogName}">
            <input type="submit"
                   value="<spring:message text="Edit Dog"/>"/>
          </c:if>
          <c:if test="${empty dog.dogName}">
            <input type="submit"
                   value="<spring:message text="Add Dog"/>"/>
          </c:if>
        </td>
      </tr>
    </table>
  </form:form>
  </body>
  </html>
