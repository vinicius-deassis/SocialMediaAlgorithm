package LoginSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import negocio.Afinidade;
import negocio.PerfilUser;
import negocio.User;

public class Main {
    private static Map<String, Map<String, List<String>>> imagens = new HashMap<>();
    private static List<String> combinacoes = new ArrayList<>();
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void addImagem(String tema, String subtema, int afinidade, String caminho) {
        Map<String, List<String>> subtemas = imagens.get(tema);
        if (subtemas == null) {
            subtemas = new HashMap<>();
            imagens.put(tema, subtemas);
        }
        List<String> imagensAfinidade = subtemas.get(subtema);
        if (imagensAfinidade == null) {
            imagensAfinidade = new ArrayList<>();
            subtemas.put(subtema, imagensAfinidade);
        }
        imagensAfinidade.add(caminho);
    }

    public static void main(String[] args) throws IOException {

        // Configurar tratamento de exceções
        try {
            // código que pode gerar exceções
        } catch (Exception e) {
            // código que trata a exceção
        }

        // Criar alguns perfis de usuário
        Afinidade afinidade = new Afinidade();
        PerfilUser perfil1 = new PerfilUser(afinidade);
        PerfilUser perfil2 = new PerfilUser(afinidade);

        // Criar usuários com os perfis criados
        User user1 = new User("Vinicius", "vinicius", "fernandes", "afinidade");
        User user2 = new User("Nicolas", "nicolas", "assis", "afinidade");

        // Adicionar os usuários criados em uma lista
        List<User> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);

        // Pedir ao usuário que faça login
        System.out.println("Digite seu nome de usuário:");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        // Verificar se as credenciais são válidas
        User usuarioLogado = null;
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(nomeUsuario) && usuario.getPass().equals(senha)) {
                usuarioLogado = usuario;
                break;
            }
        }

        // Se as credenciais forem inválidas, exibir mensagem de erro e encerrar o programa
        if (usuarioLogado == null) {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return;
        }

        // Exibir informações do perfil do usuário logado
        System.out.println("Bem-vindo, " + usuarioLogado.getUsername() + "!");
        System.out.println("Aqui estão seus interesses:");
        System.out.println(usuarioLogado.getAfinidades());

        // Adicionar algumas imagens de exemplo
        addImagem("Tema1", "Subtema1", 1, "Images/animais/cachorro.jpg");
        addImagem("Tema1", "Subtema2", -1, "Images/animais/capivara.jpg");
        addImagem("Tema2", "Subtema1", 1, "Images/esportes/basquete.jpg");
        addImagem("Tema2", "Subtema2", -1, "Images/esportes/futebol.jpg");

        // Criar lista de todas as possíveis combinações de tema, subtema e afinidade
        for (String tema : imagens.keySet()) {
            for (String subtema : imagens.get(tema).keySet()) {
                List<String> imagensAfinidade = imagens.get(tema).get(subtema);
                for (int i = 0; i < imagensAfinidade.size(); i++) {
                    String caminhoImagem = imagensAfinidade.get(i);
                    String combinacao = tema + "_" + subtema + "_" + i;
                    combinacoes.add(combinacao);
                }
            }
        }

        // Embaralhar lista de combinações
        Collections.shuffle(combinacoes);

        // Gerar algumas combinações aleatórias de imagens com afinidades correspondentes
        for (int i = 0; i < 5; i++) {
            List<String> temas = new ArrayList<>(imagens.keySet());
            Collections.shuffle(temas);
            String tema = temas.get(0);

            Map<String, List<String>> subtemas = imagens.get(tema);
            List<String> subtemasList = new ArrayList<>(subtemas.keySet());
            Collections.shuffle(subtemasList);
            String subtema = subtemasList.get(0);

            List<String> imagensAfinidade = subtemas.get(subtema);
            Collections.shuffle(imagensAfinidade);
            String imagem = imagensAfinidade.get(0);

            int afinidadeValor = subtema.contains("1") ? 1 : -1;
            combinacoes.add(imagem + ";" + afinidadeValor);
        }

        // Exibir as combinações geradas e pedir ao usuário que escolha uma delas
        System.out.println("Aqui estão algumas combinações de imagens com afinidades correspondentes:");
        for (int i = 0; i < combinacoes.size(); i++) {
            String combinacao = combinacoes.get(i);
            System.out.println((i + 1) + ") " + combinacao.split(";")[0]);
        }
        System.out.println("Escolha uma das combinações acima (digite o número correspondente):");
        int escolha = scanner.nextInt();


        // Verificar a escolha do usuário e exibir a afinidade correspondente
        if (escolha >= 1 && escolha <= combinacoes.size()) {
            String combinacaoEscolhida = combinacoes.get(escolha - 1);
            int afinidadeEscolhida = Integer.parseInt(combinacaoEscolhida.split(";")[1]);
            usuarioLogado.getAfinidades().addAfinidade(afinidadeEscolhida);
            System.out.println("Sua afinidade foi atualizada para: " + usuarioLogado.getAfinidades());
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
        }
        usuarioLogado.addAfinidade("Tema1",  1);

        // Fechar o scanner
        scanner.close();
    }
}