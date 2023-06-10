package br.com.fintech.teste;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Investimento;
import java.sql.Date;
import java.util.List;
import java.util.logging.Filter;

public class MainInvestimento {
    public static void main(String[] args) {

       testaGetAll();

    }

       private static void testaGetAll() {

        InvestimentoDAO dao = new InvestimentoDAO();
        List<Investimento> investimentos = dao.getAllById(LoginFilter.usuario.getEmail());

        for (Investimento investimento: investimentos){
            System.out.println("Investimento: " + investimento.toString());
        }


    }


}


