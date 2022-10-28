package br.com.has.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.has.beans.Funcionario;

public class FuncionarioDAO {

	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public FuncionarioDAO (Connection con)
	{
		setCon(con);
	}
	
	//inserir
	
	public String inserirFuncionario(Funcionario funcionario) 
	{
		String sql = "insert into funcionario(nome, idade, salario) values (?,?,?)";
		
		try {
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getIdade());
			ps.setDouble(3, funcionario.getSalario());
			if(ps.executeUpdate()>0) {
				return "Inserido com sucesso!";
			}else {
				return "Erro ao inserir";
			}
			
			
		}catch (SQLException e)
		{
			return e.getMessage();
		}
	
		
	}
	
	//deletar sem where
	public String deleteFuncionarioSemWhere() 
	{
		String sql = "delete from funcionario";
		
		try {
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			if(ps.executeUpdate()>0) {
				return "Deletado";
			}else {
				return "Erro ao deletar";
			}
			
			
		}catch (SQLException e)
		{
			return e.getMessage();
		}
		
	}
	
	//delete com where
	public String deleteFuncionarioWhere(Funcionario funcionario) 
	{
		String sql = "delete from funcionario where salario = (?)";
		
		try {
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, funcionario.getSalario());
			if(ps.executeUpdate()>0) {
				return "Deletado com sucesso!";
			}else {
				return "Erro ao deletar";
			}
			
			
		}catch (SQLException e)
		{
			return e.getMessage();
		}
	
		
	}
	
	//update com where
		public String updateFuncionarioWhere(Funcionario funcionario) 
		{
			String sql = "update funcionario set salario = (?) where idade =(?)";
			
			try {
				
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setDouble(1, funcionario.getSalario());
				ps.setInt(2, funcionario.getIdade());

				if(ps.executeUpdate()>0) {
					return "Alterado com sucesso!";
				}else {
					return "Erro ao deletar";
				}
				
				
			}catch (SQLException e)
			{
				return e.getMessage();
			}
		
			
		}
	
		//update sem where
				public String updateFuncionarioSemWhere(Funcionario funcionario) 
				{
					String sql = "update funcionario set salario = (?)";
					
					try {
						
						PreparedStatement ps = getCon().prepareStatement(sql);
						ps.setDouble(1, funcionario.getSalario());

						if(ps.executeUpdate()>0) {
							return "Alterado";
						}else {
							return "Erro ao deletar";
						}
						
						
					}catch (SQLException e)
					{
						return e.getMessage();
					}
				
					
				}
	
	
	
	
}
