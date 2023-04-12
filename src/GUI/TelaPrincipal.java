package GUI;

import LoginSystem.Pergunta;
import LoginSystem.Perguntas;
import dados.PerfilUserDAO;
import negocio.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class TelaPrincipal extends JFrame implements ActionListener {

    private static final int NUM_PERGUNTAS = 15;
    private Pergunta perguntas;

    private JPanel painel;
    private JButton botaoGostei;
    private JButton botaoNaoGostei;
    private JLabel imagem;
    private JLabel pergunta;
    private int perguntaAtual;
    private User user;
    private PerfilUserDAO perfilDAO;

    public TelaPrincipal(Perguntas perguntas) {
        super("Perfil do Usuário");

        // Inicializa os componentes da tela
        painel = new JPanel(new BorderLayout());
        imagem = new JLabel();
        pergunta = new JLabel();
        botaoGostei = new JButton("Gostei");
        botaoNaoGostei = new JButton("Não Gostei");

        // Adiciona os componentes ao painel
        painel.add(imagem, BorderLayout.CENTER);
        painel.add(pergunta, BorderLayout.NORTH);
        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add(botaoGostei);
        botoes.add(botaoNaoGostei);
        painel.add(botoes, BorderLayout.SOUTH);

        // Define as propriedades da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(painel);

        // Inicializa as variáveis
        perguntaAtual = 0;
        user = new User();
        perfilDAO = new PerfilUserDAO();

        // Define os eventos dos botões
        botaoGostei.addActionListener(this);
        botaoNaoGostei.addActionListener(this);

        // Exibe a primeira pergunta
        this.perguntas = perguntas;
        exibirPergunta();
    }

    private void exibirPergunta() {
        // Verifica se todas as perguntas já foram respondidas
        if (perguntaAtual >= NUM_PERGUNTAS) {
            // Calcula as afinidades do usuário e salva no banco de dados
            perfilDAO.salvar(user.getAfinidades());
            // Exibe as afinidades do usuário
            exibirAfinidades();
            return;
        }

        // Obtém a próxima pergunta
        Pergunta p = Pergunta.getPergunta(perguntaAtual);

        // Atualiza o texto da pergunta
        pergunta.setText(p.getPergunta());

        // Exibe a imagem correspondente à pergunta
        ImageIcon icone = new ImageIcon(getClass().getResource(p.getImagem()));
        imagem.setIcon(icone);

        // Atualiza o número da pergunta
        perguntaAtual++;
    }

    private void exibirAfinidades() {
        // Obtém as afinidades do usuário do banco de dados
        Map<String, Integer> afinidades = perfilDAO.getAfinidades();

        // Exibe as afinidades do usuário em uma nova janela
        JFrame frame = new JFrame("Afinidades do Usuário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel painelAfinidades = new JPanel(new GridLayout(0, 2));
        for (Map.Entry<String, Integer> entry : afinidades.entrySet()) {
            JLabel tema = new JLabel(entry.getKey());
            JLabel valor = new JLabel(entry.getValue().toString());
            painelAfinidades.add(tema);
            painelAfinidades.add(valor);
        }

        JScrollPane scroll = new JScrollPane(painelAfinidades);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(300, 250));
        JOptionPane.showMessageDialog(null, scroll, "Afinidades", JOptionPane.PLAIN_MESSAGE);

// Salvando perfil do usuário
        try {
            PerfilUserDAO.salvarPerfil(user);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar perfil do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}