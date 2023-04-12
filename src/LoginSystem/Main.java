import GUI.TelaPrincipal;
import dados.PerfilDAO;
import dados.PerfilDAOImpl;
import negocio.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo(a) ao Sistema de Perfil de Usuários!");

        PerfilDAO perfilDAO = new PerfilDAOImpl();

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        User user = perfilDAO.buscarUser(nome);
        if (user == null) {
            user = new User();
            user.setNome(nome);
            perfilDAO.salvarUser(user);
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Usuário encontrado!");
            System.out.println("Afinidades já cadastradas:");
            user.getAfinidades().forEach((tema, afinidade) -> System.out.println("- " + tema + ": " + afinidade));
        }

        TelaPrincipal telaPrincipal = new TelaPrincipal(perfilDAO, user);
        telaPrincipal.exibir();
    }
}






















