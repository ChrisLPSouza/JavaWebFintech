package br.com.fintech.controller;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.print("LOGIN SERVLET INIT");
    }

    public LoginServlet() {
        System.out.print("LOGIN SERVLET INSTANCIADO");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("LOGIN SERVLET DO_GET");
       verificar(request, response);
    }
    private void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            request.getRequestDispatcher("login-jsp").forward(request, response);

        } else {
            if (action.equals("auth")) {
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                if (email != null && !email.isEmpty() && senha!= null && !senha.isEmpty()){
                    UsuarioDAO dao = new UsuarioDAO();
                    Usuario usuario = dao.selectById(email);

                    if (usuario != null) {
                        HttpSession session = request.getSession();
                        if (session !=null) {
                            session.setAttribute("usuario", usuario);
                            request.getRequestDispatcher("home.jsp").forward(request, response);
                        }
                    }
                }else {
                    request.setAttribute("err", "E-mail ou Senha inválidos!" );
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("LOGIN SERVLET DO_POST");
        verificar(request, response);
    }
}
