
package Telas;

import DB.NotaDAO;
import Modelo.Nota;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.text.MaskFormatter;

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
        initComponents();
        
        arrumarCampoPrazo();
        arrumarComboBox();
        
        // Botão excluir fica invisível na aba de Criar
        btnExcluir.setVisible(false);
    }
    
    // Construtor para modificar a nota
    public CriarNotas(java.awt.Frame parent, boolean modal, Nota n) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Modificar Nota");        
        this.tipoFuncao = 1;
        this.notaEdicao = n;
        initComponents();
        
        arrumarCampoPrazo();
        arrumarComboBox();
        arrumarTextoMod();
        
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
        campoPrazoNota = new javax.swing.JFormattedTextField();
        chkBoxPrazoIndefinido = new javax.swing.JCheckBox();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(130, 130, 130));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCriarNota.setBackground(new java.awt.Color(102, 102, 102));
        txtCriarNota.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtCriarNota.setForeground(new java.awt.Color(230, 230, 230));
        txtCriarNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCriarNota.setText("Criar Nota");

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

        txtTitulo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(220, 220, 220));
        txtTitulo.setText("Digite o título da Nota:");

        campoTextoNome.setBackground(java.awt.Color.gray);
        campoTextoNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoTextoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTextoNomeKeyReleased(evt);
            }
        });

        txtDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(220, 220, 220));
        txtDescricao.setText("Digite a descrição da Nota:");

        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setForeground(new java.awt.Color(220, 220, 220));
        txtPrioridade.setText("Qual é a prioridade da Nota?");

        comboBoxPrioridade.setBackground(new java.awt.Color(60, 60, 60));
        comboBoxPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxPrioridade.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Média", "Alta" }));

        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setForeground(new java.awt.Color(220, 220, 220));
        txtPrazo.setText("Qual é o prazo da Nota?");

        painelScrollDescricao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollDescricao.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areaDescricao.setBackground(java.awt.Color.gray);
        areaDescricao.setColumns(20);
        areaDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setBorder(null);
        areaDescricao.setDragEnabled(true);
        areaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaDescricaoKeyReleased(evt);
            }
        });
        painelScrollDescricao.setViewportView(areaDescricao);

        btnSalvar.setBackground(new java.awt.Color(0, 110, 0));
        btnSalvar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(240, 240, 240));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setBackground(new java.awt.Color(40, 40, 40));
        btnCancelar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(230, 230, 230));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        txtContadorDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorDescricao.setForeground(new java.awt.Color(190, 190, 190));
        txtContadorDescricao.setText("0/200");

        txtContadorNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 14)); // NOI18N
        txtContadorNome.setForeground(new java.awt.Color(200, 200, 200));
        txtContadorNome.setText("0/35");

        campoPrazoNota.setBackground(java.awt.Color.gray);
        campoPrazoNota.setForeground(new java.awt.Color(210, 210, 210));
        campoPrazoNota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoPrazoNota.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        chkBoxPrazoIndefinido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        chkBoxPrazoIndefinido.setForeground(new java.awt.Color(210, 210, 210));
        chkBoxPrazoIndefinido.setText("Indefinido");
        chkBoxPrazoIndefinido.addActionListener(this::chkBoxPrazoIndefinidoActionPerformed);

        btnExcluir.setBackground(new java.awt.Color(185, 0, 0));
        btnExcluir.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(245, 245, 245));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(29, 29, 29))
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioridade)
                    .addComponent(txtTitulo)
                    .addComponent(txtDescricao)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoPrazoNota, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrazo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(chkBoxPrazoIndefinido))
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtContadorNome)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoTextoNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContadorDescricao)
                            .addComponent(painelScrollDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))))
                .addContainerGap(251, Short.MAX_VALUE))
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
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPrazoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkBoxPrazoIndefinido))
                .addGap(28, 28, 28)
                .addComponent(txtPrioridade)
                .addGap(18, 18, 18)
                .addComponent(comboBoxPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void chkBoxPrazoIndefinidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxPrazoIndefinidoActionPerformed
        if(chkBoxPrazoIndefinido.isSelected()) {
            // Bloqueia o campo
            campoPrazoNota.setEnabled(false);

            // Limpa o que o usuário digitou (a máscara volta ao padrão __/__/____ __:__)
            campoPrazoNota.setValue(null); 

            // Deixa o fundo mais escuro pra mostrar que tá bloqueado
            campoPrazoNota.setBackground(new java.awt.Color(30, 30, 30)); 
        } 
        else {
            // Desbloqueia o campo
            campoPrazoNota.setEnabled(true);

            // Volta pra cor cinza original do seu formulário (ajuste se a sua for diferente)
            campoPrazoNota.setBackground(java.awt.Color.gray); 

            arrumarCampoPrazo(); 
        }
    }//GEN-LAST:event_chkBoxPrazoIndefinidoActionPerformed

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
            
            // Se tá marcado, o prazo é nulo
            if(chkBoxPrazoIndefinido.isSelected()) {
                JOptionPane.showMessageDialog(this, "Aviso! Essa tarefa ficará sem data de entrega!!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                nota.setPrazo(null);
            }
            else {
                // Se não, pega o texto do campo
                String dataDigitada = campoPrazoNota.getText();
                
                // Aqui pega e verifica se a data é mesmo válida, o combo do uuuu no ano e com o estilo RESTRITO do ResolverStyle
                // Faz com que ele só dê o erro ao invés de arredondar caso fosse 31/04 iria para 01/05
                try {
                    // Formata com o padrão brasileiro, já que o DTF por padrão é o padrão Americano de datas.
                    // O Trocamos o yyyy para uuuu que é para o Java ser estritamente rigoroso com o padrão gregoriano.
                    // Tirei a obrigatoriedade de ter que por hora
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

                    // Pega e transforma o texto em LocalDate (sem hora aqui) usando o formatador
                    LocalDate dataPura = LocalDate.parse(dataDigitada, formatador);
                    
                    // Converte para o LocalDateTime com a hora pro final do dia
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
               String prazo = campoPrazoNota.getText().trim();
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

                if(chkBoxPrazoIndefinido.isSelected()) {
                    nota.setPrazo(null);
                }
                else {
                    // Se o prazo não estiver vazio e também não conter só as barras da máscara
                    if(!prazo.isEmpty() && prazo.equals("/  /")) {
                        // Formata só a data
                        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                        LocalDate data = LocalDate.parse(campoPrazoNota.getText(), formatador);

                        // Formata para até as meia noite do dia
                        LocalDateTime prazoFormatado = data.atTime(23, 59, 59);

                        if(!prazoFormatado.equals(nota.getPrazo())) {
                            nota.setPrazo(prazoFormatado);
                        }
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
    
    private void arrumarCampoPrazo() {  
        try {
            // O '#' obriga o usuário a digitar apenas números
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");

            // Coloca um underline onde o usuário ainda não digitou (fica visualmente bem claro)
            mascaraData.setPlaceholderCharacter('_'); 

            // Aplica a máscara no seu campo de texto
            mascaraData.install(campoPrazoNota); 

        } 
        catch (java.text.ParseException ex) {
            // Exceção obrigatória do Java caso você digite a máscara errado no código
            System.out.println("Erro ao formatar data: " + ex.getMessage());
        }
    }
    
    private void arrumarComboBox() {
        // 1. Pinta a "caixa" principal (quando ele está fechado)
        comboBoxPrioridade.setBackground(new java.awt.Color(30, 30, 30));
        comboBoxPrioridade.setForeground(new java.awt.Color(210, 210, 210));
        comboBoxPrioridade.setFocusable(false); // Tira aquele pontilhado feio de quando clica

        // 2. A MÁGICA: Pinta a "listinha" (Dropdown) que cai quando clica
        comboBoxPrioridade.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Dá aquele respiro/espaçamento no texto igual fizemos no Menu ontem!
                setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));

                if (isSelected) {
                    // Cor do "Hover" (Quando o mouse passa em cima)
                    c.setBackground(new java.awt.Color(85, 85, 85)); 
                    c.setForeground(java.awt.Color.WHITE);
                } 
                else {
                    // Cor do fundo normal escuro
                    c.setBackground(new java.awt.Color(60, 63, 65)); 
                    c.setForeground(new java.awt.Color(230, 230, 230));
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
        
        txtPrioridade.setText("Qual é a nova prioridade?");
        btnSalvar.setText("Modificar");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField campoPrazoNota;
    private javax.swing.JTextField campoTextoNome;
    private javax.swing.JCheckBox chkBoxPrazoIndefinido;
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
