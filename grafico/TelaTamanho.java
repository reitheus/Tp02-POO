package grafico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.Partida;


public class TelaTamanho extends JPanel{
    public int numDigitado;

    public TelaTamanho(TelaPrincipal tela,Partida jogo){

        setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel("Tamanho da Palavra", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JTextField texto = new JTextField(1);
        texto.setPreferredSize(new Dimension(40,20));;
        texto.setText("Digite um Número entre 3 e 14");
        add(texto,BorderLayout.CENTER);

        JButton btn = new JButton("Começar");
        add(btn,BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                    try {
                        numDigitado = Integer.parseInt(texto.getText());
                        jogo.validaTam(numDigitado);
                        if(!jogo.iniciarJogo()){                          
                            throw new EmptyStackException();

                        }else{
                            tela.atualizarPainel(new JogoAtual(tela, jogo), "JogoAtual");
                            tela.mudarTela("JogoAtual");
                            System.out.println(jogo.getPalavraSecreta());

                        }
                    }catch (NumberFormatException NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Digite um valor inteiro!","Entrada inválida",JOptionPane.ERROR_MESSAGE);
                    }catch(ArithmeticException ArithmeticException){
                        JOptionPane.showMessageDialog(null, "Digite um valor entre 3 e 14:","Valor inválido",JOptionPane.ERROR_MESSAGE);
                    }catch(EmptyStackException erro){
                        JOptionPane.showMessageDialog(null, "Não há palavras disponiveis para este tamanho!", "Dicionario Vazio", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        
    }

}
