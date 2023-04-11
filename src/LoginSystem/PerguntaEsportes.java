package LoginSystem;

import negocio.User;

public class PerguntaEsportes extends Pergunta {
    private String pergunta;

    public PerguntaEsportes() {
        super("Esportes", new String[]{"Futebol", "Basquete", "Vôlei"});
        this.pergunta = "Você gosta de esportes?";
    }

    @Override
    public String exibirPergunta() {
        return pergunta;
    }

    @Override
    public void avaliarResposta(boolean gostou, User user) {
        if (gostou) {
            user.addAfinidade(getTema(), 1);
            user.addAfinidade(getSubtemas()[0], 1);
            user.addAfinidade(getSubtemas()[1], 1);
            user.addAfinidade(getSubtemas()[2], 1);
        } else {
            user.addAfinidade(getTema(), -1);
            user.addAfinidade(getSubtemas()[0], -1);
            user.addAfinidade(getSubtemas()[1], -1);
            user.addAfinidade(getSubtemas()[2], -1);
        }
    }
}
