package br.com.webfintechfinal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public Connection conectar()  {

        try {
            return DriverManager.getConnection(ORACLE, "RM97465", "051082");
       } catch (SQLException e) {
           System.out.println("Erro ao conectar");

            throw new RuntimeException(e);
       }
    }
}
