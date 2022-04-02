<jsp:useBean id='userLoginBean' scope='request' class='bean.UserLoginBean'/>
<jsp:setProperty name='userLoginBean' property='*'/>
<jsp:forward page='/Login'/>