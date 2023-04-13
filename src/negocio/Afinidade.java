package negocio;

public class Afinidade extends User {
    private Tema tema;
    private Integer valor;

    public Afinidade("esportes", 8) {
        this.tema = tema;
        this.valor = valor;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
