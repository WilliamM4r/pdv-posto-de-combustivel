package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Acesso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AcessoCRUD extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JTable tabela;
    private DefaultTableModel modelo;
    private AcessoDAO dao;

    public AcessoCRUD(AcessoDAO dao) {
        this.dao = dao;

        setTitle("Sistema - Gerenciar Pessoas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 5, 5));
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro de Pessoa"));

        painel.add(new JLabel("Usuário:"));
        txtUsuario = new JTextField();
        painel.add(txtUsuario);

        painel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        painel.add(txtSenha);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");

        painel.add(btnAdicionar);
        painel.add(btnEditar);
        painel.add(btnExcluir);

        modelo = new DefaultTableModel(new Object[]{"Usuário", "Senha"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Ações
        btnAdicionar.addActionListener(e -> adicionarPessoa());
        btnEditar.addActionListener(e -> editarPessoa());
        btnExcluir.addActionListener(e -> excluirPessoa());

        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.getSelectedRow();
                if (linha != -1) {
                    txtUsuario.setText(modelo.getValueAt(linha, 0).toString());
                    txtSenha.setText(modelo.getValueAt(linha, 1).toString());
                }
            }
        });
    }

    private void adicionarPessoa() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Acesso p = new Acesso(usuario, senha);
        dao.adicionar(p);
        modelo.addRow(new Object[]{usuario, senha});
        limparCampos();
    }

    private void editarPessoa() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para editar!");
            return;
        }

        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        Acesso p = new Acesso(usuario, senha);
        dao.atualizar(linha, p);
        modelo.setValueAt(usuario, linha, 0);
        modelo.setValueAt(senha, linha, 1);
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
        txtUsuario.setText("");
        txtSenha.setText("");
    }
}