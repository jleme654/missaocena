package br.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.model.AssistidoVO;
import br.com.util.MissaoCenaUtil;

/**
 *
 * @since 18/10/2018
 * @author jleme
 */
public class AssistidoDAO {

	private static ClassConecta conexao = new ClassConecta();

	public static void excluiAssistido(AssistidoVO vo) {
		try {
			conexao.conecta();
			Statement stmt = conexao.con.createStatement();
			stmt.executeUpdate("delete from assistido where id = " + vo.getId());
			System.out.println("Assistido " + vo.getNome() + " excluido");
			stmt.close();
			conexao.con.close();
			System.out.println("Fechada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema:\n" + e, "ATENCAO",	JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void incluirAssistido(AssistidoVO vo) {
		try {
			conexao.conecta();
			Statement stmt = conexao.con.createStatement();
			stmt.executeUpdate("insert into dia_assistido (`idAssistido`, `diaVisita`, `dataVisita`) "
					+ "values (" + vo.getId() + ", '" + vo.getDataVisita() + "', '" + MissaoCenaUtil.getDataHojeString() +"')");
			System.out.println("Assistido " + vo.getNome() + " incluido");
			stmt.close();
			conexao.con.close();
			System.out.println("Fechada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema:\n" + e, "ATENCAO",	JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static boolean cadastrarAssistido(AssistidoVO vo) {
		try {
			conexao.conecta();
			Statement stmt = conexao.con.createStatement();
			int id = getCountAssistidos();
			vo.setId(id );
			stmt.executeUpdate("insert into assistido (`id`, `nome`, `dataVisita`, `rg`, `cpf`) values (" + vo.getId() + ", '" + vo.getNome() + "', '" + MissaoCenaUtil.getDataHojeString() +"', '" + vo.getRg() + "', '" + vo.getCpf() + "')");
			System.out.println("Assistido " + vo.getNome() + " cadastrado");
			stmt.close();
			conexao.con.close();
			System.out.println("Conexao Fechada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema:\n" + e, "ATENCAO",	JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static int getCountAssistidos() {
		int count = 0;
		try {
			conexao.conecta();
			Statement stmt = conexao.con.createStatement();
	        ResultSet rs = stmt.executeQuery("Select * from assistido");
	        while (rs.next()) {
	        	count++;
	        }
			stmt.close();
			conexao.con.close();
			System.out.println("Conexao Fechada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema:\n" + e, "ATENCAO",	JOptionPane.WARNING_MESSAGE);
		}
		count++;
		return count;
	}

}
