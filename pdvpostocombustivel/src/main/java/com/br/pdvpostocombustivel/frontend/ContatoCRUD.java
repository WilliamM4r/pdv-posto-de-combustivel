package com.br.pdvpostocombustivel.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ContatoCRUD extends JFrame {

    private JTextField txtPessoa, txtTelefone, txtEmail, txtEndereco;
    private JButton btnAdicionar, btnEditar, btnExcluir;
    private JTable tabela;
    private DefaultTableModel modelo;

    public ContatoCRUD() {
        setTitle("Cadastro de Contatos");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Gerenciar Contatos"));
        painelFormulario.setBackground(new Color(245, 245, 245));

        painelFormulario.add(new JLabel("Pessoa:"));
        txtPessoa = new JTextField();
        painelFormulario.add(txtPessoa);

        painelFormulario.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        painelFormulario.add(txtTelefone);

        painelFormulario.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        painelFormulario.add(txtEmail);

        painelFormulario.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painelFormulario.add(txtEndereco);

        // Painel de Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);

        // Painel superior (formulário + botões)
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(painelFormulario, BorderLayout.CENTER);
        painelSuperior.add(painelBotoes, BorderLayout.SOUTH);

        // Tabela
        modelo = new DefaultTableModel(new Object[]{"Pessoa", "Telefone", "Email", "Endereço"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // Adiciona tudo ao JFrame
        add(painelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Eventos dos botões
        btnAdicionar.addActionListener(e -> adicionarContato());
        btnEditar.addActionListener(e -> editarContato());
        btnExcluir.addActionListener(e -> excluirContato());

        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.getSelectedRow();
                if (linha != -1) {
                    txtPessoa.setText(modelo.getValueAt(linha, 0).toString());
                    txtTelefone.setText(modelo.getValueAt(linha, 1).toString());
                    txtEmail.setText(modelo.getValueAt(linha, 2).toString());
                    txtEndereco.setText(modelo.getValueAt(linha, 3).toString());
                }
            }
        });
    }

    private void adicionarContato() {
        modelo.addRow(new Object[]{
                txtPessoa.getText(),
                txtTelefone.getText(),
                txtEmail.getText(),
                txtEndereco.getText()
        });
        limparCampos();
    }

    private void editarContato() {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            modelo.setValueAt(txtPessoa.getText(), linha, 0);
            modelo.setValueAt(txtTelefone.getText(), linha, 1);
            modelo.setValueAt(txtEmail.getText(), linha, 2);
            modelo.setValueAt(txtEndereco.getText(), linha, 3);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para editar.");
        }
    }

    private void excluirContato() {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            modelo.removeRow(linha);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir.");
        }
    }

    private void limparCampos() {
        txtPessoa.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContatoCRUD().setVisible(true));
    }
}