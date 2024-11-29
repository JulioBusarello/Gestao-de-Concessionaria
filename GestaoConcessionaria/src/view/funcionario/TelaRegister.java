/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.funcionario;

import dao.FuncionarioDao;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 * @author julio_busarello
 */

public class TelaRegister extends javax.swing.JFrame {

    private Funcionario funcionario;

    public TelaRegister() {
        initComponents();
    }

    public void limparCampos() {
        jTfNome.setText("");
        jTfLogin.setText("");
        jPfPassword.setText("");
        jPfConfirmPass.setText("");
    }

    public void admEdit(boolean admin) {
        jLaSeta.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTfLogin = new javax.swing.JTextField();
        jPfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnRegister = new javax.swing.JButton();
        jPfConfirmPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Registro de Funcionários");
        setBackground(new java.awt.Color(60, 64, 65));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 14, 254, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 400));
        getContentPane().add(jTfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 137, 254, -1));
        getContentPane().add(jPfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 203, 254, -1));

        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 181, -1, -1));

        jLabel4.setText("Login:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 115, -1, -1));

        jBtnRegister.setText("Registrar");
        jBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 313, -1, -1));
        getContentPane().add(jPfConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 269, 254, -1));

        jLabel5.setText("Confirmar Senha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 247, -1, -1));
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 75, 254, -1));

        jLabel6.setText("Nome:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 53, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegisterActionPerformed
        String nome = jTfNome.getText();
        String login = jTfLogin.getText();
        String senha = new String(jPfPassword.getPassword());
        String senhaConfir = new String(jPfConfirmPass.getPassword());

        if (!senha.isBlank() && !senhaConfir.isBlank() && !nome.isBlank() && !login.isBlank()) {
            if (senha.equals(senhaConfir)) {
                FuncionarioDao dao = new FuncionarioDao();
                funcionario = new Funcionario(nome, login, senha);
                dao.registro(funcionario);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não condizem!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios!");
        }

    }//GEN-LAST:event_jBtnRegisterActionPerformed

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaLogin tela = new TelaLogin();
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jLaSetaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRegister;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPfConfirmPass;
    private javax.swing.JPasswordField jPfPassword;
    private javax.swing.JTextField jTfLogin;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
