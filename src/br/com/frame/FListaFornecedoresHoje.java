package br.com.frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.dao.AssistidoDAO;
import br.com.dao.ClassConecta;
import br.com.model.AssistidoVO;
import br.com.util.MissaoCenaUtil;

public class FListaFornecedoresHoje extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form FListaSetor
     */
    public FListaFornecedoresHoje() {
        initComponents();
        setBounds(250, 250, 470, 290);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExcluiServidor = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Missao Cena - Assistidos Hoje - "+ MissaoCenaUtil.getDataHojeString());
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

        btnExcluiServidor.setText("Excluir");
        btnExcluiServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiServidorActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluiServidor);
        btnExcluiServidor.setBounds(10, 10, 150, 23);

        btnSair.setText("Incluir");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(160, 10, 160, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 200, 330, 50);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data_Visita"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 440, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * botao adicionar assistido no dia
     * @param evt
     */
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    	int linha = tabela.getSelectedRow();
    	String id = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 0).toString();
        String nome = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 1).toString();
        String dataVisita = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 2).toString();

        AssistidoVO vo = new AssistidoVO();
        vo.setNome(nome);
        vo.setDataVisita(MissaoCenaUtil.convertStrToTimestamp(dataVisita));
        vo.setCpf(null);
        vo.setId(Integer.parseInt(id));
        vo.setRg(null);
          
        AssistidoDAO.incluirAssistido(vo);
   
        JOptionPane.showMessageDialog(null, "Adicionado " + vo.getNome() + " com Sucesso", "ATENCAO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * botao excluir para assistido 
     * @param dataStr
     * @return
     */
    private void btnExcluiServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiServidorActionPerformed
        int linha = tabela.getSelectedRow();
//        JOptionPane.showMessageDialog(null, tabela.getSelectedRow(), "ATENCAO", JOptionPane.WARNING_MESSAGE);
//             
//      //  int coluna = tabela.getSelectedColumn();
//        if (linha == -1) {
//            JOptionPane.showMessageDialog(null, "Selecione uma linha", "ATENCAO", JOptionPane.WARNING_MESSAGE);
//        } else {

    	//Vari�veis para pegar os valores das colunas da jTable
            String id = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 0).toString();
            String nome = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 1).toString();
            String dataVisita = ((DefaultTableModel) tabela.getModel()).getValueAt(linha, 2).toString();

            AssistidoVO vo = new AssistidoVO();
            vo.setNome(nome);
            vo.setDataVisita(MissaoCenaUtil.convertStrToTimestamp(dataVisita));
            vo.setCpf(null);
            vo.setId(Integer.parseInt(id));
            vo.setRg(null);
            
            AssistidoDAO.excluiAssistido(vo);
       
            ((DefaultTableModel) tabela.getModel()).removeRow(linha);//para remover a linha exclu�da
            JOptionPane.showMessageDialog(null, "Assistido Excluido com Sucesso", "ATENCAO", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_btnExcluiServidorActionPerformed
    
   /* private Date getMeYesterday(){
        return new Date(System.currentTimeMillis()-24*60*60*1000);
    }
    
    private Date getMeTomorrow(){
        return new Date(System.currentTimeMillis()+24*60*60*1000);
   }*/
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Statement stmt = null;
        //Connection con = null;
        try {
            //ClassDiaria CDiaria = new ClassDiaria();
            ClassConecta conexao = new ClassConecta();
            conexao.conecta();
            stmt = conexao.con.createStatement();
            
            //Timestamp hoje = new Timestamp(System.currentTimeMillis());
            //Timestamp ontem = new Timestamp(getMeYesterday().getTime());
            //Timestamp amanha = new Timestamp(getMeTomorrow().getTime());
			
            ResultSet rs = stmt.executeQuery(
            		"Select * from assistido "
            		+ "inner join dia_assistido "
            	    + "on assistido.id = dia_assistido.idAssistido "
            	    + "and dia_assistido.dataVisita = '" + MissaoCenaUtil.getDataHojeString() + "'");
            		//+ "where `dataVisita` between '"+ ontem + "' and '" + amanha + "'");
            		//+ " order by `dataVisita` desc");
            // ==> retorna o n�mero de colunas de uma tabela "rs.getMetaData().getColumnCount();"
            while (rs.next()) {
                //Adicionando os Dados da tabela na jTable              
                ((DefaultTableModel) tabela.getModel()).addRow(
                        new Object[]{
                        		rs.getString(1),
                        		rs.getString(2), // nome 
                        		rs.getString(3) // data visita
                        		});
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Personalizando a largura das Colunas
    	int first = 40, second = 210	, third = 180;
        tabela.getColumnModel().getColumn(0).setPreferredWidth(first); //Tamanho Inicial
        tabela.getColumnModel().getColumn(0).setMaxWidth(first);//Tamanho Maximo
        tabela.getColumnModel().getColumn(0).setMinWidth(first);//Tamanho M�nimo
        
        tabela.getColumnModel().getColumn(1).setPreferredWidth(second);
        tabela.getColumnModel().getColumn(1).setMaxWidth(second);
        tabela.getColumnModel().getColumn(1).setMinWidth(second);
        
        tabela.getColumnModel().getColumn(2).setPreferredWidth(third);
        tabela.getColumnModel().getColumn(2).setMaxWidth(third);
        tabela.getColumnModel().getColumn(2).setMinWidth(third);
        
//        tabela.getColumnModel().getColumn(3).setPreferredWidth(160);
//        tabela.getColumnModel().getColumn(3).setMaxWidth(160);
//        tabela.getColumnModel().getColumn(3).setMinWidth(160);
        
//        tabela.getColumnModel().getColumn(4).setPreferredWidth(90);
//        tabela.getColumnModel().getColumn(4).setMaxWidth(90);
//        tabela.getColumnModel().getColumn(4).setMinWidth(90);
        //=============================================================================
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FListaFornecedoresHoje().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluiServidor;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
