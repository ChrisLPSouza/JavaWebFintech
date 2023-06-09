package br.com.fintech.controller;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Investimento;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "InvestimentoServlet", value = "/investimento-servlet")
public class InvestimentoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
    public InvestimentoServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
//        InvestimentoDAO dao = new InvestimentoDAO();
//        List<Investimento> lista = dao.getAll();
//
//        request.setAttribute("listaInvestimentos", lista);
        request.getRequestDispatcher("invest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        String nome = request.getParameter("nome");
        String valor = request.getParameter("valor");
        float vlr = Float.parseFloat(valor);
        String data = request.getParameter("dataInicial");

        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date fmtDate = null;
        try{
            fmtDate = new java.sql.Date(fmt.parse(data).getTime());
        }catch (ParseException e){

        }

        java.util.Date date = new java.util.Date();
        Investimento investimento = new Investimento();
        investimento.setNome(nome);
        investimento.setVlInvestimento(vlr);
        investimento.setDtInicial(fmtDate);
        investimento.setDtResgate(new java.sql.Date(date.getTime()));
        investimento.setEmail(LoginFilter.usuario.getEmail());

        InvestimentoDAO dao = new InvestimentoDAO();

        int row = dao.insert(investimento);
        if (row > 0) {
            request.setAttribute("msg", "Investimento cadastrado!");
            List<Investimento> lista = dao.getAllById(LoginFilter.usuario.getEmail());
            request.setAttribute("listaInvestimentos", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar investimento!");
        }
        request.getRequestDispatcher("invest.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.print("DESTROY SERVLET INVESTIMENTO");
    }
}

