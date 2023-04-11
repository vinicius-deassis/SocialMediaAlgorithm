package LoginSystem;

import negocio.User;

public abstract class Pergunta {
    private String Tema;
    private String[] subtemas;

    public Pergunta(String tema, String[] subtemas) {
        this.Tema = tema;
        this.subtemas = subtemas;
    }

    public abstract String exibirPergunta();

    public abstract void avaliarResposta(boolean gostou, User user);

    public String getTema() {
        return Tema;
    }

    public String[] getSubtemas() {
        return subtemas;
    }

}