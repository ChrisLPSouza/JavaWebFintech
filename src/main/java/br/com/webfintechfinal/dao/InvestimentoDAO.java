package br.com.webfintechfinal.dao;

import br.com.webfintechfinal.connection.ConnectionFactory;
import br.com.webfintechfinal.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {

    private Connection connection;

    public InvestimentoDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }
    public void insert(Investimento investimento)  {
        String sql = "insert into T_FIN_INVESTIMENTO (cd_investimento, vl_investimento, dt_inicial, dt_resgate, T_FIN_USUARIO_NM_USERNAME)" +
                "values (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setFloat(1, investimento.getVlInvestimento());
            stmt.setDate(2, investimento.getDtInicial());
            stmt.setDate(3, investimento.getDtResgate());
            stmt.setString(4, investimento.getNmUserName());

            stmt.execute();
            stmt.close();
            System.out.println("Investimento inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " +e.getMessage());

        }

    }

    public List<Investimento> getAll() {

        List<Investimento> investimentos = new ArrayList<Investimento>();
        String sql = "select * from T_FIN_INVESTIMENTO order by CD_INVESTIMENTO ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Investimento investimento = new Investimento();
                investimento.setCdInvestimento(rs.getInt("cd_investimento"));
                investimento.setVlInvestimento(rs.getFloat("vl_investimento"));
                investimento.setDtInicial(rs.getDate("dt_inicial"));
                investimento.setDtResgate(rs.getDate("dt_resgate"));
                investimento.setNmUserName(rs.getString("t_fin_usuario_nm_username"));

                investimentos.add(investimento);
            }
            rs.close();
            stmt.close();
            return investimentos;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Investimento selectById(int id) {
        Investimento investimento = null;
        String sql = "select * from T_FIN_INVESTIMENTO where cd_investimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                investimento = new Investimento();
                investimento.setCdInvestimento(rs.getInt("cd_investimento"));
                investimento.setVlInvestimento(rs.getFloat("vl_investimento"));
                investimento.setDtInicial(rs.getDate("dt_inicial"));
                investimento.setDtResgate(rs.getDate("dt_resgate"));
                investimento.setNmUserName(rs.getString("t_fin_usuario_nm_username"));

            }

            rs.close();
            stmt.close();
            return investimento;
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int id) {
        String sql = "delete from T_FIN_INVESTIMENTO where cd_investimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado com sucesso!");
        }catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }

    }
    public void update(Investimento investimento) {
        String sql = "update T_FIN_INVESTIMENTO set vl_investimento=?, dt_inicial=?, dt_resgate=?, T_FIN_USUARIO_NM_USERNAME=? where cd_investimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setFloat(1, investimento.getVlInvestimento());
            stmt.setDate(2, investimento.getDtInicial());
            stmt.setDate(3, investimento.getDtResgate());
            stmt.setString(4, investimento.getNmUserName());
            stmt.setInt(5, investimento.getCdInvestimento());

            stmt.execute();
            stmt.close();
            System.out.println("Atualizado com sucesso!");
        }catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }



    }

}