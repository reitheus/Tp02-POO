import javax.swing.*;
import game.*;
import grafico.*;
public class Principal {
    public static void main(String[] args) {
        Partida obj = new Partida(null,0);
        BancoPalavras bdpalavra = new BancoPalavras();
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal janela = new TelaPrincipal();
            janela.setVisible(true);
        });
    }
}
