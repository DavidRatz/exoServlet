package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Produit;
import service.*;

@WebServlet("/produitmagasin/add")
public class ProduitMagasinAddServlet extends HttpServlet {
    GenericService<Produit> gs = (GenericService<Produit>) GenericServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nomMagasin", req.getParameter("nom"));
        req.getRequestDispatcher("/jsp/produitmagasin/produitMagasinAdd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
