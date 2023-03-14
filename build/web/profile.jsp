<%@include file="template/header.jsp" %>
<%
    Account acc = (Account) request.getSession().getAttribute("AccSession");
    if(acc == null || acc.getRole() == 1) {
%>
<c:redirect url="home"></c:redirect>
<%
    } else {
%>
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
        <div class="path">Personal information</b></div>
        <div class="content-main">
            <div id="profile-content">
                <div class="profile-content-col">
                    <div>Company name: <br/>${cus.getCompanyName()}</div>
                    <div>Contact name: <br/>${cus.getContactName()}</div>
                    <div>
                        <a href="<%=path%>/account/edit-profile?cusID=${cus.getCustomerID()}"><input type="submit" value="Edit info"/></a> 
                    </div>
                </div>
                <div class="profile-content-col">
                    <div>Company title: <br/>${cus.getContactTitle()}</div>
                    <div>Address: <br/>${cus.getAddress()}</div>
                </div>
                <div class="profile-content-col">
                    <div>Email: <br/>${sessionScope.AccSession.getEmail()}</div>
                </div>
            </div>
        </div>
    </div>
</div>
<%}%>
<%@include file="template/footer.jsp" %>
