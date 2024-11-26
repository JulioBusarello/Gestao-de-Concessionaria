/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.ClienteDao;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Cliente;
import view.TelaPrincipal;

/**
 *
 * @author julio_busarello
 */
public class TelaCadastroCliente extends javax.swing.JFrame {

    private Cliente cliente;

    public TelaCadastroCliente() {
        initComponents();
    }
    
    private void limparCampos(){
        jTfNome.setText("");
        jFfTelefone.setText("");
        jTfAno.setText("");
        jTfDia.setText("");
        jTfMes.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLaSeta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTfDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBtnCadastro = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFfTelefone = new javax.swing.JFormattedTextField();
        jTfMes = new javax.swing.JTextField();
        jTfAno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCbGenero = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/people.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE CLIENTES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 14, 254, -1));

        jLabel6.setText("Nome:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 53, -1, -1));
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 75, 254, -1));

        jLabel4.setText("Telefone:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 115, -1, -1));

        jLabel3.setText("Data de Nascimento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 181, -1, -1));
        getContentPane().add(jTfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 223, 78, -1));

        jLabel5.setText("Genero:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 267, -1, -1));

        jBtnCadastro.setText("Cadastrar");
        jBtnCadastro.setMaximumSize(new java.awt.Dimension(76, 22));
        jBtnCadastro.setMinimumSize(new java.awt.Dimension(76, 22));
        jBtnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 333, -1, -1));

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setMaximumSize(new java.awt.Dimension(76, 22));
        jBtnCancelar.setMinimumSize(new java.awt.Dimension(76, 22));
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 333, -1, -1));

        try {
            jFfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 137, 254, -1));
        getContentPane().add(jTfMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 223, 86, -1));
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 223, 78, -1));

        jLabel7.setText("Dia:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 203, 78, -1));

        jLabel8.setText("Mês:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 203, 78, -1));

        jLabel9.setText("Ano:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 203, 78, -1));

        jCbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        getContentPane().add(jCbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 250, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastroActionPerformed
        String nome = jTfNome.getText();
        String telefone = jFfTelefone.getText();
        Date dataNascimento = null;
        String genero = (String) jCbGenero.getSelectedItem();
        String ano = jTfAno.getText();
        String mes = jTfMes.getText();
        String dia = jTfDia.getText();

        if (!ano.isBlank() && !mes.isBlank() && !dia.isBlank()) {
            if (ano.length() == 4 && Integer.parseInt(ano) > 0 && Integer.parseInt(ano) < 2024) {
                if (mes.length() == 2 && Integer.parseInt(mes) >= 1 && Integer.parseInt(mes) <= 12) {
                    if (dia.length() == 2 && Integer.parseInt(dia) >= 1 && Integer.parseInt(dia) <= 31) {
                        try {
                            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                            java.util.Date utilDate = formato.parse(ano + "/" + mes + "/" + dia);
                            dataNascimento = new Date(utilDate.getTime());
                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O dia inserido é inválido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "O mês inserido é inválido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "O ano inserido é inválido");
            }
        }

        if (!telefone.isBlank() && !nome.isBlank()) {
            ClienteDao dao = new ClienteDao();
            cliente = new Cliente(nome, dataNascimento, telefone, genero);
            dao.cadastro(cliente);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios!");
        }
    }//GEN-LAST:event_jBtnCadastroActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastro;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JComboBox<String> jCbGenero;
    private javax.swing.JFormattedTextField jFfTelefone;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTfAno;
    private javax.swing.JTextField jTfDia;
    private javax.swing.JTextField jTfMes;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
