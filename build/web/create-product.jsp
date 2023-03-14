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
                    <label>Product name<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtProductName"><br/>
                    <label>Unit price<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtUnitPrice"><br/>
                    <label>Quantity per unit<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtQuantityPerUnit"><br/>
                    <label>Units in stock<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtUnitsInStock"><br/>
                </div>
                <div class="content-main-1">
                    <label>Category<span style="color: red;">*</span>:</label><br/>
                    <select name="ddlCategory">
                    </select>
                    <br/>
                    <label>Reorder level<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtReorderLevel"><br/>
                    <label>Units on order<span style="color: red;">*</span>:</label><br/>
                    <input type="text" name="txtUnitsOnOrder"><br/>
                    <label>Discontinued<span style="color: red;">*</span>:</label><br/>
                    <input type="radio" name="chkDiscontinued" value="false">In stock<br/>
                    <input type="radio" name="chkDiscontinued" value="true">Out of stock<br/>
                    <input type="submit" value="Save"/>
                </div>
            </form>
        </div>
    </div>
</div>
<%}%>
<%@include file="template/footer1.jsp" %>