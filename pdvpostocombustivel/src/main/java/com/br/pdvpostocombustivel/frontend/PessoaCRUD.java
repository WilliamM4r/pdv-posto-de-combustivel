package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class PessoaCRUD extends JFrame {
    private JTextField txtNome, txtCpfCnpj, txtNumeroCtpj;
    private JComboBox<String> cbTipoPessoa;
    private JTable tabela;
    private DefaultTableModel modelo;
    private PessoaDAO dao = new PessoaDAO();

    public PessoaCRUD() {
        setTitle("CRUD - Pessoa");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro de Pessoa"));

        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("CPF/CNPJ:"));
        txtCpfCnpj = new JTextField();
        painel.add(txtCpfCnpj);

        painel.add(new JLabel("Número CTPJ:"));
        txtNumeroCtpj = new JTextField();
        painel.add(txtNumeroCtpj);

        painel.add(new JLabel("Tipo de Pessoa:"));
        cbTipoPessoa = new JComboBox<>(new String[]{"Física", "Jurídica"});
        painel.add(cbTipoPessoa);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        painel.add(btnAdicionar);
        painel.add(btnEditar);
        painel.add(btnExcluir);

        modelo = new DefaultTableModel(new Object[]{"Nome", "CPF/CNPJ", "CTPJ", "Tipo"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarPessoa());
        btnEditar.addActionListener(e -> editarPessoa());
        btnExcluir.addActionListener(e -> excluirPessoa());

        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.getSelectedRow();
                if (linha != -1) {
                    txtNome.setText(modelo.getValueAt(linha, 0).toString());
                    txtCpfCnpj.setText(modelo.getValueAt(linha, 1).toString());
                    txtNumeroCtpj.setText(modelo.getValueAt(linha, 2).toString());
                    cbTipoPessoa.setSelectedItem(modelo.getValueAt(linha, 3).toString());
                }
            }
        });
    }

    private void adicionarPessoa() {
        String nome = txtNome.getText();
        String cpfCnpj = txtCpfCnpj.getText();
        String numeroCtpj = txtNumeroCtpj.getText();
        String tipo = (String) cbTipoPessoa.getSelectedItem();

        if (nome.isEmpty() || cpfCnpj.isEmpty() || numeroCtpj.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Pessoa p = new Pessoa(nome, cpfCnpj, numeroCtpj, tipo);
        dao.adicionar(p);
        modelo.addRow(new Object[]{nome, cpfCnpj, numeroCtpj, tipo});
        limparCampos();
    }

    private void editarPessoa() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para editar!");
            return;
        }

        String nome = txtNome.getText();
        String cpfCnpj = txtCpfCnpj.getText();
        String numeroCtpj = txtNumeroCtpj.getText();
        String tipo = (String) cbTipoPessoa.getSelectedItem();

        Pessoa p = new Pessoa(nome, cpfCnpj, numeroCtpj, tipo);
        dao.atualizar(linha, p);
        modelo.setValueAt(nome, linha, 0);
        modelo.setValueAt(cpfCnpj, linha, 1);
        modelo.setValueAt(numeroCtpj, linha, 2);
        modelo.setValueAt(tipo, linha, 3);
        limparCampos();
    }

    private void excluirPessoa() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para excluir!");
            return;
        }

        dao.remover(linha);
        modelo.removeRow(linha);
        limparCampos();
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpfCnpj.setText("");
        txtNumeroCtpj.setText("");
        cbTipoPessoa.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PessoaCRUD().setVisible(true));
    }
}