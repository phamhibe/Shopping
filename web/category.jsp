<%@page import="java.util.ArrayList" %>
<%@page import="dal.Category" %>
<%@page import="models.*" %>
<%@include file="template/header.jsp" %>
<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <c:forEach items="${listC}" var="c">         
                <a  href="category?cateID=${c.getCategoryID()}"><li class="${cateID == c.getCategoryID()?"active":""}">${c.getCategoryName()}</li></a>
            </c:forEach>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">${cate.getCategoryName()}</b></div>
        <div class="content-main">
            <c:forEach items="${listP}" var="p">
                <div class="product">
                    <a href="<%=path%>/product/detail?proID=${p.getProductID()}"><img src="<%=path%>/img/1.jpg" width="100%"/></a>
                    <div class="name"><a href="<%=path%>/product/detail?proID=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">$${p.getUnitPrice()}</div>
                    <div><a href="<%=path%>/account/cart?proID=${p.getProductID()}">Buy now</a></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>

