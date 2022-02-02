package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Magasin;
import service.GenericService;
import service.GenericServiceImpl;

@WebServlet("/magasin/add")
public class MagasinAddServlet extends HttpServlet {
    GenericService<Magasin> gs = (GenericService<Magasin>) GenericServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/magasin/magasinAdd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String rue = req.getParameter("rue");
        String numero = req.getParameter("numero");
        String ville = req.getParameter("ville");
        int cp = Integer.parseInt(req.getParameter("codePostal"));
        float superficie = Float.parseFloat(req.getParameter("superficie"));
        
        Magasin magasin = new Magasin();

        if(id> 0 && !nom.isBlank()){
            magasin.setId(id);
            magasin.setNom(nom);
            magasin.setRue(rue);
            magasin.setNumero(numero);
            magasin.setVille(ville);
            magasin.setCodePostal(cp);
            magasin.setSuperficie(superficie);
            magasin.setProduitDisponibles(null);

            if(gs.insert(magasin, m -> m.getId()==id)){
                resp.sendRedirect(req.getContextPath() + "/magasin");
            }
            else{
                resp.setStatus(400);
                req.setAttribute("error", "Magasin déjà présent !");
                req.getRequestDispatcher("/jsp/magasin/magasinAdd.jsp").forward(req,resp);
            }
            
        }
        else{
            resp.setStatus(400);
            req.setAttribute("error", "Données invalides !");
            req.getRequestDispatcher(req.getContextPath() + "/jsp/magasin/magasinAdd.jsp").forward(req,resp);
        }
        
    }

}