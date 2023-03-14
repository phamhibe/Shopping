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
        <div class="path-admin">PRODUCTS LIST</b></div>
        <div class="content-main">
            <div id="content-main-dashboard">
                <div id="product-title-header">
                    <div id="product-title-1" style="width: 25%;">
                        <b>Filter by Catetory:</b>
                        <form action="" method="get">
                            <select name="ddlCategory">
                                <option value="-1">All product</option>
                                <c:forEach items="${listC}" var="c">
                                    <option ${cid == c.getCategoryID()?"selected":""} value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                                </c:forEach>                               
                            </select>
                            <input type="submit" value="Filter">
                            </div>
                            <div id="product-title-2" style="width: 55%;">
                                <input type="text" name="txtSearch" placeholder="Enter product name to search"/>
                                <input type="submit" value="Search">
                            </div>
                        </form>
                        <div id="product-title-3" style="width: 20%;">
                            <a href="<%=path%>/create-product">Create a new Product</a>
                            <form action="">
                                <label for="upload-file">Import .xls or .xlsx file</label>
                                <input type="file" name="file" id="upload-file"/>
                            </form>
                        </div>
                    </div>
                    <div id="order-table-admin">
                        <table id="orders">
                            <tr>
                                <th>ProductID</th>
                                <th>ProductName</th>
                                <th>CategoryID</th>
                                <th>QuantityPerUnit</th>
                                <th>UnitPrice</th>
                                <th>UnitsInStock</th>
                                <th>UnitsOnOrder</th>
                                <th>ReorderLevel</th>
                                <th>Discontinued</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${listP}" var="p1">
                                <tr>
                                    <td><a href="<%=path%>/product/detail?proID=${p1.getProductID()}">#${p1.getProductID()}</a></td>
                                    <td>${p1.getProductName()}</td>
                                    <td>${p1.getCategoryID()}</td>
                                    <td>${p1.getQuantityPerUnit()}</td>
                                    <td>${p1.getUnitPrice()}</td>
                                    <td>${p1.getUnitsInStock()}</td>
                                    <td>${p1.getUnitsOnOrder()}</td>
                                    <td>${p1.getReorderLevel()}</td>
                                    <td>
                                        <c:if test="${p1.isDiscontinued() == false}">In stock</c:if>
                                        <c:if test="${p1.isDiscontinued() == true}">Out of stock</c:if>
                                        </td>
                                        <td>
                                            <a href="<%=path%>/edit-product?id=${p1.getProductID()}">Edit</a> &nbsp; | &nbsp; 
                                        <a href="<%=path%>/delete-product?id=${p1.getProductID()}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div id="paging">
                        <div class="pagination">
                            <a href="#">&laquo;</a>
                            <c:forEach begin="1" end="${endP}" var="i">
                                <a class="${page == i?"active":""}" href="<%=path%>/product-list?index=${i}&ddlCategory=${cid}&txtSearch=${search}">${i}</a>
                            </c:forEach>
                            <a href="#">&raquo;</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="template/footer1.jsp" %>
