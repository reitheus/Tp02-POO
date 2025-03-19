import javax.swing.*;
import java.awt.*;


public class Desenho extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar
        this.setBackground(Color.white);
        Graphics2D g2d = (Graphics2D) g; // Usa Graphics2D para melhor qualidade
        //g2d.setStroke(new BasicStroke(3));
        // Ativa a suavização (anti-aliasing)
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.black);
        g2d.drawRect(30, 70, 300, 50);




        // Define a cor e desenha uma linha
        //g2d.setColor(Color.pink);
        //g2d.drawLine(30, 200, 300, 500);
    
    
    }
 
}