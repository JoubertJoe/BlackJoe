package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menu {

	private JFrame frame;
	JTextField txtJogador01;
	JTextField txtJogador02;
	JTextField txtJogador03;
	JTextField txtJogador04;
	static JSpinner spinner;
	Menu este;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		este = this;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.getContentPane().setLayout(null);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner.setBounds(612, 296, 39, 21);
		frame.getContentPane().add(spinner);
		
		

		JButton btnJogadores = new JButton("Jogadores");
		btnJogadores.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		btnJogadores.setBackground(Color.WHITE);
		btnJogadores.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnJogadores.setBounds(660, 295, 110, 21);
		frame.getContentPane().add(btnJogadores);

		txtJogador01 = new JTextField("Jogador 01 :");
		txtJogador01.setHorizontalAlignment(SwingConstants.CENTER);
		txtJogador01.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtJogador01.setBounds(612, 340, 158, 20);
		frame.getContentPane().add(txtJogador01);

		txtJogador02 = new JTextField("Jogador 02 :");
		txtJogador02.setHorizontalAlignment(SwingConstants.CENTER);
		txtJogador02.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtJogador02.setBounds(612, 370, 158, 20);
		frame.getContentPane().add(txtJogador02);

		txtJogador03 = new JTextField("Jogador 03 :");
		txtJogador03.setHorizontalAlignment(SwingConstants.CENTER);
		txtJogador03.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtJogador03.setBounds(612, 400, 158, 20);
		frame.getContentPane().add(txtJogador03);

		txtJogador04 = new JTextField("Jogador 04 :");
		txtJogador04.setHorizontalAlignment(SwingConstants.CENTER);
		txtJogador04.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtJogador04.setBounds(612, 430, 158, 20);
		frame.getContentPane().add(txtJogador04);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon("img/blackJack.jpg"));
		lblFundo.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(lblFundo);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnJogadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Jogador1 jogador = new Jogador1(este);
				
				jogador.numJogadores();
				frame.dispose();

			}
		});
	}
}
