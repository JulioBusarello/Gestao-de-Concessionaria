package view;

import dao.FuncionarioDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 * @author julio_busarello
 */
public class TelaGerenciarFuncionario extends javax.swing.JFrame {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();

    public TelaGerenciarFuncionario() {
        initComponents();
        loadFun();
        telaGerenciar(false);
    }

    private void telaGerenciar(boolean ativo) {
        jTfIdFun.setVisible(false);
        jBtnSalvar.setEnabled(false);

        jBtnExcluir.setEnabled(ativo);
        jBtnLimpar.setEnabled(ativo);

        jTfNome.setEnabled(ativo);
        jTfLogin.setEnabled(ativo);
        jTfSenha.setEnabled(ativo);
        jTfSalario.setEnabled(ativo);
        jCbAdmin.setEnabled(ativo);
    }

    private void loadFun() {
        DefaultTableModel defaultFun = new DefaultTableModel(new Object[]{
            "ID",
            "Nome",
            "Login",
            "Senha",
            "Salário",
            "Admin",}, 0);

        List<Funcionario> funcionarios = funcionarioDao.getAllFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            Object linha[] = new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getLogin(),
                funcionario.getSenha(),
                funcionario.getSalario(),
                funcionario.getAdmin() ? "Sim" : "Não"
            };
            defaultFun.addRow(linha);
        }
        jTbFuncionarios.setModel(defaultFun);
        jTbFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(5);
    }

    private void puxarCli(int selection) {
        jTfIdFun.setText(jTbFuncionarios.getValueAt(selection, 0).toString());
        jTfNome.setText(jTbFuncionarios.getValueAt(selection, 1).toString());
        jTfLogin.setText(jTbFuncionarios.getValueAt(selection, 2).toString());
        jTfSenha.setText(jTbFuncionarios.getValueAt(selection, 3).toString());
        jTfSalario.setText(jTbFuncionarios.getValueAt(selection, 4).toString());
        
        jCbAdmin.setSelected(jTbFuncionarios.getValueAt(selection, 5).toString().equals("Sim") ? true : false);

        telaGerenciar(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTfIdFun = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfSalario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbFuncionarios = new javax.swing.JTable();
        jLaSeta = new javax.swing.JLabel();
        jBtnLimpar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jTfNome = new javax.swing.JTextField();
        jTfLogin = new javax.swing.JTextField();
        jTfSenha = new javax.swing.JTextField();
        jCbAdmin = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Funcionários");
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIAMENTO DE FUNCIONÁRIOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, -1));

        jTfIdFun.setText("ID");
        getContentPane().add(jTfIdFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));
        getContentPane().add(jTfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 300, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Salário:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jTbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Login", "Senha", "Salário", "Admin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbFuncionarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 244, 588, 150));

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 300, -1));
        getContentPane().add(jTfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 300, -1));
        getContentPane().add(jTfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 300, -1));

        jCbAdmin.setText("Admin");
        getContentPane().add(jCbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbFuncionariosMouseClicked
        puxarCli(jTbFuncionarios.getSelectedRow());
    }//GEN-LAST:event_jTbFuncionariosMouseClicked

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed

    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed

    }//GEN-LAST:event_jBtnSalvarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JCheckBox jCbAdmin;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbFuncionarios;
    private javax.swing.JTextField jTfIdFun;
    private javax.swing.JTextField jTfLogin;
    private javax.swing.JTextField jTfNome;
    private javax.swing.JTextField jTfSalario;
    private javax.swing.JTextField jTfSenha;
    // End of variables declaration//GEN-END:variables
}
