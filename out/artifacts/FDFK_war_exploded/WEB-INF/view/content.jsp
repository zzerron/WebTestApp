<%--
  Created by IntelliJ IDEA.
  User: Dinislam
  Date: 05.10.2018
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .center {display:block; margin:0 auto;}
    </style>
</head>
<jsp:useBean id="BeanOfUrl" class="beans.BeanOfURL" scope="request"/>
<img class="center" src="${pageContext.request.contextPath}/images/${BeanOfUrl.id}" height="90%">
</html>
