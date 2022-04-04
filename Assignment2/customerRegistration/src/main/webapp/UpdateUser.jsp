<%
HttpSession httpSession = request.getSession();
            String username=(String)httpSession.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                requestDispatcher.forward(request,response);
            }
%>
<jsp:useBean id='userBean' scope='request' class='bean.UserBean'/>
<jsp:setProperty name='userBean' property='*'/>
<jsp:forward page='/UpdateUser'/>
