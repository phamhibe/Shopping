<%@include file="template/header.jsp" %>
<div id="content">
    <div id="cart">
        <div id="cart-title">
            <h3>SHOPPING CART</h3>
        </div>

        <div id="cart-content">
            <c:choose>
                <c:when test="${msgCart ne null}">
                    <div class="cart-item">
                        <span class="msg-error">${msgCart}</span><br/>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${sessionScope.CartSession}" var="c">
                        <div class="cart-item">
                            <div class="cart-item-infor">
                                <div class="cart-item-img">
                                    <img src="<%=path%>/img/1.jpg"/>
                                </div>
                                <div class="cart-item-name">
                                    <a href="<%=path%>/product/detail?proID=${c.getProduct().getProductID()}">${c.getProduct().getProductName()}</a>
                                </div>
                                <div class="cart-item-price">
                                    $ ${c.getProduct().getUnitPrice() * c.getQuantity()}
                                </div>
                                <div class="cart-item-button">
                                    <a href="<%=path%>/account/cart-action?proID=${c.getProduct().getProductID()}&remove=true">Remove</a>
                                </div>
                            </div>
                            <div class="cart-item-function">
                                <a href="<%=path%>/account/cart-action?proID=${c.getProduct().getProductID()}&sub=true">-</a>  
                                <input type="text" value="${c.getQuantity()}" disabled/>
                                <a href="<%=path%>/account/cart-action?proID=${c.getProduct().getProductID()}&add=true">+</a>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>     
        </div>
        <div id="cart-summary">
            <div id="cart-summary-content">Total amount: <span style="color:red">${total} $</span></div>
        </div>      
        <form action="<%=path%>/account/cart-action" method="post">
            <div id="customer-info">
                <div id="customer-info-content">
                    <h3>CUSTOMER INFORMATION:</h3>
                    <c:choose>
                        <c:when test="${sessionScope.AccSession == null}">
                            <div id="customer-info-detail">
                                <div id="customer-info-left">
                                    <label>Company name<span style="color: red;">*</span></label><br/>
                                    <input type="text" name="txtCompanyName"/><br/>
                                    <c:if test="${msgCompanyName ne null}">
                                        <span class="msg-error">${msgCompanyName}</span><br/>
                                    </c:if>
                                    <label>Contact name<span style="color: red;">*</span></label><br/>
                                    <input type="text" name="txtContactName"/><br/>
                                    <c:if test="${msgContactName ne null}">
                                        <span class="msg-error">${msgContactName}</span><br/>
                                    </c:if>
                                    <label>Required date<span style="color: red;">*</span></label><br/>
                                    <input type="date" name="txtRequiredDate"><br/>
                                    <c:if test="${msgRequiredDate ne null}">
                                        <span class="msg-error">${msgRequiredDate}</span><br/>
                                    </c:if>
                                </div>
                                <div id="customer-info-right">
                                    <label>Contact title<span style="color: red;">*</span></label><br/>
                                    <input type="text" name="txtContactTitle"/><br/>
                                    <c:if test="${msgContactTitle ne null}">
                                        <span class="msg-error">${msgContactTitle}</span><br/>
                                    </c:if>
                                    <label>Address<span style="color: red;">*</span></label><br/>
                                    <input type="text" name="txtAddress"/><br/>
                                    <c:if test="${msgAddress ne null}">
                                        <span class="msg-error">${msgAddress}</span><br/>
                                    </c:if>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div id="customer-info-detail">
                                <div id="customer-info-left">
                                    <label>Company name<span style="color: red;">*</span></label><br/>
                                    <input type="text" value="${c.getCompanyName()}" name="txtCompanyName" readonly/><br/>
                                    <label>Contact name<span style="color: red;">*</span></label><br/>
                                    <input type="text" value="${c.getContactName()}" name="txtContactName" readonly/><br/>
                                    <label>Required date<span style="color: red;">*</span></label><br/>
                                    <input type="date" name="txtRequiredDate"><br/>
                                    <c:if test="${msgRequiredDate ne null}">
                                        <span class="msg-error">${msgRequiredDate}</span><br/>
                                    </c:if>
                                </div>
                                <div id="customer-info-right">
                                    <label>Contact title<span style="color: red;">*</span></label><br/>
                                    <input type="text" value="${c.getContactTitle()}" name="txtContactTitle" readonly/><br/>
                                    <label>Address<span style="color: red;">*</span></label><br/>
                                    <input type="text" value="${c.getAddress()}" name="txtAddress" readonly/><br/>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div id="customer-info">
                <div id="customer-info-content">
                    <h3>PAYMENT METHODS:</h3>
                    <div id="customer-info-payment">
                        <div>
                            <input type="radio" name="rbPaymentMethod" checked/>
                            Payment C.O.D - Payment on delivery
                        </div>
                        <div>
                            <input type="radio" name="rbPaymentMethod" disabled/>
                            Payment via online payment gateway
                        </div>
                    </div>
                </div>
            </div>
            <div id="cart-order">
                <input type="submit" value="ORDER"/>
            </div>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>

