package br.com.fintech.controller.servlet;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

//    @Override
//    public void init() {
//        System.out.println("LOGIN SERVLET INIT");
//    }

    public LoginServlet() {
        super();
        System.out.println("LOGIN SERVLET INSTANCIADO");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LOGIN SERVLET DO_GET");
        verificar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LOGIN SERVLET DO_POST");
        verificar(request, response);
    }

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            if (action.equals("auth")) {
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                if (email != null && !email.isEmpty() && senha!= null && !senha.isEmpty()){
                    UsuarioDAO dao = new UsuarioDAO();
                    Usuario usuario = dao.selectById(email);

                    if (usuario != null && usuario.getSenha().equals(senha)) {
                        HttpSession session = request.getSession();
                        if (session !=null) {
                            session.setAttribute("usuario", usuario);
                            request.getRequestDispatcher("home.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("err", "E-mail ou Senha inválidos!" );
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                    }
                }else {
                    request.setAttribute("err", "Verificar E-mail e senha" );
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
