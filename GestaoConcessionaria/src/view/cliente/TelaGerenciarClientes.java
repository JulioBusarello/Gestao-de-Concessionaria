package view.cliente;

import dao.ClienteDao;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.TelaPrincipal;

/**
 * @author julio_busarello
 */

public class TelaGerenciarClientes extends javax.swing.JFrame {

    private ClienteDao clienteDao = new ClienteDao();

    private Long id;
    private String nome, telefone, ano, mes, dia, genero;
    private Date dataNascimento;

    private TelaCadastroCliente dataConverter = new TelaCadastroCliente();

    public TelaGerenciarClientes() {
        initComponents();
        loadCli();
        telaGerenciar(false);
    }

    private void telaGerenciar(boolean ativo) {
        jTfIdCliente.setVisible(false);
        jBtnSalvar.setEnabled(false);

        jBtnExcluir.setEnabled(ativo);
        jBtnLimpar.setEnabled(ativo);

        jTfNome.setEnabled(ativo);
        jFfDia.setEnabled(ativo);
        jFfMes.setEnabled(ativo);
        jFfAno.setEnabled(ativo);
        jFfTelefone.setEnabled(ativo);
        jCbGenero.setEnabled(ativo);
    }

    private void loadCli() {
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
        jTbClientes.setDefaultEditor(Object.class, null);
    }

    private void pegarDados() {
        this.id = Long.parseLong(jTfIdCliente.getText());
        this.nome = jTfNome.getText();
        this.telefone = jFfTelefone.getText();
        this.ano = jFfAno.getText();
        this.mes = jFfMes.getText();
        this.dia = jFfDia.getText();
        this.genero = (String) jCbGenero.getSelectedItem();
        this.dataNascimento = dataConverter.converterParaData(ano, mes, dia);
    }

    private void mostrarDados(int selection) {
        String[] data = jTbClientes.getValueAt(selection, 2).toString().split("-");

        jTfIdCliente.setText(jTbClientes.getValueAt(selection, 0).toString());
        jTfNome.setText(jTbClientes.getValueAt(selection, 1).toString());
        jFfDia.setText(data[2]);
        jFfMes.setText(data[1]);
        jFfAno.setText(data[0]);
        jFfTelefone.setText(jTbClientes.getValueAt(selection, 3).toString());
        jCbGenero.setSelectedItem(jTbClientes.getValueAt(selection, 4));

        telaGerenciar(true);
    }

    private void limparCli() {
        jTfIdCliente.setText("");
        jTfNome.setText("");
        jFfDia.setText("");
        jFfMes.setText("");
        jFfAno.setText("");
        jFfTelefone.setText("");
        jTbClientes.clearSelection();
        jCbGenero.setSelectedIndex(0);

        telaGerenciar(false);
    }

    private void deletarCli() {
        Long idCli = Long.parseLong(jTfIdCliente.getText());

        int optDel = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Cliente?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optDel == JOptionPane.YES_NO_OPTION) {
            clienteDao.deleteCliente(idCli);
            loadCli();
        }
        telaGerenciar(false);
    }

    private void salvarCli() {
        pegarDados();

        if (camposNaoPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido!");
            return;
        }

        if (dataNascimento == null) {
            JOptionPane.showMessageDialog(null, "A data inserida é inválida!");
            return;
        }

        if (genero.equals("Escolha um Genero")) {
            JOptionPane.showMessageDialog(null, "Escolha um gênero válido!");
            return;
        }

        int optSav = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alterações deste cliente?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (optSav == JOptionPane.YES_NO_OPTION) {
            ClienteDao dao = new ClienteDao();
            Cliente cliente = new Cliente(id, nome, dataNascimento, telefone, genero);
            dao.updateCliente(cliente);
        }

        limparCli();
        loadCli();
    }

    private boolean camposNaoPreenchidos() {
        return jTfNome.getText().isBlank() || jFfAno.getText().isBlank() || jFfDia.getText().isBlank() || jFfMes.getText().isBlank() || jFfTelefone.getText().isBlank();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaSeta = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBtnLimpar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jFfAno = new javax.swing.JFormattedTextField();
        jFfDia = new javax.swing.JFormattedTextField();
        jFfMes = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Clientes");
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
        jLabel2.setText("GERENCIAMENTO DE CLIENTES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, -1));

        jTfIdCliente.setText("ID");
        getContentPane().add(jTfIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, -1));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jTfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeKeyReleased(evt);
            }
        });
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

        jLabel7.setText("Dia:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 78, -1));

        jLabel8.setText("Mês:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 78, -1));

        jLabel9.setText("Ano:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 78, -1));

        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        try {
            jFfAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFfAnoKeyReleased(evt);
            }
        });
        getContentPane().add(jFfAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 120, -1));

        try {
            jFfDia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFfDiaKeyReleased(evt);
            }
        });
        getContentPane().add(jFfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 80, -1));

        try {
            jFfMes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFfMesKeyReleased(evt);
            }
        });
        getContentPane().add(jFfMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbClientesMouseClicked
        int linha = jTbClientes.getSelectedRow();
        if (linha != -1) {
            mostrarDados(linha);
        }
    }//GEN-LAST:event_jTbClientesMouseClicked

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limparCli();
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        deletarCli();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        pegarDados();

        salvarCli();
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jTfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfNomeKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTfNomeKeyReleased

    private void jFfDiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFfDiaKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jFfDiaKeyReleased

    private void jFfMesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFfMesKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jFfMesKeyReleased

    private void jFfAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFfAnoKeyReleased
        if (camposNaoPreenchidos()) {
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jFfAnoKeyReleased

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
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JFormattedTextField jFfAno;
    private javax.swing.JFormattedTextField jFfDia;
    private javax.swing.JFormattedTextField jFfMes;
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
    private javax.swing.JTextField jTfIdCliente;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
