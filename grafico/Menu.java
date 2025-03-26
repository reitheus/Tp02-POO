package grafico;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Partida;


public class Menu extends JPanel{

    public Menu(TelaPrincipal tela,Partida jogo) {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Jogo da Forca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JButton botaoStart = new JButton("Start");

        
        botaoStart.addActionListener(_ -> tela.mudarTela("Tamanho")); // Muda para o jogo ao clicar

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoStart);
        add(painelBotoes, BorderLayout.CENTER);

    }

}