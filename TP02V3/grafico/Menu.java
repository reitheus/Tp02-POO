package grafico;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Partida;


public class Menu extends JPanel{

    public Menu(TelaPrincipal tela,Partida jogo) {
        //faz as modificações da tela e do painel
        setLayout(new BorderLayout());
        tela.setSize(800, 600);
        tela.setLocationRelativeTo(null);


        //Texto do jogo forca
        JLabel titulo = new JLabel("Jogo da Forca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setPreferredSize(new Dimension(100, 50));
        add(titulo, BorderLayout.NORTH);
        //Cria um novo botão
        JButton botaoStart = new JButton("Start");
        //Adiciona ação de começar um jogo
        botaoStart.addActionListener(e -> tela.mudarTela("Tamanho")); // Muda para o jogo ao clicar
        botaoStart.setPreferredSize(new Dimension(100, 50));
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoStart);
        add(painelBotoes, BorderLayout.CENTER);

    }

}