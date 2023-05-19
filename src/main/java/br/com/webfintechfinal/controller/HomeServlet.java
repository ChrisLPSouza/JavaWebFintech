package br.com.webfintechfinal.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("msg", "Sucesso Dashboard");
        request.getRequestDispatcher("dash.jsp").forward(request, response);
    }

    public void destroy() {
        System.out.print("DESTROY - helloServlet");
    }
}