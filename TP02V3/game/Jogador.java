package game;
import java.util.ArrayList;
import java.util.List;

// Classe que gerencia as letras já usadas pelo jogador
public class Jogador {
    private List<Character> letrasUsadas;
    //cria uma coleção de listas de palavras usadas
    public Jogador() {
        letrasUsadas = new ArrayList<>();
    }

    //faz o teste se a letra já foi utilizada
    public boolean tentarLetra(char letra) {
        if (letrasUsadas.contains(letra)) {
            return false; // Retorna falso se a letra já foi usada
        }
        letrasUsadas.add(letra);
        return true;
    }

    //pega as letras usadas da coleção
    public List<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    //Reseta letras usadas
    public void resetarLetrasUsadas() {
        letrasUsadas.clear();
    }
}
