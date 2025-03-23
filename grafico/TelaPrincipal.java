import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelPrincipal;

    public TelaPrincipal() {
        setTitle("Jogo da Forca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Criando o layout que troca os painéis
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Criando os painéis e adicionando ao painel principal
        Menu menu = new Menu(this);
        JogoAtual jogoAtual = new JogoAtual(this);

        painelPrincipal.add(menu, "Menu");
        painelPrincipal.add(jogoAtual, "Jogo");

        add(painelPrincipal);
    }

    // Método para mudar de tela
    public void mudarTela(String nomeTela) {
        cardLayout.show(painelPrincipal, nomeTela);
    }

    
}