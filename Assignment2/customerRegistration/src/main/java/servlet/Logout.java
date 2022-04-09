package servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            HttpSession httpSession = request.getSession();
            httpSession.removeAttribute("username");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception exception) {
        }
    }
}