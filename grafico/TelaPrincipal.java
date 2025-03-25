package grafico;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Partida;

public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelPrincipal;

    public TelaPrincipal(Partida jogo) {
        setTitle("Jogo da Forca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Criando o layout que troca os painéis
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Criando os painéis e adicionando ao painel principal
        Menu menu = new Menu(this,jogo);


        painelPrincipal.add(menu, "Menu");


        add(painelPrincipal);
    }

    // Método para mudar de tela
    public void mudarTela(String nomeTela) {
        cardLayout.show(painelPrincipal, nomeTela);
    }

    public void trocaTela(JFrame obj1, JFrame obj2){
        obj1.setVisible(false);
        obj2.setVisible(true);
    }
    
}