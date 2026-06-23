
package telas.usuarios;

import database.UsuarioDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Frame;
import java.awt.Window;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelo.Usuario;
import telas.Login;
import util.Criptografia;
import util.EstiloGlobal;
import util.Sessao;


public class CriarUsuarios extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CriarUsuarios.class.getName());
    
    private Usuario usuarioEdicao = null;
    private final int tipoFuncao; 
            
    public CriarUsuarios(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Criar Usuários");
        this.tipoFuncao = 0;
        
        initComponents();
        arrumarComboBox();

    }
    
    public CriarUsuarios(Frame parent, boolean modal, Usuario user) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Modificar Usuários");
        this.usuarioEdicao = user;
        this.tipoFuncao = 1;
        
        initComponents();
        arrumarComboBox();
        arrumarTextoMod();
        
        // Tira qualquer tamanho herdado do initComponents do Criar
        this.setPreferredSize(null);
        this.setMinimumSize(null);
        this.setMaximumSize(null);
        
        // Pega todos os elementos, empacota eles e calcula o espaço dele
        this.pack();
        
        // Arruma a tela para ficar centralizada
        this.setLocationRelativeTo(null);
        
        // Se a permissão da sessão do usuário não for de adminstrador, impede ele de modificar
        if(Sessao.permissao != 1) {
            comboBoxPermissao.setEnabled(false);
        }   
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

        txtCriarUsuarios.setBackground(new java.awt.Color(102, 102, 102));
        txtCriarUsuarios.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtCriarUsuarios.setForeground(new java.awt.Color(230, 230, 230));
        txtCriarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCriarUsuarios.setText("Criar Usuários");

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

        txtLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(220, 220, 220));
        txtLogin.setText("Coloque o seu Login:");

        campoTextoLogin.setBackground(java.awt.Color.gray);
        campoTextoLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoTextoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoLoginKeyReleased(evt);
            }
        });

        txtContadorLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorLogin.setForeground(new java.awt.Color(200, 200, 200));
        txtContadorLogin.setText("0/50");

        txtApelido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtApelido.setForeground(new java.awt.Color(220, 220, 220));
        txtApelido.setText("Coloque o seu apelido:");

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

        txtSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(220, 220, 220));
        txtSenha.setText("Coloque a sua senha:");

        campoSenha.setBackground(java.awt.Color.gray);
        campoSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        txtConfirmarSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtConfirmarSenha.setForeground(new java.awt.Color(220, 220, 220));
        txtConfirmarSenha.setText("Confirme a sua senha:");

        campoConfirmarSenha.setBackground(java.awt.Color.gray);
        campoConfirmarSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        txtPermissao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPermissao.setForeground(new java.awt.Color(220, 220, 220));
        txtPermissao.setText("Selecione a permissão:");

        comboBoxPermissao.setBackground(new java.awt.Color(60, 60, 60));
        comboBoxPermissao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxPermissao.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPermissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));
        comboBoxPermissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxPermissaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxPermissaoFocusLost(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 110, 0));
        btnSalvar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(240, 240, 240));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setBackground(new java.awt.Color(40, 40, 40));
        btnCancelar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(230, 230, 230));
        btnCancelar.setText("Cancelar");
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
        int tamMinimo = 5;
        
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
        else if(tamanho > 0 && tamanho < tamMinimo) {
            // Deixa com a cor vermelha
            txtContadorLogin.setForeground(new Color(209,30,51));
        }
        else {
            // Se tiver dentro do limite, deixa na cor normal do texto
            txtContadorLogin.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoTextoLoginKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tipoFuncao == 1) {
            modificar(usuarioEdicao);
        }
        else {
            cadastrar();
        }
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
        int tamMinimo = 5;
        
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
        else if(tamanho > 0 && tamanho < tamMinimo) {
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
                CriarUsuarios dialog = new CriarUsuarios(new javax.swing.JFrame(), true);
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

    private void cadastrar() {
        String strLogin = campoTextoLogin.getText().trim();
        String strApelido = campoTextoApelido.getText().trim();
        
        int tamSenha = campoSenha.getPassword().length;
        boolean senhasDiferentes = !Arrays.equals(campoSenha.getPassword(), campoConfirmarSenha.getPassword());
        
        // Guard Clausures: Retorna logo o resultado para evitar aninhamento
        
        // Caso o login ou o apelido esteja vazio
        if(strLogin.equals("") || strApelido.equals("")) {
            JOptionPane.showMessageDialog(this, "O login e/ou apelido não podem estar vazio!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Caso o login ou o apelido seja menor do que 5 
        if(strLogin.length() < 5 || strApelido.length() < 5) {
            JOptionPane.showMessageDialog(this, "O login e/ou apelido precisam ter pelo menos 5 caracteres!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Senha vazia
        if(tamSenha == 0) {
            JOptionPane.showMessageDialog(this, "A senha não pode ser vazia!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Senha fraca
        if(tamSenha < 8) {
            JOptionPane.showMessageDialog(this, "Senha muito fraca, tem que ter oito caracteres ou mais!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Caso as senhas não baterem
        if(senhasDiferentes) {
            JOptionPane.showMessageDialog(this, "As senhas não são iguais!!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        } 

        // Pega o texto do campo de texto
        String login = campoTextoLogin.getText();
        String apelido = campoTextoApelido.getText();

        try {
            // Cria o objeto do DAO, busca o login no DAO
            UsuarioDAO dao = new UsuarioDAO();

            // Se não existir, cria o objeto de Usuario e insere o login
            if (dao.verificarCadastro(login)) {
                JOptionPane.showMessageDialog(this, "Erro, esse usuário já está cadastrado!!", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Usuario user = new Usuario();
            user.setLogin(login);
            user.setApelido(apelido);

            // Criptografa a senha e se a senha não for vazia, bota a senha
            Criptografia crip = new Criptografia();
            String senha = crip.criptografar(campoSenha.getPassword());

            user.setSenha(senha);
            
            // Index == 0? Sim, Usuario; Não, Adminstrador
            int permissao = comboBoxPermissao.getSelectedIndex() == 0 ? 0 : 1;

            user.setPermissao(permissao);

            // Cadastra o usuário
            dao.cadastrar(user);

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
            campoTextoLogin.setText("");
            campoTextoApelido.setText("");
            campoSenha.setText("");
            campoConfirmarSenha.setText("");
        } 

        catch (Exception e) {
            //Não conseguiu cadastrar
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificar(Usuario u) {
        int resposta;
        int usuLogado = -1;
        if(u.getId() == Sessao.idUsuario) {
            resposta = JOptionPane.showConfirmDialog(this, "Você deseja realmente modificar o seu usuário?", 
                "Confirmar Alteração...", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            // É o usuario logado
            usuLogado = 1;
        }
        else {
            resposta = JOptionPane.showConfirmDialog(this, "Você deseja realmente modificar esse usuário?", 
                "Confirmar Alteração...", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            // Não é o usuario logado
            usuLogado = 0;
        }
        
        
        if(resposta == JOptionPane.YES_OPTION) {
            String strLogin = campoTextoLogin.getText().trim();
            String strApelido = campoTextoApelido.getText().trim();
            int tamSenha = campoSenha.getPassword().length;
            int tamC = campoConfirmarSenha.getPassword().length;
            boolean senhasDiferentes = !Arrays.equals(campoSenha.getPassword(), campoConfirmarSenha.getPassword());
            
             // Se o tamanho for maior do que cinco
            if(strLogin.length() < 5) {
                JOptionPane.showMessageDialog(this, "O login não pode estar vazio e nem ter menos do que cinco caracteres!!",
                        "Aviso!",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Se o apelido tiver menos do que cinco caracteres ou estiver vazio
            if(strApelido.length() < 5) {
                JOptionPane.showMessageDialog(this, "O apelido não pode estar vazio e nem ter menos do que cinco caracteres!!",
                        "Aviso!", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Se tiver coisa nos campos de senha, significa que quer trocar a senha
            if(tamSenha != 0 || tamC != 0) {
                if(tamSenha < 8) {
                    JOptionPane.showMessageDialog(this, "Senha muito fraca, tem que ter oito caracteres ou mais!!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(senhasDiferentes) {
                    JOptionPane.showMessageDialog(this, "As senhas não são iguais!!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
                
            try {
                Usuario usuario = u;
                UsuarioDAO dao = new UsuarioDAO();
                
                if(dao.verificarAdmins() && comboBoxPermissao.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(this, "Erro!!\nVocê não pode modificar a sua permissão enquanto não haver mais de um administrador ativo!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Se não for igual o que ele digitou
                if(!strLogin.equals(usuario.getLogin())) {
                    usuario.setLogin(strLogin);
                }
                
                // Se não for igual o que ele digitou
                if(!strApelido.equals(usuario.getApelido())) {
                    usuario.setApelido(strApelido);
                }
                
                if(tamSenha != 0) {
                    Criptografia crip = new Criptografia();
                    String senha = crip.criptografar(campoSenha.getPassword());
                    usuario.setSenha(senha);
                }
                
                // Passa o index direto
                usuario.setPermissao(comboBoxPermissao.getSelectedIndex());
                
                dao.modificar(usuario);
                
                if(usuLogado == 1) {
                    JOptionPane.showMessageDialog(this, "Você alterou os própios dados de acesso.\nPor segurança, faça o login novamente!!",
                            "Sessão Expirada", 
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    // Limpa a sessão do usuário
                    Sessao.limparSessao();
                    
                    // Percorre todas as telas abertas e fecha elas
                    for (Window janela : Window.getWindows()) {
                        janela.dispose();
                    }

                    // Instancia o login sem passar para uma variável.
                    // Como não vamos passar mais propiedades para ela (setTitle, setLocation...)
                    // podemos chamar assim
                    new Login().setVisible(true);
                    }
                else {
                    JOptionPane.showMessageDialog(this, "Usuário modificado com sucesso!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void arrumarTextoMod() {
        txtCriarUsuarios.setText("Modificar Usuários");
        
        txtLogin.setText("Coloque o novo login:");
        campoTextoLogin.setText(usuarioEdicao.getLogin());
        
        txtApelido.setText("Coloque o novo apelido:");
        campoTextoApelido.setText(usuarioEdicao.getApelido());
        
        txtSenha.setText("Coloque a nova senha (Vazia = Sem modificação):");
        txtConfirmarSenha.setText("Confirme a nova senha:");
        
        txtPermissao.setText("Coloque a nova permissão:");
        
        switch(usuarioEdicao.getPermissao()) {
            case 0 -> comboBoxPermissao.setSelectedIndex(0);
            case 1 -> comboBoxPermissao.setSelectedIndex(1);
        }
        btnSalvar.setText("Modificar");
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
