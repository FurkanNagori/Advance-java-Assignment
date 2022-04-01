<jsp:useBean id='userBean' scope='request' class='bean.UserBean'/>
<jsp:useBean id='userLoginBean' scope='request' class='bean.UserLoginBean'/>
<jsp:setProperty name='userBean' property='*'/>
<jsp:setProperty name='userLoginBean' property='*'/>
<jsp:forward page='/Registration'/>
