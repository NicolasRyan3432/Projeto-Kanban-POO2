
package Modelo;
import java.awt.Cursor;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class CartaoNota extends javax.swing.JPanel {
    private Nota notaAtual;
    
    // Construtor recebe uma nota inteira ao invés de pedaços separados da nota.
    public CartaoNota(Nota n, String prioridade) {
        // A notaAtual recebe a nota que foi clicada
        this.notaAtual = n;
        
        initComponents();
        
        // Faz com que ocupe todo o espaço disponível na horizontal
        this.setMaximumSize(new java.awt.Dimension(32767, this.getPreferredSize().height));
        
        // Se o titulo for maior do que 22, pega e fatia a string em 19 caracteres
        // e adiciona mais três caracteres (...)
        if(notaAtual.getNome().length() > 22) {
            notaAtual.setNome(notaAtual.getNome().substring(0,19) + " ...");
        }
        
        // Parte onde que a nota recebe os seus valores reais
        txtTitulo.setText(notaAtual.getNome());
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
        setMaximumSize(new java.awt.Dimension(393, 208));
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAutor)
                            .addComponent(txtTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrazo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrioridade)
                                .addGap(18, 18, 18)
                                .addComponent(varPrioridade)))
                        .addGap(0, 93, Short.MAX_VALUE))))
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
            
            // Parte que vai chamar a nova tela com as informações da nota atual
            // Por enquanto vai ser um jOptionPane só pra ver se funcionou
            JOptionPane.showMessageDialog(this, "Deu certo fudido!!! Nome da nota: " + notaAtual.getNome());
            
            // Volta o cursor ao normal
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtPrazo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel varPrioridade;
    // End of variables declaration//GEN-END:variables
}
