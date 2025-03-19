
import javax.swing.*;
import java.awt.*;

public class Jogo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal janela = new TelaPrincipal();
            janela.setVisible(true);
        });
    }
}








// public class Teste {
//     public static void main(String[] args) {
//         System.out.println("Olá, mundo!");
//     }
// }