/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Funcionario;

/**
 *
 * @author julio_busarello
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    public static Funcionario funcionario;

    public TelaPrincipal() {
        initComponents();
    }

    public void objectFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        telaFuncionario();
    }
    
    public void telaFuncionario(){
        if (funcionario.getAdmin()) {

        } else {
            jMiCadastrarCli.setEnabled(false);
        }
        
        String[] nomeFuncionario = funcionario.getNome().split(" ");

        jMeUsuario.setText(nomeFuncionario[0]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMeUsuario = new javax.swing.JMenu();
        jMiEditarConta = new javax.swing.JMenuItem();
        jMiReturnLogin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMeFuncionário = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMiCadastrarCli = new javax.swing.JMenuItem();
        jMiGerenciarCli = new javax.swing.JMenuItem();
        jMiListarCli = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setPreferredSize(new java.awt.Dimension(600, 390));
        setResizable(false);

        jMiEditarConta.setText("Editar Conta");
        jMiEditarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEditarContaActionPerformed(evt);
            }
        });
        jMeUsuario.add(jMiEditarConta);

        jMiReturnLogin.setText("Voltar ao Login");
        jMiReturnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiReturnLoginActionPerformed(evt);
            }
        });
        jMeUsuario.add(jMiReturnLogin);

        jMenuBar1.add(jMeUsuario);

        jMenu3.setText("   ");
        jMenuBar1.add(jMenu3);

        jMeFuncionário.setText("Funcionário");
        jMenuBar1.add(jMeFuncionário);

        jMenu1.setText("Cliente");

        jMiCadastrarCli.setText("Cadastrar");
        jMiCadastrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCadastrarCliActionPerformed(evt);
            }
        });
        jMenu1.add(jMiCadastrarCli);

        jMiGerenciarCli.setText("Gerenciar");
        jMiGerenciarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiGerenciarCliActionPerformed(evt);
            }
        });
        jMenu1.add(jMiGerenciarCli);

        jMiListarCli.setText("Listar");
        jMiListarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiListarCliActionPerformed(evt);
            }
        });
        jMenu1.add(jMiListarCli);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Veiculos");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMiCadastrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCadastrarCliActionPerformed
        TelaCadastroCliente tela = new TelaCadastroCliente();
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jMiCadastrarCliActionPerformed

    private void jMiReturnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiReturnLoginActionPerformed
        TelaLogin tela = new TelaLogin();
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jMiReturnLoginActionPerformed

    private void jMiEditarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEditarContaActionPerformed
        TelaEditarConta tela = new TelaEditarConta(funcionario);
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jMiEditarContaActionPerformed

    private void jMiListarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiListarCliActionPerformed
        TelaListarClientes tela = new TelaListarClientes();
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jMiListarCliActionPerformed

    private void jMiGerenciarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiGerenciarCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiGerenciarCliActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMeFuncionário;
    private javax.swing.JMenu jMeUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMiCadastrarCli;
    private javax.swing.JMenuItem jMiEditarConta;
    private javax.swing.JMenuItem jMiGerenciarCli;
    private javax.swing.JMenuItem jMiListarCli;
    private javax.swing.JMenuItem jMiReturnLogin;
    // End of variables declaration//GEN-END:variables
}
