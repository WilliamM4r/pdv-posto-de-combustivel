
package com.br.pdvfrontend.view;

import com.br.pdvfrontend.model.Pessoa;
import com.br.pdvfrontend.service.PessoaService;

import javax.swing.*;
import java.awt.*;

public class PessoaForm extends JDialog {

    private JTextField idField;
    private JTextField nomeField;
    private JTextField emailField;
    private JButton salvarButton;
    private PessoaService pessoaService;
    private Pessoa pessoa; // Objeto a ser editado (se não for null, é edição)
    private PessoaList parentList; // Referência à tela de listagem

    public PessoaForm(PessoaList parentList, Pessoa pessoa) {
        super(parentList, true); // JDialog modal
        this.parentList = parentList;
        this.pessoa = pessoa;
        this.pessoaService = new PessoaService();

        if (pessoa == null) {
            setTitle("Nova Pessoa");
        } else {
            setTitle("Editar Pessoa - ID " + pessoa.getId());
        }

        initializeUI();
        loadData();
        pack();
        setLocationRelativeTo(parentList); // Centraliza em relação à janela principal
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        idField = new JTextField(10);
        idField.setEditable(false);

        nomeField = new JTextField(20);
        emailField = new JTextField(20);

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> savePessoa());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(salvarButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        if (this.pessoa != null) {
            idField.setText(String.valueOf(this.pessoa.getId()));
            nomeField.setText(this.pessoa.getNome());
            emailField.setText(this.pessoa.getEmail());
        }
    }

    private void savePessoa() {

        String nome = nomeField.getText();
        String email = emailField.getText();

        if (nome.trim().isEmpty() || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome e Email são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pessoa pessoaToSave = (this.pessoa != null) ? this.pessoa : new Pessoa();
        pessoaToSave.setNome(nome);
        pessoaToSave.setEmail(email);

        try {

            String msg = (this.pessoa == null) ? "Nova Pessoa salva (simulado)!" : "Pessoa atualizada (simulado)!";
            JOptionPane.showMessageDialog(this, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            parentList.reloadList();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}