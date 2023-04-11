package LoginSystem;

import dados.PerfilDAO;
import negocio.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerfilDAO perfilDAO = new PerfilDAOImpl();
        User user = new User();

        System.out.println("Bem-vindo ao sistema de criação de perfil de usuário.");
        System.out.println("Por favor, responda às seguintes perguntas sobre suas preferências em relação a imagens:");

        // tema 1: esportes
        Map<String, List<String>> subtemas1 = new HashMap<>();
        subtemas1.put("Futebol", Arrays.asList("futebol1.jpg", "futebol2.jpg", "futebol3.jpg"));
        subtemas1.put("Basquete", Arrays.asList("basquete1.jpg", "basquete2.jpg", "basquete3.jpg"));
        subtemas1.put("Vôlei", Arrays.asList("volei1.jpg", "volei2.jpg", "volei3.jpg"));
        Tema tema1 = new Tema("Esportes", subtemas1);

        // tema 2: cultura pop
        Map<String, List<String>> subtemas2 = new HashMap<>();
        subtemas2.put("Filmes", Arrays.asList("filmes1.jpg", "filmes2.jpg", "filmes3.jpg"));
        subtemas2.put("Séries", Arrays.asList("series1.jpg", "series2.jpg", "series3.jpg"));
        subtemas2.put("Música", Arrays.asList("musica1.jpg", "musica2.jpg", "musica3.jpg"));
        Tema tema2 = new Tema("Cultura Pop", subtemas2);

        // tema 3: estilo de vida
        Map<String, List<String>> subtemas3 = new HashMap<>();
        subtemas3.put("Viagem", Arrays.asList("viagem1.jpg", "viagem2.jpg", "viagem3.jpg"));
        subtemas3.put("Gastronomia", Arrays.asList("gastronomia1.jpg", "gastronomia2.jpg", "gastronomia3.jpg"));
        subtemas3.put("Moda", Arrays.asList("moda1.jpg", "moda2.jpg", "moda3.jpg"));
        Tema tema3 = new Tema("Estilo de Vida", subtemas3);

        List<Tema> temas = Arrays.asList(tema1, tema2, tema3);

        for (int i = 0; i < 15; i++) {
            ;
            System.out.println("\nPergunta " + (i + 1));
            System.out.println("Qual imagem você mais gosta?");

            for (int j = 0; j < temas.size(); j++) {
                System.out.println((j + 1) + " - " + temas.get(j).getNome());
            }

            int escolhaTema = -1;
            do {
                try {
                    escolhaTema = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um número válido.");
                }
            } while (escolhaTema < 1 || escolhaTema > temas.size());

            Tema temaEscolhido = temas.get(escolhaTema - 1);

            System.out.println("\nEscolha um subtema:");

            List<String> subtemas = new ArrayList<>(temaEscolhido.getSubtemas().keySet());
            for (int j = 15 * 3; j < (i + 1) * 3; j++) {
                System.out.println((j - 15 * 3 + 1) + " - " + subtemas.get(j - 15 * 3));
            }
            int escolhaSubtema = -1;
            do {
                try {
                    escolhaSubtema = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um número válido.");
                }
            } while (escolhaSubtema < 1 || escolhaSubtema > 3);

            String subtemaEscolhido = subtemas.get((escolhaSubtema - 1) + 15 * 3);

            user.addAfinidade(subtemaEscolhido, 1);
        }

        perfilDAO.salvar(User().getAfinidades());

        System.out.println("\nPerfil criado com sucesso!");
    }
}





















