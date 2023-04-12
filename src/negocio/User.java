package negocio;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, Integer> afinidades;

    public User() {
        afinidades = new HashMap<>();
    }

    public void addAfinidade(String tema, int valor) {
        if (afinidades.containsKey(tema)) {
            int af = afinidades.get(tema);
            afinidades.put(tema, af + valor);
        } else {
            afinidades.put(tema, valor);
        }
    }

    public static Map<String, Integer> getAfinidades() {
        return afinidades;
    }
}
//teste3