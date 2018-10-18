package br.com.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.model.AssistidoVO;

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
			//INSERT INTO `dia_assistido`(`idAssistido`, `diaVisita`) VALUES ([value-1],[value-2])
			stmt.executeUpdate("insert into dia_assistido (`idAssistido`, `diaVisita`) values (" + vo.getId() + ", " + vo.getDataVisita() + ")");
			System.out.println("Assistido " + vo.getNome() + " excluido");
			stmt.close();
			conexao.con.close();
			System.out.println("Fechada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema:\n" + e, "ATENCAO",	JOptionPane.WARNING_MESSAGE);
		}
	}

}
