package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name="HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        // Scanner sc = new Scanner(System.in);
        // PrintWriter out = resp.getWriter();
        // out.println(sc.nextLine() + " " + sc.nextLine());
        // out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
