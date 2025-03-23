import javax.swing.*;
import java.awt.*;


public class Desenho extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar
        this.setBackground(Color.green);

        g.setColor(Color.black);
        g.drawRect(100, 200, 500, 500);


    }
 
}