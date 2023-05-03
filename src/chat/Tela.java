package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela extends JFrame {
    
    public Tela() {
        super("Tela de Controle");
        
        JButton botaoServidor = new JButton("Iniciar Servidor");
        JButton botaoCliente = new JButton("Iniciar Cliente");
        
    
        botaoServidor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Servidor servidor = new Servidor();
                Thread s = new Thread(servidor);
                s.start();
				
            }
        });
        

        botaoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Cliente cliente = new Cliente();
                Thread c = new Thread(cliente);
                c.start();
				
            }
        });
        

        JPanel painelBotoes = new JPanel(new GridLayout(2, 1));
        painelBotoes.add(botaoServidor);
        painelBotoes.add(botaoCliente);
        
        getContentPane().add(painelBotoes, BorderLayout.CENTER);
        
        setSize(200, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Tela();
    }
}
