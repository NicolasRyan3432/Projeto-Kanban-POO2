
package Telas;

import DB.NotaDAO;
import Modelo.Usuario;
import Modelo.CartaoNota;
import Modelo.Nota;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Main extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
    
    private final Usuario user;
    
    /* 
        A função Main recebe logo o usuario inteiro 
        para poder enviar o id do usuario atual para as telas: CartaoNota, CriarNotas e VisualizarNotas 
        (Que subdivide nas três funções que necessita que o id do usuário seja igual ao que fez a nota)
    */
    public Main(Usuario u) {
        // Configurações da janela
        setTitle("Painel Kanban"); // Titulo da aba
        this.setMinimumSize(new Dimension(1250, 960)); // Tamanho mínimo da tela (pra não quebrar)
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza na tela
        
        // Recebe todo o usuário que tá logado atualmente.
        this.user = u;
        
        initComponents();  //Inicia os componentes
        
        arrumarCoresMenuPopup();
        recarregarNotas();
        
        //jLabel1.setText("Seja Bem-Vindo " + user.nome);
        
        // ContentPane é o conteúdo invisível que o Swing adiciona no jFrame 
        getContentPane().setBackground(new java.awt.Color(102, 102, 102)); 
        
        // Aumenta a quantidade de pixels que a tela desce por rolagem
        painelAFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelSFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelCScroll.getVerticalScrollBar().setUnitIncrement(20);
        
        // Seta a cor escura no fundo do combobox
        comboBoxOrdenacao.setBackground(new Color(51, 51, 51));
        comboBoxOrdenacao.setForeground(new Color(220, 220, 200));

        // Seta a cor escura no menu que aparece
        comboBoxOrdenacao.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Se o mouse estiver passando por cima dos items
            if(isSelected) {
                c.setBackground(new java.awt.Color(85, 85, 85)); 
                c.setForeground(new Color(255, 255, 255));
            } 
            else {
                c.setBackground(new Color(51, 51, 51)); 
                c.setForeground(new Color(255, 255, 255));
            }
            return c;
        }
    });
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        itemCriarNotas = new javax.swing.JMenuItem();
        itemGerenciarUser = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        painelTopo = new javax.swing.JPanel();
        txtBoasVindas = new javax.swing.JLabel();
        txtTarefasUser = new javax.swing.JLabel();
        txtTarefasTotais = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        comboBoxOrdenacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        painelColunas = new javax.swing.JPanel();
        painelAF = new javax.swing.JPanel();
        painelAFTopo = new javax.swing.JPanel();
        txtAFTopo = new javax.swing.JLabel();
        painelAFScroll = new javax.swing.JScrollPane();
        painelAFNotas = new javax.swing.JPanel();
        painelSF = new javax.swing.JPanel();
        painelSFTopo = new javax.swing.JPanel();
        txtSFTopo = new javax.swing.JLabel();
        painelSFScroll = new javax.swing.JScrollPane();
        painelSFNotas = new javax.swing.JPanel();
        painelC = new javax.swing.JPanel();
        painelCTopo = new javax.swing.JPanel();
        txtCTopo = new javax.swing.JLabel();
        painelCScroll = new javax.swing.JScrollPane();
        painelCNotas = new javax.swing.JPanel();

        menuPopup.setBackground(new java.awt.Color(0, 0, 0));
        menuPopup.setForeground(new java.awt.Color(255, 102, 102));
        menuPopup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemCriarNotas.setBackground(new java.awt.Color(0, 0, 0));
        itemCriarNotas.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemCriarNotas.setForeground(java.awt.Color.lightGray);
        itemCriarNotas.setText("Criar Notas");
        itemCriarNotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        itemCriarNotas.setOpaque(true);
        itemCriarNotas.addActionListener(this::itemCriarNotasActionPerformed);
        menuPopup.add(itemCriarNotas);

        itemGerenciarUser.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemGerenciarUser.setForeground(java.awt.Color.lightGray);
        itemGerenciarUser.setText("Gerenciar Usuários");
        itemGerenciarUser.setAlignmentY(1.5F);
        itemGerenciarUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        itemGerenciarUser.setMargin(new java.awt.Insets(10, 11, 3, 11));
        itemGerenciarUser.setOpaque(true);
        menuPopup.add(itemGerenciarUser);

        Logout.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        Logout.setForeground(java.awt.Color.lightGray);
        Logout.setText("Logout");
        Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logout.setOpaque(true);
        menuPopup.add(Logout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(1250, 950));

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));

        txtBoasVindas.setBackground(new java.awt.Color(204, 204, 204));
        txtBoasVindas.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 22)); // NOI18N
        txtBoasVindas.setForeground(new java.awt.Color(230, 230, 230));
        txtBoasVindas.setText("Seja Bem-Vindo, Nícolas");

        txtTarefasUser.setBackground(new java.awt.Color(204, 204, 204));
        txtTarefasUser.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtTarefasUser.setForeground(java.awt.Color.lightGray);
        txtTarefasUser.setText("Suas Tarefas: 0");

        txtTarefasTotais.setBackground(new java.awt.Color(204, 204, 204));
        txtTarefasTotais.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtTarefasTotais.setForeground(java.awt.Color.lightGray);
        txtTarefasTotais.setText("Tarefas Totais: 0");

        btnMenu.setBackground(new java.awt.Color(80, 80, 80));
        btnMenu.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(200, 200, 200));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(this::btnMenuActionPerformed);

        comboBoxOrdenacao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maior Prioridade", "Menor Prioridade", "Prazo (Ordem Crescente)", "Prazo (Ordem Decrescente)", "Nome (Ordem Alfabética)" }));

        jLabel1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("Ordenar por:");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBoasVindas)
                    .addComponent(txtTarefasTotais)
                    .addComponent(txtTarefasUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMenu))
                .addGap(60, 60, 60))
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBoasVindas)
                    .addComponent(btnMenu))
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTarefasUser)
                        .addGap(18, 18, 18)
                        .addComponent(txtTarefasTotais)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap())))
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelColunas.setBackground(new java.awt.Color(51, 51, 51));
        painelColunas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        painelColunas.setAlignmentX(0.0F);
        painelColunas.setFocusable(false);
        painelColunas.setLayout(new java.awt.GridLayout(1, 0));

        painelAF.setBackground(new java.awt.Color(51, 51, 51));
        painelAF.setLayout(new java.awt.BorderLayout());

        painelAFTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelAFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAFTopo.setForeground(new java.awt.Color(230, 230, 230));

        txtAFTopo.setBackground(new java.awt.Color(204, 255, 51));
        txtAFTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtAFTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtAFTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAFTopo.setText("A FAZER");

        javax.swing.GroupLayout painelAFTopoLayout = new javax.swing.GroupLayout(painelAFTopo);
        painelAFTopo.setLayout(painelAFTopoLayout);
        painelAFTopoLayout.setHorizontalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelAFTopoLayout.setVerticalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAF.add(painelAFTopo, java.awt.BorderLayout.PAGE_START);

        painelAFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelAFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelAFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelAFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelAFNotas.setLayout(new javax.swing.BoxLayout(painelAFNotas, javax.swing.BoxLayout.Y_AXIS));
        painelAFScroll.setViewportView(painelAFNotas);

        painelAF.add(painelAFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelAF);

        painelSF.setBackground(new java.awt.Color(51, 51, 51));
        painelSF.setLayout(new java.awt.BorderLayout());

        painelSFTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelSFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFTopo.setForeground(new java.awt.Color(230, 230, 230));

        txtSFTopo.setBackground(new java.awt.Color(255, 102, 102));
        txtSFTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtSFTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtSFTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSFTopo.setText("SENDO FEITO");
        txtSFTopo.setAlignmentX(0.5F);

        javax.swing.GroupLayout painelSFTopoLayout = new javax.swing.GroupLayout(painelSFTopo);
        painelSFTopo.setLayout(painelSFTopoLayout);
        painelSFTopoLayout.setHorizontalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSFTopoLayout.setVerticalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelSF.add(painelSFTopo, java.awt.BorderLayout.PAGE_START);

        painelSFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelSFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelSFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelSFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelSFNotas.setLayout(new javax.swing.BoxLayout(painelSFNotas, javax.swing.BoxLayout.Y_AXIS));
        painelSFScroll.setViewportView(painelSFNotas);

        painelSF.add(painelSFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelSF);

        painelC.setBackground(new java.awt.Color(51, 51, 51));
        painelC.setLayout(new java.awt.BorderLayout());

        painelCTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelCTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCTopo.setForeground(new java.awt.Color(230, 230, 230));

        txtCTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtCTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtCTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCTopo.setText("CONCLUÍDO");

        javax.swing.GroupLayout painelCTopoLayout = new javax.swing.GroupLayout(painelCTopo);
        painelCTopo.setLayout(painelCTopoLayout);
        painelCTopoLayout.setHorizontalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCTopoLayout.setVerticalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelC.add(painelCTopo, java.awt.BorderLayout.PAGE_START);

        painelCScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelCScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelCScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelCNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelCNotas.setLayout(new javax.swing.BoxLayout(painelCNotas, javax.swing.BoxLayout.Y_AXIS));
        painelCScroll.setViewportView(painelCNotas);

        painelC.add(painelCScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelC);

        getContentPane().add(painelColunas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        /* 
            Ao clicar no botão, o show faz com que o menu popup apareça na tela.
            O .show() precisa de três parâmetros: o componente de referência (btnMenu), a posição X e a posição Y. 
            O '0' alinha o menu exatamente na beirada esquerda do botão. 
            O 'btnMenu.getHeight()' faz o menu abrir exatemente colado na parte de baixo do botão!
        */ 
        
        // Para calcular o tamanho exato para o menu ficar exatamente grudado à direita do botão
        int x = btnMenu.getWidth() - menuPopup.getPreferredSize().width;
        // Altura do botão, igual estava antes
        int y = btnMenu.getHeight();
        
        menuPopup.show(btnMenu, x, y);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void itemCriarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCriarNotasActionPerformed
        // Cria a tela de criação. 
        // O zero é  o id do usuário que clicou para poder mandar para o DAO o id dele
        CriarNotas tela = new CriarNotas(this, true, 1);
        
        // Coloca ela no centro da tela
        tela.setLocationRelativeTo(this);
        
        // Deixa visível, o Modal aparece na tela e trava a tela principal
        tela.setVisible(true);
        
        // Terminou de criar a nota, recarrega para aparecer a nota
        recarregarNotas();
    }//GEN-LAST:event_itemCriarNotasActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new Main(null).setVisible(true));
    }
    
    private void arrumarCoresMenuPopup() {
        // O UIManager serve para trocar a cor do hover padrão (que não tem como trocar pela interface).
        // Trocamos o azulão padrão por um cinza um pouco mais claro que o fundo
        javax.swing.UIManager.put("MenuItem.selectionBackground", new java.awt.Color(85, 85, 85)); 
        javax.swing.UIManager.put("MenuItem.selectionForeground", new java.awt.Color(255, 255, 255)); 

        // Força o fundo do menu a ficar escuro
        menuPopup.setOpaque(true);
        menuPopup.setBackground(new java.awt.Color(51, 51, 51));

        // Força todos os botões de dentro a ficarem escuros também usando um laço de repetição
        for (java.awt.Component item : menuPopup.getComponents()) {
            if (item instanceof javax.swing.JMenuItem menuItem) {
                menuItem.setOpaque(true);
                menuItem.setBackground(new java.awt.Color(51, 51, 51)); 
                menuItem.setForeground(new java.awt.Color(210, 210, 210)); 
                
                // Cria uma borda invisivel para dar o espaçamento nas bordas
                menuItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));
            }
        }
    }
    
    public void recarregarNotas() {
        try {
            // Limpa as colunas (pra não ter notas duplicadas)
            painelAFNotas.removeAll();
            painelSFNotas.removeAll();
            painelCNotas.removeAll();
            
            // Puxa os dados do banco
            NotaDAO dao = new NotaDAO();
            ArrayList<Nota> notas = dao.listar();
            
            // For Each maroto pra instanciar as notas
            for(Nota n : notas) {
                String prioridade;
                
                switch(n.getPrioridade()) {
                    case 3 -> prioridade = "Alta";
                    case 2 -> prioridade = "Média";
                    case 1 -> prioridade = "Baixa";
                    default -> prioridade = "Baixa";
                }
                
                // Cria o cartao agora passando a nota atual (n) e a prioridade como parâmetro
                // Aqui vai vir do Usuario, como n tá criado ainda, deixei aqui assim msm.
                CartaoNota cartao = new CartaoNota(n, 1, prioridade);
                
                
                // Switch para colocar as notas nas colunas certas dependendo da categoria delas
                switch (n.getCategoria()) {
                    // Case com a sintaxe moderna do Java e usando as chaves para que ele possa adicionar a nota E
                    // colocar uma "área rígida" de baixo da nota
                    case "AF" -> { 
                        painelAFNotas.add(cartao);
                        painelAFNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
                    }
                    case "SF" -> {
                        painelSFNotas.add(cartao);
                        painelSFNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));

                    }
                    case "C" -> {  
                        painelCNotas.add(cartao);
                        painelCNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
                    }
                    default -> {
                        painelAFNotas.add(cartao);
                        painelAFNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
                    }
                }
            }
            
            // Manda o Java Swing recarregar a tela 
            painelAFNotas.revalidate();
            painelAFNotas.repaint();
            
            painelSFNotas.revalidate();
            painelSFNotas.repaint();
            
            painelCNotas.revalidate();
            painelCNotas.repaint();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o Kanban:\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Logout;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> comboBoxOrdenacao;
    private javax.swing.JMenuItem itemCriarNotas;
    private javax.swing.JMenuItem itemGerenciarUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JPanel painelAF;
    private javax.swing.JPanel painelAFNotas;
    private javax.swing.JScrollPane painelAFScroll;
    private javax.swing.JPanel painelAFTopo;
    private javax.swing.JPanel painelC;
    private javax.swing.JPanel painelCNotas;
    private javax.swing.JScrollPane painelCScroll;
    private javax.swing.JPanel painelCTopo;
    private javax.swing.JPanel painelColunas;
    private javax.swing.JPanel painelSF;
    private javax.swing.JPanel painelSFNotas;
    private javax.swing.JScrollPane painelSFScroll;
    private javax.swing.JPanel painelSFTopo;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtAFTopo;
    private javax.swing.JLabel txtBoasVindas;
    private javax.swing.JLabel txtCTopo;
    private javax.swing.JLabel txtSFTopo;
    private javax.swing.JLabel txtTarefasTotais;
    private javax.swing.JLabel txtTarefasUser;
    // End of variables declaration//GEN-END:variables

    
}
