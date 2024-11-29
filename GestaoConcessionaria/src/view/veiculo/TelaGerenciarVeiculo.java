package view.veiculo;

import dao.VeiculoDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import view.TelaPrincipal;

/**
 * @author julio
 */

public class TelaGerenciarVeiculo extends javax.swing.JFrame {

    private VeiculoDao veiculoDao = new VeiculoDao();

    public TelaGerenciarVeiculo() {
        initComponents();
    }
    
    private void loadVe(){
        DefaultTableModel defaultVe = new DefaultTableModel(new Object[]{
            "ID",
            "Placa",
            "Marca",
            "Modelo",
            "Ano",
            "Cor",
            "Preço",
            "Anunciado",
            "Id Dono"
        }, 0);

        List<Veiculo> veiculos = veiculoDao.getAll();
        for (Veiculo veiculo : veiculos) {
            Object linha[] = new Object[]{
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getPreco(),
                veiculo.isAnunciado() ? "Sim" : "Não",
                veiculo.hasDono() ? veiculo.getId_cliente() : "Sem dono",
            };
            defaultVe.addRow(linha);
        }

        jTbVeiculos.setModel(defaultVe);
        jTbVeiculos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTbVeiculos.setDefaultEditor(Object.class, null);
    }
    
    private void limparVe() {
        jTfIdVeiculo.setText("");
        jTfPlaca.setText("");
        jTfMarca.setText("");
        jTfModelo.setText("");
        jTfAno.setText("");
        jTfCor.setText("");
        jTfPreco.setText("");
        
        jTbVeiculos.clearSelection();
        //telaAnunciar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTfPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfIdVeiculo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfModelo = new javax.swing.JTextField();
        jBtnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTfAno = new javax.swing.JTextField();
        jTfCor = new javax.swing.JTextField();
        jTfPreco = new javax.swing.JTextField();
        jBtnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLaSeta = new javax.swing.JLabel();
        jBtnLimpar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 170, -1));

        jLabel1.setText("Placa:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jTfIdVeiculo.setText("ID");
        getContentPane().add(jTfIdVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, -1));

        jLabel3.setText("Marca:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));
        getContentPane().add(jTfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, -1));

        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));
        getContentPane().add(jTfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 120, -1));

        jLabel5.setText("Preço:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel6.setText("Cor:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel7.setText("Ano:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 170, -1));
        getContentPane().add(jTfCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, -1));
        getContentPane().add(jTfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 170, -1));

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 120, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIAR VEÍCULOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, -1));

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.setText("jLabel3");
        jLaSeta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jBtnLimpar1.setText("Limpar");
        jBtnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 110, -1));

        jTbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Marca", "Modelo", "Ano", "Cor", "Preço", "Anunciado", "Id do Dono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbVeiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTbVeiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 680, 170));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jBtnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpar1ActionPerformed
        limparVe();
    }//GEN-LAST:event_jBtnLimpar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar1;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbVeiculos;
    private javax.swing.JTextField jTfAno;
    private javax.swing.JTextField jTfCor;
    private javax.swing.JTextField jTfIdVeiculo;
    private javax.swing.JTextField jTfMarca;
    private javax.swing.JTextField jTfModelo;
    private javax.swing.JTextField jTfPlaca;
    private javax.swing.JTextField jTfPreco;
    // End of variables declaration//GEN-END:variables
}
