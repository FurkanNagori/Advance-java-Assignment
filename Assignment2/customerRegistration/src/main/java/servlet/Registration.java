package servlet;

import bean.ErrorBean;
import bean.MessageBean;
import bean.UserBean;
import bean.UserLoginBean;
import dao.DAOException;
import dao.UserDAO;
import dto.UserDTO;
import dto.UserLoginDTO;
//import helper.sendEmail;

import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //      sendEmail send  = new sendEmail();
        try {
            HttpSession httpSession = request.getSession();
            String userName = (String) httpSession.getAttribute("username");
            if (userName == null) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                requestDispatcher.forward(request, response);
            }
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
                // System.out.print(send.sendEmail(userLoginDTO));
                MessageBean messageBean = new MessageBean();
                messageBean.setMessage("Registration successfull");
                messageBean.setButtonText("Login now");
                messageBean.setButtonAction("/LoginPage.jsp");
                request.setAttribute("messageBean",messageBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request,response);


            } catch (DAOException daoException) {
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean", errorBean);
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
