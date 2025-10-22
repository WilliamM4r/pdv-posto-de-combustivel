package com.br.pdvpostocombustivel.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ProdutoCRUD extends JFrame {

    private JTextField txtNome, txtReferencia, txtFornecedor, txtCategoria, txtMarca;
    private JButton btnAdicionar, btnEditar, btnExcluir;
    private JTable tabela;
    private DefaultTableModel modelo;

    public ProdutoCRUD() {
        setTitle("Cadastro de Produtos - Posto de Gasolina");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel painelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Gerenciar Produtos"));
        painelFormulario.setBackground(new Color(245, 245, 245));

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Referência:"));
        txtReferencia = new JTextField();
        painelFormulario.add(txtReferencia);

        painelFormulario.add(new JLabel("Fornecedor:"));
        txtFornecedor = new JTextField();
        painelFormulario.add(txtFornecedor);

        painelFormulario.add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        painelFormulario.add(txtCategoria);

        painelFormulario.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        painelFormulario.add(txtMarca);

        // Painel de Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);

        // Painel Superior
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(painelFormulario, BorderLayout.CENTER);
        painelSuperior.add(painelBotoes, BorderLayout.SOUTH);

        // Tabela
        modelo = new DefaultTableModel(new Object[]{"Nome", "Referência", "Fornecedor", "Categoria", "Marca"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // Adiciona componentes ao JFrame
        add(painelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarProduto());
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());

        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.getSelectedRow();
                if (linha != -1) {
                    txtNome.setText(modelo.getValueAt(linha, 0).toString());
                    txtReferencia.setText(modelo.getValueAt(linha, 1).toString());
                    txtFornecedor.setText(modelo.getValueAt(linha, 2).toString());
                    txtCategoria.setText(modelo.getValueAt(linha, 3).toString());
                    txtMarca.setText(modelo.getValueAt(linha, 4).toString());
                }
            }
        });
    }

    private void adicionarProduto() {
        modelo.addRow(new Object[]{
                txtNome.getText(),
                txtReferencia.getText(),
                txtFornecedor.getText(),
                txtCategoria.getText(),
                txtMarca.getText()
        });
        limparCampos();
    }

    private void editarProduto() {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            modelo.setValueAt(txtNome.getText(), linha, 0);
            modelo.setValueAt(txtReferencia.getText(), linha, 1);
            modelo.setValueAt(txtFornecedor.getText(), linha, 2);
            modelo.setValueAt(txtCategoria.getText(), linha, 3);
            modelo.setValueAt(txtMarca.getText(), linha, 4);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
        }
    }

    private void excluirProduto() {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            modelo.removeRow(linha);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.");
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtReferencia.setText("");
        txtFornecedor.setText("");
        txtCategoria.setText("");
        txtMarca.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProdutoCRUD().setVisible(true));
    }
}