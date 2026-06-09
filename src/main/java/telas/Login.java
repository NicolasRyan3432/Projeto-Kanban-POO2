
package telas;
import database.Conexao;
import javax.swing.JOptionPane;
import modelo.Usuario;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private Usuario user;
    
    public Login() {
        // Seta a FiraCode Nerd Font Regular como padrão do aplicativo
        try {
            // 1. Lê o arquivo da fonte que está embutido no seu .jar
            java.io.InputStream is = getClass().getResourceAsStream("/fonts/FiraCode-Regular.ttf");

            // 2. Cria a fonte na memória do Java
            java.awt.Font fonteFira = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);

            // 3. A MÁGICA: Registra a fonte no Ambiente Gráfico do PC do usuário!
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fonteFira);

        } 
        catch (FontFormatException | IOException e) {
            System.out.println("Erro ao carregar a fonte: " + e.getMessage());
        }
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Projeto Kanban");
        
        /*
            Seta o botãoEntrar como o botão padrão da tela, então, ao clicar no ENTER, o código
            ativa a função que o botãoEntrar faz.
            Por convenção (o CheckBox ser marcado também com o enter), movi para caso o CheckBox esteja focalizado
            (com o focus em cima dele usando tabulação), o padrão pra ativar a função de logar não seja o enter
            mas caso não esteja focado, o padrão seja o enter
            this.getRootPane().setDefaultButton(botaoEntrar);
        */ 
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JLabel();
        painelLogin = new javax.swing.JPanel();
        txtLogin = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        campoTexto = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        chkBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));

        txtTitulo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Projeto Kanban");

        txtComplemento.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtComplemento.setForeground(new java.awt.Color(235, 235, 235));
        txtComplemento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtComplemento.setText("Seja Bem-Vindo!!");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtComplemento)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelLogin.setBackground(new java.awt.Color(102, 102, 102));
        painelLogin.setMinimumSize(new java.awt.Dimension(800, 450));
        painelLogin.setPreferredSize(new java.awt.Dimension(800, 450));

        txtLogin.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(220, 220, 220));
        txtLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtLogin.setText("Login:");

        txtSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(220, 220, 220));
        txtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSenha.setText("Senha:");

        botaoEntrar.setBackground(new java.awt.Color(0, 110, 0));
        botaoEntrar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        botaoEntrar.setForeground(new java.awt.Color(230, 230, 230));
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(this::botaoEntrarActionPerformed);
        botaoEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarKeyPressed(evt);
            }
        });

        botaoSair.setBackground(new java.awt.Color(40, 40, 40));
        botaoSair.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(230, 230, 230));
        botaoSair.setText("Sair");
        botaoSair.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botaoSairFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botaoSairFocusLost(evt);
            }
        });
        botaoSair.addActionListener(this::botaoSairActionPerformed);

        campoTexto.setBackground(java.awt.Color.gray);
        campoTexto.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        campoSenha.setBackground(java.awt.Color.gray);
        campoSenha.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

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

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLoginLayout.createSequentialGroup()
                        .addComponent(txtLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLoginLayout.createSequentialGroup()
                        .addComponent(txtSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoEntrar)
                .addGap(36, 36, 36))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSair)
                    .addComponent(botaoEntrar))
                .addGap(33, 33, 33))
        );

        getContentPane().add(painelLogin, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        logar();
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        // Aqui ele checa se o checkbox está selecionado. 
        // Serve para o clique do mouse, para o enter e agora serve com o espaço.
        if(chkBox.isSelected()) {
            campoSenha.setEchoChar((char) 0);
        }
        else {
            campoSenha.setEchoChar('*');
        }
    }//GEN-LAST:event_chkBoxActionPerformed

    private void botaoEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_botaoEntrarKeyPressed

    private void chkBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chkBoxKeyPressed
        // Se o código da tecla digitada for igual ao VK_ENTER (que é a msm coisa do evt == 10, igual estava antes)
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            /* 
                Agora funciona tanto apertando o ENTER, quanto o ESPAÇO 
                (que por padrão para checkboxes e outros o espaço serve para marcar-los). 
                Agora ele chama o ActionPerformed por conta do doClick();
            */ 
            chkBox.doClick();
        }   
    }//GEN-LAST:event_chkBoxKeyPressed

    private void chkBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chkBoxFocusGained
        // Com ele focado
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_chkBoxFocusGained

    private void chkBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chkBoxFocusLost
        // Sem ele focado
        this.getRootPane().setDefaultButton(botaoEntrar);
    }//GEN-LAST:event_chkBoxFocusLost

    private void botaoSairFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botaoSairFocusGained
        // Com ele focado
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_botaoSairFocusGained

    private void botaoSairFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botaoSairFocusLost
        // Sem ele focado
        this.getRootPane().setDefaultButton(botaoEntrar);
    }//GEN-LAST:event_botaoSairFocusLost

    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
    
    public void logar() {
        // Teste de conexão, se der ruim não deixa o usuário logar
        // As coisas vão dentro do try dps
        try {
            // Vai ser substituido pela parte de conexão do banco lá com o DAO do usuário
            Conexao conexao = new Conexao();
            Connection con = conexao.abrirConexao();
            
            String senha = new String(campoSenha.getPassword());
        
            if(campoTexto.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "O login não pode estar vazio!!");
            }
            else if(campoSenha.getPassword().length < 3) {
                JOptionPane.showMessageDialog(this, "A senha não pode ter menos do que três caracteres!!");
            }
            else if(!campoTexto.getText().equals("Nicolas")) {
                JOptionPane.showMessageDialog(this, "Erro: O login está incorreto!!");
            }
            else if(!senha.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Erro: A senha está incorreta!!");
            }
            else {
                Main tela = new Main(user); 
                tela.setVisible(true);
                this.dispose();
            }
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar o sistema:\n" + e.getMessage(),
                    "Erro de Conexão!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoTexto;
    private javax.swing.JCheckBox chkBox;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtComplemento;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtSenha;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
