package dados;

import negocio.PerfilUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PerfilDAOImpl implements PerfilDAO {

    private static final String FILE_NAME = "perfis.bin";

    private List<PerfilUser> perfis;

    public PerfilDAOImpl() {
        carregarPerfis();
    }

    public List<PerfilUser> getPerfis() {
        return perfis;
    }

    // Adiciona um novo perfil de usuário à lista de perfis e salva no arquivo
    public void salvarPerfilUser(PerfilUser perfil) {
        perfis.add(perfil);
        salvarPerfis();
    }

    public void atualizarPerfilUser(PerfilUser perfil) {
        int index = perfis.indexOf(perfil);
        perfis.set(index, perfil);
        salvarPerfis();
    }

    public void excluirPerfilUser(PerfilUser perfil) {
        perfis.remove(perfil);
        salvarPerfis();
    }
    
    // Salva a lista de perfis de usuários no arquivo
    private void salvarPerfis() {
        try {
            File file = new File(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(perfis);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void carregarPerfis() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                perfis = (List<PerfilUser>) in.readObject();
                in.close();
            } else {
                perfis = new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    // Métodos da interface PerfilDAO que precisam ser implementados
    @Override
    public void inserir(PerfilUser PerfilUser) throws SQLException {
        perfis.add(PerfilUser);
        salvarPerfis();
    }

    @Override
    public void atualizar(PerfilUser PerfilUser) throws SQLException {
        int index = perfis.indexOf(PerfilUser);
        perfis.set(index, PerfilUser);
        salvarPerfis();
    }

    @Override
    public void excluir(String user) throws SQLException {
        for (PerfilUser perfil : perfis) {
            if (perfil.getUser().equals(user)) {
                perfis.remove(perfil);
                salvarPerfis();
                break;
            }
        }
    }

    @Override
    public List<PerfilUser> listar() throws SQLException {
        return perfis;
    }
}

