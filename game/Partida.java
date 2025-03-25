package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Partida {
    //Atributos
    private int tamanho;
    private Dicionario dicionario;
    private Jogador jogador;
    private String palavraSecreta;
    private char[] estadoPalavra;
    private int tentativasRestantes;
    private int posição;

    //Construtor
    public Partida(){
    }
    public Partida(String arquivo) throws IOException {
        dicionario = new Dicionario(arquivo);
        jogador = new Jogador();
        posição = 0;
    }

    //Metodos
    public boolean iniciarJogo() {
        palavraSecreta = dicionario.obterPalavra(tamanho);//busca a palavra
        if (palavraSecreta == null) {
            return false; // Se não há palavras disponíveis, retorna falso
        }
        estadoPalavra = new char[palavraSecreta.length()];
        Arrays.fill(estadoPalavra, '_');//coloca _ em cada posição do array
        tentativasRestantes = 7;
        jogador.resetarLetrasUsadas();
        return true;
    }

    public boolean processarTentativa(char letra) {
        if (!jogador.tentarLetra(letra)) {
            
            return false; // Retorna falso se a letra já foi usada
        }
        boolean acertou = false;
        String palavraNormalizada = dicionario.removerAcentos(palavraSecreta);
        char letraNormalizada = dicionario.removerAcentos(String.valueOf(letra)).charAt(0);
        System.out.println(palavraNormalizada);
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraNormalizada.charAt(i) == letraNormalizada) {
                estadoPalavra[i] = palavraSecreta.charAt(i); //coloca a letra na posição correta
                posição = i;
                System.out.println(posição);
                acertou = true;

            }
        }
        if (!acertou) {
            tentativasRestantes--;
        }
        return true;
    }

    public boolean jogoTerminado() {
        return tentativasRestantes == 0 || new String(estadoPalavra).equals(palavraSecreta);
    }

    public boolean jogadorVenceu() {
        return new String(estadoPalavra).equals(palavraSecreta);
    }

    public String getEstadoPalavra() {
        return new String(estadoPalavra);
    }

    public List<Character> getLetrasUsadas() {
        return jogador.getLetrasUsadas();
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public void resetarPalavrasUsadas() {
        dicionario.resetarPalavrasUsadas();
    }

    public void setTam(int tamanho){
        this.tamanho = tamanho;
    }

    public int getTam(){
        return tamanho;
    }
    
    public int getPosição() {
        return posição;
    }
    public void validaTam(int num){
  
        if(num >= 3 && num <=14){
            tamanho = num;
            System.out.println("settam:"+tamanho);
        }else{
            throw new ArithmeticException();
        }
    }

}
