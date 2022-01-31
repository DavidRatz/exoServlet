package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/addition/solve")
public class AdditionSolveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int m1= Integer.parseInt(req.getParameter("m1"));
        int m2= Integer.parseInt(req.getParameter("m2"));
        String saveIn = req.getParameter("save-in");

        switch(saveIn){
            case "session":
                req.getSession().setAttribute("rslt",m1+m2);
                break;
            case "request":
                req.setAttribute("rslt",m1+m2);
                break;
            default:
                resp.sendError(400);
        }

        req.getRequestDispatcher("/jsp/attribute/rslt.jsp").forward(req,resp);
        //resp.sendRedirect(req.getContextPath() + "/jsp/attribute/rslt.jsp");
    }

}
