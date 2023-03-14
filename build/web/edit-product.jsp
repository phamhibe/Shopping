<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header1.jsp" %>
<div id="content">
    <div id="content-left">
        <ul>
            <a href="dashboard.jsp"><li>Dashboard</li></a>
            <a href="order.jsp"><li>Orders</li></a>
            <a href="<%=path%>/product-list"><li>Products</li></a>
            <a href="#"><li>Customers</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path-admin">CREATE A NEW PRODUCT</b></div>
        <div class="content-main">
            <form id="content-main-product" action="" method="post">
                <div class="content-main-1">
                    <input type="hidden" name="txtProductID" value="${p.getProductID()}" readonly><br/>
                    <label>Product name:</label><br/>
                    <input type="text" name="txtProductName" value="${p.getProductName()}"><br/>
                    <label>Unit price:</label><br/>
                    <input type="text" name="txtUnitPrice" value="${p.getUnitPrice()}"><br/>
                    <label>Quantity per unit:</label><br/>
                    <input type="text" name="txtQuantityPerUnit" value="${p.getQuantityPerUnit()}"><br/>
                    <label>Units in stock:</label><br/>
                    <input type="text" name="txtUnitsInStock" value="${p.getUnitsInStock()}"><br/>
                </div>
                <div class="content-main-1">
                    <label>Category:</label><br/>
                    <select name="ddlCategory">
                        <c:forEach items="${listC}" var="c">
                            <option ${p.getCategoryID() == c.getCategoryID()?"selected":""} value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <label>Reorder level:</label><br/>
                    <input type="text" name="txtReorderLevel" value="${p.getReorderLevel()}"><br/>
                    <label>Units on order:</label><br/>
                    <input type="text" name="txtUnitsOnOrder" value="${p.getUnitsOnOrder()}" readonly><br/>
                    <label>Discontinued:</label><br/>
                    <input type="radio" name="chkDiscontinued" value="false" ${p.isDiscontinued() == false?"checked":""}>In stock<br/>
                    <input type="radio" name="chkDiscontinued" value="true" ${p.isDiscontinued() == true?"checked":""}>Out of stock<br/>
                    <input type="submit" value="Save"/>
                    <a href="<%=path%>/product-list"><input type="submit" value="Cancel"></a> 
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="template/footer1.jsp" %>