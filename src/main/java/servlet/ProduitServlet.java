package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Produit;
import service.*;

@WebServlet(name="ProduitServlet", value = "/produit")
public class ProduitServlet extends HttpServlet {

    private final ProduitService ps = ProduitServiceImpl.getInstance();
    //GenericService<Produit> ps = (GenericService<Produit>) GenericServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String path = "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        // List<Produit> list = ps.getAll();
        // PrintWriter out = resp.getWriter();
        // out.println("<html><head></head><body><h1>Liste des produits</h1>");
        // list.forEach(produit -> {
        //     out.println("<li>");
        //     out.println(produit.getNom());
        //     out.println(" ");
        //     out.println(produit.getMarque());
        //     out.println(" ");
        //     out.println(produit.getPrix());
        //     out.println("$</li>");
        // });
        
        // out.println("</ul>");
        // out.println("<a href=\"" + path + "/produit/update\"><button>Update</button></a>");
        // out.println("</body></html>");
        List<Produit> list = ps.getAll();
        req.setAttribute("listeProduit",list);
        req.getRequestDispatcher("/jsp/produit/produits.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
