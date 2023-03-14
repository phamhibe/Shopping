<%@include file="template/header.jsp"%>
<div id="content">
    <div id="form">
        <h3 style="padding: 20px;"></h3>
        <div id="form-content">           
                <label>Your Password<span style="color: red;">*</span></label><br/>
                <input type="text" value="${passSession}"/><br/>
                <a href="<%=path%>/account/signin"><input type="submit" value="SIGN IN" style="margin-bottom: 30px;"/><br/></a> 
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>
