package br.com.frame;

import br.com.model.Fornecedores;
import javax.swing.JOptionPane;

/**
 *
 * @author julio.leme
 *
 */
public class FCadFornecedor extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8207656819434578098L;
	/**
     * Creates new form FCadUser
     */
    public FCadFornecedor() {
        initComponents();
        setBounds(250, 250, 395, 310);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUser1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUser3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Montadora Digasim v.01");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("MS Sans Serif", 1, 12)); // NOI18N
        jLabel1.setText("Cadastro de Fornecedores");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 10, 160, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 370, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel2.setText("Nome: ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 110, 14);
        jPanel2.add(txtUser);
        txtUser.setBounds(110, 10, 150, 20);

        jLabel4.setText("Funcao:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 40, 100, 14);
        jPanel2.add(txtUser1);
        txtUser1.setBounds(110, 40, 150, 20);

        jLabel6.setText("Telefone:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 70, 100, 14);
        jPanel2.add(txtUser3);
        txtUser3.setBounds(110, 70, 150, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 60, 370, 150);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalvar);
        btnSalvar.setBounds(180, 10, 100, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(80, 10, 100, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 210, 370, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtUser.getText().length() == 0 || txtUser1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha os campos", "ATENCAO", JOptionPane.WARNING_MESSAGE);
        } else {
            Fornecedores pro = new Fornecedores();
            pro.setNome(txtUser.getText());
            pro.setFuncao(txtUser1.getText());
            pro.setTelefone(txtUser3.getText());
            pro.incluiFornecedor();

            this.dispose();
//            System.out.println("###"+   pro);
//            EstoqueVO estoque = new EstoqueVO();
//            estoque.setNomeProduto(pro.getNome());
//            estoque.setQtde(Integer.parseInt(txtUser2.getText().toString()));
//            estoque.incluiEstoque();

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCadFornecedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUser1;
    private javax.swing.JTextField txtUser3;
    // End of variables declaration//GEN-END:variables
}
