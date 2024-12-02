/*
    Tela para excluir compras, com acesso somente para funcionários administradores
 */

package view.compra;

import dao.CompraDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Compra;
import view.TelaPrincipal;

/**
 * @author julio
 */

public class TelaGerenciarCompra extends javax.swing.JFrame {

    private final CompraDao compraDao = new CompraDao();

    public TelaGerenciarCompra() {
        initComponents();
        tela(false);
        loadCompra();
    }

    private void loadCompra() {
        DefaultTableModel defaultCompra = new DefaultTableModel(new Object[]{
            "ID",
            "Qtd. Par.",
            "Data",
            "Cliente",
            "Placa do Veículo",
            "Funcionário"
        }, 0);

        List<Compra> compras = compraDao.getAll();
        for (Compra compra : compras) {
            Object linha[] = new Object[]{
                compra.getId(),
                compra.getParcelas(),
                compra.getData(),
                compra.getCliente().getNome(),
                compra.getVeiculo().getPlaca(),
                compra.getFuncionario().getNome()
            };
            defaultCompra.addRow(linha);
        }
        jTbCompras.setModel(defaultCompra);
        jTbCompras.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTbCompras.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTbCompras.setDefaultEditor(Object.class, null);
    }

    private void tela(boolean ativo) {
        jTfIdCompra.setVisible(false);

        jTfDono.setEnabled(false);
        jTfParcelas.setEnabled(false);
        jTfFuncionario.setEnabled(false);
        jTfDataCompra.setEnabled(false);
        jTfPlaca.setEnabled(false);

        jBtnLimpar.setEnabled(ativo);
        jBtnExcluir.setEnabled(ativo);

        if (!ativo) {
            limparCampos();
        }
    }

    private void limparCampos() {
        jTfIdCompra.setText("");

        jTfParcelas.setText("");
        jTfDataCompra.setText("");
        jTfDono.setText("");
        jTfPlaca.setText("");
        jTfFuncionario.setText("");

        jTbCompras.clearSelection();
    }

    private void mostrarDados(int selection) {
        jTfIdCompra.setText(jTbCompras.getValueAt(selection, 0).toString());

        jTfParcelas.setText(jTbCompras.getValueAt(selection, 1).toString());
        jTfDataCompra.setText(jTbCompras.getValueAt(selection, 2).toString());
        jTfDono.setText(jTbCompras.getValueAt(selection, 3).toString());
        jTfPlaca.setText(jTbCompras.getValueAt(selection, 4).toString());
        jTfFuncionario.setText(jTbCompras.getValueAt(selection, 5).toString());

        tela(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTfParcelas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfDataCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfDono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfPlaca = new javax.swing.JTextField();
        jBtnLimpar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTfIdCompra = new javax.swing.JTextField();
        jLaSeta = new javax.swing.JLabel();
        jTfFuncionario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbCompras = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Parcelas:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));
        getContentPane().add(jTfParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 300, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data da Compra:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));
        getContentPane().add(jTfDataCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 300, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));
        getContentPane().add(jTfDono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 300, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Placa do Veículo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 300, -1));

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
        getContentPane().add(jBtnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIAR COMPRAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, -1));

        jTfIdCompra.setText("ID");
        getContentPane().add(jTfIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, -1));

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));
        getContentPane().add(jTfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 300, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Funcionário:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jTbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "N Parcelas", "Data Compra", "Cliente", "Placa do Veículo", "Funcionário "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbCompras.getTableHeader().setReorderingAllowed(false);
        jTbCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 580, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        tela(false);
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        try {
            Long idCompra = Long.valueOf(jTfIdCompra.getText());

            int optDel = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Compra?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (optDel == JOptionPane.YES_NO_OPTION) {
                compraDao.delete(idCompra);
                loadCompra();
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Não foi possível excluir a Compra!");
        }

        tela(false);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jTbComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbComprasMouseClicked
        int linha = jTbCompras.getSelectedRow();
        if (linha != -1) {
            mostrarDados(linha);
        }
    }//GEN-LAST:event_jTbComprasMouseClicked

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
            java.util.logging.Logger.getLogger(TelaGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbCompras;
    private javax.swing.JTextField jTfDataCompra;
    private javax.swing.JTextField jTfDono;
    private javax.swing.JTextField jTfFuncionario;
    private javax.swing.JTextField jTfIdCompra;
    private javax.swing.JTextField jTfParcelas;
    private javax.swing.JTextField jTfPlaca;
    // End of variables declaration//GEN-END:variables
}
