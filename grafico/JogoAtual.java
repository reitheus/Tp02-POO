import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JogoAtual extends JPanel{
    private String letraDigitada = "";

    public JogoAtual(TelaPrincipal tela) {

        String palavra = "ava";
        String traco = "";
        
        //Texto do jogo atual
        JLabel titulo = new JLabel("Jogo atual", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        setLayout(null);
        add(titulo, BorderLayout.NORTH);
        titulo.setBounds(300, 50, 250, 50);


        //Desenhas as barras das letras
        for(int i = 0; i < palavra.length(); i++){
            traco = traco + "_ ";
        }
        JLabel barras = new JLabel(traco, SwingConstants.CENTER);
        barras.setFont(new Font("Arial", Font.BOLD, 50));
        add(barras, BorderLayout.NORTH);
        barras.setBounds(300, 150, 300, 100);

        //Texto que pede para digitar uma letra
        JLabel texto1 = new JLabel("Digite uma letra: ", SwingConstants.CENTER);
        texto1.setFont(new Font("Arial", Font.BOLD, 20));
        add(texto1, BorderLayout.NORTH);
        texto1.setBounds(280, 300, 215, 50);
        
        //caixa de texto que recebe a letra
        JTextField letra = new JTextField(1); // Caixa de texto com 1 colunas
        letra.setBounds(500, 315, 70, 30);
        add(letra, BorderLayout.CENTER);


        JLabel label = new JLabel("");
        label.setBounds(300, 200, 200, 30);
        add(label, BorderLayout.CENTER);

        JButton botao = new JButton("Enviar Letra");
        botao.setBounds(580, 310, 130, 40);
        add(botao, BorderLayout.CENTER);
        
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letraDigitada = letra.getText();
                label.setText("Você digitou: " + letraDigitada);
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar
        this.setBackground(Color.LIGHT_GRAY );

        Graphics2D g2d = (Graphics2D) g; // Conversão para Graphics2D
        g2d.setStroke(new BasicStroke(5));

        g2d.setColor(Color.black);
        //g2d.drawRect(30, 70, 300, 400);


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
        //posx, poy, diametro largura, diametro altura
        g2d.setColor(Color.black);
        g2d.drawOval(125, 130, 50, 50);

        //pontos (x1, y1, x2, y2)
        //Tronco
        g2d.setColor(Color.black);
        g2d.drawLine(150, 180, 150, 250);

        //pontos (x1, y1, x2, y2)
        //Braço esquerdo
        g2d.setColor(Color.black);
        g2d.drawLine(105, 180, 150, 190);

        //pontos (x1, y1, x2, y2)
        //Braço Direito
        g2d.setColor(Color.black);
        g2d.drawLine(150, 190, 195, 180);

        //pontos (x1, y1, x2, y2)
        //Perna esquerdo
        g2d.setColor(Color.black);
        g2d.drawLine(105, 280, 150, 250);

        //pontos (x1, y1, x2, y2)
        //Perna Direita
        g2d.setColor(Color.black);
        g2d.drawLine(150, 250, 195, 280);


    }



}