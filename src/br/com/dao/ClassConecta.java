package br.com.dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
*
* @since 18/10/2018
* @author jleme
*/
public class ClassConecta {

    /**
     * Creates a new instance of ClassConecta
     */
    public ClassConecta() {
    }
    // Acesso Local - funcao para conex�o com Banco    
//    private String url = "jdbc:mysql://localhost/db_digasim";
//    private String driver = "com.mysql.jdbc.Driver";
//    private String user = "root";
//    private String pwd = "797908";//Senha do Banco de dados
    
    // Acesso Remoto
    private String url = "jdbc:mysql://200.234.201.118/digasim_sistema";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "digasim_sistema";
    private String pwd = "csmdpla";//Senha do Banco de dados
    public Connection con = null;

    public Connection conecta() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Driver n�o encontrado!\n" + e, "ATEN��O", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Erro na Conex�o com Banco\n" + e, "ATEN��O", JOptionPane.WARNING_MESSAGE);
        }
        // System.out.println("Conectado");
        return con;
    }
    //fim da conexao
    //========================================================
    public static void main(String[] args) {
        System.out.println(new ClassConecta().conecta());
    }
}
