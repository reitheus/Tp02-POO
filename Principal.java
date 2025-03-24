import grafico.*;
import game.*;

import java.io.IOException;

import javax.swing.*;
public class Principal {
    public static void main(String[] args) {
        try{
            Partida jogo = new Partida("words-pt.txt");
            SwingUtilities.invokeLater(() -> {
                TelaPrincipal janela = new TelaPrincipal(jogo);
                janela.setVisible(true);
            });
        }catch(IOException erroIO){
            JOptionPane.showMessageDialog(null, "Erro ao carregar o dicionário de palavra verifique o caminho", "Erro de entrada",JOptionPane.WARNING_MESSAGE);
        }
    }
}
