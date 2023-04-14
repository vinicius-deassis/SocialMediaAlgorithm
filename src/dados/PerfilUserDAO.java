package dados;

import java.util.ArrayList;
import java.util.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class PerfilUserDAO {

    private static final String FILE_PATH = "perfis.dat";
    private ArrayList<Map<String, Integer>> usuarios = new ArrayList<>();

    public void salvar(Map<String, Integer> afinidades) {
        usuarios.add(afinidades);
    }

    public ArrayList<Map<String, Integer>> getUsuarios() {
        return usuarios;
    }

}
