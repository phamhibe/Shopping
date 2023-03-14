<%@include file="template/header.jsp" %>
<div id="content">
    <div id="form">
        <div id="form-title">

            <span><a href="<%=path%>/account/signup" style="color: red;">SIGN UP</a></span>
            <span><a href="<%=path%>/account/signin">SIGN IN</a></span>
        </div>
        <div id="form-content">
            <form action="" method="post" onsubmit="return checkPass()">
                <label>Company name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCopName"/><br/>
                <%if(request.getAttribute("msgCopName") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgCopName"));%>
                </span>
                <%}%>
                <br/>
                <label>Contact name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCName"/><br/>
                <%if(request.getAttribute("msgCName") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgCName"));%>
                </span>
                <%}%>
                <br/>
                <label>Contact title<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtTitle"/><br/>
                <%if(request.getAttribute("msgTitle") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgTitle"));%>
                </span>
                <%}%>
                <br/>
                <label>Address<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtAddress"/><br/>
                <%if(request.getAttribute("msgAddress") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgAddress"));%>
                </span>
                <%}%>
                <br/>
                <label>Email<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtEmail"/><br/>
                <%if(request.getAttribute("msgEmail") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgEmail"));%>
                </span>
                <%} else if(request.getAttribute("msgCheckEmail") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgCheckEmail"));%>
                </span>
                <%}%>
                <br/>
                <label>Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtPass"/><br/>
                <%if(request.getAttribute("msgPass") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgPass"));%>
                </span>
                <%}%>
                <br/>
                <label>Re-Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtRePass"/><br/>
                <%if(request.getAttribute("msgRePass") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgRePass"));%>
                </span>
                <%} else if(request.getAttribute("msgCheckPass") != null) {%>
                <span class="msg-error">
                    <%out.print(request.getAttribute("msgCheckPass"));%>
                </span>
                <%}%>
                <br/>
                <div></div>
                <input type="submit" value="SIGN UP" style="margin-bottom: 30px;"/>
            </form>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>

