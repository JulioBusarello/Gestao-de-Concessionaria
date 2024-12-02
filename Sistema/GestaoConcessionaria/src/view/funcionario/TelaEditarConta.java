/*
    Tela para que qualquer funcionário possa realizar a edição dos seus próprios
    dados
*/

package view.funcionario;

import dao.FuncionarioDao;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.TelaPrincipal;

/**
 * @author julio_busarello
 */

public class TelaEditarConta extends javax.swing.JFrame {

    private Funcionario funcionario;
    private boolean editar = false;
    private boolean campoSenha = false;

    public TelaEditarConta() {
        initComponents();
    }

    public TelaEditarConta(Funcionario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        preencherCampos();
        campos(false);
        jBtnSalvar.setEnabled(false);
        jTfSenha1.setVisible(false);
    }

    private void preencherCampos() {
        jTfNome.setText(funcionario.getNome());
        jTfLogin.setText(funcionario.getLogin());
        jTfSenha.setText(funcionario.getSenha());
        jTfSenha1.setText(funcionario.getSenha());
        mostrarSenha(campoSenha);
    }

    private void campos(Boolean ativado) {
        jTfNome.setEnabled(ativado);
        jTfLogin.setEnabled(ativado);
        jTfSenha.setEnabled(ativado);
    }

    private void mostrarSenha(Boolean verSenha) {
        String senha = jTfSenha.getText();
        String senha1 = jTfSenha1.getText();
        if (verSenha) {
            jTfSenha.setText(senha1);
        } else {
            String campo = "";
            for (int i = 0; i < senha.length(); i++) {
                campo += "*";
            }
            jTfSenha.setText(campo);
        }
        
        if(verSenha && editar){
            jTfSenha.setEnabled(true);
        }else{
            jTfSenha.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jLaEye = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jTfLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfSenha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jTfSenha1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Conta");
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jLaEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/eye.png"))); // NOI18N
        jLaEye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLaEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaEyeMouseClicked(evt);
            }
        });
        getContentPane().add(jLaEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 161, -1, 26));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIADOR DE CONTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 600, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 78, -1, -1));

        jTfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeKeyReleased(evt);
            }
        });
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 73, 270, -1));

        jTfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfLoginKeyReleased(evt);
            }
        });
        getContentPane().add(jTfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 117, 270, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Login:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 122, 36, -1));

        jTfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfSenhaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 161, 270, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 166, 46, -1));

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 200, -1, -1));
        getContentPane().add(jTfSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 339, 270, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLaEyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaEyeMouseClicked
        if (campoSenha) {
            campoSenha = false;
            mostrarSenha(campoSenha);
        } else {
            campoSenha = true;
            mostrarSenha(campoSenha);
        }
    }//GEN-LAST:event_jLaEyeMouseClicked

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        Long id = funcionario.getId();
        String nome = jTfNome.getText();
        String login = jTfLogin.getText();
        String senha = jTfSenha1.getText();

        if (!nome.isBlank() && !login.isBlank() && !senha.isBlank()) {
            FuncionarioDao dao = new FuncionarioDao();
            Funcionario funcionario2 = new Funcionario(id, nome, login, senha);
            dao.editar(funcionario2);
            jBtnSalvar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão corretos!");
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        if (editar) {
            editar = false;
            campos(editar);
        } else {
            editar = true;
            campos(editar);
            if(!campoSenha){
                jTfSenha.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jTfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfNomeKeyReleased
        if (!jTfNome.getText().isBlank() && !jTfLogin.getText().isBlank() && !jTfSenha.getText().isBlank()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfNomeKeyReleased

    private void jTfLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfLoginKeyReleased
        if (!jTfNome.getText().isBlank() && !jTfLogin.getText().isBlank() && !jTfSenha.getText().isBlank()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfLoginKeyReleased

    private void jTfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfSenhaKeyReleased
        if (!jTfNome.getText().isBlank() && !jTfLogin.getText().isBlank() && !jTfSenha.getText().isBlank()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
        
        if(!jTfSenha.getText().isBlank()){
            jTfSenha1.setText(jTfSenha.getText());
        }
    }//GEN-LAST:event_jTfSenhaKeyReleased

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
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
            java.util.logging.Logger.getLogger(TelaEditarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLaEye;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTfLogin;
    private javax.swing.JTextField jTfNome;
    private javax.swing.JTextField jTfSenha;
    private javax.swing.JTextField jTfSenha1;
    // End of variables declaration//GEN-END:variables
}
