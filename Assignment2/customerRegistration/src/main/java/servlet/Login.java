package servlet;

import bean.ErrorBean;
import bean.UserLoginBean;
import dao.DAOException;
import dao.UserDAO;
import dto.UserLoginDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{

    public void doPost(HttpServletRequest request , HttpServletResponse response)
    {
        try
        {
            HttpSession httpSession = request.getSession();
            UserLoginBean userLoginBean = (UserLoginBean) request.getAttribute("userLoginBean");
            String username = userLoginBean.getUsername();
            String password = userLoginBean.getPassword();
            try
            {
                UserLoginDTO userLoginDTO = (new UserDAO()).getByUsername(username);
                String dbPassword = userLoginDTO.getPassword();
                if(dbPassword.equals(password))
                {

                    httpSession.setAttribute("username",username);
                    RequestDispatcher requestDispatcher;
                    requestDispatcher = request.getRequestDispatcher("/Index.jsp");
                    requestDispatcher.forward(request,response);
                }
                else
                {
                    throw new DAOException("Invalid username/password");
                }
            }catch(DAOException daoException)
            {
                System.out.println(daoException.getMessage());
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(daoException.getMessage());
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                request.setAttribute("errorBean",errorBean);
                requestDispatcher.forward(request,response);

            }


        }catch(Exception exception)
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (Exception e) {

            }
        }


    }
}