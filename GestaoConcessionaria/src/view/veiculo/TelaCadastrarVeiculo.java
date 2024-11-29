package view.veiculo;

import dao.VeiculoDao;
import javax.swing.JOptionPane;
import model.Veiculo;
import view.TelaPrincipal;

/**
 * @author julio_busarello
 */
public class TelaCadastrarVeiculo extends javax.swing.JFrame {

    private Veiculo veiculo;

    String placa, marca, modelo, cor;
    int ano;
    double preco;

    public TelaCadastrarVeiculo() {
        initComponents();
    }

    private void limparVe() {
        jTfPlaca.setText("");
        jTfMarca.setText("");
        jTfModelo.setText("");
        jFfAno.setText("");
        jTfCor.setText("");
        jTfPreco.setText("");

        //telaAnunciar(false);
    }

    private void pegarDados() {
        this.placa = jTfPlaca.getText();
        this.marca = jTfMarca.getText();
        this.modelo = jTfModelo.getText();
        this.ano = Integer.parseInt(jFfAno.getText());
        this.cor = jTfCor.getText();
        this.preco = Double.parseDouble(jTfPreco.getText());
    }

    private boolean camposNaoPreenchidos() {
        return jTfPlaca.getText().isBlank() || jTfMarca.getText().isBlank() || jTfModelo.getText().isBlank() || jFfAno.getText().isBlank() || jTfCor.getText().isBlank() || jTfPreco.getText().isBlank();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtnCadastro = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jTfPlaca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTfModelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTfCor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTfPreco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jFfAno = new javax.swing.JFormattedTextField();
        jTfMarca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Veículo");
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/car.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 400));

        jLabel6.setText("Placa:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE VEÍCULO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 14, 300, -1));

        jBtnCadastro.setText("Cadastrar");
        jBtnCadastro.setMaximumSize(new java.awt.Dimension(76, 22));
        jBtnCadastro.setMinimumSize(new java.awt.Dimension(76, 22));
        jBtnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 230, -1));

        jLabel7.setText("Marca:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));
        getContentPane().add(jTfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 230, -1));

        jLabel8.setText("Modelo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel9.setText("Ano:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));
        getContentPane().add(jTfCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 230, -1));

        jLabel10.setText("Cor:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));
        getContentPane().add(jTfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 230, -1));

        jLabel11.setText("Preço:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        try {
            jFfAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 230, -1));
        getContentPane().add(jTfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 230, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jBtnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastroActionPerformed
        if (camposNaoPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
            return;
        }

        pegarDados();

        VeiculoDao dao = new VeiculoDao();
        veiculo = new Veiculo(placa, marca, modelo, cor, ano, preco);
        dao.cadastrar(veiculo);
        limparVe();
    }//GEN-LAST:event_jBtnCadastroActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        limparVe();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastrarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastro;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JFormattedTextField jFfAno;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTfCor;
    private javax.swing.JTextField jTfMarca;
    private javax.swing.JTextField jTfModelo;
    private javax.swing.JTextField jTfPlaca;
    private javax.swing.JTextField jTfPreco;
    // End of variables declaration//GEN-END:variables
}
