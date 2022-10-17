package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VeriServlet", urlPatterns = {"/VeriServlet"})
public class VeriServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        
        //Obtener arreglo de cliente
        Cookie[] cukis = request.getCookies();
        
        if (cukis !=null){
            for(Cookie c : cukis){
                if (c.getName().equals("visitas")){
                    //Antes de la asignacion se convierte un valor en cadena
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        contador++;
        
        //Antes de la asignacion se convierte cadena en valor
        Cookie c = new Cookie("visitas",Integer.toString(contador));
        
        c.setMaxAge(180);
        response.addCookie(c);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (contador<=1){
            out.println("<h1 align='center'>Bienvenido a nuestro sitio Web</h1>");
        } else {
            out.println("<h1 align='center'>Gracias por visitarnos nuevamente</h1>");
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
