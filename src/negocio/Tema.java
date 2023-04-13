package negocio;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tema {
    private String nome;
    private Map<String, List<Image>> subtemas;

    public Tema(String nome, Map<String, List<Image>> subtemas) {
        this.nome = nome;
        this.subtemas = subtemas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Tema getAnimaisTema() {
        Map<String, List<Image>> subtemas = new HashMap<>();
        subtemas.put("animais", Arrays.asList(
                new ImageIcon("Images/animais/cachorro.jpg").getImage(),
                new ImageIcon("Images/animais/capivara.jpg").getImage(),
                new ImageIcon("Images/animais/chinchilla.jpg").getImage()
        ));
        return new Tema("animais", subtemas);
    }

    public Map<String, List<Image>> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(Map<String, List<Image>> subtemas) {
        this.subtemas = subtemas;
    }
}
