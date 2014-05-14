
package Servlets;

//import Classes.Acceso_A_Datos;
//import Classes.Acceso_Productos;
import Classes.Acceso_A_Datos;
import Classes.Acceso_Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Desplegar_Material extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       // response.setContentType("text/html;charset=UFT-8");
        PrintWriter out = response.getWriter();
       // ResultSet rs;
       // Acceso_A_Datos add = new Acceso_A_Datos();
       // add.Conectar();
       // Acceso_Productos ap = new Acceso_Productos();
       // rs = ap.RescatarDatos();
     /*   out.println("<html>");
            out.println("<head>");
                out.println("<title>asdasdadsasad</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("COÑOOOOOOOOOOOOOOOOOOO");
            out.println("</body>");
        out.println("</html>");
        */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
      
        try{
            
        processRequest(request, response);
        response.setContentType("text/html;charset=UFT-8");
        PrintWriter out = response.getWriter();
        
        ResultSet rs; //Resultado consulta
        
        Acceso_A_Datos add = new Acceso_A_Datos();
        add.Conectar();
        
        Acceso_Productos ap = new Acceso_Productos();
        
        String tit, banda;
        
        banda = request.getParameter("Nombre_Banda");
        
        if(banda.isEmpty()) rs = ap.RescatarDatos();
        else rs = ap.RescatarDatos_filtro(banda);
        
        
        
      //  banda = request.getParameter("Nombre_Banda");
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ruined Pig</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1' align='center'>");
            
            out.println("<tr>");
            out.println("<td>");
            out.println("<strong>Título<strong>");
            out.println("</td>");
            out.println("<td>");
            out.println("<strong>Nombre Banda<strong>");
            out.println("</td>");
            out.println("<td>");
            out.println("<strong>Precio<strong>");
            out.println("</td>");
            out.println("<td>");
            out.println("<strong>Cantidad<strong>");
            out.println("</td>");
            out.println("<td>");
            out.println("<strong>Tipo Producto<strong>");
            out.println("</td>");
            out.println("</tr>");
            
              
                while(rs.next()){
            out.println("<tr>");
                out.println("<td>");
                tit = rs.getString("TITULO");
                out.println(" "+tit+" ");
                out.println("</td>");
                out.println("<td>");
                tit = rs.getString("NOMBRE_BANDA");
                out.println(" "+tit+" ");
                out.println("</td>");
                out.println("<td>");
                tit = rs.getString("PRECIO");
                out.println(" "+tit+" ");
                out.println("</td>");
                out.println("<td>");
                tit = rs.getString("CANTIDAD");
                out.println(" "+tit+" ");
                out.println("</td>");
                out.println("<td>");
                tit = rs.getString("TIPO_PRODUCTO");
                out.println(" "+tit+" ");
                out.println("</td>");
            out.println("</tr>");   
                }
            
            out.println("</table>");
            
            
            out.println("</body>");

        }
        catch(Exception ex){
        System.out.println(ex);
        }
        
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
