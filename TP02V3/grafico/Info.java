package grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Partida;
import game.Ranking;

public class Info extends JPanel{

    public Info(TelaPrincipal tela,Partida jogo){
        
        //faz as modificações da tela e do painel
        setLayout(null);
        tela.setSize(600,400);
        Ranking score = jogo.getEstatistica();

        JLabel titulo = new JLabel("Informações do Jogo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);
        titulo.setBounds(150,50,300,30);
        titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //titulos
        JLabel texto1 = new JLabel("Fails: ");
        texto1.setFont(new Font("Arial", Font.BOLD, 24));
        add(texto1,BorderLayout.CENTER);
        texto1.setBounds(200,100,100,30);

        JLabel texto2 = new JLabel("Hits: ");
        texto2.setFont(new Font("Arial", Font.BOLD, 24));
        add(texto2,BorderLayout.CENTER);
        texto2.setBounds(200,150,100,30);

        JLabel texto3 = new JLabel("Total Score:");
        texto3.setFont(new Font("Arial", Font.BOLD, 24));
        add(texto3,BorderLayout.CENTER);
        texto3.setBounds(150,200,200,30);

        //dados dos scores
        JLabel dado1 = new JLabel();
        dado1.setFont(new Font("Arial", Font.BOLD, 24));
        add(dado1,BorderLayout.CENTER);
        dado1.setBounds(330,100,100,30);
        dado1.setText(""+score.getFail());


        ////texto que mostra o score do jogo
        JLabel dado2 = new JLabel();
        dado2.setFont(new Font("Arial", Font.BOLD, 24));
        add(dado2,BorderLayout.CENTER);
        dado2.setBounds(330,150,100,30);
        dado2.setText(""+score.getHit());

        //Cria um novo texto que mostra o score do jogo
        JLabel dado3 = new JLabel();
        dado3.setFont(new Font("Arial", Font.BOLD, 24));
        add(dado3,BorderLayout.CENTER);
        dado3.setBounds(330,200,200,30);
        dado3.setText(""+score.getTScore());
        
        //botoes
        JButton btn = new JButton("Sair");
        add(btn,BorderLayout.SOUTH);
        btn.setBounds(350, 300, 200, 50);
        
        //Cria um novo botão para o menu
        JButton btn1 = new JButton("Voltar ao inicio");
        add(btn1,BorderLayout.SOUTH);
        btn1.setBounds(050, 300, 200, 50);

        //Adiciona ação de fechar o jogo
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        //Adiciona ação para o botão para voltar ao menu
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tela.mudarTela("Menu");
            }
        });
    }

}
