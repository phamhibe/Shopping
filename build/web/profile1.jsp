<%@include file="template/header.jsp" %>
<div id="content">
    <div id="content-left">
        <h3 style="font-weight: normal;">Welcome, ${cus.getCompanyName()}</h3>
        <h3>Account Management</h3>
        <ul>
            <a href="<%=path%>/account/profile?cusID=${cus.getCustomerID()}"><li>Personal information</li></a>
        </ul>
        <h3>My order</h3>
        <ul>
            <a href="<%=path%>/account/all-order"><li>All orders</li></a>
            <a href="<%=path%>/account/cancel-order"><li>Canceled order</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">LIST ORDERS</b></div>
        <div class="content-main">
            <div id="profile-content-order">
                <c:forEach items="${listO}" var="o">
                    <c:if test="${o.getShippedDate() == null && o.getRequiredDate() != null}">
                        <div>
                            <div class="profile-order-title">
                                <div class="profile-order-title-left">

                                    <div>Order creation date: ${o.getOrderDate()}</div>
                                    <div>Order: <a href="#">#${o.getOrderID()}</a></div>

                                </div>
                                <div class="profile-order-title-right">
                                    <form action="" method="post">
                                        <span>Pending</span>
                                        <input type="hidden" name="orderID" value="${o.getOrderID()}">
                                        <span><input type="submit" value="Cancel"></span>
                                    </form>
                                </div>

                            </div>
                            <c:forEach items="${listOD}" var="od">
                                <c:forEach items="${listP}" var="p">
                                    <c:if test="${o.getOrderID() == od.getOrderID()}">
                                        <c:if test="${od.getProductID() == p.getProductID()}">
                                            <div class="profile-order-content">
                                                <div class="profile-order-content-col1">
                                                    <a href="detail.jsp"><img src="<%=path%>/img/2.jpg" width="100%"/></a>
                                                </div>
                                                <div class="profile-order-content-col2">${p.getProductName()}</div>
                                                <div class="profile-order-content-col3">Quantity: ${od.getQuantity()}</div>
                                                <div class="profile-order-content-col4">${od.getUnitPrice() * od.getQuantity()} $</div>
                                            </div>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:forEach>
                <c:forEach items="${listO}" var="o">
                    <c:if test="${o.getShippedDate() != null}">
                        <div>
                            <div class="profile-order-title">
                                <div class="profile-order-title-left">
                                    <div>Order creation date: ${o.getOrderDate()}</div>
                                    <div>Order: <a href="#">#${o.getOrderID()}</a></div>
                                </div>
                                <div class="profile-order-title-right">
                                    <span style="color: blue;">Completed</span>
                                </div>
                            </div>
                            <c:forEach items="${listOD}" var="od">
                                <c:forEach items="${listP}" var="p">
                                    <c:if test="${o.getOrderID() == od.getOrderID()}">
                                        <c:if test="${od.getProductID() == p.getProductID()}">
                                            <div class="profile-order-content">
                                                <div class="profile-order-content-col1">
                                                    <a href="detail.jsp"><img src="<%=path%>/img/2.jpg" width="100%"/></a>
                                                </div>
                                                <div class="profile-order-content-col2">${p.getProductName()}</div>
                                                <div class="profile-order-content-col3">Quantity: ${od.getQuantity()}</div>
                                                <div class="profile-order-content-col4">${od.getUnitPrice() * od.getQuantity()} $</div>
                                            </div>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>
