<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header1.jsp" %>
<%
    Account acc = (Account) request.getSession().getAttribute("AccSession");
    if(acc == null || acc.getRole() == 2) {
%>
<c:redirect url="home"></c:redirect>
<%
    } else {
%>
<div id="content">
    <div id="content-left">
        <ul>
            <a href="dashboard.jsp"><li>Dashboard</li></a>
            <a href="<%=path%>/order-list"><li>Orders</li></a>
            <a href="<%=path%>/product-list"><li>Products</li></a>
            <a href="#"><li>Customers</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path-admin">ORDERS LIST</b></div>
        <div class="content-main">
            <div id="content-main-dashboard">
                <div id="order-title">
                    <b>Filter by Order date:</b>
                    <form>
                        From: <input type="date" name="txtStartOrderDate"/>
                        To: <input type="date" name="txtEndOrderDate"/>
                        <input type="submit" value="Filter">
                    </form>
                </div>
                <div id="order-table">
                    <table id="orders">
                        <tr>
                            <th>OrderID</th>
                            <th>OrderDate</th>
                            <th>RequiredDate</th>
                            <th>ShippedDate</th>
                            <th>Employee</th>
                            <th>Customer</th>
                            <th>Freight($)</th>
                            <th>Status</th>
                        </tr>
                        <c:forEach items="${listO}" var="o">
                            <tr>
                                <td><a href="<%=path%>/order-detail?orderID=${o.getOrderID()}">#${o.getOrderID()}</a></td>
                                <td>${o.getOrderDate()}</td>
                                <td>${o.getRequiredDate()}</td>
                                <td>${o.getShippedDate()}</td>
                                <c:forEach items="${listE}" var="e">
                                    <c:if test="${o.getEmployeeID() == e.getEmployeeID()}">
                                        <td>${e.getLastName()}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${listC}" var="c">
                                    <c:if test="${o.getCustomerID() == c.getCustomerID()}">
                                        <td>${c.getContactName()}</td>
                                    </c:if>
                                </c:forEach>
                                <td>${o.getFreight()}</td>
                                <c:if test="${o.getRequiredDate() != null}">
                                    <td style="color: blue;">Pending</td>
                                </c:if>
                                <c:if test="${o.getShippedDate() != null}">
                                    <td style="color: green;">Completed</td>
                                </c:if>
                                <c:if test="${o.getRequiredDate() == null}">
                                    <td style="color: green;">Cancelled</td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div id="paging">
                    <div class="pagination">
                        <a href="#">&laquo;</a>
                        <c:choose>
                            <c:when test="${StartOrderDate == null && EndOrderDate == null}">
                                <c:forEach begin="1" end="${endP}" var="i">
                                    <a class="${page == i?"active":""}" href="<%=path%>/order-list?index=${i}">${i}</a>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:forEach begin="1" end="${endP}" var="i">
                                    <a class="${page == i?"active":""}" href="<%=path%>/order-list?index=${i}&txtStartOrderDate=${StartOrderDate}&txtEndOrderDate=${EndOrderDate}">${i}</a>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        <a href="#">&raquo;</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%}%>
<%@include file="template/footer1.jsp" %>