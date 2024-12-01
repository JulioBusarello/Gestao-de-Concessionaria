package view.veiculo;

import dao.VeiculoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import view.TelaPrincipal;

/**
 * @author julio_busarello
 */
public class TelaAnunciarVeiculo extends javax.swing.JFrame {

    private VeiculoDao veiculoDao = new VeiculoDao();

    public TelaAnunciarVeiculo() {
        initComponents();
        loadVe();
        telaAnunciar(false);
    }

    private void loadVe() {
        DefaultTableModel defaultVe = new DefaultTableModel(new Object[]{
            "ID",
            "Placa",
            "Marca",
            "Modelo",
            "Ano",
            "Cor",
            "Preço"
        }, 0);

        List<Veiculo> veiculos = veiculoDao.getAllUnAnnounced();
        for (Veiculo veiculo : veiculos) {
            Object linha[] = new Object[]{
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getPreco(),};
            defaultVe.addRow(linha);
        }

        jTbVeiculos.setModel(defaultVe);
        jTbVeiculos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTbVeiculos.setDefaultEditor(Object.class, null);
    }

    private void telaAnunciar(boolean selecionado) {
        jTfIdVeiculo.setVisible(false);
        
        jTfPlaca.setEnabled(false);
        jTfMarca.setEnabled(false);
        jTfModelo.setEnabled(false);
        jTfCor.setEnabled(false);
        jTfPreco.setEnabled(false);
        jTfAno.setEnabled(false);
        
        jBtnAnunciar.setEnabled(selecionado);
        jBtnLimpar.setEnabled(selecionado);
    }
    
    private void puxarVe(int selection){
        jTfIdVeiculo.setText(jTbVeiculos.getValueAt(selection, 0).toString());
        jTfPlaca.setText(jTbVeiculos.getValueAt(selection, 1).toString());
        jTfMarca.setText(jTbVeiculos.getValueAt(selection, 2).toString());
        jTfModelo.setText(jTbVeiculos.getValueAt(selection, 3).toString());
        jTfAno.setText(jTbVeiculos.getValueAt(selection, 4).toString());
        jTfCor.setText(jTbVeiculos.getValueAt(selection, 5).toString());
        jTfPreco.setText(jTbVeiculos.getValueAt(selection, 6).toString());
        
        telaAnunciar(true);
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
        telaAnunciar(false);
    }
    
    private void anunciarVe() {
        Long id = Long.valueOf(jTfIdVeiculo.getText());
        
        int optAn = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja anunciar este Veículo?", 
                "Confirmar",JOptionPane.YES_NO_OPTION);
        
        if (optAn == JOptionPane.YES_NO_OPTION) {
            veiculoDao.anunciarVeiculo(id);
            loadVe();
            limparVe();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbVeiculos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTfPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfModelo = new javax.swing.JTextField();
        jTfPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfCor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTfAno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtnAnunciar = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jTfIdVeiculo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anunciar veículo");
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

        jTbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Marca", "Modelo", "Ano", "Cor", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbVeiculos.getTableHeader().setReorderingAllowed(false);
        jTbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbVeiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 580, 170));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ANUNCIAR VEÍCULOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 600, -1));

        jLabel1.setText("Placa:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 56, -1, -1));
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 51, 170, -1));

        jLabel3.setText("Marca:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 100, -1, -1));
        getContentPane().add(jTfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 95, 170, -1));

        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 144, -1, -1));
        getContentPane().add(jTfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 139, 170, -1));
        getContentPane().add(jTfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 139, 170, -1));

        jLabel5.setText("Preço:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 144, -1, -1));
        getContentPane().add(jTfCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 95, 170, -1));

        jLabel6.setText("Cor:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 100, -1, -1));
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 51, 170, -1));

        jLabel7.setText("Ano:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 56, -1, -1));

        jBtnAnunciar.setText("Anunciar");
        jBtnAnunciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnunciarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAnunciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 183, 130, -1));

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 183, 130, -1));

        jTfIdVeiculo.setText("ID");
        getContentPane().add(jTfIdVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbVeiculosMouseClicked
        int selection = jTbVeiculos.getSelectedRow();
        
        puxarVe(selection);
    }//GEN-LAST:event_jTbVeiculosMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limparVe();
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnAnunciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnunciarActionPerformed
        anunciarVe();
    }//GEN-LAST:event_jBtnAnunciarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAnunciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAnunciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAnunciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAnunciarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAnunciarVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnunciar;
    private javax.swing.JButton jBtnLimpar;
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
