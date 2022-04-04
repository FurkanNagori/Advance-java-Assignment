package servlet;

import bean.ErrorBean;
import bean.UserBean;
import dao.DAOException;
import dao.UserDAO;
import dto.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUser extends HttpServlet
{
    public void doPost(HttpServletRequest request , HttpServletResponse response)
    {
        try
        {
            HttpSession httpSession = request.getSession();
            String username=(String)httpSession.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginPage.jsp");
                requestDispatcher.forward(request,response);
            }
            UserBean userBean = (UserBean) request.getAttribute("userBean");
            try
            {

                UserDAO userDAO = new UserDAO();
                UserDTO userDTO = new UserDTO();
                userDTO.setPartyId(userBean.getPartyId());
                userDTO.setFirstName(userBean.getFirstName());
                userDTO.setLastName(userBean.getLastName());
                userDTO.setAddress(userBean.getAddress());
                userDTO.setCity(userBean.getCity());
                userDTO.setZip(userBean.getZip());
                userDTO.setState(userBean.getState());
                userDTO.setCountry(userBean.getCountry());
                userDTO.setPhone(userBean.getPhone());
                userDAO.update(userDTO);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UsersView");
                requestDispatcher.forward(request,response);

            }catch(DAOException daoException)
            {
                System.out.println(daoException.getMessage());
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean",errorBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditUser.jsp");
                requestDispatcher.forward(request,response);
            }


        }catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try{
                requestDispatcher.forward(request,response);
            }catch(Exception e)
            {

            }
        }


    }

}