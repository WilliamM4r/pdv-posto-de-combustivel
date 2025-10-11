
package com.br.pdvfrontend.view;

import com.br.pdvfrontend.model.Pessoa;
import com.br.pdvfrontend.service.PessoaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PessoaList extends JFrame {

    private JTable pessoaTable;
    private JButton novoButton;
    private JButton editarButton;
    private JButton excluirButton;
    private PessoaService pessoaService;

    public PessoaList() {
        super("Listagem de Pessoas - PDV Frontend");
        this.pessoaService = new PessoaService();
        initializeUI();
        loadPessoas();
    }

    private void initializeUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Nome", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        pessoaTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(pessoaTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        novoButton = new JButton("Novo");
        editarButton = new JButton("Editar");
        excluirButton = new JButton("Excluir");

        novoButton.addActionListener(e -> openPessoaForm(null));
        editarButton.addActionListener(e -> handleEditar());
        excluirButton.addActionListener(e -> handleExcluir());

        buttonPanel.add(novoButton);
        buttonPanel.add(editarButton);
        buttonPanel.add(excluirButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null); // Centraliza a janela
    }

    private void loadPessoas() {
        DefaultTableModel model = (DefaultTableModel) pessoaTable.getModel();
        model.setRowCount(0); // Limpa as linhas existentes

        List<Pessoa> pessoas = pessoaService.buscarTodas();

        for (Pessoa p : pessoas) {
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getEmail()});
        }
    }

    private void openPessoaForm(Pessoa pessoa) {
        PessoaForm form = new PessoaForm(this, pessoa);
        form.setVisible(true);
    }

    private void handleEditar() {
        int selectedRow = pessoaTable.getSelectedRow();
        if (selectedRow >= 0) {

            Long pessoaId = (Long) pessoaTable.getValueAt(selectedRow, 0);

            Pessoa pessoaParaEditar = new Pessoa(pessoaId,
                    (String) pessoaTable.getValueAt(selectedRow, 1),
                    (String) pessoaTable.getValueAt(selectedRow, 2));

            openPessoaForm(pessoaParaEditar);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void handleExcluir() {
        int selectedRow = pessoaTable.getSelectedRow();
        if (selectedRow >= 0) {
            Long pessoaId = (Long) pessoaTable.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir a Pessoa ID " + pessoaId + "?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Pessoa excluída (simulado).", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                loadPessoas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void reloadList() {
        loadPessoas();
    }
}