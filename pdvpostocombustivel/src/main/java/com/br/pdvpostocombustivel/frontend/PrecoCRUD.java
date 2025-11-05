package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Preco;

import java.math.BigDecimal;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PrecoCRUD extends JFrame {
    private final JTextField txtValor = new JTextField(10);
    private final JTable tabela;
    private final DefaultTableModel modeloTabela;
    private final PrecoDAO precoDAO = new PrecoDAO();

    public PrecoCRUD() {
        setTitle("Gerenciador de Preços - Posto de Combustível");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Valor (R$):"));
        painelSuperior.add(txtValor);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");

        painelSuperior.add(btnAdicionar);
        painelSuperior.add(btnEditar);
        painelSuperior.add(btnExcluir);

        add(painelSuperior, BorderLayout.NORTH);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"Valor (R$)", "Data Alteração", "Hora Alteração"}, 0);
        tabela = new JTable(modeloTabela);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarPreco());
        btnEditar.addActionListener(e -> editarPreco());
        btnExcluir.addActionListener(e -> excluirPreco());

        setVisible(true);
    }

    private void adicionarPreco() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            Preco preco = new Preco(
                    BigDecimal.valueOf(valor),
                    (Data) new Date(),
                    (Data) new Date()
            );
                    precoDAO.adicionar(preco);
            atualizarTabela();
            txtValor.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor numérico válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarPreco() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            try {
                double novoValor = Double.parseDouble(txtValor.getText());
                Preco preco = precoDAO.listar().get(linha);

                preco.setValor(BigDecimal.valueOf(novoValor));
                preco.setDataAlteracao((Data) new Date());
                preco.setHoraAlteracao((Data) new Date());

                precoDAO.atualizar(linha, preco);
                atualizarTabela();
                txtValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Informe um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um preço para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void excluirPreco() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            precoDAO.remover(linha);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um preço para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Preco preco : precoDAO.listar()) {
            modeloTabela.addRow(new Object[]{
                    preco.getValor(),
                    preco.getDataAlteracao(),
                    preco.getHoraAlteracao()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PrecoCRUD::new);
    }
}
