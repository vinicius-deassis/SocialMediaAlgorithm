package LoginSystem;

import negocio.User;

public class Perguntas {
    private String tema;
    private String subtema;
    private String pergunta;

    public Perguntas(String tema, String subtema, String pergunta) {
        this.tema = tema;
        this.subtema = subtema;
        this.pergunta = pergunta;
    }

    public String exibirPergunta() {
        return pergunta;
    }

    public void avaliarResposta(boolean gostou, User user) {
        // Lógica para avaliar a resposta do usuário
    }

    public String getTema() {
        return tema;
    }

    public String getSubtema() {
        return subtema;
    }
}
