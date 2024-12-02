/*
    Tela para gerenciar funcionários, com acesso somente para funcionários administradores
 */
package view.funcionario;

import dao.FuncionarioDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.TelaPrincipal;

/**
 * @author julio_busarello
 */
public class TelaGerenciarFuncionario extends javax.swing.JFrame {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private Funcionario funcionario;

    Long id;
    String nome, login, senha;
    Double salario;
    boolean admin;

    public TelaGerenciarFuncionario() {
        initComponents();
        loadFun();
        telaGerenciar(false);
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

        if (!ativo) {
            jTbFuncionarios.clearSelection();
            limparFun();
        }
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
        for (Funcionario funcionarioL : funcionarios) {
            Object linha[] = new Object[]{
                funcionarioL.getId(),
                funcionarioL.getNome(),
                funcionarioL.getLogin(),
                funcionarioL.getSenha(),
                funcionarioL.getSalario(),
                funcionarioL.getAdmin() ? "Sim" : "Não"
            };
            defaultFun.addRow(linha);
        }
        jTbFuncionarios.setModel(defaultFun);
        jTbFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTbFuncionarios.setDefaultEditor(Object.class, null);
    }

    private Long mostrarDados(int selection) {
        Long id = Long.valueOf(jTbFuncionarios.getValueAt(selection, 0).toString());

        jTfIdFun.setText(id.toString());
        jTfNome.setText(jTbFuncionarios.getValueAt(selection, 1).toString());
        jTfLogin.setText(jTbFuncionarios.getValueAt(selection, 2).toString());
        jTfSenha.setText(jTbFuncionarios.getValueAt(selection, 3).toString());
        jTfSalario.setText(jTbFuncionarios.getValueAt(selection, 4).toString());

        jCbAdmin.setSelected("Sim".equals(jTbFuncionarios.getValueAt(selection, 5).toString()));

        telaGerenciar(true);

        return id;
    }

    private void pegarDados() {
        this.id = Long.valueOf(jTfIdFun.getText());
        this.nome = jTfNome.getText();
        this.login = jTfLogin.getText();
        this.senha = jTfSenha.getText();
        this.salario = Double.valueOf(jTfSalario.getText());
        this.admin = jCbAdmin.isSelected();
    }

    private void limparFun() {
        jTfIdFun.setText("");
        jTfNome.setText("");
        jTfLogin.setText("");
        jTfSenha.setText("");
        jTfSalario.setText("");

        jCbAdmin.setSelected(false);
    }

    private void excluirFun() {
        Long id = Long.valueOf(jTfIdFun.getText());

        if (funcionarioDao.funcionarioEmUso(id)) {
            JOptionPane.showMessageDialog(null, "Não é possível deletar este Funcionário, pois ele está em uso!");
            return;
        }

        int optDel = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Funcionário?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optDel != JOptionPane.YES_NO_OPTION) {
            return;
        }

        if (id.equals(funcionario.getId())) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir sua própria conta!");
            return;
        }

        funcionarioDao.delete(id);
        loadFun();

        telaGerenciar(false);
    }

    private void salvarFun() {
        pegarDados();

        if (camposNaoPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido!");
            return;
        }

        int optSav = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alterações deste cliente?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optSav == JOptionPane.YES_NO_OPTION) {
            FuncionarioDao dao = new FuncionarioDao();
            Funcionario funcionario = new Funcionario(id, nome, login, senha, salario, admin);
            dao.editar(funcionario);
        }

        limparFun();
        loadFun();
    }

    private boolean camposNaoPreenchidos() {
        return jTfNome.getText().isBlank() || jTfLogin.getText().isBlank() || jTfSenha.getText().isBlank() || jTfSalario.getText().isBlank();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTfIdFun = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfSalario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbFuncionarios = new javax.swing.JTable();
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

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIAMENTO DE FUNCIONÁRIOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, -1));

        jTfIdFun.setText("ID");
        getContentPane().add(jTfIdFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jTfSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfSalarioKeyReleased(evt);
            }
        });
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
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jTfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeKeyReleased(evt);
            }
        });
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 300, -1));

        jTfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfLoginKeyReleased(evt);
            }
        });
        getContentPane().add(jTfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 300, -1));

        jTfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfSenhaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 300, -1));

        jCbAdmin.setText("Admin");
        jCbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbAdminActionPerformed(evt);
            }
        });
        getContentPane().add(jCbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbFuncionariosMouseClicked
        int selection = jTbFuncionarios.getSelectedRow();
        Long id = mostrarDados(selection);

        if (funcionario.getId().equals(id)) {
            jCbAdmin.setEnabled(false);
        }
    }//GEN-LAST:event_jTbFuncionariosMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        telaGerenciar(false);
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        excluirFun();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        salvarFun();
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jTfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfNomeKeyReleased
        if (!camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfNomeKeyReleased

    private void jTfLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfLoginKeyReleased
        if (!camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfLoginKeyReleased

    private void jTfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfSenhaKeyReleased
        if (!camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfSenhaKeyReleased

    private void jTfSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfSalarioKeyReleased
        if (!camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        } else {
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTfSalarioKeyReleased

    private void jCbAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbAdminActionPerformed
        jBtnSalvar.setEnabled(true);
    }//GEN-LAST:event_jCbAdminActionPerformed

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.objectFuncionario(funcionario);
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
