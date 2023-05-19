package br.com.webfintechfinal.teste;

import br.com.webfintechfinal.dao.UsuarioDAO;
import br.com.webfintechfinal.model.Usuario;

import java.sql.SQLException;

public class MainUsuario {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setNome("katia ivanova");
        usuario.setEmail("katia@mail.com");
        usuario.setSenha("1234");
        usuario.setTelefone("963256422");
        usuario.setPais("Brasil");
        usuario.setUserName("kativa");

        UsuarioDAO dao = new UsuarioDAO();

        try {
            int row = dao.insert(usuario);
            if(row > 0) {
                System.out.println("INSERIDO COM SUCESSO");
            }
            else {
                System.err.println("ERRO NO INSERT USUARIO");
            }
        } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
