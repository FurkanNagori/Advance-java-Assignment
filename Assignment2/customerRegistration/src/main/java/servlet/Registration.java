package servlet;

import bean.ErrorBean;
import bean.UserBean;
import bean.UserLoginBean;
import dao.DAOException;
import dao.UserDAO;
import dto.UserDTO;
import dto.UserLoginDTO;

import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            /*HttpSession httpSession = request.getSession();
            String username=(String)httpSession.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginPage.jsp");
                requestDispatcher.forward(request,response);
            }
             */
            UserBean userBean = (UserBean) request.getAttribute("userBean");
            String firstName = userBean.getFirstName();
            String lastName = userBean.getLastName();
            String address = userBean.getAddress();
            String city = userBean.getCity();
            int zip = userBean.getZip();
            String state = userBean.getState();
            String country = userBean.getCountry();
            String phone = userBean.getPhone();
            UserLoginBean userLoginBean = (UserLoginBean) request.getAttribute("userLoginBean");
            String username = userLoginBean.getUsername();
            String password = userLoginBean.getPassword();
            try {

                UserDTO userDTO = new UserDTO();
                userDTO.setFirstName(firstName);
                userDTO.setLastName(lastName);
                userDTO.setAddress(address);
                userDTO.setCity(city);
                userDTO.setZip(zip);
                userDTO.setState(state);
                userDTO.setCountry(country);
                userDTO.setPhone(phone);
                UserLoginDTO userLoginDTO = new UserLoginDTO();
                userLoginDTO.setUsername(username);
                userLoginDTO.setPassword(password);
                UserDAO userDAO = new UserDAO();
                userDAO.add(userDTO, userLoginDTO);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Index.jsp");
                requestDispatcher.forward(request, response);

            } catch (DAOException daoException) {
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean",errorBean);
                errorBean.setError(daoException.getMessage());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RegistrationForm.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (Exception e) {

                }

            }


        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (Exception e) {

            }
        }


    }

}
