<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="dal.*" %>
<%@page import="models.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web</title>
        <% String path = request.getContextPath();%>
        <link href="<%=path%>/css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <div id="logo">
                    <a href="<%=path%>/home"><img src="<%=path%>/img/logo.png"/></a>
                </div>
                <div id="banner">
                    <ul>
                        <li>
                            <form action="search" method="post">
                                <input type="txt" name="txtSearch" placeholder="Enter product name" style="border-radius: 10px">
                                <input type="submit" value="Search" style="padding-left: 0px">
                            </form>  
                        </li>
                        <c:choose>
                            <c:when test="${sessionScope.CartSession == null}">
                                <li><a href="<%=path%>/cart.jsp">Cart: 0</a></li>
                                </c:when>
                                <c:otherwise>
                                <li><a href="<%=path%>/cart.jsp">Cart: ${CartSession.size()}</a></li>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${sessionScope.AccSession == null}">
                                <li><a href="<%=path%>/account/signin">SignIn</a></li>
                                <li><a href="<%=path%>/account/signup">SignUp</a></li>
                                </c:when>
                                <c:otherwise>
                                <li><a href="<%=path%>/account/profile?cusID=${sessionScope.AccSession.getCustomerID()}">Profile</a></li>
                                <li><a href="<%=path%>/account/signin">SignOut</a></li>
                                </c:otherwise>
                            </c:choose>
                    </ul>
                </div>
            </div>
