import javax.swing.*;
import java.awt.*;


public class JogoAtual extends JPanel{
    

    public JogoAtual(TelaPrincipal tela) {

        
        JLabel titulo = new JLabel("Jogo atual", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);
        

    }

}