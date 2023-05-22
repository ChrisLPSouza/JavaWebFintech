package br.com.fintech.dao;

import br.com.fintech.model.Objetivo;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoDAO {
	
	private Connection connection;

    public ObjetivoDAO() {
    
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }
    
    public void insert (Objetivo objetivo)  throws SQLException {
        String sql = "insert into T_FIN_OBJETIVO (cd_objetivo, nm_objetivo, vl_meta, dt_objetivo)" +
                "values (?, ?, ?, ?)" ;
        
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, objetivo.getCodigo());
            stmt.setString(2, objetivo.getDescricao());
            stmt.setDouble(3, objetivo.getValor());
            Date dataObjetivo = new Date(new java.util.Date().getTime());
            stmt.setDate(4, dataObjetivo);
           

            stmt.execute();
        } catch (SQLException e) {
            stmt.close();
        }
    }
    
    public List<Objetivo> getAll(){
    	
    	List<Objetivo> objetivos = new ArrayList<Objetivo>();
    	
    	 String sql = "select * from T_FIN_OBJETIVO order by CD_OBJETIVO";
         try {
             Statement stmt = connection.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {
                 Objetivo objetivo = new Objetivo();
                 objetivo.setCodigo(rs.getInt("cd_objetivo"));
                 objetivo.setDescricao(rs.getString("nm_objetivo"));
                 objetivo.setValor(rs.getDouble("vl_meta"));
                 
                 objetivo.setData(rs.getDate("dt_objetivo"));
                 

                 objetivos.add(objetivo);
             }
             rs.close();
             stmt.close();
             return objetivos;

         } catch (SQLException e) {
             System.out.println("Erro: " + e.getMessage());
             return null;
         }
	
}
    
    public Objetivo selectById(int codigo) {
    	
    	Objetivo objetivo = null;
        String sql = "select * from T_FIN_OBJETIVO where cd_objetivo=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	objetivo = new Objetivo();
                objetivo.setCodigo(rs.getInt("cd_objetivo"));
                objetivo.setDescricao(rs.getString("nm_objetivo"));
                objetivo.setValor(rs.getDouble("vl_meta"));
                objetivo.setData(rs.getDate("dt_objetivo"));
            }

            rs.close();
            stmt.close();
            return objetivo;
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    	
    
    public void delete(int codigo) throws SQLException {
        String sql = "delete from T_FIN_OBJETIVO where cd_objetivo=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close(); 
    	
    }
    
    public void update(Objetivo objetivo) throws SQLException {
            String sql = "update T_FIN_OBJETIVO set nm_objetivo=?, vl_meta=?, dt_objetivo=? where cd_objetivo=?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, objetivo.getDescricao());
            stmt.setDouble(2, objetivo.getValor());
            Date dataObjetivo = new Date(new java.util.Date().getTime());
            stmt.setDate(3, dataObjetivo);
            stmt.setInt(4, objetivo.getCodigo());

            stmt.execute();
            stmt.close();

    }
}
