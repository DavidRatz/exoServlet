package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Magasin;
import service.GenericService;
import service.GenericServiceImpl;

@WebServlet("/magasin")
public class MagasinServlet extends HttpServlet {

    GenericService<Magasin> gs = (GenericService<Magasin>) GenericServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Magasin> listMagasin = gs.getAll();
        req.setAttribute("listMagasin", listMagasin);
        req.getRequestDispatcher("/jsp/magasin/magasins.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
