package br.com.webfintechfinal.dao;

import br.com.webfintechfinal.model.Receita;

import java.sql.SQLException;
import java.util.List;

public interface IReceitaDAO {

	public void insert(Receita receita) throws SQLException;    

    public List<Receita> getAll() throws SQLException;
    
    public Receita selectById(int codigo) throws SQLException;
    
    public void delete(int codigo) throws SQLException;
    
    public void update(Receita receita) throws SQLException;

}
