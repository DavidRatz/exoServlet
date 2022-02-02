package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import exceptions.ProduitNotFoundException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Produit;
import model.ProduitForm;
import service.ProduitService;
import service.ProduitServiceImpl;

@WebServlet(name="ProduitUpdateServlet", value = "/produit/update")
public class ProduitUpdateServlet extends HttpServlet {
    private final ProduitService ps = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter  out = resp.getWriter();
        String path = "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        out.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>modification de produits</title>        </head>        <body><form action=\"" + path + "/produit/update\" method=\"post\">    <input type=\"number\" name=\"id\" id=\"\" placeholder=\"id\"><br>    <input type=\"text\" name=\"nom\" id=\"\" placeholder=\"nom\"><br> <input type=\"number\" name=\"prix\" id=\"\" placeholder=\"prix\"><br>    <button type=\"submit\" name=\"submit\" id=\"\">Submit</button><br></form>        </body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            double prix = Double.parseDouble(req.getParameter("prix"));
            
            if(nom == null || nom.isBlank()){
                resp.setStatus(400);
                out.print("nom non défini");
            }
            else{
                ProduitForm pForm = new ProduitForm(id, nom, prix);
                ps.update(id, pForm);
                resp.sendRedirect(req.getContextPath()+"/produit");
            }
        } catch(NumberFormatException ex){
            resp.setStatus(400);
            out.print("id ou prix invalide");
        }catch(ProduitNotFoundException ex){
            resp.setStatus(400);
            out.print(ex.getMessage());
        }
    }

}
