package view.veiculo;

import dao.ClienteDao;
import dao.VeiculoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import view.TelaPrincipal;

/**
 * @author julio
 */

public class TelaGerenciarVeiculo extends javax.swing.JFrame {

    private final VeiculoDao veiculoDao = new VeiculoDao();
    private final ClienteDao clienteDao = new ClienteDao();

    Long id;
    String placa, marca, modelo, cor;
    int ano;
    Double preco;

    public TelaGerenciarVeiculo() {
        initComponents();
        loadVe();
        tela(false);
    }

    private void tela(boolean ativo) {
        jTfIdVeiculo.setVisible(false);

        jTfPlaca.setEnabled(ativo);
        jTfMarca.setEnabled(ativo);
        jTfModelo.setEnabled(ativo);
        jTfAno.setEnabled(ativo);
        jTfCor.setEnabled(ativo);
        jTfPreco.setEnabled(ativo);

        jBtnSalvar.setEnabled(false);
        jBtnExcluir.setEnabled(ativo);
        jBtnLimpar.setEnabled(ativo);
    }

    private void loadVe() {
        DefaultTableModel defaultVe = new DefaultTableModel(new Object[]{
            "ID",
            "Placa",
            "Marca",
            "Modelo",
            "Ano",
            "Cor",
            "Preço",
            "Anunciado",
            "Nome Dono"
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
                veiculo.hasDono() ? clienteDao.getById(veiculo.getId_cliente()).getNome() : "Sem dono",
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
        tela(false);
    }

    private void mostrarDados(int selection) {
        jTfIdVeiculo.setText(jTbVeiculos.getValueAt(selection, 0).toString());

        jTfPlaca.setText(jTbVeiculos.getValueAt(selection, 1).toString());
        jTfMarca.setText(jTbVeiculos.getValueAt(selection, 2).toString());
        jTfModelo.setText(jTbVeiculos.getValueAt(selection, 3).toString());
        jTfAno.setText(jTbVeiculos.getValueAt(selection, 4).toString());
        jTfCor.setText(jTbVeiculos.getValueAt(selection, 5).toString());
        jTfPreco.setText(jTbVeiculos.getValueAt(selection, 6).toString());

        tela(true);
    }

    private void pegarDados() {
        this.id = Long.valueOf(jTfIdVeiculo.getText());
        this.placa = jTfPlaca.getText();
        this.marca = jTfMarca.getText();
        this.modelo = jTfModelo.getText();
        this.ano = Integer.parseInt(jTfAno.getText());
        this.cor = jTfCor.getText();
        this.preco = Double.valueOf(jTfPreco.getText());
    }

    private void salvarVe() {
        pegarDados();

        if (camposNaoPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido!");
            return;
        }

        int optSav = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alterações deste Veículo?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optSav == JOptionPane.YES_NO_OPTION) {
            VeiculoDao dao = new VeiculoDao();
            Veiculo veiculo = new Veiculo(id, placa, marca, modelo, cor, ano, preco);
            dao.editarVeiculo(veiculo);
        }

        limparVe();
        loadVe();
    }
    
    private boolean camposNaoPreenchidos(){
        return jTfPlaca.getText().isBlank() || jTfMarca.getText().isBlank() || jTfModelo.getText().isBlank() || jTfAno.getText().isBlank() || jTfCor.getText().isBlank() || jTfPreco.getText().isBlank();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
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
        jBtnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Veículos");
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(null);
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

        jTfPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPlacaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 170, -1));

        jLabel1.setText("Placa:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jTfIdVeiculo.setText("ID");
        getContentPane().add(jTfIdVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, -1));

        jLabel3.setText("Marca:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jTfMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfMarcaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, -1));

        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jTfModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfModeloKeyReleased(evt);
            }
        });
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

        jTfAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfAnoKeyReleased(evt);
            }
        });
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 170, -1));

        jTfCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCorKeyReleased(evt);
            }
        });
        getContentPane().add(jTfCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, -1));

        jTfPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPrecoKeyReleased(evt);
            }
        });
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

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 110, -1));

        jTbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Marca", "Modelo", "Ano", "Cor", "Preço", "Anunciado", "Nome Dono"
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
        jTbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbVeiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 680, 170));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        salvarVe(); 
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        Long idVe = Long.valueOf(jTfIdVeiculo.getText());

        int optDel = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Veículo?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optDel == JOptionPane.YES_NO_OPTION) {
            veiculoDao.deleteVeiculo(idVe);
            loadVe();
        }
        limparVe();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limparVe();
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jTbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbVeiculosMouseClicked
        int linha = jTbVeiculos.getSelectedRow();
        if (linha != -1) {
            mostrarDados(linha);
        }
    }//GEN-LAST:event_jTbVeiculosMouseClicked

    private void jTfPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPlacaKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfPlacaKeyReleased

    private void jTfMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfMarcaKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfMarcaKeyReleased

    private void jTfModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfModeloKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfModeloKeyReleased

    private void jTfAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfAnoKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfAnoKeyReleased

    private void jTfCorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCorKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfCorKeyReleased

    private void jTfPrecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPrecoKeyReleased
        if(camposNaoPreenchidos()){
            jBtnSalvar.setEnabled(false);
        } else{
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfPrecoKeyReleased

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
    private javax.swing.JButton jBtnLimpar;
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
