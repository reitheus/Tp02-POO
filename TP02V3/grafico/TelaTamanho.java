package grafico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EmptyStackException;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import game.Partida;


public class TelaTamanho extends JPanel implements MouseListener{
    public int numDigitado;
    private JTextField texto;

    public TelaTamanho(TelaPrincipal tela,Partida jogo){
        //faz as modificações da tela e do painel
        setLayout(new BorderLayout());
        tela.setSize(450,200);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY );
        JLabel titulo = new JLabel("Escolha o tamanho da Palavra");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(30, 10, 600,30);
        add(titulo, BorderLayout.NORTH);

        //caixa de texto que recebe o tamanho da palavra
        texto = new JTextField(1);
        texto.setPreferredSize(new Dimension(40,20));
        texto.setBounds(30, 50, 220,40);
        add(texto,BorderLayout.CENTER);
        texto.setText("Digite um Número entre 3 e 14");
        
        //botão para iniciar a partida
        JButton btn = new JButton("Começar");
        btn.setBounds(30, 90, 150,40);
        add(btn,BorderLayout.SOUTH);

        texto.addMouseListener(this);
           
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
                          
                    }
                }catch (NumberFormatException NumberFormatException){
                    JOptionPane.showMessageDialog(null, "Digite um valor inteiro!","Entrada inválida",JOptionPane.ERROR_MESSAGE);
                }catch(ArithmeticException ArithmeticException){
                    JOptionPane.showMessageDialog(null, "Digite um valor entre 3 e 14:","Valor inválido",JOptionPane.ERROR_MESSAGE);
                }catch(EmptyStackException erro){
                    JOptionPane.showMessageDialog(null, "Não há palavras disponiveis para este tamanho!", "Dicionario Vazio", JOptionPane.INFORMATION_MESSAGE);
                }
                texto.setText("Digite um Número entre 3 e 14");
            }
        });
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        texto.setText("");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}

    
