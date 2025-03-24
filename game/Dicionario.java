package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// Classe responsável por carregar as palavras do arquivo e fornecer palavras únicas
public class Dicionario {
    private List<String> palavrasDisponiveis;
    private Set<String> palavrasUsadas;
    private Random random;

    public Dicionario(String arquivo) throws IOException {
        palavrasDisponiveis = new ArrayList<>();
        palavrasUsadas = new HashSet<>();
        random = new Random();
        carregarPalavras(arquivo);
    }

    private void carregarPalavras(String arquivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavrasDisponiveis.add(linha.trim().toLowerCase()); // Mantém a palavra original
            }
        }
    }

    // Método para remover acentos sem modificar a palavra original
    public String removerAcentos(String palavra) {
        return Normalizer.normalize(palavra, Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", "");
    }

    public String obterPalavra(int tamanho) {
        List<String> candidatas = new ArrayList<>();
        for (String palavra : palavrasDisponiveis) {
            if (palavra.length() == tamanho && !palavrasUsadas.contains(palavra)) {
                candidatas.add(palavra);
            }
        }
        if (candidatas.isEmpty()) {
            return null; // Retorna null se não houver palavras disponíveis
        }
        String palavraEscolhida = candidatas.get(random.nextInt(candidatas.size()));
        palavrasUsadas.add(palavraEscolhida);
        return palavraEscolhida;
    }

    public void resetarPalavrasUsadas() {
        palavrasUsadas.clear();
    }
}
