package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name="RequestServlet", value = "/request")
public class RequestServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PrintWriter out = resp.getWriter();
        // out.println("Hello World 5 !  ");
        // out.close();

        PrintWriter out = resp.getWriter();

        String method = req.getMethod();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String serverPath = req.getServletPath();

        Map<String,String> headers = new HashMap<>();
        Enumeration<String> headerName = req.getHeaderNames();
        while (headerName.hasMoreElements()) {
            String header = headerName.nextElement();
            headers.put(header, req.getHeader(header));
        }

      String body = req.getReader().lines().reduce("",(acc,line) -> acc+line);
        out.println("OKOKOKOK");
        out.println(method);
        out.println(" ");
        out.println(uri);
        out.println(" ");
        out.println(protocol);
        out.println(" ");
        out.println(serverName);
        out.println(" ");
        out.println(serverPort);
        out.println(" ");
        out.println(serverPath);

      headers.forEach((key,value)->out.println(key+" " +value));

   out.println(" ");

       out.println(body);
   }


    
}