package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Acesso;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private AcessoDAO dao;

    public LoginFrame() {
        dao = new AcessoDAO();

        // Adiciona um usuário padrão para login inicial
        dao.adicionar(new Acesso("admin", "1234"));

        setTitle("Login - Sistema de Pessoas");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(3, 2, 5, 5));
        painel.setBorder(BorderFactory.createTitledBorder("Acesso ao Sistema"));

        painel.add(new JLabel("Usuário:"));
        txtUsuario = new JTextField();
        painel.add(txtUsuario);

        painel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        painel.add(txtSenha);

        JButton btnLogin = new JButton("Entrar");
        painel.add(btnLogin);

        JButton btnSair = new JButton("Sair");
        painel.add(btnSair);

        add(painel);

        btnLogin.addActionListener(e -> fazerLogin());
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void fazerLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (dao.validarLogin(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            PessoaCRUD telaCrud = new PessoaCRUD(dao);
            telaCrud.setVisible(true);
            dispose(); // fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}