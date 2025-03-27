package grafico;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import game.Partida;
import game.Ranking;

// import java.util.Vector;
// import java.util.Arrays;


public class JogoAtual extends JPanel{
    private String letraDigitada = "";
    private Vector<JLabel> digitos = new Vector<>();
    private Vector<JLabel> barras = new Vector<>();
    private Vector<Boolean> boneco = new Vector<>(Arrays.asList(false, false, false, false, false, false,false));
    private int parteDoCorpo = 0;

    public JogoAtual(TelaPrincipal tela,Partida jogo) {

        //Ordem do Vector do boneco
        // 1 cabeça, 2 tronco, 3 braço esquerdo, 4 braço direito, 5 perna esquerda, 6 perna direita
        tela.setSize(800,600);
        setLayout(null);
        Ranking temScore = new Ranking();
        String palavra;
        palavra = jogo.getPalavraSecreta();
        
        //Texto do jogo atual
        JLabel titulo = new JLabel("Jogo atual", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        add(titulo, BorderLayout.NORTH);
        titulo.setBounds(300, 50, 250, 50);

        //Desenhas as barras das letras e passa a palavra para o vector de label
        for(int i = 0; i < jogo.getTam(); i++){
            digitos.add(new JLabel(palavra.charAt(i)+""));
            barras.add(new JLabel("_ "));
            digitos.get(i).setBounds(i*30, 0, 40, 40);
            digitos.get(i).setVisible(false);
            barras.get(i).setBounds(i*30, 10, 40, 40);
            
        }
        
        //adicionando os digitos da palavra no panel
        JPanel painelPalavra = new JPanel();
        for (JLabel digito : digitos) {
            digito.setFont(new Font("Arial", Font.BOLD, 40));
            painelPalavra.add(digito);
        }
        //adicionando as barras no painel
        for (JLabel bar : barras) {
            bar.setFont(new Font("Arial", Font.BOLD, 40));
            painelPalavra.add(bar);
        }
        //adciona o painel da palavra para o painel principal
        add(painelPalavra, BorderLayout.NORTH);
        painelPalavra.setLayout(null);
        painelPalavra.setBackground(Color.LIGHT_GRAY );
        painelPalavra.setBounds(365, 160, 250, 100);
        
        //Texto que pede para digitar uma letra
        JLabel texto1 = new JLabel("Digite uma letra: ", SwingConstants.CENTER);
        texto1.setFont(new Font("Arial", Font.BOLD, 20));
        add(texto1, BorderLayout.NORTH);
        texto1.setBounds(280, 300, 215, 50);
        
        //caixa de texto que recebe a letra
        JTextField letra = new JTextField(1); // Caixa de texto com 1 colunas
        letra.setBounds(500, 315, 70, 30);
        add(letra, BorderLayout.CENTER);

        //caixa de texto que recebe as letras usadas;
        JLabel texto2 = new JLabel();
        texto2.setFont(new Font("Arial", Font.BOLD, 20));
        add(texto2, BorderLayout.SOUTH);
        texto2.setBounds(250,400,215,50);
  
        
        //Adiciona um botão que vai enviar a letra digitada na caixa de texto
        JButton botao = new JButton("Enviar Letra");
        botao.setBounds(580, 310, 130, 40);
        add(botao, BorderLayout.CENTER);

        //Adiciona um botão que vai iniciar uma nova partida
        JButton botao1 = new JButton("Novo jogo");
        botao1.setBounds(580, 410, 130, 40);
        add(botao1, BorderLayout.CENTER);
        
        // Criando um filtro para permitir apenas um caractere
        ((AbstractDocument) letra.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length() - length) <= 1) { // Permite só 1 caractere
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });


        //Adiciona ação do botão que rebe o valor enviado na caixa de texto
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jogo.jogadorVenceu()){
                    temScore.addHit();
                    temScore.calculaTScoreP(jogo.getTam(),temScore.getHit());
                    temScore.addScore(temScore.getFail());
                    jogo.setEstatistica(temScore);
                    jogo.resetarPalavrasUsadas();
                    JOptionPane.showMessageDialog(null,"Parabéns você venceu! \n Escolha uma das opções para continuar:","Vencedor da Partida!",JOptionPane.INFORMATION_MESSAGE);
                    tela.atualizarPainel(new Info(tela, jogo), "InfoJogo");
                    tela.mudarTela("InfoJogo");
                }else if(!jogo.jogoTerminado()){
                    try{
                        letraDigitada = letra.getText();
                        if(!jogo.processarTentativa(letraDigitada.charAt(0))){
                            JOptionPane.showMessageDialog(null, "Letra ja utlizada. Tente outra!", "Letra Existente",JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            if(jogo.getAcertou()){
                                for (int i = 0; i < jogo.getEstadoPalavra().length(); i++) {
                                    if(jogo.getEstadoPalavra().charAt(i) != '_'){
                                        digitos.get(i).setVisible(true);
                                    }
                                }
    
                            }else{
                                boneco.set(parteDoCorpo, true);
                                parteDoCorpo++;
                                repaint();
                                temScore.addFail();
                            }
                        }
                        texto2.setText(jogo.getLetrasUsadas().toString());
                        letra.setText("");

                    }catch(IllegalArgumentException erro){
                        JOptionPane.showMessageDialog(null, "Digite apenas Letras!", "Erro de entrada",JOptionPane.ERROR_MESSAGE);
                    }catch(StringIndexOutOfBoundsException vaz){
                        JOptionPane.showMessageDialog(null, "Digite uma Letra!", "Erro de entrada",JOptionPane.WARNING_MESSAGE);
                    }
                    
                }else{
                    temScore.addScore(temScore.getFail());
                    jogo.setEstatistica(temScore);
                    jogo.resetarPalavrasUsadas();
                    JOptionPane.showMessageDialog(null,"Você Perdeu! \n Escolha uma das opções para continuar:","Fim da Partida!",JOptionPane.INFORMATION_MESSAGE);
                    tela.atualizarPainel(new Info(tela, jogo), "InfoJogo");
                    tela.mudarTela("InfoJogo");
                }
                
                
            }
        });  
        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                jogo.getPalavraSecreta();
                tela.atualizarPainel(new Menu(tela, jogo), "Menu");
                tela.mudarTela("Menu");
            }
        });
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar
        this.setBackground(Color.LIGHT_GRAY );

        Graphics2D g2d = (Graphics2D) g; // Conversão para Graphics2D
        g2d.setStroke(new BasicStroke(5));

        //pontos (x1, y1, x2, y2)
        //chão
        g2d.setColor(Color.black);
        g2d.drawLine(30, 330, 230, 330);


        //pontos (x1, y1, x2, y2)
        //suporte diagonal
        g2d.setColor(Color.gray);
        g2d.drawLine(50, 120, 100, 80);


        //pontos (x1, y1, x2, y2)
        //base da forca
        g2d.setColor(Color.black);
        g2d.drawLine(50, 80, 50, 330);


        //pontos (x1, y1, x2, y2)
        //aste que segura a forca
        g2d.setColor(Color.black);
        g2d.drawLine(50, 80, 150, 80);

        //pontos (x1, y1, x2, y2)
        //corda que enforca
        g2d.setColor(Color.black);
        g2d.drawLine(150, 80, 150, 130);
        //cabeça
        if(boneco.get(0)){ 
            //posx, poy, diametro largura, diametro altura
            g2d.setColor(Color.black);
            g2d.drawOval(125, 130, 50, 50);
        }
        //Tronco
        if(boneco.get(1)){ 
            //pontos (x1, y1, x2, y2)
            
            g2d.setColor(Color.black);
            g2d.drawLine(150, 180, 150, 250);
        }

        //Braço esquerdo
        if(boneco.get(2)){ 
            //pontos (x1, y1, x2, y2)
            g2d.setColor(Color.black);
            g2d.drawLine(105, 180, 150, 190);
        }

        //Braço Direito
        if(boneco.get(3)){ 
            //pontos (x1, y1, x2, y2)
            g2d.setColor(Color.black);
            g2d.drawLine(150, 190, 195, 180);
        }

        //Perna esquerdo
        if(boneco.get(4)){ 
            //pontos (x1, y1, x2, y2)
            g2d.setColor(Color.black);
            g2d.drawLine(105, 280, 150, 250);
        }

        //Perna Direita
        if(boneco.get(5)){ 
            //pontos (x1, y1, x2, y2)
            g2d.setColor(Color.black);
            g2d.drawLine(150, 250, 195, 280);
         }

        //X
        if(boneco.get(6)){
            g2d.setColor(Color.RED);
            g2d.drawLine(120, 120, 180, 180);
            g2d.drawLine(120, 180, 180, 120);
        }
    }



}