package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstoqueCRUD extends JFrame {
    private final JTextField txtDataValidade = new JTextField(10);
    private final JTextField txtQuantidade = new JTextField(5);
    private final JTextField txtLocalTanque = new JTextField(10);
    private final JTextField txtLocalEndereco = new JTextField(15);
    private final JTextField txtLocalFabricacao = new JTextField(10);
    private final DefaultTableModel modeloTabela;
    private final JTable tabela;
    private final EstoqueDAO estoqueDAO = new EstoqueDAO();

    public EstoqueCRUD() {
        setTitle("Gerenciamento de Estoque - Posto de Combustível");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel painelTopo = new JPanel(new GridLayout(3, 4, 5, 5));
        painelTopo.setBorder(BorderFactory.createTitledBorder("Informações do Estoque"));

        painelTopo.add(new JLabel("Data de Validade:"));
        painelTopo.add(txtDataValidade);
        painelTopo.add(new JLabel("Quantidade:"));
        painelTopo.add(txtQuantidade);
        painelTopo.add(new JLabel("Local do Tanque:"));
        painelTopo.add(txtLocalTanque);
        painelTopo.add(new JLabel("Endereço:"));
        painelTopo.add(txtLocalEndereco);
        painelTopo.add(new JLabel("Local de Fabricação:"));
        painelTopo.add(txtLocalFabricacao);

        add(painelTopo, BorderLayout.NORTH);

        // Botões
        JPanel painelBotoes = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);

        add(painelBotoes, BorderLayout.SOUTH);

        // Tabela
        modeloTabela = new DefaultTableModel(
                new String[]{"Data Validade", "Quantidade", "Local Tanque", "Endereço", "Fabricação"}, 0);
        tabela = new JTable(modeloTabela);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Eventos dos botões
        btnAdicionar.addActionListener(e -> adicionar());
        btnEditar.addActionListener(e -> editar());
        btnExcluir.addActionListener(e -> excluir());

        setVisible(true);
    }

    private void adicionar() {
        try {
            LocalDate dataValidade = LocalDate.parse(txtDataValidade.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            BigDecimal quantidade = new BigDecimal(txtQuantidade.getText());

            String localTanque = txtLocalTanque.getText();
            String localEndereco = txtLocalEndereco.getText();
            String localFabricacao = txtLocalFabricacao.getText();

            Estoque estoque = new Estoque(dataValidade, quantidade, localTanque, localEndereco, localFabricacao);
            estoqueDAO.adicionar(estoque);

            atualizarTabela();
            limparCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar: verifique os valores!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editar() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            try {
                LocalDate dataValidade = LocalDate.parse(txtDataValidade.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                BigDecimal quantidade = new BigDecimal(txtQuantidade.getText());
                String localTanque = txtLocalTanque.getText();
                String localEndereco = txtLocalEndereco.getText();
                String localFabricacao = txtLocalFabricacao.getText();

                Estoque estoque = new Estoque(dataValidade, quantidade, localTanque, localEndereco, localFabricacao);
                estoqueDAO.atualizar(linha, estoque);
                atualizarTabela();
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao editar: verifique os valores!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para editar!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void excluir() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            estoqueDAO.remover(linha);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para excluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Estoque e : estoqueDAO.listar()) {
            modeloTabela.addRow(new Object[]{
                    e.getDataValidade(),
                    e.getQuantidade(),
                    e.getLocalTanque(),
                    e.getLocalEndereco(),
                    e.getLoteFabricacao()
            });
        }
    }

    private void limparCampos() {
        txtDataValidade.setText("");
        txtQuantidade.setText("");
        txtLocalTanque.setText("");
        txtLocalEndereco.setText("");
        txtLocalFabricacao.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EstoqueCRUD::new);
    }
}
