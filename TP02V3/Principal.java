import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import game.Partida;
import grafico.TelaPrincipal;
public class Principal {
    private static Partida jogo;
    public static void main(String[] args) {
        try{
            //Cria um novo objeto Partida
            jogo = new Partida("words-pt.txt");
            //Cria uma nova ela principal
            SwingUtilities.invokeLater(() -> {
                TelaPrincipal janela = new TelaPrincipal(jogo);
                janela.setVisible(true);
            });
        }catch(IOException erroIO){
            //Mostra mensagem de erro se não houver o dicionario
            JOptionPane.showMessageDialog(null, "Erro ao carregar o dicionário de palavra verifique o caminho", "Erro de entrada",JOptionPane.WARNING_MESSAGE);
        }
    }
}
