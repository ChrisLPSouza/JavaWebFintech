package br.com.fintech.controller;

import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Despesa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DespesaServlet", value = "/despesa-servlet")
public class DespesaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public DespesaServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastra-despesa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nome =  request.getParameter("nome");
       String valor = request.getParameter("valor");
       float vlr = Float.parseFloat(valor);

       Despesa despesa = new Despesa();
       despesa.setNome(nome);
       despesa.setValor(vlr);
       despesa.setEmail(LoginFilter.usuario.getEmail());

        DespesaDAO dao = new DespesaDAO();

        int row = dao.insert(despesa);
        if (row > 0) {
            request.setAttribute("msg", "Despesa cadastrada!");
        } else {
            request.setAttribute("err", "Erro ao cadastrar despesa!");
        }
        request.getRequestDispatcher("cadastra-despesa.jsp").forward(request, response);
    }
}
