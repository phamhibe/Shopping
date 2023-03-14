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
            <a href="#"><li>Canceled order</li></a>
        </ul>
    </div>
    <div id="content-right">
        <form action="" method="post">
            <div class="path">Personal information</b></div>
            <div class="content-main">
                <div id="profile-content">
                    <div class="profile-content-col">
                        <div>Company name: <br/><input type="txt" name="txtCompanyName" value="${cus.getCompanyName()}"></div>
                        <div>Contact name: <br/><input type="txt" name="txtContactName" value="${cus.getContactName()}"></div>
                        <div>
                            <a href="<%=path%>/edit-profile.jsp"><input type="submit" value="Update info"/></a>
                            <a href="<%=path%>/account/profile?cusID=${cus.getCustomerID()}"><input type="submit" value="Cancel"/></a>
                        </div>
                    </div>
                    <div class="profile-content-col">
                        <div>Company title: <br/><input type="txt" name="txtContactTitle" value="${cus.getContactTitle()}"></div>
                        <div>Address: <br/><input type="txt" name="txtAddress" value="${cus.getAddress()}"></div>
                    </div>
                    <div class="profile-content-col">
                        <div>Email: <br/><input type="txt" name="txtEmail" value="${sessionScope.AccSession.getEmail()}"></div>
                        <div>Password: <br/><input type="txt" name="txtPassword" value="${sessionScope.AccSession.getPassword()}"></div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>
