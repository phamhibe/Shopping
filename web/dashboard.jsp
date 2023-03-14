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

<%
    request.setAttribute("cD", new CustomerDAO());
    request.setAttribute("accD", new AccountDAO());
    request.setAttribute("oD", new OrderDAO());
    ArrayList<OrderDetail> odt = new OrderDetailDAO().getWeeklySaleByOrdDet();
    double sum =0;
    for(OrderDetail o: odt) {
        sum += (o.getUnitPrice() * o.getQuantity());
    }
    DecimalFormat df = new DecimalFormat("$#0.00"); 
    ArrayList<OrderDetail> odtAll = new OrderDetailDAO().getAllOrderDetail();
    double sumAll = 0;
    for(OrderDetail oA: odtAll) {
        sumAll += (oA.getUnitPrice() * oA.getQuantity());
    }
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
        <div class="path-admin">DASHBOARD</b></div>
        <div class="content-main">
            <div id="content-main-dashboard">
                <div id="dashboard-1">
                    <div id="dashboard-1-container">
                        <div class="dashboard-item">
                            <div class="dashboard-item-title">Weekly Sales</div>
                            <div class="dashboard-item-content">$47K</div>
                        </div>
                        <div class="dashboard-item">
                            <div class="dashboard-item-title">Total Orders</div>
                            <div class="dashboard-item-content">$1000K</div>
                        </div>
                        <div class="dashboard-item">
                            <div class="dashboard-item-title">Total Customers</div>
                            <div class="dashboard-item-content">5K</div>
                        </div>
                        <div class="dashboard-item">
                            <div class="dashboard-item-title">Total Guest</div>
                            <div class="dashboard-item-content">3K</div>
                        </div>
                    </div>
                </div>
                <div id="dashboard-2">
                    <select>
                        <c:forEach items="${listYear}" var="item">
                        <option value="${item.getYear()}">${item.getYear()}</option>
                        </c:forEach>
                    </select>

                    <div id="chart" style="text-align: center;">
                        <div id="chart1">
                            <h3>Statistic Orders (Month)</h3>
                            <canvas id="myChart1" style="width: 100%;"></canvas>
                        </div>
                        <div id="chart2">
                            <canvas id="myChart2" style="width: 80%;"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%}%>
<%@include file="template/footer1.jsp" %>
<script>
    function OrdersChart() {
        var xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        new Chart("myChart1", {
            type: "line",
            data: {
                labels: xValues,
                datasets: [{
                        data: [${oD.countOrderByMonth(1)}, ${oD.countOrderByMonth(2)}, ${oD.countOrderByMonth(3)},
    ${oD.countOrderByMonth(4)}, ${oD.countOrderByMonth(5)}, ${oD.countOrderByMonth(6)},
    ${oD.countOrderByMonth(7)}, ${oD.countOrderByMonth(8)}, ${oD.countOrderByMonth(9)},
    ${oD.countOrderByMonth(10)}, ${oD.countOrderByMonth(11)}, ${oD.countOrderByMonth(12)}],
                        borderColor: "sienna",
                        fill: true
                    }]
            },
            options: {
                legend: {display: false}
            }
        });
    }
    function CustomersChart() {
        var xValues = ["Total", "New customer"];
        var yValues = [${cD.getCountAllCus()}, ${cD.getCountNewCus()}];
        var barColors = ["green", "red"];
        new Chart("myChart2", {
            type: "bar",
            data: {
                labels: xValues,
                datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
            },
            options: {
                legend: {display: false},
                title: {
                    display: true,
                    text: "New Customers (30 daily Avg)"
                }
            }
        });
    }
    OrdersChart();
    CustomersChart();
</script>
