
package telas.notas;

import database.NotaDAO;
import modelo.Nota;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;


public class CriarNotas extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CriarNotas.class.getName());
    

    private int idUsuario = 0;
    private final int tipoFuncao;
    private Nota notaEdicao = null;
    
    // Constutor usado para criar a nota
    public CriarNotas(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Criar Nota");
        this.idUsuario = id;
        this.tipoFuncao = 0;
        
        arrumarMenu();
        initComponents();
        
        arrumarComboBox();
        arrumarCampoPrazo();
        arrumarCalendario();
        
        // Botão excluir fica invisível na aba de Criar
        btnExcluir.setVisible(false);
    }
    
    // Construtor para modificar a nota
    public CriarNotas(java.awt.Frame parent, boolean modal, Nota n) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Modificar Nota");        
        this.tipoFuncao = 1;
        this.notaEdicao = n;
        
        arrumarMenu();
        initComponents();
        
        arrumarComboBox();
        arrumarTextoMod();
        arrumarCampoPrazo();
        arrumarCalendario();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtCriarNota = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        campoTextoNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JLabel();
        comboBoxPrioridade = new javax.swing.JComboBox<>();
        txtPrazo = new javax.swing.JLabel();
        painelScrollDescricao = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtContadorDescricao = new javax.swing.JLabel();
        txtContadorNome = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        campoPrazo = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(130, 130, 130));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCriarNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCriarNota.setText("Criar Nota");
        txtCriarNota.setBackground(new java.awt.Color(102, 102, 102));
        txtCriarNota.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtCriarNota.setForeground(new java.awt.Color(230, 230, 230));

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriarNota, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriarNota, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelDados.setBackground(new java.awt.Color(51, 51, 51));
        painelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setText("Digite o título da Nota:");
        txtTitulo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(220, 220, 220));

        campoTextoNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoTextoNome.setBackground(java.awt.Color.gray);
        campoTextoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoNomeKeyReleased(evt);
            }
        });

        txtDescricao.setText("Digite a descrição da Nota:");
        txtDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(220, 220, 220));

        txtPrioridade.setText("Qual é a prioridade da Nota?");
        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setForeground(new java.awt.Color(220, 220, 220));

        comboBoxPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Média", "Alta" }));
        comboBoxPrioridade.setBackground(new java.awt.Color(60, 60, 60));
        comboBoxPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxPrioridade.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPrioridade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxPrioridadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxPrioridadeFocusLost(evt);
            }
        });

        txtPrazo.setText("Qual é o prazo da Nota?");
        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setForeground(new java.awt.Color(220, 220, 220));

        painelScrollDescricao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollDescricao.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areaDescricao.setColumns(20);
        areaDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setBackground(java.awt.Color.gray);
        areaDescricao.setBorder(null);
        areaDescricao.setDragEnabled(true);
        areaDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                areaDescricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                areaDescricaoFocusLost(evt);
            }
        });
        areaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaDescricaoKeyReleased(evt);
            }
        });
        painelScrollDescricao.setViewportView(areaDescricao);

        btnSalvar.setText("Salvar");
        btnSalvar.setBackground(new java.awt.Color(0, 110, 0));
        btnSalvar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(240, 240, 240));
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(40, 40, 40));
        btnCancelar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(230, 230, 230));
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        txtContadorDescricao.setText("0/200");
        txtContadorDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorDescricao.setForeground(new java.awt.Color(190, 190, 190));

        txtContadorNome.setText("0/35");
        txtContadorNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorNome.setForeground(new java.awt.Color(200, 200, 200));

        btnExcluir.setText("Excluir");
        btnExcluir.setBackground(new java.awt.Color(185, 0, 0));
        btnExcluir.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(245, 245, 245));
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(29, 29, 29))
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioridade)
                    .addComponent(txtTitulo)
                    .addComponent(txtDescricao)
                    .addComponent(txtPrazo)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtContadorNome)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoTextoNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContadorDescricao)
                            .addComponent(painelScrollDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
                    .addComponent(campoPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addComponent(campoTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadorNome)
                .addGap(28, 28, 28)
                .addComponent(txtDescricao)
                .addGap(18, 18, 18)
                .addComponent(painelScrollDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadorDescricao)
                .addGap(24, 24, 24)
                .addComponent(txtPrazo)
                .addGap(18, 18, 18)
                .addComponent(campoPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtPrioridade)
                .addGap(18, 18, 18)
                .addComponent(comboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(painelDados, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
      
    private void campoTextoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoNomeKeyReleased
        // Limite de caracteres lá no banco
        int limite = 35;
        
        // Pega o quê o usuário digitou e vê o tamanho
        String texto = campoTextoNome.getText();
        int tamanho = texto.length();
        
        // Atualiza o número na tela em tempo real
        txtContadorNome.setText(tamanho + " / " + limite);
        
        // Caso o usuário digite a mais do que o limite
        if(tamanho >= limite) {
            // Arranca o texto que ele pôs a mais a força
            campoTextoNome.setText(texto.substring(0, limite));
            
            // Seta o contador como limite/limite = 35/35
            txtContadorNome.setText(limite + " / " + limite);
            
            // Deixa com a cor vermelha
            txtContadorNome.setForeground(new java.awt.Color(209,30,51));
        }
        else {
            // Se tiver dentro do limite, deixa na cor normal do texto
            txtContadorNome.setForeground(new java.awt.Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoTextoNomeKeyReleased

    private void areaDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaDescricaoKeyReleased
        // Limite de caracteres lá no banco
        int limite = 200;

        // Pega o quê o usuário digitou e vê o tamanho
        String texto = areaDescricao.getText();
        int tamanho = texto.length();

        // Atualiza o número na tela em tempo real
        txtContadorDescricao.setText(tamanho + " / " + limite);

        // Caso o usuário digite a mais do que o limite
        if(tamanho >= limite) {
            // Arranca o texto que ele pôs a mais a força
            areaDescricao.setText(texto.substring(0, limite));

            // Seta o contador como limite/limite = 200/200
            txtContadorDescricao.setText(limite + " / " + limite);

            // Deixa com a cor vermelha
            txtContadorDescricao.setForeground(new java.awt.Color(209,30,51));
        }
        else {
            // Se tiver dentro do limite, deixa na cor normal do texto
            txtContadorDescricao.setForeground(new java.awt.Color(200, 200, 200));
        }
    }//GEN-LAST:event_areaDescricaoKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Se for zero (construtor de criar) ele chama o cadastrar
        if(tipoFuncao == 0) {
            cadastrar();
        }
        else {
            modificar(notaEdicao);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir essa nota?", 
                "Aviso!", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
        
       // Se a resposta for sim
        if(resposta == JOptionPane.YES_OPTION) {
            try {
                NotaDAO dao = new NotaDAO();
                dao.deletar(this.notaEdicao.getId()); 
                
                // Fecha a tela
                this.dispose(); 
                JOptionPane.showMessageDialog(this, "Nota removida com sucesso!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
            }
        }      
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void areaDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_areaDescricaoFocusGained
        // Com o foco o enter serve pra quebrar as linhas
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_areaDescricaoFocusGained

    private void areaDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_areaDescricaoFocusLost
        // Sem o foco na área da descrição, 
        // o botão padrão volta a ser o enter pra salvar
        this.getRootPane().setDefaultButton(btnSalvar);
    }//GEN-LAST:event_areaDescricaoFocusLost

    private void comboBoxPrioridadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxPrioridadeFocusGained
        // Com foco o enter serve pra poder selecionar a prioridade
        // além do espaço que por padrão serve pra selecionar checkbox e comboobox
        this.getRootPane().setDefaultButton(null);
    }//GEN-LAST:event_comboBoxPrioridadeFocusGained

    private void comboBoxPrioridadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxPrioridadeFocusLost
        // Sem o foco, o botão padrão volta a ser o de salvar
        this.getRootPane().setDefaultButton(btnSalvar);
    }//GEN-LAST:event_comboBoxPrioridadeFocusLost

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CriarNotas dialog = new CriarNotas(new javax.swing.JFrame(), true, 0);
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
        try {
            Nota nota = new Nota();
            NotaDAO dao = new NotaDAO();
            
            String titulo = campoTextoNome.getText().trim();
            
            // Colocando os dados normais
            // --- Lembrar de trocar aqui quando o DAO Tiver Pronto
            nota.setIdUsuario(idUsuario);
            
            if(titulo.isEmpty()) {
                // Isso cria uma tela com o icone de erro, a segunda string é o titulo do Pane
                JOptionPane.showMessageDialog(this, "A Nota tem que ter um título!!!", "Erro!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                nota.setNome(campoTextoNome.getText());
            }
            
            nota.setDescricao(areaDescricao.getText());
            
            // Se o campo estiver vazio, ele seta o nulo na nota
            if(campoPrazo.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Aviso! Essa tarefa ficará sem data de entrega!!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                nota.setPrazo(null);
            }
            else {
                try {
                    LocalDate dataPura = campoPrazo.getDate();
                    LocalDateTime dataComHora = dataPura.atTime(23, 59, 59);
                    
                    // Insere a data dentro da Nota
                    nota.setPrazo(dataComHora);
                }
                catch(DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(this, "Data inválida!!", "Erro!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            // Switch para pegar a prioridade no campo de texto.
            switch (comboBoxPrioridade.getSelectedIndex()) {
                case 0 -> nota.setPrioridade(1);
                case 1 -> nota.setPrioridade(2);
                case 2 -> nota.setPrioridade(3);
                default -> nota.setPrioridade(1);
            }
            
            // Salvando a nota no DAO
            dao.criar(nota);
            JOptionPane.showMessageDialog(this, "Nota adicionada com sucesso!!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
            
            // Fecha a tela de cadastro caso deu tudo certo
            this.dispose();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }
    
    private void modificar(Nota notaEdicao) {
        // Adicionei um verificador para confirmar a modificação do usuário
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Você deseja realmente modificar essa nota?", 
                "Confirmar Alteração", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if(resposta == JOptionPane.YES_OPTION) {
            try {
               Nota nota = notaEdicao;
               NotaDAO dao = new NotaDAO();

               String titulo = campoTextoNome.getText().trim();
               int prioridade;

               // Pega e transforma pros números das prioridades
               // 1 = Baixa, 2 = Média e 3 = Alta
               switch(comboBoxPrioridade.getSelectedIndex()) {
                   case 0 -> prioridade = 1;
                   case 1 -> prioridade = 2;
                   case 2 -> prioridade = 3;
                   default -> prioridade = 1;
               }

               // Se o titulo não estiver vazio (vazio = não quer modificar)
               if(!titulo.isEmpty()) {
                   // O texto é igual ao texto que já está na nota (igual = não quer modificar)
                   if(!campoTextoNome.getText().equals(nota.getNome())) {
                       nota.setNome(campoTextoNome.getText());
                   }
               }

                // Aqui é pra garantir que a descrição tá vazia antes de pegar e mandar pro banco
                if(areaDescricao.getText().trim().equals("Sem descrição!")) {
                    nota.setDescricao("");
                }
                if(!areaDescricao.getText().equals(nota.getDescricao())) {
                     nota.setDescricao(areaDescricao.getText());
                }

                // Se o usuário não marcou o checkbox
                if(campoPrazo.getDate() == null) {
                     nota.setPrazo(null);
                }
                else {
                    LocalDate prazoDigitado = campoPrazo.getDate();
                    LocalDateTime prazo = prazoDigitado.atTime(23, 59, 59);
                    
                    if(!prazo.equals(nota.getPrazo())) {
                        nota.setPrazo(prazo);
                   }
                }
                
                if(prioridade != nota.getPrioridade()) {
                   nota.setPrioridade(prioridade);
                }        

               // Salva no histórico antes de modificar a nota
               dao.adicionarHistorico(nota.getId(), nota.getCategoria());

               // Salvando a nota no DAO
                dao.modificar(nota);
                JOptionPane.showMessageDialog(this, "Nota modificada com sucesso!!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);

                // Fecha a tela de cadastro caso deu tudo certo
                this.dispose();
            }
            catch(java.time.format.DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(this, "Data inválida! Digite no formato DD/MM/AAAA.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao modificar a nota: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void arrumarComboBox() {
        // Pinta a "caixa" principal (quando ele está fechado)
        comboBoxPrioridade.setBackground(new java.awt.Color(30, 30, 30));
        comboBoxPrioridade.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPrioridade.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(51, 51, 51), 2));

        // Pinta a "listinha" (Dropdown) que cai quando clica
        comboBoxPrioridade.setRenderer(new javax.swing.DefaultListCellRenderer() {
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
    
    private void arrumarTextoMod() {
        txtCriarNota.setText("Modificar Nota");
        txtTitulo.setText("Digite o novo nome da nota:");
        campoTextoNome.setText(notaEdicao.getNome());
        
        
        txtDescricao.setText("Digite a nova descrição da nota:");
        areaDescricao.setText(notaEdicao.getDescricao());
        
        txtPrazo.setText("Qual é o novo prazo da nota?");
        
        // Se o prazo for diferente de vazio, ele pega e formata, senão é indefinido
        if(notaEdicao.getPrazo() != null) {
            LocalDateTime prazoTempo = notaEdicao.getPrazo();
            LocalDate prazo = prazoTempo.toLocalDate();
            
            campoPrazo.setDate(prazo);
        }

        txtPrioridade.setText("Qual é a nova prioridade?");
        
        switch(notaEdicao.getPrioridade()) {
            case 1 -> comboBoxPrioridade.setSelectedIndex(0);
            case 2 -> comboBoxPrioridade.setSelectedIndex(1);
            case 3 -> comboBoxPrioridade.setSelectedIndex(2);
            default -> comboBoxPrioridade.setSelectedIndex(0);
        }
        btnSalvar.setText("Modificar");
    }
    
    private void arrumarMenu() {
        // Força o UI do PopupMenu e os MenuItem a usar o UI básico
        javax.swing.UIManager.put("PopupMenuUI", "javax.swing.plaf.basic.BasicPopupMenuUI");
        javax.swing.UIManager.put("MenuItemUI", "javax.swing.plaf.basic.BasicMenuItemUI");

        // Força o menu a pegar as cores
        javax.swing.UIManager.put("PopupMenu.background", new Color(51, 51, 51));
        javax.swing.UIManager.put("PopupMenu.border", javax.swing.BorderFactory.createLineBorder(new Color(51, 51, 51), 2));

        javax.swing.UIManager.put("MenuItem.background", new Color(51, 51, 51));
        javax.swing.UIManager.put("MenuItem.foreground", new Color(220, 220, 220));
        javax.swing.UIManager.put("MenuItem.selectionBackground", new java.awt.Color(0, 110, 0)); 
        javax.swing.UIManager.put("MenuItem.selectionForeground", new Color(220, 220, 220));
        
        // Força a pegar a fonte e força uma borda vazia para dar espaçamento nos itens
        javax.swing.UIManager.put("MenuItem.font", new java.awt.Font("FiraCode Nerd Font", 0, 16));
        javax.swing.UIManager.put("MenuItem.border", javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
    
    private void arrumarCalendario() {
        // Configuração do local
        Locale localeBR = new Locale("pt", "BR");
        
        // Cor do campo
        campoPrazo.getComponentDateTextField().setForeground(new Color(200, 200, 200)); // Texto branco
        campoPrazo.getComponentDateTextField().setCaretColor(new Color(200, 200, 200)); // Aquele tracinho que pisca
        campoPrazo.getComponentToggleCalendarButton().setBackground(Color.GRAY);
        
        
        // 1. Captura as configurações internas do Calendário
        DatePickerSettings config = campoPrazo.getSettings();

        // Seta o local brasileiro
        config.setLocale(localeBR);

        // Permite datas vazias (Indefinido)
        config.setAllowEmptyDates(true);

        // Espaço entre o campo de texto e o botão do popup
        config.setGapBeforeButtonPixels(0);
        config.setBorderPropertiesList(new java.util.ArrayList<>());
        
        // Formatação do campo
        config.setFormatForDatesCommonEra("dd/MM/yyyy");
        config.setFormatForDatesBeforeCommonEra("dd/MM/uuuu");
        
        // Seta o limite de data que o usuário pode colocar  
        config.setDateRangeLimits(LocalDate.of(2025, 1, 1), null);
 
        // Tamanho do popup do calendário 
        config.setSizeDatePanelMinimumHeight(200);
        config.setSizeDatePanelMinimumWidth(200);

        // Estilizando a Caixa de Texto (Onde a data fica escrita)
        config.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, Color.GRAY);
        config.setColor(DatePickerSettings.DateArea.TextFieldBackgroundInvalidDate, new Color(51, 51, 51)); 


        // Seta as fontes para os labels
        config.setFontClearLabel(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontCalendarDateLabels(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontCalendarWeekNumberLabels(new Font("FiraCode Nerd Font", 0, 18));
        config.setFontCalendarWeekdayLabels(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontInvalidDate(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontMonthAndYearMenuLabels(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontMonthAndYearNavigationButtons(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontTodayLabel(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontValidDate(new Font("FiraCode Nerd Font", 0, 16));
        config.setFontVetoedDate(new Font("FiraCode Nerd Font", 0, 16));


        // Fundo do painel geral
        config.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, new Color(51, 51, 51));

        // Fundo dos números
        config.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(65, 65, 65)); 

        // Cor de fundo do label do ano e mês
        config.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, new Color(50, 50, 50));

        // Cor de fundo do label do dia de hoje
        config.setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, new Color(50, 50, 50));

        // Cor de hover
        config.setColor(DatePickerSettings.DateArea.BackgroundCalendarPanelLabelsOnHover, new Color(100, 100, 100));

        // Cor do fundo do campo de limpar
        config.setColor(DatePickerSettings.DateArea.BackgroundClearLabel, new Color(50, 50, 50));

        // Cor de fundo dos botões de navegação
        config.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(65, 65, 65));

        // Cor do fundo dos dias da semana
        config.setColorBackgroundWeekdayLabels(new Color(60, 60, 60), true);

        // Cor do texto dos quadradinhos dos dias
        config.setColor(DatePickerSettings.DateArea.CalendarTextNormalDates, new Color(200, 200, 200));

        // Cor do texto dos dias da semana (Seg, Ter, Qua..)
        config.setColor(DatePickerSettings.DateArea.CalendarTextWeekdays, new Color(200, 200, 200));

        // Cor do texto do label de limpar
        config.setColor(DatePickerSettings.DateArea.TextClearLabel, new java.awt.Color(200, 200, 200));

        // Cor do texto do mês e ano
        config.setColor(DatePickerSettings.DateArea.TextMonthAndYearMenuLabels, new java.awt.Color(200, 200, 200));

        // Cor do texto do dia de hoje
        config.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(200, 200, 200));

        // Borda do dia selecionado
        config.setColor(DatePickerSettings.DateArea.CalendarBorderSelectedDate, new Color(100, 100, 100)); 
        
        // Cor de Fundo das datas não permitidas
        config.setColor(DatePickerSettings.DateArea.CalendarBackgroundVetoedDates, new Color(100, 100, 100));
        
        // Borda do popup do calendário
        config.setBorderCalendarPopup(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        // Tira a borda azul de dentro, no campo que fica os números
        config.setBorderPropertiesList(new ArrayList<>());


         // Cor do dia selecionado
        config.setColor(DatePickerSettings.DateArea.CalendarBackgroundSelectedDate, new java.awt.Color(0, 100, 0)); 
    }
   
    private void arrumarCampoPrazo() {
        
        // Pegamos o campo de texto puro que fica dentro do LGoodDatePicker
        javax.swing.JTextField campoTextoData = campoPrazo.getComponentDateTextField();

        // Colocamos o nosso "espião" de teclado nele
        campoTextoData.addKeyListener(new java.awt.event.KeyAdapter() {

            // CAPTURANDO O ENTER (keyPressed acontece no exato milissegundo que a tecla afunda)
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Abre o calendário na tela!
                    campoPrazo.openPopup();

                    /*
                        Como a gente definiu o ENTER como a ação padrão de salvar
                        caso o usuário clique no enter ele pega e "consome" o enter
                        para não "vazar" a ação e acionar o código de salvar
                    */
                    evt.consume(); 
                }
            }

            // AUTO-COMPLETANDO A BARRA (keyReleased acontece quando o dedo solta a tecla)
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                // Se for digitado Delete ou o Backspace, ignora para não atrapalhar
                if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || 
                    evt.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }
                
                // Pega o texto do campo de texto
                String texto = campoTextoData.getText();
                
                /*  
                    
                    Forçamos o dia e o mês a setar 0 se for 4, 5, 6, 7, 8 ou 9 o primeiro número
                    pois não existe dia 40, 50, 60, 70, 80 e 90, mesma coisas pros meses
                    (não passa nem de 20, o máximo é 12)
                */
                
                /*
                    O sistema já sabe que não existe dia 50, então transforma em "05/" na hora!
                    Verifica se o número tá entre quatro e nove (os dois são inclusos).
                    Se for, já mete um zero no começo, o número inserido e a barra
                */ 
                if(texto.matches("^[4-9]$")) {
                    campoTextoData.setText("0" + texto + "/");
                }
                
                /*
                    Trava do dia: O cara tentou digitar de 32 a 39 -> Trava no "31/"
                    Verifica se a string começa com o número 3, se sim, verifica
                    se o número tá entre dois e nove, se sim, mete logo 31 e a barra
                */
                else if (texto.matches("^3[2-9]$")) {
                    campoTextoData.setText("31/");
                }
                
                /*
                    Trava do mês: O cara tentou digitar de 13 a 19 no Mês -> Trava no "12/"
                    Esse faz o seguinte: verifica se tem dois digitos no começo (d{2}),
                    depois vem a barra, o número um e se o que vem depois tá entre três e nove
                    se sim, já mete o número doze com a barra na frente com os três caracteres anteriores
                */
                else if (texto.matches("^\\d{2}/1[3-9]$")) {
                    // Mantém os 3 primeiros caracteres ("10/") e joga o "12/" na frente
                    campoTextoData.setText(texto.substring(0, 3) + "12/");
                }
                
                // O sistema já sabe que não existe mês 52, então transforma em "10/05/" na hora!
                else if(texto.matches("^\\d{2}/[2-9]$")) {
                    campoTextoData.setText(texto.substring(0, 3) + "0" + texto.substring(3) + "/");
                }
                
                // Temos três casos para esse caso aqui: "9/8/2025"
                
                // 1. O cara forçou a barra manualmente no Dia (Ex: "9/")
                // Quaisquer números e a barra
                else if(texto.matches("^\\d/$")) {
                    campoTextoData.setText("0" + texto);
                }
                
                // 2. O cara forçou a barra manualmente no Mês (Ex: "09/8/")
                // Quaisquer dois números, a barra e qualquer número
                else if(texto.matches("^\\d{2}/\\d/$")) {
                    campoTextoData.setText(texto.substring(0, 3) + "0" + texto.substring(3));
                }
                
                // 3. Comportamento normal: fechou o par do Dia ("10") ou do Mês ("09/08")
                // Quaisquer dois números ou quaisquer dois números, a barra e quaisquer dois números
                else if(texto.matches("^\\d{2}$") || texto.matches("^\\d{2}/\\d{2}$")) {
                    campoTextoData.setText(texto + "/");
                }
            }
        });  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private com.github.lgooddatepicker.components.DatePicker campoPrazo;
    private javax.swing.JTextField campoTextoNome;
    private javax.swing.JComboBox<String> comboBoxPrioridade;
    private javax.swing.JPanel painelDados;
    private javax.swing.JScrollPane painelScrollDescricao;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtContadorDescricao;
    private javax.swing.JLabel txtContadorNome;
    private javax.swing.JLabel txtCriarNota;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtPrazo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
