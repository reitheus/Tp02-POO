package grafico;
import javax.swing.*;

import game.Partida;

import java.awt.*;


public class Menu extends JPanel{

    public Menu(TelaPrincipal tela,Partida jogo) {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Jogo da Forca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JButton botaoStart = new JButton("Start");
        botaoStart.addActionListener(e -> tela.mudarTela("Tamanho")); // Muda para o jogo ao clicar

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoStart);
        add(painelBotoes, BorderLayout.CENTER);

    }

}