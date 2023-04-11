package dados;

import negocio.User;

import java.io.*;

public class PerfilDAO {
    private static final String ARQUIVO_PERFIL = "perfil.dat";

    public static void salvar(User user) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PERFIL))) {
            objectOutputStream.writeObject(user);
        } catch (IOException ex) {
            throw new IOException("Erro ao salvar perfil do usuário.", ex);
        }
    }

    public static User carregarPerfil() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_PERFIL))) {
            return (User) objectInputStream.readObject();
        } catch (IOException ex) {
            throw new IOException("Erro ao carregar perfil do usuário.", ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Perfil do usuário não encontrado.", ex);
        }
    }

}
