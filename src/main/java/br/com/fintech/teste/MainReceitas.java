package br.com.fintech.teste;

import br.com.fintech.dao.ReceitaDAO;
import br.com.fintech.model.Receita;

import java.sql.SQLException;
import java.util.List;

public class MainReceitas {

    public static void main(String[] args) {
        testaInsertReceita();
        testaGetAllReceitas();
        testaReceitaById();
       testaUpdateReceita();
       testaDeleteReceita();

    }
    private static void testaInsertReceita() {

        Receita receita = new Receita();
        receita.setDescricao("Pix");
        receita.setRecorrencia("S");
        receita.setValor(350);
        receita.setUserName("romeum");

        ReceitaDAO dao = new ReceitaDAO();
        try {
            dao.insert(receita);

        } catch (SQLException e) {

            System.out.println("Erro ao inserir os dados \n" + e.getMessage());
        }

    }

    private static void testaGetAllReceitas() {

        ReceitaDAO dao = new ReceitaDAO();
        List<Receita> receitas = dao.getAll();

        for (Receita receita : receitas) {
            System.out.println("Receita: " + receita.toString());
        }
    }

    private static void testaReceitaById() {

        ReceitaDAO dao = new ReceitaDAO();
        Receita receita = dao.selectById(4);

        System.out.println("Receita: " + receita.toString());

    }

    private static void testaUpdateReceita() {

        Receita receita = new Receita();
        receita.setDescricao("Empréstimo");

        ReceitaDAO dao = new ReceitaDAO();
        try {
            dao.update(receita);
            System.out.println("Receita alteradas com sucesso!");
        } catch (SQLException e) {

            System.out.println("Erro ao alterar os dados \n" + e.getMessage());
        }


    }

    private static void testaDeleteReceita() {

        ReceitaDAO dao = new ReceitaDAO();
        try {
            dao.delete(2);
            System.out.println("Receita deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar os dados \n" + e.getMessage());
        }
    }
}
