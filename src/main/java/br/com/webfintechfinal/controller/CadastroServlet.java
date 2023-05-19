package br.com.webfintechfinal.controller;

import br.com.webfintechfinal.dao.UsuarioDAO;
import br.com.webfintechfinal.model.Usuario;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CadastroServlet", value = "/cadastro-servlet")
public class CadastroServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTelefone("963256422");
        usuario.setPais("Brasil");
        usuario.setUserName(nome);


        UsuarioDAO dao = new UsuarioDAO();

        try {
            int row = dao.insert(usuario);
            if (row > 0) {
                request.setAttribute("msg", nome + ", Registrado com sucesso!");
            } else {
                request.setAttribute("err", "Erro ao cadastrar!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
