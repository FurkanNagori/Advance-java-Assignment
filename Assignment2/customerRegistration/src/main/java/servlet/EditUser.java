package servlet;

import bean.UserBean;
import dao.DAOException;
import dao.UserDAO;
import dto.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditUser extends HttpServlet {
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
            UserDAO userDAO = new UserDAO();
            UserDTO userDTO;
            userDTO = userDAO.getByPartyId(partyId);

            UserBean userBean = new UserBean();
            userBean.setPartyId(userDTO.getPartyId());
            userBean.setFirstName(userDTO.getFirstName());
            userBean.setLastName(userDTO.getLastName());
            userBean.setAddress(userDTO.getAddress());
            userBean.setCity(userDTO.getCity());
            userBean.setZip(userDTO.getZip());
            userBean.setState(userDTO.getState());
            userBean.setCountry(userDTO.getCountry());
            userBean.setPhone(userDTO.getPhone());
            request.setAttribute("userBean", userBean);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditUser.jsp");
            requestDispatcher.forward(request, response);

        } catch (DAOException daoException) {
            System.out.println(daoException.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
            }
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
