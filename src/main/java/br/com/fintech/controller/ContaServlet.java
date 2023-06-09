package br.com.fintech.controller;

import br.com.fintech.dao.ContaDAO;
import br.com.fintech.dao.ObjetivoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Conta;
import br.com.fintech.model.Objetivo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContaServlet", value = "/conta-servlet")
public class ContaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
    public ContaServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        ContaDAO dao = new ContaDAO();
        List<Conta> lista = dao.getAll();

        request.setAttribute("listaContas", lista);
        request.getRequestDispatcher("conta.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        String nrConta = request.getParameter("numero");
        String agencia = request.getParameter("agencia");

        Conta conta = new Conta();
        conta.setNrConta(25003);
        conta.setAgencia(0123);
        conta.setNrBanco(336);
        conta.setEmail(LoginFilter.usuario.getEmail());

        ContaDAO dao = new ContaDAO();

        int row = dao.insert(conta);
        if (row > 0) {
            request.setAttribute("msg", "Conta cadastrada!");
            List<Conta> lista = dao.getAll();
            request.setAttribute("listaContas", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar conta!");
        }
        request.getRequestDispatcher("conta.jsp").forward(request, response);
    }

}