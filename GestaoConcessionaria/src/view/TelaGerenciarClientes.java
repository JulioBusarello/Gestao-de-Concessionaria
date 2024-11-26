package view;

import dao.ClienteDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 * @author julio_busarello
 */
public class TelaGerenciarClientes extends javax.swing.JFrame {

    private ClienteDao clienteDao = new ClienteDao();

    public TelaGerenciarClientes() {
        initComponents();
        loadCli();
        telaGerenciar(false);
    }

    public void telaGerenciar(boolean ativo) {
        jTfIdCliente.setVisible(false);

        jBtnSalvar.setEnabled(ativo);
        jBtnExcluir.setEnabled(ativo);
        jBtnLimpar.setEnabled(ativo);
    }

    public void loadCli() {
        DefaultTableModel defaultCli = new DefaultTableModel(new Object[]{
            "ID",
            "Nome",
            "Data de Nascimento",
            "Telefone",
            "Genero"
        }, 0);

        List<Cliente> clientes = clienteDao.getAllClientes();
        for (Cliente cliente : clientes) {
            Object linha[] = new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getDataNascimento(),
                cliente.getTelefone(),
                cliente.getGenero()};
            defaultCli.addRow(linha);
        }
        jTbClientes.setModel(defaultCli);
        jTbClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
    }

    public void puxarCli(int selection) {
        try {
            String[] data = jTbClientes.getValueAt(selection, 2).toString().split("-");

            jTfIdCliente.setText(jTbClientes.getValueAt(selection, 0).toString());
            jTfNome.setText(jTbClientes.getValueAt(selection, 1).toString());
            jTfDia.setText(data[2]);
            jTfMes.setText(data[1]);
            jTfAno.setText(data[0]);
            jFfTelefone.setText(jTbClientes.getValueAt(selection, 3).toString());
            jCbGenero.setSelectedItem(jTbClientes.getValueAt(selection, 4));
            
            telaGerenciar(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limparCli() {
        jTfIdCliente.setText("");
        jTfNome.setText("");
        jTfDia.setText("");
        jTfMes.setText("");
        jTfAno.setText("");
        jFfTelefone.setText("");
        jTbClientes.clearSelection();
        jCbGenero.setSelectedIndex(0);
        
        telaGerenciar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTfIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFfTelefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jCbGenero = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbClientes = new javax.swing.JTable();
        jTfDia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTfMes = new javax.swing.JTextField();
        jTfAno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLaSeta = new javax.swing.JLabel();
        jBtnLimpar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Clientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GERENCIAMENTO DE CLIENTES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, -1));

        jTfIdCliente.setText("ID");
        getContentPane().add(jTfIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, -1));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));
        getContentPane().add(jTfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 300, -1));

        jLabel3.setText("Data de Nascimento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel4.setText("Telefone:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        try {
            jFfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 300, -1));

        jLabel5.setText("Genero:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jCbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um Genero", "Masculino", "Feminino" }));
        getContentPane().add(jCbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, -1));

        jTbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "Telefone", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbClientes.getTableHeader().setReorderingAllowed(false);
        jTbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 254, 588, 140));
        getContentPane().add(jTfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 78, -1));

        jLabel7.setText("Dia:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 78, -1));

        jLabel8.setText("Mês:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 78, -1));
        getContentPane().add(jTfMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 80, -1));
        getContentPane().add(jTfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 120, -1));

        jLabel9.setText("Ano:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 78, -1));

        jLaSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/seta.png"))); // NOI18N
        jLaSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLaSetaMouseClicked(evt);
            }
        });
        getContentPane().add(jLaSeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jBtnExcluir.setText("Excluir");
        getContentPane().add(jBtnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jBtnSalvar.setText("Salvar");
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLaSetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLaSetaMouseClicked
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        tela.telaFuncionario();
    }//GEN-LAST:event_jLaSetaMouseClicked

    private void jTbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbClientesMouseClicked
        int linha = jTbClientes.getSelectedRow();
        if (linha != -1) {
            puxarCli(linha);
        }
    }//GEN-LAST:event_jTbClientesMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limparCli();
    }//GEN-LAST:event_jBtnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCbGenero;
    private javax.swing.JFormattedTextField jFfTelefone;
    private javax.swing.JLabel jLaSeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbClientes;
    private javax.swing.JTextField jTfAno;
    private javax.swing.JTextField jTfDia;
    private javax.swing.JTextField jTfIdCliente;
    private javax.swing.JTextField jTfMes;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
