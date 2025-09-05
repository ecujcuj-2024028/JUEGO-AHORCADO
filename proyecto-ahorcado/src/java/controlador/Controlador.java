
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Palabra;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {  
    ControladorPalabra pala = new ControladorPalabra();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("entor a controlador");
        
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if ("principal".equals(menu)) {
            List<Palabra> lista = pala.listarPalabras();
            request.setAttribute("palabrasDB", lista);
            System.out.println(lista);
            request.getRequestDispatcher("/ahorcado.jsp").forward(request, response);
        } else if ("ahorcado".equals(menu)) {
            List<Palabra> lista = pala.listarPalabras();
            request.setAttribute("palabrasDB", lista);
            System.out.println(lista);
            request.getRequestDispatcher("/ahorcado.jsp").forward(request, response);
            return;
        } else if("log".equals(menu)){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
