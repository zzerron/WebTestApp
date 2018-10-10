<%--
  Created by IntelliJ IDEA.
  User: Dinislam
  Date: 05.10.2018
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div>

    <form action="${pageContext.request.contextPath}/mycontroller" method="post"
    style="height: 5%; margin-top: 1%">
        <button name="no" value="no"
                style="position: fixed; left: 15%; width: 15%; background: yellow; font-size: medium; font-family: Georgia">
            No
        </button>
        <button name="yes" value="yes"
                style="position: fixed; right: 15%; width: 15%; background: yellow; font-size: medium; font-family: Georgia">
            Yes
        </button>
    </form>
</div>
</html>
