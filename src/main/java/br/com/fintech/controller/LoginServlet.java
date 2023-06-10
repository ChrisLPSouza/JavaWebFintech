package br.com.fintech.controller;

import br.com.fintech.dao.BancoDAO;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Banco;
import br.com.fintech.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        verificar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

                            // Cria um banco aleatorio, sempre após o login
                            int idBanco = new Random().nextInt(9999);
                            Banco banco = new Banco();
                            banco.setNome("Banco " + idBanco);
                            BancoDAO bancoDAO = new BancoDAO();
                            bancoDAO.insert(banco);
                            //

                            LoginFilter.usuario = usuario;
                            session.setAttribute("usuario", usuario);
                            request.setAttribute("msg", "Usuario Autenticado!");
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
