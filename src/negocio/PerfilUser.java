package negocio;

import LoginSystem.Pergunta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfilUser {
    private List<Pergunta> perguntas;
    private String[] respostas;
    private User user;
    private Map<String, Map<String, Integer>> frequencias;
    private static final int VALOR_AFINIDADE = 1;

    public PerfilUser(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
        respostas = new String[perguntas.size()];
        user = new User();
        frequencias = new HashMap<>();
        inicializarFrequencias();
    }

    private void inicializarFrequencias() {
        for (Pergunta pergunta : perguntas) {
            Map<String, Integer> subFrequencias = new HashMap<>();
            for (String subTema : pergunta.getSubtemas()) {
                subFrequencias.put(subTema, 0);
            }
            frequencias.put(pergunta.getTema(), subFrequencias);
        }
    }

    public void responder(int indice, String resposta) {
        respostas[indice] = resposta;
        atualizarFrequencias(indice, resposta);
    }

    private void atualizarFrequencias(int indice, String resposta) {
        Pergunta pergunta = perguntas.get(indice);
        Map<String, Integer> subFrequencias = frequencias.get(pergunta.getTema());
        List<String> subTemas = Arrays.asList(pergunta.getSubtemas());
        String subTemaSelecionado = subTemas.get(Integer.parseInt(resposta) - 1);
        for (String subTema : subTemas) {
            if (subTema.equals(subTemaSelecionado)) {
                user.addAfinidade(subTema, VALOR_AFINIDADE);
                int frequencia = subFrequencias.get(subTema);
                subFrequencias.put(subTema, frequencia + VALOR_AFINIDADE);
            } else {
                int frequencia = subFrequencias.get(subTema);
                subFrequencias.put(subTema, frequencia - VALOR_AFINIDADE);
            }
        }
    }

    public User getUser() {
        return user;
    }

    public Map<String, Map<String, Integer>> getFrequencias() {
        return frequencias;
    }
}

