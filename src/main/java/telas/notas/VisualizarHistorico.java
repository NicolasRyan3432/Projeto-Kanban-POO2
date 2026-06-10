
package telas.notas;
import database.NotaDAO;
import modelo.HistoricoNota;
import modelo.Nota;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class VisualizarHistorico extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VisualizarHistorico.class.getName());
    private final HistoricoNota notaHistorico; 
    private final Nota notaAtual;
    public boolean restaurouComSucesso = false;
    
    public VisualizarHistorico(java.awt.Dialog parent, boolean modal, Nota notaAtual, HistoricoNota notaClicada) {
        super(parent, modal);
        this.notaHistorico = notaClicada;
        this.notaAtual = notaAtual;
        this.setTitle("Painel Kanban - Visualizar Histórico");
        initComponents();
        
        preencherDados();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtNome = new javax.swing.JLabel();
        painelInfo = new javax.swing.JPanel();
        txtDescricao = new javax.swing.JLabel();
        txtAutor = new javax.swing.JLabel();
        painelScrollDescricao = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        txtPrioridade = new javax.swing.JLabel();
        varPrioridade = new javax.swing.JLabel();
        txtDataCriacao = new javax.swing.JLabel();
        txtPrazoAntigo = new javax.swing.JLabel();
        txtCategoriaAntiga = new javax.swing.JLabel();
        txtCategoriaNova = new javax.swing.JLabel();
        btnRestaurar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 730));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(240, 240, 240));
        txtNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNome.setText("Fazer Almoço");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelInfo.setBackground(new java.awt.Color(51, 51, 51));
        painelInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(220, 220, 220));
        txtDescricao.setText("Descrição Antiga:");

        txtAutor.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtAutor.setForeground(new java.awt.Color(220, 220, 220));
        txtAutor.setText("Autor: Nicolas");

        painelScrollDescricao.setBackground(new java.awt.Color(102, 102, 102));
        painelScrollDescricao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollDescricao.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areaDescricao.setEditable(false);
        areaDescricao.setBackground(new java.awt.Color(102, 102, 102));
        areaDescricao.setColumns(20);
        areaDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setCaretColor(new java.awt.Color(102, 102, 102));
        painelScrollDescricao.setViewportView(areaDescricao);

        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setForeground(new java.awt.Color(220, 220, 220));
        txtPrioridade.setText("Prioridade Antiga:");

        varPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        varPrioridade.setForeground(new java.awt.Color(220, 220, 220));
        varPrioridade.setText("Alta");

        txtDataCriacao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDataCriacao.setForeground(new java.awt.Color(220, 220, 220));
        txtDataCriacao.setText("Data de Criação: 13/08/2026 às 12:34");

        txtPrazoAntigo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazoAntigo.setForeground(new java.awt.Color(220, 220, 220));
        txtPrazoAntigo.setText("Prazo Antigo: 15/08/2026 até 23:59:59");

        txtCategoriaAntiga.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtCategoriaAntiga.setForeground(new java.awt.Color(220, 220, 220));
        txtCategoriaAntiga.setText("Status antigo: Sendo Feito");

        txtCategoriaNova.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtCategoriaNova.setForeground(new java.awt.Color(220, 220, 220));
        txtCategoriaNova.setText("Status atual: A Fazer");

        btnRestaurar.setBackground(new java.awt.Color(0, 0, 110));
        btnRestaurar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(240, 240, 240));
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(this::btnRestaurarActionPerformed);

        btnFechar.setBackground(new java.awt.Color(40, 40, 40));
        btnFechar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(220, 220, 220));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout painelInfoLayout = new javax.swing.GroupLayout(painelInfo);
        painelInfo.setLayout(painelInfoLayout);
        painelInfoLayout.setHorizontalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoriaNova)
                    .addComponent(txtCategoriaAntiga)
                    .addComponent(txtPrazoAntigo)
                    .addComponent(txtDataCriacao)
                    .addGroup(painelInfoLayout.createSequentialGroup()
                        .addComponent(txtPrioridade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varPrioridade))
                    .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDescricao)
                        .addComponent(painelScrollDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(txtAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRestaurar)
                .addGap(43, 43, 43))
        );
        painelInfoLayout.setVerticalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(txtAutor)
                .addGap(28, 28, 28)
                .addComponent(txtDescricao)
                .addGap(28, 28, 28)
                .addComponent(painelScrollDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrioridade)
                    .addComponent(varPrioridade))
                .addGap(28, 28, 28)
                .addComponent(txtPrazoAntigo)
                .addGap(28, 28, 28)
                .addComponent(txtDataCriacao)
                .addGap(28, 28, 28)
                .addComponent(txtCategoriaAntiga)
                .addGap(28, 28, 28)
                .addComponent(txtCategoriaNova)
                .addGap(18, 18, 18)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestaurar)
                    .addComponent(btnFechar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(painelInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        int resultado = verificarAlteracoes(notaAtual, notaHistorico);
        
        if(resultado == 5) {
            JOptionPane.showMessageDialog(this, "As notas são iguais! Cancelando restauração...", "Cancelando...", JOptionPane.INFORMATION_MESSAGE);
            restaurouComSucesso = false;
        }
        else {
            restaurarInfo();

            // Seta como sucesso
            restaurouComSucesso = true;

            // Explode todos os JDialog que estão abertos (Visualizar Notas, TelaHistorico e VisualizarNotas)
            for (java.awt.Window janela : java.awt.Window.getWindows()) {
                // Se a janela for um JDialog (qualquer modal aberto), manda pro ralo!
                // Como a tela Main é um JFrame, ela sobrevive intacta.
                if (janela instanceof javax.swing.JDialog) {
                    janela.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnRestaurarActionPerformed

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
                VisualizarHistorico dialog = new VisualizarHistorico(new javax.swing.JDialog(), true, null, null);
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
    
    private void preencherDados() {
        try {
            // Pega e limpa o texto da descrição pra ver se tem alguma coisa dentro
            String textoDescricao = notaHistorico.getDescricaoAntiga().trim();
            
            // Pega a categoria atual ("AF", "SF", "C")
            String categoriaAntiga = notaHistorico.getCategoriaAntiga();
            String categoriaNova = notaHistorico.getCategoriaNova();
            String categoriaFormatadaA;
            String categoriaFormatadaN;
            
            // Pega a prioridade
            int prioridade = notaHistorico.getPrioridadeAntiga();
            
            // Coloca o Título da nota
            txtNome.setText(notaHistorico.getNomeAntigo());
            // Coloca o nome do Autor
            txtAutor.setText("Autor: " + notaHistorico.getAutor());

            // Verificação pra ver se a descrição está vazia 
            
            if(textoDescricao.isEmpty()) {
                areaDescricao.setText("Sem descrição!");
            }
            else {
                areaDescricao.setText(notaHistorico.getDescricaoAntiga());
            }
            
            // Transformando a prioridade que é int para as suas respectivas prioridades em texto
            switch(prioridade) {
                case 3 -> {
                    varPrioridade.setText("Alta");
                    varPrioridade.setForeground(java.awt.Color.RED);
                }
                case 2 -> {
                    varPrioridade.setText("Média");
                    varPrioridade.setForeground(java.awt.Color.ORANGE);
                }
                case 1 -> {
                    varPrioridade.setText("Baixa");
                    varPrioridade.setForeground(java.awt.Color.GREEN);
                } 
                default -> {
                    varPrioridade.setText("Baixa");
                    varPrioridade.setForeground(java.awt.Color.GREEN); // Caso venha alguma outra cor
                }
            }
            
            // Se o prazo for diferente de vazio, ele pega e formata, senão é indefinido
            if(notaHistorico.getPrazoAntigo() != null) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                txtPrazoAntigo.setText("Prazo: " + notaHistorico.getPrazoAntigo().format(formatador));
            }
            else {
                txtPrazoAntigo.setText("Prazo: Indefinido");
            }
            
            // Mesma coisa aqui, só que é com a data e formatamos bonitinho para aparecer a data e hora
            if(notaHistorico.getDataAlteracao() != null) {
                DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
                
                txtDataCriacao.setText("Data da Criação: " 
                        + notaHistorico.getDataAlteracao().format(formatadorData) 
                        + " às " 
                        + notaHistorico.getDataAlteracao().format(formatadorHora)); 
            }
            else {
                txtDataCriacao.setText("Data: Indefinida");
            }
            
            // Troca a sigla da categoria para o que ela significa para mostrar visualmente
            switch(categoriaAntiga) {
                case "AF" -> { 
                    categoriaFormatadaA = "A Fazer";
                }
                case "SF" -> {
                    categoriaFormatadaA = "Sendo Feito";
                }
                case "C" -> {
                    categoriaFormatadaA = "Concluído";
                }
                default -> {
                    categoriaFormatadaA = "A Fazer";
                }
            }
            
            switch(categoriaNova) {
                case "AF" -> { 
                    categoriaFormatadaN = "A Fazer";
                }
                case "SF" -> {
                    categoriaFormatadaN = "Sendo Feito";
                }
                case "C" -> {
                    categoriaFormatadaN = "Concluído";
                }
                default -> {
                    categoriaFormatadaN = "A Fazer";
                }
            }
                
            // Insere na tela
            if(categoriaFormatadaA.equals(categoriaFormatadaN)) {
                txtCategoriaAntiga.setText("Status antigo: Sem alteração!");
                txtCategoriaNova.setText("Status atual: " + categoriaFormatadaA);
            }
            else {
                txtCategoriaAntiga.setText("Status antigo: " + categoriaFormatadaA);
                txtCategoriaNova.setText("Status atual: " + categoriaFormatadaN);                
            }
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: Não foi possível carregar as informações da nota! " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }      
    }
    
    private void restaurarInfo() {
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Tem certeza que deseja restaurar a nota para esta versão antiga?\nOs dados atuais da nota serão sobrescritos.",
                "Confirmar Restauração",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if(resposta == JOptionPane.YES_OPTION) {
                try {
                NotaDAO dao = new NotaDAO();
                
                
                // Salva a nota atual no histórico antes de restaurar a alteração
                dao.adicionarHistorico(this.notaAtual.getId(), this.notaAtual.getCategoria());

                // Restaura pra nota selecionada
                dao.restaurar(this.notaHistorico);
                JOptionPane.showMessageDialog(this, "Nota restaurada com sucesso!!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao restaurar a nota: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }
    
    private int verificarAlteracoes(Nota notaEdicao, HistoricoNota n) {
        int contador = 0;
        Nota nota = notaEdicao;
        HistoricoNota notaH = n;
        
        String tituloN = nota.getNome().trim();
        String tituloH = notaH.getNomeAntigo().trim();
        String desN = nota.getDescricao().trim();
        String desH = notaH.getDescricaoAntiga().trim();
        String categoriaN = nota.getCategoria();
        String categoriaH = notaH.getCategoriaAntiga();
        int prioN = nota.getPrioridade();
        int prioH = notaH.getPrioridadeAntiga();
        LocalDateTime prazoN = nota.getPrazo();
        LocalDateTime prazoH = notaH.getPrazoAntigo();
        String pH = "";
        String pN = "";
        
        if(prazoN == null) {
            pN = "Indefinido";
        }
        
        if(prazoH == null) {
            pH = "Indefinido";
        }
        
        if(pN.equals(pH)) {
            contador ++;
        }
        
        if(tituloN.equals(tituloH)) {
            contador ++;
        }

        if(desN.equals(desH)) {
            contador ++;
        }
        
        if(categoriaN.equals(categoriaH)) {
            contador ++;
        }
        
        if(prioN == prioH) {
            contador ++;
        }
        
        
        // contador = 5, nota igual, não insere
        return contador;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JPanel painelInfo;
    private javax.swing.JScrollPane painelScrollDescricao;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtCategoriaAntiga;
    private javax.swing.JLabel txtCategoriaNova;
    private javax.swing.JLabel txtDataCriacao;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPrazoAntigo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel varPrioridade;
    // End of variables declaration//GEN-END:variables
}
