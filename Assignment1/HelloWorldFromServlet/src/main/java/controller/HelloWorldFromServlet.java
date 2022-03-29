package controller;

import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldFromServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/plain");
            pw.println("Hello World from servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
