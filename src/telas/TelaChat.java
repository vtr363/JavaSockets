package telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import chat.Cliente;
import chat.Servidor;
import chat.msgHandler;

public class TelaChat {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtIpDoServidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Inicia servidor
					Servidor servidor = new Servidor();
			        Thread s = new Thread(servidor);
			        s.start();
			        
					TelaChat window = new TelaChat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 406, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_471927241687600");
		panel.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(25, 207, 136, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		PrintStream printStream = new PrintStream(new msgHandler(textArea));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(25, 10, 207, 186);
		panel.add(textArea);

		JScrollPane scroll = new JScrollPane ( textArea );
		scroll.setBounds(10, 10,144,155);
    	scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panel.add(scroll);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.sendMsg(textField.getText());
				textField.setText("");
			}
		});

		System.setOut(printStream);
		btnNewButton.setBounds(171, 207, 61, 19);
		panel.add(btnNewButton);
		
		txtIpDoServidor = new JTextField();
		txtIpDoServidor.setToolTipText("IP do outro computador");
		txtIpDoServidor.setText("Ex.: 192.168.0.0");
		txtIpDoServidor.setBounds(286, 95, 96, 19);
		panel.add(txtIpDoServidor);
		txtIpDoServidor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IP:");
		lblNewLabel.setBounds(252, 98, 24, 13);
		panel.add(lblNewLabel);
		
		JTextPane txtpnSeuIp = new JTextPane();
		txtpnSeuIp.setEditable(false);
		txtpnSeuIp.setText(Servidor.ip);
		txtpnSeuIp.setBounds(269, 28, 96, 19);
		panel.add(txtpnSeuIp);
		
		JLabel lblNewLabel_2 = new JLabel("Seu IP:");
		lblNewLabel_2.setBounds(293, 16, 45, 13);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Conectar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente(txtIpDoServidor.getText());
                Thread c = new Thread(cliente);
                c.start();
				
			}
		});
		btnNewButton_1.setBounds(269, 124, 85, 21);
		panel.add(btnNewButton_1);
	}
}
