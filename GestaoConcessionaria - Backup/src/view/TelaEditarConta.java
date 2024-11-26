package view;

import dao.FuncionarioDao;
import javax.swing.JOptionPane;
import model.Funcionario;

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
        jLaSeta = new javax.swing.JLabel();
        jTfSenha1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Conta");
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jLaEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/eye.png"))); // NOI18N
        jLaEye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLaEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaEyeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIADOR DE CONTA");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");

        jTfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeKeyReleased(evt);
            }
        });

        jTfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfLoginKeyReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Login:");

        jTfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfSenhaKeyReleased(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Senha:");

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLaSeta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTfSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnEditar)
                        .addGap(155, 155, 155)
                        .addComponent(jBtnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLaEye))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(jLaSeta))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addComponent(jTfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLaEye, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jTfSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

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

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

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
