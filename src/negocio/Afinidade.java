package negocio;

import java.util.List;

//Variavel Afinidade e seus metodos para implementação
public class Afinidade extends User {
    private Tema tema;
    private Integer valor;
    

    public Afinidade(Tema tema, Integer valor) {
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
