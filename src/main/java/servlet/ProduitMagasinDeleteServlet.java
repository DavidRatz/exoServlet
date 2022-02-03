package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.*;
import service.*;

@WebServlet("/produitmagasin/delete")
public class ProduitMagasinDeleteServlet extends HttpServlet {
    //GenericService<Produit> gs = (GenericService<Produit>) GenericServiceImpl.getInstance();

    ProduitService service = ProduitServiceImpl.getInstance();
    MagasinService serviceMag = MagasinServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nomMagasin = req.getParameter("nom");
        List<Produit> listProduit = service.getAll();
        req.setAttribute("nomMagasin", nomMagasin);
        req.setAttribute("listProduit", listProduit);
        req.getRequestDispatcher("/jsp/produitmagasin/produitMagasinDelete.jsp").forward(req,resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {

            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nomMagasin");
            
            Produit produit = service.getOne(id);
            
            serviceMag.delete(nom,produit);
            
            resp.sendRedirect(req.getContextPath()+"/magasin");
        }catch (NumberFormatException ex){
                resp.setStatus(400);
                resp.sendRedirect(req.getContextPath()+"/produitmagasin/delete");
        }
    }

}
