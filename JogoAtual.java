import javax.swing.*;
import java.awt.*;


public class JogoAtual extends JPanel{
    

    public JogoAtual(TelaPrincipal tela) {

        JLabel titulo = new JLabel("Jogo atual", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        setLayout(null);
        add(titulo, BorderLayout.NORTH);
        titulo.setBounds(300, 50, 250, 50);

        JLabel texto1 = new JLabel("Digite uma letra: ", SwingConstants.CENTER);
        texto1.setFont(new Font("Arial", Font.BOLD, 18));
        add(texto1, BorderLayout.NORTH);
        texto1.setBounds(300, 330, 200, 50);
        
        
        JTextField letra = new JTextField(30); // Caixa de texto com 1 colunas
        letra.setBounds(500, 345, 50, 20);


        add(letra, BorderLayout.CENTER);
        

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar
        this.setBackground(Color.white);

        Graphics2D g2d = (Graphics2D) g; // Conversão para Graphics2D
        g2d.setStroke(new BasicStroke(5));

        g2d.setColor(Color.black);
        //g2d.drawRect(30, 70, 300, 400);


        //pontos (x1, y1, x2, y2)
        //chão
        g2d.setColor(Color.black);
        g2d.drawLine(50, 330, 250, 330);

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