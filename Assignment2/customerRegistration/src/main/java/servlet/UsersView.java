package servlet;

import dao.UserDAO;
import dto.UserDTO;
import dto.UserLoginDTO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;


public class UsersView extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {

            Map<UserLoginDTO, UserDTO> users = new UserDAO().getAll();

            PrintWriter pw = response.getWriter();
            response.setContentType("text/html");
            UserDTO userDTO;
            UserLoginDTO userLoginDTO;
            // Header starts here.
            pw.println("<link rel='stylesheet' type='text/css' href='/customerRegistration/css/headerFooter.css'>");
            pw.println("<!--");
            pw.println("templateType: global_partial");
            pw.println("label: Website header");
            pw.println("-->");
            pw.println("<header class=\"bg-primary-gradiant\">");
            pw.println("<div class=\"pt-10 pb-10 pl-0-lg pr-0-lg pl-10 pr-10 c-container m-auto \">");
            pw.println("<ul class=\"list-style-type-none flex justify-between align-items-center m-0\">");
            pw.println("<li class=\"head-nav-item w-10-lg w-50\">");
            pw.println("</li>");
            pw.println("<li class=\"head-nav-item-button hidden-lg show-md w-50 text-right\" id=\"navToggle\">");
            pw.println("<div class=\"glow-on-hover inline-block\">");
            pw.println("<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"30\" width=\"30\" class=\"text-white\" fill=\"#fff\" viewBox=\"0 0 24 24\" stroke=\"currentColor\" stroke-width=\"2\">");
            pw.println("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M4 6h16M4 12h8m-8 6h16\" />");
            pw.println("</svg>");
            pw.println("</div>");
            pw.println("</li>");
            pw.println("<li class=\"show hidden-md w-50-lg w-100\">");
            pw.println("<ul id=\"navLinkBox\" class=\"m-0 list-style-type-none flex-lg hidden justify-between align-items-center\">");
            pw.println("<li class=\"head-nav-item\">");
            pw.println("<a href=\"/Index.jsp\" class=\"text-decoration-none text-white \">HotWax</a>");
            pw.println("</li>");
            pw.println("<li class=\"head-nav-item\">");
            pw.println("<a href=\"/customerRegistration/Logout\"class=\"head-nav-item-button pt-10 pb-10 pl-15 pr-15 rounded-full inline-flex justify-center align-items-center shadow text-bold glow-on-hover position-relative mt-0-lg mt-15\">");
            pw.println("<span class=\"text-white\">Log out</span>");
            pw.println("<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"18\" width=\"18\" class=\"text-white\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\" stroke-width=\"2\">");
            pw.println("<path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M9 5l7 7-7 7\" />");
            pw.println("</svg>");
            pw.println("</a>");
            pw.println("</li>");
            pw.println("</ul>");
            pw.println("</li>");
            pw.println("</ul>");
            pw.println("</div>");
            pw.println("</header>");
            pw.println("<main>");
            // Table starts here.
            pw.println("<link rel='stylesheet' type='text/css' href='/customerRegistration/css/usersView.css'>");
            pw.println("<h2>User Details table</h2>");
            pw.println("<p>table with detail view</p>");
            pw.println("<table id=\"usertab\">");
            pw.println("<tr>");
            pw.println("<th>Name</th>");
            pw.println("<th>Username/email.id</th>");
            pw.println("<th>Address</th>");
            pw.println("<th>City</th>");
            pw.println("<th>Zip</th>");
            pw.println("<th>State</th>");
            pw.println("<th>Country</th>");
            pw.println("<th>Phone</th>");
            pw.println("<th>Edit</th>");
            pw.println("<th>Delete</th>");
            pw.println("</tr>");
            for (Map.Entry<UserLoginDTO, UserDTO> entry : users.entrySet()) {
                userLoginDTO = entry.getKey();
                userDTO = entry.getValue();
                pw.println("<tr>");
                pw.println("<td>" + userDTO.getFirstName() + "&nbsp;" + userDTO.getLastName() + " </td>");
                pw.println("<td>" + userLoginDTO.getUsername() + "</td>");
                pw.println("<td>" + userDTO.getAddress() + "</td>");
                pw.println("<td>" + userDTO.getCity() + "</td>");
                pw.println("<td>" + userDTO.getZip() + "</td>");
                pw.println("<td>" + userDTO.getState() + "</td>");
                pw.println("<td>" + userDTO.getCountry() + "</td>");
                pw.println("<td>" + userDTO.getPhone() + "</td>");
                pw.println("<td>");
                pw.println("<div class=\"select\"\"><a href='/customerRegistration/EditUser?partyId=" + userDTO.getPartyId() + "'>edit</a></div>");
                pw.println("</td>");
                pw.println("<td>");
                pw.println("<div class=\"select\"\"><a href='/customerRegistration/DeleteUser?partyId=" + userDTO.getPartyId() + "'>Delete</a></div>");
                pw.println("</td>");
                pw.println("</tr>");
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}