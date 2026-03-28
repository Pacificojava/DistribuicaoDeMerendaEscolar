package DistribuicaoAlimentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    private List<Alimentos> listadeAlimentos = new ArrayList<>();
    private List<Escolas> listadeEscolas = new ArrayList<>();

    public Main() {
        setTitle("Sistema de Distribuição de Alimentos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton btnNutricionista = new JButton("Acesso Nutricionista");
        JButton btnAgenteEstoque = new JButton("Acesso Agente de Estoque");

        btnNutricionista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaNutricionista();
            }
        });

        btnAgenteEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaAgenteEstoque();
            }
        });

        panel.add(btnNutricionista);
        panel.add(btnAgenteEstoque);
        add(panel);
    }

    private void abrirJanelaNutricionista() {
        // Janela para Nutricionista: adicionar escolas e calcular distribuição
        JFrame frameNutri = new JFrame("Painel da Nutricionista");
        frameNutri.setSize(500, 400);
        frameNutri.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameNutri.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton btnAdicionarEscola = new JButton("Adicionar Escola");
        JButton btnCalcularDistribuicao = new JButton("Calcular Distribuição");
        JButton btnVerificarEscolas = new JButton("Verificar Escolas");

        btnAdicionarEscola.addActionListener(e -> {
            // Lógica para adicionar escola via GUI
            // Por simplicidade, usar JOptionPane
            String nome = javax.swing.JOptionPane.showInputDialog("Nome da Escola:");
            String qAlunosStr = javax.swing.JOptionPane.showInputDialog("Quantidade de Alunos:");
            if (nome != null && qAlunosStr != null) {
                try {
                    int qAlunos = Integer.parseInt(qAlunosStr);
                    Escolas escola = new Escolas();
                    escola.Nomes = nome;
                    escola.QAlunos = qAlunos;
                    listadeEscolas.add(escola);
                    javax.swing.JOptionPane.showMessageDialog(null, "Escola adicionada!");
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                }
            }
        });

        btnCalcularDistribuicao.addActionListener(e -> {
            if (listadeAlimentos.isEmpty() || listadeEscolas.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Adicione alimentos e escolas primeiro!");
                return;
            }
            // Calcular totais
            double TotalAlimento = 0;
            for (Alimentos a : listadeAlimentos) {
                TotalAlimento += a.qGramas;
            }
            int TotalAlunos = 0;
            for (Escolas esc : listadeEscolas) {
                TotalAlunos += esc.QAlunos;
            }
            // Calcular Destinado
            for (Escolas esc : listadeEscolas) {
                esc.Destinado = (TotalAlimento * esc.QAlunos) / TotalAlunos;
            }
            // Perguntar quantos dias
            String daysStr = javax.swing.JOptionPane.showInputDialog("Quantos dias a distribuição vai durar?");
            if (daysStr == null) return;
            try {
                int days = Integer.parseInt(daysStr);
                double porcaoDiaria = (105 + 35 + 25 + 80 + 40) / 1000.0; // 0.285 kg por aluno por dia
                double totalNeeded = porcaoDiaria * TotalAlunos * days;
                StringBuilder sb = new StringBuilder("Distribuição de Alimentos para " + days + " dias:\n");
                for (Escolas esc : listadeEscolas) {
                    sb.append("Escola: ").append(esc.Nomes).append(" | Destinado: ").append(String.format("%.2f", esc.Destinado)).append(" kilos\n");
                }
                if (totalNeeded > TotalAlimento) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Estoque insuficiente para " + days + " dias. Necessário: " + String.format("%.2f", totalNeeded) + " kg, Disponível: " + String.format("%.2f", TotalAlimento) + " kg");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
                }
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Número de dias inválido!");
            }
        });

        btnVerificarEscolas.addActionListener(e -> {
            if (listadeEscolas.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhuma escola adicionada!");
                return;
            }
            StringBuilder sb = new StringBuilder("Lista de Escolas:\n");
            for (Escolas esc : listadeEscolas) {
                sb.append("Nome: ").append(esc.Nomes).append(" | Quantidade de Alunos: ").append(esc.QAlunos).append("\n");
            }
            javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
        });

        panel.add(btnAdicionarEscola);
        panel.add(btnCalcularDistribuicao);
        panel.add(btnVerificarEscolas);
        frameNutri.add(panel);
        frameNutri.setVisible(true);
    }

    private void abrirJanelaAgenteEstoque() {
        // Janela para Agente de Estoque: adicionar alimentos
        JFrame frameEstoque = new JFrame("Painel do Agente de Estoque");
        frameEstoque.setSize(500, 400);
        frameEstoque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEstoque.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton btnAdicionarAlimento = new JButton("Adicionar Alimento");
        JButton btnVerificarAlimentos = new JButton("Verificar Alimentos");

        btnAdicionarAlimento.addActionListener(e -> {
            String nome = javax.swing.JOptionPane.showInputDialog("Nome do Alimento:");
            String qGramasStr = javax.swing.JOptionPane.showInputDialog("Quantidade em Kilos:");
            if (nome != null && qGramasStr != null) {
                try {
                    float qGramas = Float.parseFloat(qGramasStr);
                    Alimentos alimento = new Alimentos();
                    alimento.Nome = nome;
                    alimento.qGramas = qGramas;
                    listadeAlimentos.add(alimento);
                    javax.swing.JOptionPane.showMessageDialog(null, "Alimento adicionado!");
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                }
            }
        });

        btnVerificarAlimentos.addActionListener(e -> {
            if (listadeAlimentos.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhum alimento adicionado!");
                return;
            }
            StringBuilder sb = new StringBuilder("Lista de Alimentos:\n");
            for (Alimentos ali : listadeAlimentos) {
                sb.append("Nome: ").append(ali.Nome).append(" | Quantidade: ").append(ali.qGramas).append(" kilos\n");
            }
            javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
        });

        panel.add(btnAdicionarAlimento);
        panel.add(btnVerificarAlimentos);
        frameEstoque.add(panel);
        frameEstoque.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}

