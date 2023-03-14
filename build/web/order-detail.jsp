<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header1.jsp" %>
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
        <div class="path-admin">ORDER DETAIL</b></div>
        <div class="content-main">
            <div id="content-main-dashboard">
                <div>
                    <div class="profile-order-title">
                        <div class="profile-order-title-left">
                            <div>OrderID: ${o.getOrderID()}</div>
                            <div>Order creation date: ${o.getOrderDate()}</div>
                        </div>
                        <div class="profile-order-title-right">
                            <c:if test="${o.getShippedDate() != null}">
                                <span style="color: green;">Completed</span>
                            </c:if>
                            <c:if test="${o.getRequiredDate() != null}">
                                <span style="color: blue;">Pending</span>
                            </c:if>
                            <c:if test="${o.getRequiredDate() == null}">
                                <span style="color: red;">Cancelled</span>
                            </c:if>
                        </div>
                    </div>
                    <c:forEach items="${listOD}" var="od">
                        <c:forEach items="${listP}" var="p">
                            <c:if test="${od.getProductID() == p.getProductID()}">
                                <div class="profile-order-content" style="background-color: white;">
                                    <div class="profile-order-content-col1">
                                        <a href="<%=path%>/product/detail?proID=${p.getProductID()}"><img src="<%=path%>/img/2.jpg" width="100%"/></a>
                                    </div>
                                    <div class="profile-order-content-col2">${p.getProductName()}</div>
                                    <div class="profile-order-content-col3">Quantity: ${od.getQuantity()}</div>
                                    <div class="profile-order-content-col4">${od.getUnitPrice() * od.getQuantity()} $</div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:forEach>


                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="template/footer1.jsp" %>