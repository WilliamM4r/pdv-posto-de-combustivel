package com.br.pdvfrontend.view;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        // Garante que a interface gráfica (Swing) seja executada na thread de eventos (EDT)
        SwingUtilities.invokeLater(() -> {
            // A aplicação começa chamando a tela principal (Listagem)
            PessoaList frame = new PessoaList();
            frame.setVisible(true);
        });
    }
}