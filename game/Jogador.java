package game;
import java.util.*;

// Classe que gerencia as letras já usadas pelo jogador
public class Jogador {
    private List<Character> letrasUsadas;

    public Jogador() {
        letrasUsadas = new ArrayList<>();
    }

    public boolean tentarLetra(char letra) {
        if (letrasUsadas.contains(letra)) {
            return false; // Retorna falso se a letra já foi usada
        }
        letrasUsadas.add(letra);
        return true;
    }

    public List<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    public void resetarLetrasUsadas() {
        letrasUsadas.clear();
    }
}
