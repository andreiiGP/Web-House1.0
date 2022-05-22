/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.Validar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrei Bhip
 */
public class registrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nom= request.getParameter("nombre");
        String ape= request.getParameter("apellido");
        String corr= request.getParameter("correo");
        String tel= request.getParameter("telefono");
        String user= request.getParameter("usuarios");
        String pass= request.getParameter("contraseña");
        
        Validar va = new Validar();
        if (va.REGISTRARUSU(nom, ape, corr, tel, user, pass)){
            response.sendRedirect("loguin.jsp");
        }
        else{
        
        response.sendRedirect("Registro.jsp");
        }
    }

  

}
