package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Magasin;
import service.GenericService;
import service.MagasinServiceImpl;

@WebServlet("/magasin")
public class MagasinServlet extends HttpServlet {

    GenericService<Magasin> ps = MagasinServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
