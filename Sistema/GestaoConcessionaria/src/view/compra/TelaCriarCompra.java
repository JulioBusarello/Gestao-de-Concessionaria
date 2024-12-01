package view.compra;

import dao.ClienteDao;
import dao.CompraDao;
import dao.VeiculoDao;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Compra;
import model.Funcionario;
import model.Veiculo;
import view.TelaPrincipal;
import static view.cliente.TelaCadastroCliente.anoAtual;

/**
 * @author julio
 */
public class TelaCriarCompra extends javax.swing.JFrame {

    String dono, placa, dia, mes, ano;
    int parcelas;
    Date data;

    private Compra compra;
    private Veiculo veiculo;
    private Cliente cliente;
    private Funcionario funcionario;

    // --- Construtor
    public TelaCriarCompra() {
        initComponents();
        limparCampos();
    }

    // --- Setter
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    // --- Métodos
    private void limparCampos() {
        jTfDono.setText("");
        jTfParcelas.setText("");
        jTfPlaca.setText("");

        jTfDia.setText("");
        jTfMes.setText("");
        jTfAno.setText("");

        jBtnConfirmar.setEnabled(false);
    }

    private Date converterParaData(String ano, String mes, String dia) {
        if (Integer.parseInt(ano) < anoAtual) {
            return null;
        }

        if (Integer.parseInt(mes) > 12 || Integer.parseInt(mes) < 1) {
            return null;
        }

        if (Integer.parseInt(dia) > 31 || Integer.parseInt(dia) < 1) {
            return null;
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date utilDate = formato.parse(ano + "/" + mes + "/" + dia);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    private void pegarDados() {
        this.dono = jTfDono.getText();
        this.placa = jTfPlaca.getText();
        try {
            this.parcelas = Integer.parseInt(jTfParcelas.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insira um número de parcelas válido!");
            return;
        }
        this.dia = jTfDia.getText();
        this.mes = jTfMes.getText();
        this.ano = jTfAno.getText();
        this.data = converterParaData(ano, mes, dia);
    }

    private boolean camposNaoPreenchidos() {
        return jTfDono.getText().isBlank() || jTfParcelas.getText().isBlank() || jTfPlaca.getText().isBlank() || jTfDia.getText().isBlank() || jTfMes.getText().isBlank() || jTfAno.getText().isBlank();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTfPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfParcelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfDono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jTfAno = new javax.swing.JTextField();
        jTfDia = new javax.swing.JTextField();
        jTfMes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criar Compra");
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

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CRIAR COMPRA VEICULAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 300, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/compra.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        jTfPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPlacaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 240, -1));

        jLabel3.setText("Placa Veículo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jTfParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfParcelasKeyReleased(evt);
            }
        });
        getContentPane().add(jTfParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 240, -1));

        jLabel4.setText("Parcelas:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        jTfDono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfDonoKeyReleased(evt);
            }
        });
        getContentPane().add(jTfDono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 240, -1));

        jLabel5.setText("Nome do Dono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel6.setText("Data da Compra:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        jLabel7.setText("Dia:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 78, 20));

        jLabel8.setText("Mês:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 78, 20));

        jLabel9.setText("Ano:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 78, 20));

        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        jTfAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfAnoKeyReleased(evt);
            }
        });
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 80, -1));

        jTfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfDiaKeyReleased(evt);
            }
        });
        getContentPane().add(jTfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 70, -1));

        jTfMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfMesKeyReleased(evt);
            }
        });
        getContentPane().add(jTfMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 70, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        pegarDados();

        veiculo = new VeiculoDao().getByPlaca(placa);
        cliente = new ClienteDao().getByNome(dono);
        
        if (camposNaoPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
            return;
        }

        if(cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return;
        }
        
        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado");
            return;
        } else if (veiculo.getId_cliente() > 0) {
            JOptionPane.showMessageDialog(null, "O veículo informado já possui dono!");
            return;
        }

        if (data == null) {
            JOptionPane.showMessageDialog(null, "A data inserida é inválida!");
            return;
        }
        
        if(veiculo != null && cliente != null){
            VeiculoDao vDao = new VeiculoDao();
            vDao.mudarDono(veiculo, cliente.getId());
        }

        CompraDao dao = new CompraDao();
        compra = new Compra(parcelas, data, veiculo, cliente, funcionario);
        dao.criarCompra(compra);
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jTfDonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfDonoKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfDonoKeyReleased

    private void jTfParcelasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfParcelasKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfParcelasKeyReleased

    private void jTfPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPlacaKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfPlacaKeyReleased

    private void jTfDiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfDiaKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfDiaKeyReleased

    private void jTfMesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfMesKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfMesKeyReleased

    private void jTfAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfAnoKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnConfirmar.setEnabled(false);
        } else {
            jBtnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfAnoKeyReleased

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
            java.util.logging.Logger.getLogger(TelaCriarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnLimpar;
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
    private javax.swing.JTextField jTfAno;
    private javax.swing.JTextField jTfDia;
    private javax.swing.JTextField jTfDono;
    private javax.swing.JTextField jTfMes;
    private javax.swing.JTextField jTfParcelas;
    private javax.swing.JTextField jTfPlaca;
    // End of variables declaration//GEN-END:variables
}
