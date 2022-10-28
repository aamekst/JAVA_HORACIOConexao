package br.com.has.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.has.DAO.FuncionarioDAO;
import br.com.has.beans.Funcionario;
import br.com.has.conexao.ConexaoDAO;

public class DeleteSemWhere {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = ConexaoDAO.abrirConexao();
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO(con);
		
		
		System.out.println(funcionarioDao.deleteFuncionarioSemWhere());
		ConexaoDAO.fecharConexao(con);
		

	}

}
