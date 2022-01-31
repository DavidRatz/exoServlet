package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Produit;
import service.ProduitService;
import service.ProduitServiceImpl;

@WebServlet(name="ProduitServlet", value = "/produit")
public class ProduitServlet extends HttpServlet {

    ProduitService ps = ProduitServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        List<Produit> list = ps.getAll();
        PrintWriter out = resp.getWriter();
        out.println("<html><head></head><body><h1>Liste des produits</h1>");
        list.forEach(produit -> {
            out.println("<li>");
            out.println(produit.getNom());
            out.println(" ");
            out.println(produit.getMarque());
            out.println(" ");
            out.println(produit.getPrix());
            out.println("$</li>");
        });
        
        out.println("</ul>");
        out.println("<a href=\"" + path + "/produit/update\"><button>Update</button></a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
