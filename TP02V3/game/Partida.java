package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Partida {
    //Atributos
    private int tamanho;
    private boolean acertou;
    private Dicionario dicionario;
    private Jogador jogador;
    private String palavraSecreta;
    private char[] estadoPalavra;//Palavra que está sendo construida para comparar com a original
    private int tentativasRestantes;//Quantidade de tentaivas restantes
    private int posição;//Posição do letra
    private Ranking estatistica;

    //Construtor
    public Partida(){
    }
    public Partida(String arquivo) throws IOException {
        dicionario = new Dicionario(arquivo);
        jogador = new Jogador();
        estatistica = new Ranking();
        posição = -1;
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

    //Processa a tentativa se acertou uma letra da palavra
    public boolean processarTentativa(char letra) {
        if (!jogador.tentarLetra(letra)) {
            return false;
        }
        acertou = false;
        String palavraNormalizada = dicionario.removerAcentos(palavraSecreta);
        char letraNormalizada = dicionario.removerAcentos(String.valueOf(letra)).charAt(0);
        //Verifica se em alguma possição existe a letra que está sendo testada
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraNormalizada.charAt(i) == letraNormalizada) {
                estadoPalavra[i] = palavraSecreta.charAt(i); //coloca a letra na posição correta
                posição = i;
                acertou = true;

            }
        }
        if (!acertou) {
            tentativasRestantes--;
        }
        return true;
    }

    //Retorna a quantidade de tentativa = 0 quando o jogo termina
    public boolean jogoTerminado() {
        return tentativasRestantes == 0;
    }
    //Verifica se o jogador venceu comparand as strings
    public boolean jogadorVenceu() {
        return new String(estadoPalavra).equals(palavraSecreta);
    }
    //Pega o estado da palavra
    public String getEstadoPalavra() {
        return new String(estadoPalavra);
    }
    //Pega as letras utilizadas
    public List<Character> getLetrasUsadas() {
        return jogador.getLetrasUsadas();
    }
    //retorna as tentativas restantes
    public int getTentativasRestantes() {
        return tentativasRestantes;
    }
    //retorna a palavras secreta
    public String getPalavraSecreta() {
        return palavraSecreta;
    }
    //reseta palavras usadas
    public void resetarPalavrasUsadas() {
        dicionario.resetarPalavrasUsadas();
    }
    //seleciona o tamanh da palavra
    public void setTam(int tamanho){
        this.tamanho = tamanho;
    }
    //retorna tamanho
    public int getTam(){
        return tamanho;
    }
    //retorna se acertou
    public boolean getAcertou() {
        return acertou;
    }
    //retorna posição
    public int getPosição() {
        return posição;
    }
    //Atualiza as estatisticas do ranking
    public void setEstatistica(Ranking estatistica){
        this.estatistica = estatistica;
    }
    //retorna as estatiticas do ranking
    public Ranking getEstatistica() {
        return estatistica;
    }
    public void validaTam(int num){
  
        if(num >= 3 && num <=14){
            tamanho = num;
        }else{
            throw new ArithmeticException();
        }
    }

}
