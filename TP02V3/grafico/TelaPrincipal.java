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
        
        
        // Criando o layout que troca os painéis
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Criando os painéis e adicionando ao painel principal
        Menu menu = new Menu(this,jogo);
        TelaTamanho tamanho = new TelaTamanho(this,jogo);
        
        painelPrincipal.add(menu, "Menu");
        painelPrincipal.add(tamanho,"Tamanho");

        

        add(painelPrincipal);
    }

    // Método para mudar de tela
    public void mudarTela(String nomeTela) {
        cardLayout.show(painelPrincipal, nomeTela);
    }

    public void atualizarPainel(JPanel nome,String apilido){
        painelPrincipal.add(nome,apilido);
    }

    public void novoJogo(JPanel menu){
        cardLayout.removeLayoutComponent(menu);
    }
    
}