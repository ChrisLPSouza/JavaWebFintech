package br.com.fintech.dao;

import br.com.fintech.model.Receita;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    private Connection connection;

    public ReceitaDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Receita receita) throws SQLException {
        String sql = "insert into T_FIN_RECEITAS (cd_recebimento, ds_recebimento, st_recorrencia, vl_recebimento, T_FIN_USUARIO_DS_EMAIL)" +
                "values (SQ_RECEITAS.NEXTVAL, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, receita.getDescricao());
            stmt.setString(2, receita.getRecorrencia());
            stmt.setFloat(3, receita.getValor());
            stmt.setString(4, receita.getUserName());

            stmt.execute();
            stmt.close();
            System.out.println("Receita inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: "+ e.getMessage());

        }

    }

    public List<Receita> getAll() {
        List<Receita> receitas = new ArrayList<Receita>();
        String sql = "select * from T_FIN_RECEITAS";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Receita receita = new Receita();
                receita.setCodigo(rs.getInt("cd_recebimento"));
                receita.setDescricao(rs.getString("ds_recebimento"));
                receita.setRecorrencia(rs.getString("st_recorrencia"));
                receita.setValor(rs.getFloat("vl_recebimento"));
              //  receita.setUsuario(rs.getString("nm_username"));

                receitas.add(receita);
            }
            rs.close();
            stmt.close();
            return receitas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Receita selectById(int codigo) {
        Receita receita = null;
        String sql = "select * from T_FIN_RECEITAS where cd_recebimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                receita = new Receita();
                receita.setCodigo(rs.getInt("cd_recebimento"));
                receita.setDescricao(rs.getString("ds_recebimento"));
                receita.setRecorrencia(rs.getString("st_recorrencia"));
                receita.setValor(rs.getFloat("vl_recebimento"));
                receita.setUserName(rs.getString("t_fin_usuario_nm_username"));
            }

            rs.close();
            stmt.close();
            return receita;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int codigo) throws SQLException {
        String sql = "delete from T_FIN_RECEITAS where cd_recebimento=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
    }
    public void update(Receita receita) throws SQLException {
        String sql = "update T_FIN_RECEITAS set ds_recebimento=?, st_recorrencia=?, vl_recebimento=? where cd_recebimento=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, receita.getDescricao());
        stmt.setString(2, receita.getRecorrencia());
        stmt.setFloat(3, receita.getValor());
        stmt.setInt(4, receita.getCodigo());

        stmt.execute();
        stmt.close();

    }
 }

