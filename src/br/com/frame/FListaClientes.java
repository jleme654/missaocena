/*package br.com.frame;

import br.com.dao.ClassConecta;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FListaClientes extends javax.swing.JFrame {

    *//**
     * Creates new form FListaSetor
     *//*
    public FListaClientes() {
        initComponents();
        setBounds(250, 250, 470, 290);
    }

    *//**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Missao Cena - Cadastro Assistidos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(80, 10, 160, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 200, 330, 50);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data_Visita", "Rg"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 450, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Statement stmt = null;
        Connection con = null;
        try {
            //ClassDiaria CDiaria = new ClassDiaria();
            ClassConecta conexao = new ClassConecta();
            conexao.conecta();
            stmt = conexao.con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from assistidos order by nome desc");
            // ==> retorna o n�mero de colunas de uma tabela "rs.getMetaData().getColumnCount();"
            while (rs.next()) {
                //Adicionando os Dados da tabela na jTable              
                ((DefaultTableModel) tabela.getModel()).addRow(
                        new Object[]{rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Personalizando a largura das Colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(159); //Tamanho Inicial
        tabela.getColumnModel().getColumn(0).setMaxWidth(159);//Tamanho Maximo
        tabela.getColumnModel().getColumn(0).setMinWidth(159);//Tamanho M�nimo
        
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(1).setMaxWidth(140);
        tabela.getColumnModel().getColumn(1).setMinWidth(140);
        
        tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setMaxWidth(140);
        tabela.getColumnModel().getColumn(2).setMinWidth(140);
        
//        tabela.getColumnModel().getColumn(3).setPreferredWidth(160);
//        tabela.getColumnModel().getColumn(3).setMaxWidth(160);
//        tabela.getColumnModel().getColumn(3).setMinWidth(160);
        
//        tabela.getColumnModel().getColumn(4).setPreferredWidth(90);
//        tabela.getColumnModel().getColumn(4).setMaxWidth(90);
//        tabela.getColumnModel().getColumn(4).setMinWidth(90);
        //=============================================================================
    }//GEN-LAST:event_formWindowActivated

    *//**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FListaClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
*/