<jsp:useBean id='userBean' scope='request' class='bean.UserBean'/>
<jsp:setProperty name='userBean' property='*'/>
<jsp:forward page='/UpdateUser'/>
