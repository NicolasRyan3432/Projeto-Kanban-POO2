
package Modelo;
import Telas.VisualizarNotas;
import Telas.Main;
import Telas.VisualizarHistorico;
import java.awt.Cursor;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class CartaoNota extends javax.swing.JPanel {
    private final Nota notaAtual;
    private HistoricoNota notaHistorico;
    private int idUsuario;
    private final int modoOperacao;
    
    // Construtor recebe uma nota inteira ao invés de pedaços separados da nota.
    // Construtor chamado no main
    public CartaoNota(Nota n, int idUsuario, String prioridade) {
        // A notaAtual recebe a nota que foi clicada
        this.notaAtual = n;
        this.idUsuario = idUsuario;
        this.modoOperacao = 0;
        
        initComponents();
        preencherCampos(prioridade);
        
        // Pega o titulo que tá na nota sem fatiar ele
        final String tituloOriginal = notaAtual.getNome();
        
        // Cria um componente que vai ficar vendo se a tela (componente) cresceu ou diminuiu de tamanho
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                // Aqui a gente usa o getWidth() porque a nota já nasceu e já tem tamanho real!
                int larguraReal = getWidth(); 

                // Se der algum bug e a largura vier 0, a gente trava no 400 padrão
                if(larguraReal <= 0) { 
                    larguraReal = 400; 
                }
                
                // Aqui a gente usa a regra de 3: Se 400px cabem 22 letras, 'larguraReal' cabe X.
                int limiteDinamico = (larguraReal * 22) / 400; 

                // Aplica a tesoura
                if (tituloOriginal.length() > limiteDinamico) {
                    int corte = Math.max(0, limiteDinamico - 3);
                    txtTitulo.setText(tituloOriginal.substring(0, corte) + "...");
                } 
                else {
                    // Se for menor do que o limite, mostra inteiro o titulo
                    txtTitulo.setText(tituloOriginal); 
                }
            }
        });
    }
    
    /*
        Construtor chamado no TelaHistórico, 
        precisa de receber a nota que o cara selecionou pra poder salvar no histórico 
        na hora de salvar
    */ 
    public CartaoNota(Nota n, HistoricoNota notaClicada, String prioridade) {
        this.notaAtual = n;
        this.notaHistorico = notaClicada;
        this.modoOperacao = 1;
        
        initComponents();
        preencherCampos(notaClicada, prioridade);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        txtAutor = new javax.swing.JLabel();
        varPrioridade = new javax.swing.JLabel();
        txtPrazo = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 85, 85));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(430, 208));
        setMinimumSize(new java.awt.Dimension(400, 208));
        setPreferredSize(new java.awt.Dimension(400, 208));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        txtTitulo.setBackground(new java.awt.Color(0, 0, 0));
        txtTitulo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(230, 230, 230));
        txtTitulo.setText("Fazer Almoço");

        txtAutor.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtAutor.setForeground(new java.awt.Color(210, 210, 210));
        txtAutor.setText("Autor: Nícolas");

        varPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        varPrioridade.setForeground(new java.awt.Color(209, 30, 51));
        varPrioridade.setText("Alta");

        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setForeground(new java.awt.Color(210, 210, 210));
        txtPrazo.setText("Prazo: Hoje, até as 13:00");

        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setForeground(new java.awt.Color(210, 210, 210));
        txtPrioridade.setText("Prioridade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAutor)
                        .addContainerGap(244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrazo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrioridade)
                                .addGap(18, 18, 18)
                                .addComponent(varPrioridade))
                            .addComponent(txtTitulo))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addComponent(txtAutor)
                .addGap(18, 18, 18)
                .addComponent(txtPrazo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varPrioridade)
                    .addComponent(txtPrioridade))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Verifica se foi um clique DUPLO
        if(evt.getClickCount() == 2) {
            // Muda o cursor para o de "carregando" para dar um feedback visual
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            // Cria um objeto que pega tela principal em relação a essa tela 
            // Aqui é só para pegar a posição da onde que a telaInfo deve nascer
            Window telaPrincipal = SwingUtilities.getWindowAncestor(this);
            
            // SE FOR NO MAIN, chama o VisualizarNotas, se não, chama o VisualizarHistorico
            if(modoOperacao == 0) {
                // Cria a tela de informações passando como atributo a telaPrincipal (como JFrame) e essa nota atual (a clicada)
                VisualizarNotas telaInfo = new VisualizarNotas((JFrame) telaPrincipal, true, this.notaAtual, idUsuario);
                
                // Fica no centro da telaPrincipal
                telaInfo.setLocationRelativeTo(telaPrincipal);

                // Deixa visível
                telaInfo.setVisible(true);
                
                // Depois que fechou a tela de visualizar, como a gente não sabe se o cara fez alguma modificação,
                // a gente recarrega a tela só por preucaução
                if(telaPrincipal instanceof Main principal) {
                    principal.carregarNotas();
                }
            }
            else {
                VisualizarHistorico telaHistorico = new VisualizarHistorico((JDialog) telaPrincipal, true,  notaAtual, notaHistorico);
                telaHistorico.setLocationRelativeTo(telaPrincipal);
                telaHistorico.setVisible(true);
                
                // Se a restauração foi sucedida, manda recarregar as notas
                // Se o cara abriu, viu o histórico, abriu uma nota mas só fechou ele não recarrega
                if(telaHistorico.restaurouComSucesso == true) {
                    if(telaPrincipal instanceof Main principal) {
                        principal.carregarNotas();
                    }
                }
            }
           
            // Volta o cursor ao normal
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_formMouseClicked

    private void preencherCampos(String prioridade) {
        // Faz com que ocupe todo o espaço disponível na horizontal
        this.setMaximumSize(new java.awt.Dimension(32767, this.getPreferredSize().height));
        
        // Parte onde que a nota recebe os seus valores reais
        txtAutor.setText("Autor: " + notaAtual.getNomeAutor());
        
        if(notaAtual.getPrazo() != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            txtPrazo.setText("Prazo: " + notaAtual.getPrazo().format(formatador));
        }
        else {
            txtPrazo.setText("Prazo: Indefinido");
        }
        /*  
            Aqui separei em dois labels, um é do texto "Prioridade" 
            e o outro que é realmente a prioridade que vem do banco
        */ 
        
        varPrioridade.setText(prioridade);
        
        // Troca a cor do texto dependendo da prioridade dele
        // As setinhas substituem a antiga notação do switch (case coisa: coisa aqui dentro; break;)
        switch(prioridade) {
            case "Alta" -> varPrioridade.setForeground(java.awt.Color.RED);
            case "Média" -> varPrioridade.setForeground(java.awt.Color.ORANGE);
            case "Baixa" -> varPrioridade.setForeground(java.awt.Color.GREEN);
            default -> varPrioridade.setForeground(java.awt.Color.GRAY); // Caso venha alguma outra cor
        }
    }
    
    private void preencherCampos(HistoricoNota notaAtual, String prioridade) {
        String notaFormatada;
        
        // Faz com que ocupe todo o espaço disponível na horizontal
        this.setMaximumSize(new java.awt.Dimension(32767, this.getPreferredSize().height));
        
        // Se o titulo for maior do que 22, pega e fatia a string em 19 caracteres
        // e adiciona mais três caracteres (...)
        if(notaAtual.getNomeAntigo().length() > 22) {
            notaFormatada = (notaAtual.getNomeAntigo().substring(0,19) + " ...");
            txtTitulo.setText(notaFormatada);
        }
        else {
            txtTitulo.setText(notaAtual.getNomeAntigo());
        }
       
        
        if(notaAtual.getAutor() != null) {
            txtAutor.setText("Autor: " + notaAtual.getAutor());
        }
        else {
            txtAutor.setText("Autor: Indefinido");
        }
        
        
        if(notaAtual.getPrazoAntigo() != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            txtPrazo.setText("Prazo: " + notaAtual.getPrazoAntigo().format(formatador));
        }
        else {
            txtPrazo.setText("Prazo: Indefinido");
        }

        
        varPrioridade.setText(prioridade);
        
       
        switch(prioridade) {
            case "Alta" -> varPrioridade.setForeground(java.awt.Color.RED);
            case "Média" -> varPrioridade.setForeground(java.awt.Color.ORANGE);
            case "Baixa" -> varPrioridade.setForeground(java.awt.Color.GREEN);
            default -> varPrioridade.setForeground(java.awt.Color.GRAY); // Caso venha alguma outra cor
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtPrazo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel varPrioridade;
    // End of variables declaration//GEN-END:variables

  
}
