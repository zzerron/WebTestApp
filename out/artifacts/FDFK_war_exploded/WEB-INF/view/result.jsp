<%--
  Created by IntelliJ IDEA.
  User: Dinislam
  Date: 10.10.2018
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body style="background: black">
<div style=" color: yellow; font-family: Georgia; font-size: medium; text-align: center; height: 5%">
    <h1 style="padding: 5px">Result!</h1>
    <jsp:useBean id="beanOfSession" class="beans.BeanOfSession" scope="session"/>
    <jsp:getProperty name="beanOfSession" property="history"></jsp:getProperty>
    <%request.getSession().removeAttribute("beanOfSession");%>
</div>
</body>
</html>
