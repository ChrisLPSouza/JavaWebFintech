package br.com.webfintechfinal.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}