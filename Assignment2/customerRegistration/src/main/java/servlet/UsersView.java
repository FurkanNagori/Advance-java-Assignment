package servlet;
import dao.UserDAO;
import dto.UserDTO;
import dto.UserLoginDTO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;


public class UsersView extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {

        try
        {

            Map<UserLoginDTO, UserDTO> users =new UserDAO().getAll();

            PrintWriter pw = response.getWriter();
            response.setContentType("text/html");

            UserDTO userDTO;
            UserLoginDTO userLoginDTO;

            pw.println("<link rel='stylesheet' type='text/css' href='/customerRegistration/css/usersView.css'>");
            pw.println("<h2>User Details table</h2>");
            pw.println("<p>table with detail view</p>");
            pw.println("<table id=\"usertab\">");
            pw.println("<tr>");
            pw.println("<th>Name</th>");
            pw.println("<th>User login id</th>");
            pw.println("<th>Address</th>");
            pw.println("<th>City</th>");
            pw.println("<th>Phone</th>");
            pw.println("<th>Edit</th>");
            pw.println("<th>Delete</th>");
            pw.println("</tr>");
            for (Map.Entry<UserLoginDTO, UserDTO> entry : users.entrySet()) {
                userLoginDTO  = entry.getKey();
                userDTO = entry.getValue();
                pw.println("<tr>");
                pw.println("<td>"+userDTO.getFirstName()+"</td>");
                pw.println("<td>"+userLoginDTO.getUsername()+"</td>");
                pw.println("<td>"+userDTO.getAddress()+"</td>");
                pw.println("<td>"+userDTO.getCity()+"</td>");
                pw.println("<td>"+userDTO.getPhone()+"</td>");
                pw.println("<td>");
                pw.println("<div class=\"select\"\"><a href='/customerRegistration/EditUser?partyId="+userDTO.getPartyId()+"'>edit</a></div>");
                pw.println("</td>");
                pw.println("<td>");
                pw.println("<div class=\"select\"\"><a href='/customerRegistration/DeleteUser?partyId="+userDTO.getPartyId()+"'>Delete</a></div>");
                pw.println("</td>");
                pw.println("</tr>");

            }


        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }


    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        doGet(request,response);
    }
}