import javax.swing.*;
import java.awt.*;


public class Menu extends JPanel{
    //private JFrame frame;

    public Menu(TelaPrincipal tela) {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Jogo da Forca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JButton botaoStart = new JButton("Start");
        botaoStart.addActionListener(e -> tela.mudarTela("Jogo")); // Muda para o jogo ao clicar

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoStart);
        add(painelBotoes, BorderLayout.CENTER);

    }

}