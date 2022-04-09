package servlet;

import dao.DAOException;
import dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUser extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession httpSession = request.getSession();
            String username=(String)httpSession.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                requestDispatcher.forward(request,response);
            }
            int partyId = Integer.parseInt(request.getParameter("partyId"));
            try {
                UserDAO userDAO = new UserDAO();
                boolean flag = userDAO.isSameUser(partyId,username);
                System.out.println(flag);
                if(flag){
                    throw new DAOException("can't delete yourself");
                     }
                else {
                    userDAO.delete(partyId);
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UsersView");
                try {
                    requestDispatcher.forward(request, response);
                } catch (Exception e) {
                }

            } catch (DAOException daoException) {
                System.out.println(daoException.getMessage());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UsersView");
                try {
                    requestDispatcher.forward(request, response);
                } catch (Exception e) {
                }
            }

        } catch (Exception exception) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
            }
        }
    }
}