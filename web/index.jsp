<%@page import="java.util.ArrayList" %>
<%@page import="dal.Category" %>
<%@page import="models.*" %>
<%@include file="template/header.jsp" %>
<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <c:forEach items="${listC}" var="c">         
                <a href="category?cateID=${c.getCategoryID()}"><li class="${tag == c.getCategoryID() ? "active":""}">${c.getCategoryName()}</li></a>
                    </c:forEach>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">Hot</b></div>
        <div class="content-main">
            <c:forEach items="${listP}" begin="0" end="3" var="p">
                <div class="product">
                    <a href="<%=path%>/product/detail?proID=${p.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                    <div class="name"><a href="<%=path%>/product/detail?proID=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">$${p.getUnitPrice()}</div>
                    <div><a href="<%=path%>/account/cart?proID=${p.getProductID()}&buy=true">Buy now</a></div>
                </div>
            </c:forEach>
        </div>
        <div class="path">Best Sale</b></div>
        <div class="content-main">
            <c:forEach items="${listP1}" var="p1">
            <div class="product">
                <a href="<%=path%>/product/detail?proID=${p1.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="<%=path%>/product/detail?proID=${p1.getProductID()}">${p1.getProductName()}</a></div>
                <div class="price">$${p1.getUnitPrice()}</div>
                <div><a href="<%=path%>/account/cart?proID=${p1.getProductID()}&buy=true">Buy now</a></div>
            </div>
            </c:forEach>
        </div>
        <div class="path">New Product</b></div>
        <div class="content-main">
            <c:forEach items="${listP2}" begin="0" end="3" var="p2">
            <div class="product">
                <a href="<%=path%>/product/detail?proID=${p2.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="<%=path%>/product/detail?proID=${p2.getProductID()}">${p2.getProductName()}</a></div>
                <div class="price">$${p2.getUnitPrice()}</div>
                <div><a href="<%=path%>/account/cart?proID=${p2.getProductID()}&buy=true">Buy now</a></div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>
