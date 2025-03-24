package grafico;
import game.Partida;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.EmptyStackException;


public class TelaTamanho extends JPanel{
    int numDigitado;

    public TelaTamanho(TelaPrincipal tela,Partida jogo){

        setLayout(new BorderLayout(160,80));
        
        JLabel titulo = new JLabel("Tamanho da Palavra", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JTextField texto = new JTextField(1);
        texto.setPreferredSize(new Dimension(50,30));;
        texto.setText("Digite um Número entre 3 e 14");
        add(texto,BorderLayout.CENTER);

        JButton btn = new JButton("Começar");
        add(btn,BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                    try {
                        numDigitado = Integer.parseInt(texto.getText());
                        jogo.validaTam(numDigitado);
                        if(jogo.iniciarJogo()){
                            tela.mudarTela("Jogo");

                        }else{
                            throw new EmptyStackException();
                        }
                    } catch (NumberFormatException NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Digite um valor inteiro!","Entrada inválida",JOptionPane.ERROR_MESSAGE);
                    }catch(ArithmeticException ArithmeticException){
                        JOptionPane.showMessageDialog(null, "Digite um valor entre 3 e 14:","Valor inválido",JOptionPane.ERROR_MESSAGE);
                    }catch(EmptyStackException erro){
                        JOptionPane.showMessageDialog(null, "Não há palavras disponiveis!", "Dicionario Vazio", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        
    }

}
