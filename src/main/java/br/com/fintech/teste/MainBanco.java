package br.com.fintech.teste;

import br.com.fintech.dao.BancoDAO;
import br.com.fintech.model.Banco;

import java.util.List;

public class MainBanco {

    public static void main(String[] args) {
        testaInsertBanco();
        testaGetAllBancos();
        testaDeleteBanco();
    }
    private static void testaInsertBanco() {

        Banco banco = new Banco();
        banco.setNome("Santander");

        BancoDAO dao = new BancoDAO();
        dao.insert(banco);

    }

    private static void testaGetAllBancos() {

        BancoDAO dao = new BancoDAO();
        List<Banco> bancos = dao.getAll();

        for (Banco banco : bancos) {
            System.out.println("Banco: " + banco.toString());
        }
    }


    private static void testaDeleteBanco() {

        BancoDAO dao = new BancoDAO();
        dao.delete(41);
        dao.delete(42);
    }
}