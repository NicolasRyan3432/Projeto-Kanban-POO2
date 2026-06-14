
package telas.usuarios;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import util.EstiloGlobal;


public class CriarUsuarios extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CriarUsuarios.class.getName());


    public CriarUsuarios(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Criar Usuários");

        initComponents();
        arrumarComboBox();

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtCriarUsuarios = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtLogin = new javax.swing.JLabel();
        campoTextoLogin = new javax.swing.JTextField();
        txtContadorLogin = new javax.swing.JLabel();
        txtApelido = new javax.swing.JLabel();
        campoTextoApelido = new javax.swing.JTextField();
        txtContadorApelido = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha = new javax.swing.JLabel();
        campoConfirmarSenha = new javax.swing.JPasswordField();
        txtPermissao = new javax.swing.JLabel();
        comboBoxPermissao = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chkBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(700, 830));
        setPreferredSize(new java.awt.Dimension(700, 830));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(130, 130, 130));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCriarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCriarUsuarios.setText("Criar Usuários");
        txtCriarUsuarios.setBackground(new java.awt.Color(102, 102, 102));
        txtCriarUsuarios.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtCriarUsuarios.setForeground(new java.awt.Color(230, 230, 230));

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelDados.setBackground(new java.awt.Color(51, 51, 51));
        painelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtLogin.setText("Coloque o seu Login:");
        txtLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(220, 220, 220));

        campoTextoLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoTextoLogin.setBackground(java.awt.Color.gray);
        campoTextoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoLoginKeyReleased(evt);
            }
        });

        txtContadorLogin.setText("0/50");
        txtContadorLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorLogin.setForeground(new java.awt.Color(200, 200, 200));

        txtApelido.setText("Coloque o seu apelido:");
        txtApelido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtApelido.setForeground(new java.awt.Color(220, 220, 220));

        campoTextoApelido.setBackground(java.awt.Color.gray);
        campoTextoApelido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoTextoApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoApelidoKeyReleased(evt);
            }
        });

        txtContadorApelido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorApelido.setForeground(new java.awt.Color(200, 200, 200));
        txtContadorApelido.setText("0/50");

        txtSenha.setText("Coloque a sua senha:");
        txtSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(220, 220, 220));

        campoSenha.setBackground(java.awt.Color.gray);
        campoSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        txtConfirmarSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtConfirmarSenha.setForeground(new java.awt.Color(220, 220, 220));
        txtConfirmarSenha.setText("Confirme a sua senha:");

        campoConfirmarSenha.setBackground(java.awt.Color.gray);
        campoConfirmarSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        txtPermissao.setText("Selecione a sua permissão:");
        txtPermissao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPermissao.setForeground(new java.awt.Color(220, 220, 220));

        comboBoxPermissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));
        comboBoxPermissao.setBackground(new java.awt.Color(60, 60, 60));
        comboBoxPermissao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxPermissao.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPermissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxPermissaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxPermissaoFocusLost(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setBackground(new java.awt.Color(0, 110, 0));
        btnSalvar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(240, 240, 240));
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(40, 40, 40));
        btnCancelar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(230, 230, 230));
        btnCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnCancelarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnCancelarFocusLost(evt);
            }
        });
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        chkBox.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        chkBox.setForeground(new java.awt.Color(220, 220, 220));
        chkBox.setText("Mostrar Senha");
        chkBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chkBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                chkBoxFocusLost(evt);
            }
        });
        chkBox.addActionListener(this::chkBoxActionPerformed);
        chkBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chkBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(29, 29, 29))
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPermissao)
                    .addComponent(txtLogin)
                    .addComponent(txtApelido)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtContadorLogin)
                            .addComponent(campoTextoLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(campoTextoApelido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContadorApelido)
                            .addComponent(campoSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoConfirmarSenha, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(54, 54, 54)
                        .addComponent(chkBox)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtLogin)
                .addGap(18, 18, 18)
                .addComponent(campoTextoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadorLogin)
                .addGap(28, 28, 28)
                .addComponent(txtApelido)
                .addGap(18, 18, 18)
                .addComponent(campoTextoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadorApelido)
                .addGap(28, 28, 28)
                .addComponent(txtSenha)
                .addGap(18, 18, 18)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtConfirmarSenha)
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkBox))
                .addGap(28, 28, 28)
                .addComponent(txtPermissao)
                .addGap(18, 18, 18)
                .addComponent(comboBoxPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(82, 82, 82))
        );

        getContentPane().add(painelDados, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
      
    private void campoTextoLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoLoginKeyReleased
        // Limite de caracteres lá no banco
        int limite = 50;
        
        // Pega o quê o usuário digitou e vê o tamanho
        String texto = campoTextoLogin.getText();
        int tamanho = texto.length();
        
        // Atualiza o número na tela em tempo real
        txtContadorLogin.setText(tamanho + " / " + limite);
        
        // Caso o usuário digite a mais do que o limite
        if(tamanho >= limite) {
            // Arranca o texto que ele pôs a mais a força
            campoTextoLogin.setText(texto.substring(0, limite));
            
            // Seta o contador como limite/limite = 50/50
            txtContadorLogin.setText(limite + " / " + limite);
            
            // Deixa com a cor vermelha
            txtContadorLogin.setForeground(new Color(209,30,51));
        }
        else {
            // Se tiver dentro do limite, deixa na cor normal do texto
            txtContadorLogin.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoTextoLoginKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Não salva ainda pq n tem funçao
        JOptionPane.showConfirmDialog(this, "Botão salvar clicado, pena q n temos salvar ainda :(");
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboBoxPermissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxPermissaoFocusGained
        // Com foco o enter serve pra poder selecionar a prioridade
        // além do espaço que por padrão serve pra selecionar checkbox e comboobox
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_comboBoxPermissaoFocusGained

    private void comboBoxPermissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxPermissaoFocusLost
        // Sem o foco, o botão padrão volta a ser o de salvar
        this.getRootPane().setDefaultButton(btnSalvar);
    }//GEN-LAST:event_comboBoxPermissaoFocusLost

    private void campoTextoApelidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoApelidoKeyReleased
        // Limite de caracteres lá no banco
        int limite = 50;
        
        // Pega o quê o usuário digitou e vê o tamanho
        String texto = campoTextoApelido.getText();
        int tamanho = texto.length();
        
        // Atualiza o número na tela em tempo real
        txtContadorApelido.setText(tamanho + " / " + limite);
        
        // Caso o usuário digite a mais do que o limite
        if(tamanho >= limite) {
            // Arranca o texto que ele pôs a mais a força
            txtContadorApelido.setText(texto.substring(0, limite));
            
            // Seta o contador como limite/limite = 50/50
            txtContadorApelido.setText(limite + " / " + limite);
            
            // Deixa com a cor vermelha
            txtContadorApelido.setForeground(new Color(209,30,51));
        }
        else {
            // Se tiver dentro do limite, deixa na cor normal do texto
            txtContadorApelido.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoTextoApelidoKeyReleased

    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        if(chkBox.isSelected()) {
            campoSenha.setEchoChar((char) 0);
            campoConfirmarSenha.setEchoChar((char) 0);
        }
        else {
            campoSenha.setEchoChar('*');
            campoConfirmarSenha.setEchoChar('*');
        }    
    }//GEN-LAST:event_chkBoxActionPerformed

    private void chkBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chkBoxKeyPressed
        // Enter chama o ActionPerformed.
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            chkBox.doClick();
        }
    }//GEN-LAST:event_chkBoxKeyPressed

    private void chkBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chkBoxFocusGained
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_chkBoxFocusGained

    private void chkBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chkBoxFocusLost
        this.getRootPane().setDefaultButton(btnSalvar);
    }//GEN-LAST:event_chkBoxFocusLost

    private void btnCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCancelarFocusGained
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_btnCancelarFocusGained

    private void btnCancelarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCancelarFocusLost
        this.getRootPane().setDefaultButton(btnSalvar);
    }//GEN-LAST:event_btnCancelarFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EstiloGlobal.aplicarTema();
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CriarUsuarios dialog = new CriarUsuarios(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    private void arrumarComboBox() {
        // Pinta a "caixa" principal (quando ele está fechado)
        comboBoxPermissao.setBackground(new java.awt.Color(30, 30, 30));
        comboBoxPermissao.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPermissao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(51, 51, 51), 2));

        // Pinta a "listinha" (Dropdown) que cai quando clica
        comboBoxPermissao.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Seta uma borda para dar espaçamento nos items
                setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));

                if (isSelected) {
                    // Cor do "Hover" (Quando o mouse passa em cima)
                    c.setBackground(new Color(0, 100, 0)); 
                    c.setForeground(new Color(230, 230, 230));

                } 
                else {
                    // Cor do fundo normal escuro
                    c.setBackground(new Color(65, 65, 65)); 
                    c.setForeground(new Color(230, 230, 230));
                }
                return c;
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPasswordField campoConfirmarSenha;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoTextoApelido;
    private javax.swing.JTextField campoTextoLogin;
    private javax.swing.JCheckBox chkBox;
    private javax.swing.JComboBox<String> comboBoxPermissao;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtApelido;
    private javax.swing.JLabel txtConfirmarSenha;
    private javax.swing.JLabel txtContadorApelido;
    private javax.swing.JLabel txtContadorLogin;
    private javax.swing.JLabel txtCriarUsuarios;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtPermissao;
    private javax.swing.JLabel txtSenha;
    // End of variables declaration//GEN-END:variables
}
