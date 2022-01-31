package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import model.Personne;
import service.PersonneServiceImpl;

@WebServlet(name="PersonneServlet", value = "/personne")
public class PersonneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Personne> lPersonnes = new PersonneServiceImpl().getAll();
        Scanner sc = new Scanner(System.in);
        PrintWriter out = resp.getWriter();
        //out.println(sc.nextLine() + " " + sc.nextLine());
        out.println(Arrays.asList(lPersonnes));
        out.println("test");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
