<%
  HttpSession httpSession = request.getSession();
  String username=(String)httpSession.getAttribute("username");
  if(username==null)
  {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
    requestDispatcher.forward(request,response);
  }
%>
<jsp:useBean id='messageBean' scope='request' class='bean.MessageBean' />
<link rel='stylesheet' type='text/css' href='/customerRegistration/css/notification.css'>
<div class="container-720">
  <div class="heading" style="background: #5cb85c;display:flex; align-items: center;justify-content: space-between;margin-left:-20px;margin-right: -20px;box-shadow: 0 5px 10px -5px green;padding-left: 30px;padding-right:30px;">
    <h1 style="line-height: 50px;padding-left: 10px;color:white"><%messageBean.getMessage();%></h1>
  </div>
  <main style="padding: 10px;">

    <p>
      <a href="<%messageBean.getButtonAction();%>"  style="background: linear-gradient(45deg, #f046ff, #9b00e8 );text-decoration: none;color: white;font-weight: 700;padding: 20px;min-width: 220px;display: inline-block;text-align: center;border-radius: 8px;box-shadow: 0 5px 5px -3px rgba(247, 123, 0, 0.6588235294117647);font-size: 1.4em;">
        <%messageBean.getButtonText();%>
      </a>
    </p>
  </main>
</div>
