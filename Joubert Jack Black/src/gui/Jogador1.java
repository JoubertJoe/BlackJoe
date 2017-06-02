package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import baralho.Baralho;
import gui.JLayer.MP3Musica;
import iftm.Regras;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.xml.bind.ParseConversionEvent;

public class Jogador1 extends JFrame {

	public JFrame frmBlackjackJoe;
	private final ButtonGroup groupJogadorDaVez = new ButtonGroup();
	public String carta1j1, carta2j1, carta3j1, carta4j1, carta1j2, carta2j2, carta3j2, carta4j2, carta1j3, carta2j3,
			carta3j3, carta4j3, carta1j4, carta2j4, carta3j4, carta4j4, cartaj1, carta0j1, cartaj2, carta0j2, cartaj3,
			carta0j3, cartaj4, carta0j4;
	Baralho deck = new Baralho();
	public JButton btnEmbaralhar;
	JRadioButton radioJ1, radioJ2, radioJ3, radioJ4;
	JButton btnRecomecar, btnVoltar, btnTerminar4, btnTerminar3, btnTerminar2, btnTerminar1, btnComprar;
	JLabel lblJ, lblPontos, lblPerder, lblGanhar, lblContinuar;
	public JLayer musica;
	Menu menu;
	Regras regra = new Regras();

	public Jogador1(Menu menuref) {
		menu = menuref;
		initialize();
	}

	void vencer(int jogador) {
		regra.placarJogador[jogador] = regra.placarJogador[jogador] + deck.getValor();
		if (regra.placarJogador[jogador] == 21) {
			JOptionPane.showMessageDialog(null,
					"EITA!!! Tu ganhou, levou a bolada toda!\n Tome um Whisky e comemore!!!");

			radioJ1.setEnabled(false);

			radioJ2.setEnabled(false);

			radioJ3.setEnabled(false);

			radioJ4.setEnabled(false);

		} else if (regra.placarJogador[jogador] > 21) {
			JOptionPane.showMessageDialog(null,
					"Aqui no tudo ou nada, funciona assim, estourou 21 já era!\n Não pare de jogar!\n (Cassinos não se pagam sozinhos)");
			if (jogador == 1) {
				radioJ1.setEnabled(false);
			} else if (jogador == 2) {
				radioJ2.setEnabled(false);
			} else if (jogador == 3) {
				radioJ3.setEnabled(false);
			} else if (jogador == 4) {
				radioJ4.setEnabled(false);
			}
		}

	}

	double calculaGanhar(int jogador) {
		float prob = 0;
		double porcentagem = 0;
		for (int i = 0; i < deck.catasRestantes(); i++) {
			if (regra.placarJogador[jogador] + deck.getValorCarta(i) == 21) {
				prob++;
			}
		}
		prob = prob / deck.catasRestantes();
		porcentagem = 100 * prob;
		return porcentagem;
	}

	double calculaPerder(int jogador) {
		float prob = 0;
		double porcentagem = 0;
		for (int i = 0; i < deck.catasRestantes(); i++) {
			if (regra.placarJogador[jogador] + deck.getValorCarta(i) > 21) {
				prob++;
			}
		}
		prob = prob / deck.catasRestantes();
		porcentagem = 100 * prob;
		return porcentagem;
	}

	double calculaContinuar(int jogador) {
		float prob = 0;
		double porcentagem = 0;
		for (int i = 0; i < deck.catasRestantes(); i++) {
			if (regra.placarJogador[jogador] + deck.getValorCarta(i) < 21) {
				prob++;
			}
		}
		prob = prob / deck.catasRestantes();
		porcentagem = 100 * prob;
		return porcentagem;
	}

	void numJogadores() {
		if ((Integer) menu.spinner.getValue() == 1) {
			radioJ1.setEnabled(true);
			radioJ2.setEnabled(false);
			radioJ3.setEnabled(false);
			radioJ4.setEnabled(false);
		} else if ((Integer) menu.spinner.getValue() == 2) {
			radioJ3.setEnabled(false);
			radioJ4.setEnabled(false);
		} else if ((Integer) menu.spinner.getValue() == 3) {
			radioJ4.setEnabled(false);
		}
	}

	void contarPlacar() {
		int vencedor = 0;
		if ((radioJ1.isEnabled() == false) && (radioJ2.isEnabled() == false) && (radioJ3.isEnabled() == false)
				&& (radioJ4.isEnabled() == false)) {
			int maiorPlacar = 0;
			for (int i = 1; i < 5; i++) {
				if (regra.placarJogador[i] > 21)
					regra.placarJogador[i] = 0;

				if (maiorPlacar < regra.placarJogador[i]) {
					maiorPlacar = regra.placarJogador[i];
					vencedor = i;

				}

			}

			JOptionPane.showMessageDialog(null,
					"Jogador " + vencedor + " Venceu!\n" + "Essa noite ele paga as bebidas pessoal!! O cara ta rico!");
		} else if ((Integer) menu.spinner.getValue() == 2) {
			if ((radioJ1.isEnabled() == false) && (radioJ2.isEnabled() == false)) {
				if (regra.placarJogador[1] > regra.placarJogador[2]) {

					JOptionPane.showMessageDialog(null, menu.txtJogador01.getText() + " Venceu!\n"
							+ "Essa noite ele paga as bebidas pessoal!! O cara ta rico!");
				} else {
					JOptionPane.showMessageDialog(null, menu.txtJogador02.getText() + " Venceu!\n"
							+ "Essa noite ele paga as bebidas pessoal!! O cara ta rico!");
				}
			}

		} else if ((Integer) menu.spinner.getValue() == 1) {
			JOptionPane.showMessageDialog(null,
					menu.txtJogador01.getText() + " : " + regra.placarJogador[1] + "pontos.");
		}
	}

	void labelDinamica(int jogador) {
		if (jogador == 1) {
			lblJ.setText(menu.txtJogador01.getText());
		} else if (jogador == 2) {
			lblJ.setText(menu.txtJogador02.getText());
		} else if (jogador == 3) {
			lblJ.setText(menu.txtJogador03.getText());
		} else if (jogador == 4) {
			lblJ.setText(menu.txtJogador04.getText());
		}
		if (regra.placarJogador[jogador] <= 21) {
			lblPontos.setText("Pontos" + regra.placarJogador[jogador]);
		} else {
			lblPontos.setText("ESTOUROU");
		}
		lblGanhar.setText(" Ganhar :" + calculaGanhar(jogador) + "%");
		lblPerder.setText(" Perder : " + calculaPerder(jogador) + "%");
		lblContinuar.setText(" Continuar : " + calculaContinuar(jogador) + "%");
	}

	private void initialize() {

		musica = new JLayer();
		MP3Musica mp3 = new MP3Musica();
		mp3.start();
		deck.criaCartas();
		deck.preencheBaralho();
		frmBlackjackJoe = new JFrame();
		frmBlackjackJoe.setIconImage(Toolkit.getDefaultToolkit().getImage(Jogador1.class
				.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		frmBlackjackJoe.setResizable(false);
		frmBlackjackJoe.setTitle("Black (Jack) Joe");
		frmBlackjackJoe.getContentPane().setBackground(new Color(0, 94, 32));
		frmBlackjackJoe.getContentPane().setLayout(null);

		JLabel lblCarta4J1 = new JLabel("");
		lblCarta4J1.setIcon(new ImageIcon(carta4j1));
		lblCarta4J1.setBounds(125, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta4J1);

		JLabel lblCarta3J1 = new JLabel("");
		lblCarta3J1.setIcon(new ImageIcon(carta3j1));
		lblCarta3J1.setBounds(110, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta3J1);

		JLabel lblCarta2j1 = new JLabel("");
		lblCarta2j1.setIcon(new ImageIcon(carta2j1));
		lblCarta2j1.setBounds(85, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta2j1);

		JLabel lblCarta1j1 = new JLabel("");
		lblCarta1j1.setBounds(60, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta1j1);

		JLabel lblcarta0j1 = new JLabel("");
		lblcarta0j1.setBounds(35, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblcarta0j1);

		JLabel lblCartaj1 = new JLabel("");
		lblCartaj1.setBounds(10, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCartaj1);

		JLabel lblCarta4J2 = new JLabel("");
		lblCarta4J2.setIcon(new ImageIcon(carta4j2));
		lblCarta4J2.setBounds(455, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta4J2);

		JLabel lblCarta3J2 = new JLabel("");
		lblCarta3J2.setBounds(430, 465, 140, 180);
		lblCarta3J2.setIcon(new ImageIcon(carta3j2));
		frmBlackjackJoe.getContentPane().add(lblCarta3J2);

		JLabel lblCarta2J2 = new JLabel("");
		lblCarta2J2.setBounds(405, 465, 140, 180);
		lblCarta2J2.setIcon(new ImageIcon(carta2j2));
		frmBlackjackJoe.getContentPane().add(lblCarta2J2);

		JLabel lblCarta1J2 = new JLabel("");
		lblCarta1J2.setIcon(new ImageIcon(carta1j2));
		lblCarta1J2.setBounds(380, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta1J2);

		JLabel lblCarta0J2 = new JLabel("");
		lblCarta0J2.setIcon(new ImageIcon(carta1j2));
		lblCarta0J2.setBounds(355, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta0J2);

		JLabel lblCartaJ2 = new JLabel("");
		lblCartaJ2.setIcon(new ImageIcon(carta1j2));
		lblCartaJ2.setBounds(330, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCartaJ2);

		JLabel lblCarta4J3 = new JLabel("");
		lblCarta4J3.setIcon(new ImageIcon(carta4j3));
		lblCarta4J3.setBounds(803, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta4J3);

		JLabel lblCarta3J3 = new JLabel("");
		lblCarta3J3.setBounds(778, 465, 140, 180);
		lblCarta3J3.setIcon(new ImageIcon(carta3j3));
		frmBlackjackJoe.getContentPane().add(lblCarta3J3);

		JLabel lblCarta2J3 = new JLabel("");
		lblCarta2J3.setIcon(new ImageIcon(carta2j3));
		lblCarta2J3.setBounds(753, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta2J3);

		JLabel lblCarta1J3 = new JLabel("");
		lblCarta1J3.setIcon(new ImageIcon(carta2j3));
		lblCarta1J3.setBounds(728, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta1J3);

		JLabel lblCarta0J3 = new JLabel("");
		lblCarta0J3.setIcon(new ImageIcon(carta2j3));
		lblCarta0J3.setBounds(703, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta0J3);

		JLabel lblCartaJ3 = new JLabel("");
		lblCartaJ3.setIcon(new ImageIcon(carta2j3));
		lblCartaJ3.setBounds(678, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCartaJ3);

		JLabel lblCarta4J4 = new JLabel("");
		lblCarta4J4.setIcon(new ImageIcon(carta4j4));
		lblCarta4J4.setBounds(1125, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta4J4);

		JLabel lblCarta3J4 = new JLabel("");
		lblCarta3J4.setIcon(new ImageIcon(carta3j4));
		lblCarta3J4.setBounds(1100, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta3J4);

		JLabel lblCarta2J4 = new JLabel("");
		lblCarta2J4.setIcon(new ImageIcon(carta2j4));
		lblCarta2J4.setBounds(1075, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta2J4);

		JLabel lblCarta1J4 = new JLabel("");
		lblCarta1J4.setIcon(new ImageIcon(carta1j4));
		lblCarta1J4.setBounds(1050, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta1J4);

		JLabel lblCarta0J4 = new JLabel("");
		lblCarta0J4.setIcon(new ImageIcon(carta1j4));
		lblCarta0J4.setBounds(1025, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCarta0J4);

		JLabel lblCartaJ4 = new JLabel("");
		lblCartaJ4.setIcon(new ImageIcon(carta1j4));
		lblCartaJ4.setBounds(1000, 465, 140, 180);
		frmBlackjackJoe.getContentPane().add(lblCartaJ4);

		JLabel lblBlackjoe = new JLabel("BlackJoe");
		lblBlackjoe.setIcon(new ImageIcon("img/blackjoetinta.png"));
		lblBlackjoe.setBounds(335, -11, 600, 300);
		frmBlackjackJoe.getContentPane().add(lblBlackjoe);

		JLabel lblComprar = new JLabel("Comprar");
		lblComprar.setIcon(new ImageIcon("img/baralho/Verso.png"));
		lblComprar.setBounds(10, 36, 163, 207);
		frmBlackjackJoe.getContentPane().add(lblComprar);

		JLabel lblTudoOuNada = new JLabel("Tudo ou nada");
		lblTudoOuNada.setIcon(new ImageIcon("img/Tudo ou nada.png"));
		lblTudoOuNada.setBounds(223, 282, 794, 144);
		frmBlackjackJoe.getContentPane().add(lblTudoOuNada);

		JLabel lblJogo1 = new JLabel("");
		lblJogo1.setIcon(new ImageIcon("img/espacocarta.png"));
		lblJogo1.setBounds(10, 437, 257, 201);
		frmBlackjackJoe.getContentPane().add(lblJogo1);

		JLabel lblJogo2 = new JLabel("");
		lblJogo2.setIcon(new ImageIcon("img/espacocarta.png"));
		lblJogo2.setBounds(337, 437, 257, 201);
		frmBlackjackJoe.getContentPane().add(lblJogo2);

		JLabel lblJogo3 = new JLabel("");
		lblJogo3.setIcon(new ImageIcon("img/espacocarta.png"));
		lblJogo3.setBounds(678, 437, 257, 201);
		frmBlackjackJoe.getContentPane().add(lblJogo3);

		JLabel lblJogo4 = new JLabel("");
		lblJogo4.setIcon(new ImageIcon("img/espacocarta.png"));
		lblJogo4.setBounds(997, 437, 257, 201);
		frmBlackjackJoe.getContentPane().add(lblJogo4);

		btnComprar = new JButton("Comprar");
		// Botão invisível
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setBorderPainted(false);
		JLabel lblJogadorDaVez = new JLabel("Jogador da Vez");
		lblJogadorDaVez.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogadorDaVez.setForeground(Color.WHITE);
		lblJogadorDaVez.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblJogadorDaVez.setBounds(983, 132, 259, 23);
		frmBlackjackJoe.getContentPane().add(lblJogadorDaVez);
		btnComprar.setBounds(31, 36, 124, 183);
		frmBlackjackJoe.getContentPane().add(btnComprar);

		btnTerminar1 = new JButton("Terminar");
		btnTerminar1.setBackground(Color.BLACK);
		btnTerminar1.setForeground(Color.WHITE);
		btnTerminar1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnTerminar1.setBounds(10, 665, 257, 23);
		frmBlackjackJoe.getContentPane().add(btnTerminar1);

		btnTerminar2 = new JButton("Terminar");
		btnTerminar2.setBackground(Color.BLACK);
		btnTerminar2.setForeground(Color.WHITE);
		btnTerminar2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnTerminar2.setBounds(335, 665, 259, 23);
		frmBlackjackJoe.getContentPane().add(btnTerminar2);

		btnTerminar3 = new JButton("Terminar");
		btnTerminar3.setBackground(Color.BLACK);
		btnTerminar3.setForeground(Color.WHITE);
		btnTerminar3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnTerminar3.setBounds(678, 665, 259, 23);
		frmBlackjackJoe.getContentPane().add(btnTerminar3);

		btnTerminar4 = new JButton("Terminar");
		btnTerminar4.setBackground(Color.BLACK);
		btnTerminar4.setForeground(Color.WHITE);
		btnTerminar4.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnTerminar4.setBounds(995, 665, 259, 23);
		frmBlackjackJoe.getContentPane().add(btnTerminar4);

		btnRecomecar = new JButton("Retornar ao Menu");
		btnRecomecar.setForeground(Color.WHITE);
		btnRecomecar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnRecomecar.setBackground(Color.BLACK);
		btnRecomecar.setBounds(983, 60, 259, 23);
		frmBlackjackJoe.getContentPane().add(btnRecomecar);

		radioJ1 = new JRadioButton("1");
		groupJogadorDaVez.add(radioJ1);
		radioJ1.setBackground(new Color(0, 94, 32));
		radioJ1.setFont(new Font("Arial Black", Font.BOLD, 12));
		radioJ1.setForeground(Color.WHITE);
		radioJ1.setBounds(983, 162, 52, 23);
		radioJ1.setSelected(true);
		frmBlackjackJoe.getContentPane().add(radioJ1);

		radioJ2 = new JRadioButton("2");
		groupJogadorDaVez.add(radioJ2);
		radioJ2.setForeground(Color.WHITE);
		radioJ2.setFont(new Font("Arial Black", Font.BOLD, 12));
		radioJ2.setBackground(new Color(0, 94, 32));
		radioJ2.setBounds(1055, 162, 52, 23);
		frmBlackjackJoe.getContentPane().add(radioJ2);

		radioJ3 = new JRadioButton("3");
		groupJogadorDaVez.add(radioJ3);
		radioJ3.setForeground(Color.WHITE);
		radioJ3.setFont(new Font("Arial Black", Font.BOLD, 12));
		radioJ3.setBackground(new Color(0, 94, 32));
		radioJ3.setBounds(1133, 163, 52, 23);
		frmBlackjackJoe.getContentPane().add(radioJ3);

		radioJ4 = new JRadioButton("4");
		groupJogadorDaVez.add(radioJ4);
		radioJ4.setForeground(Color.WHITE);
		radioJ4.setFont(new Font("Arial Black", Font.BOLD, 12));
		radioJ4.setBackground(new Color(0, 94, 32));
		radioJ4.setBounds(1202, 162, 52, 23);
		frmBlackjackJoe.getContentPane().add(radioJ4);

		btnEmbaralhar = new JButton("Embaralhar");
		btnEmbaralhar.setForeground(Color.WHITE);
		btnEmbaralhar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEmbaralhar.setBackground(Color.BLACK);
		btnEmbaralhar.setBounds(983, 14, 259, 23);
		frmBlackjackJoe.getContentPane().add(btnEmbaralhar);
		numJogadores();

		JPanel panel = new JPanel();
		panel.setBorder(
				new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE));
		panel.setBackground(Color.BLACK);
		panel.setBounds(7, 230, 163, 200);
		frmBlackjackJoe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPlacar = new JLabel("Placar");
		lblPlacar.setBounds(59, 7, 44, 17);
		lblPlacar.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPlacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlacar.setForeground(Color.WHITE);
		panel.add(lblPlacar);

		lblJ = new JLabel(menu.txtJogador01.getText());
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ.setForeground(Color.WHITE);
		lblJ.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblJ.setBounds(10, 37, 143, 17);
		panel.add(lblJ);

		lblPontos = new JLabel("PONTOS");
		lblPontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontos.setForeground(Color.WHITE);
		lblPontos.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPontos.setBounds(10, 62, 143, 17);
		panel.add(lblPontos);

		lblPerder = new JLabel("");
		lblPerder.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerder.setForeground(Color.WHITE);
		lblPerder.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPerder.setBounds(10, 113, 143, 17);
		panel.add(lblPerder);

		lblGanhar = new JLabel("");
		lblGanhar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanhar.setForeground(Color.WHITE);
		lblGanhar.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblGanhar.setBounds(10, 141, 143, 17);
		panel.add(lblGanhar);

		lblContinuar = new JLabel("");
		lblContinuar.setHorizontalAlignment(SwingConstants.CENTER);
		lblContinuar.setForeground(Color.WHITE);
		lblContinuar.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblContinuar.setBounds(10, 160, 143, 17);
		panel.add(lblContinuar);

		JLabel lblChances = new JLabel("CHANCES");
		lblChances.setHorizontalAlignment(SwingConstants.CENTER);
		lblChances.setForeground(new Color(0, 0, 255));
		lblChances.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblChances.setBounds(10, 85, 143, 17);
		panel.add(lblChances);
		frmBlackjackJoe.setBounds(40, 10, 1280, 726);
		frmBlackjackJoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjackJoe.setVisible(true);

		// acoes
		// ------ Cartas iniciais -----
		/// j1
		if (radioJ1.isEnabled() == true) {
			deck.embaralha();
			cartaj1 = deck.getImagem();
			lblCartaj1.setIcon(new ImageIcon(cartaj1));
			vencer(1);
			deck.compra();
			carta0j1 = deck.getImagem();
			lblcarta0j1.setIcon(new ImageIcon(carta0j1));
			vencer(1);
			deck.compra();
		}
		/// j2
		if (radioJ2.isEnabled() == true) {
			deck.embaralha();
			cartaj2 = deck.getImagem();
			lblCartaJ2.setIcon(new ImageIcon(cartaj2));
			vencer(2);
			deck.compra();
			carta0j2 = deck.getImagem();
			lblCarta0J2.setIcon(new ImageIcon(carta0j2));
			vencer(2);
			deck.compra();
		}

		/// j3
		if (radioJ3.isEnabled() == true) {
			deck.embaralha();
			cartaj3 = deck.getImagem();
			lblCartaJ3.setIcon(new ImageIcon(cartaj3));
			vencer(3);
			deck.compra();
			carta0j3 = deck.getImagem();
			lblCarta0J3.setIcon(new ImageIcon(carta0j3));
			vencer(3);
			deck.compra();
		}

		/// j4
		if (radioJ4.isEnabled() == true) {
			deck.embaralha();
			cartaj4 = deck.getImagem();
			lblCartaJ4.setIcon(new ImageIcon(cartaj4));
			vencer(4);
			deck.compra();
			carta0j4 = deck.getImagem();
			lblCarta0J4.setIcon(new ImageIcon(carta0j4));
			vencer(4);
			deck.compra();
		}

		// =====Embaralhar====>
		btnEmbaralhar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				deck.embaralha();
				JOptionPane.showMessageDialog(btnEmbaralhar, "Embaralhado");
			}
		});

		// =====Comprar=====>
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// teste jogador 01:
				if (radioJ1.isSelected() == true && radioJ1.isEnabled() == true) {

					if (regra.placarJogador[1] < 21) {
						if (regra.numerocartas(1) == 0) {
							carta1j1 = deck.getImagem();
							lblCarta1j1.setIcon(new ImageIcon(carta1j1));
							vencer(1);
							deck.compra();
							regra.aumentaNumeroDeCartas(1);
						} else if (regra.numerocartas(1) == 1) {
							carta2j1 = deck.getImagem();
							lblCarta2j1.setIcon(new ImageIcon(carta2j1));
							vencer(1);
							deck.compra();
							regra.aumentaNumeroDeCartas(1);
						} else if (regra.numerocartas(1) == 2) {
							carta3j1 = deck.getImagem();
							lblCarta3J1.setIcon(new ImageIcon(carta3j1));
							vencer(1);
							deck.compra();
							regra.aumentaNumeroDeCartas(1);
						} else if (regra.numerocartas(1) == 3) {
							carta4j1 = deck.getImagem();
							lblCarta4J1.setIcon(new ImageIcon(carta4j1));
							vencer(1);
							deck.compra();
							regra.aumentaNumeroDeCartas(1);
						} else {
							JOptionPane.showMessageDialog(null, "Você já tem cartas de mais!");
						}
						labelDinamica(1);

					}
				}
				if (radioJ2.isSelected() == true && radioJ2.isEnabled() == true) {

					if (regra.placarJogador[2] < 21) {
						carta1j2 = deck.getImagem();
						if (regra.numerocartas(2) == 0) {
							carta1j2 = deck.getImagem();
							lblCarta1J2.setIcon(new ImageIcon(carta1j2));
							vencer(2);
							deck.compra();
							regra.aumentaNumeroDeCartas(2);
						} else if (regra.numerocartas(2) == 1) {
							carta2j2 = deck.getImagem();
							lblCarta2J2.setIcon(new ImageIcon(carta2j2));
							vencer(2);
							deck.compra();
							regra.aumentaNumeroDeCartas(2);
						} else if (regra.numerocartas(2) == 2) {
							carta3j2 = deck.getImagem();
							lblCarta3J2.setIcon(new ImageIcon(carta3j2));
							vencer(2);
							deck.compra();
							regra.aumentaNumeroDeCartas(2);
						} else if (regra.numerocartas(2) == 3) {
							carta4j2 = deck.getImagem();
							lblCarta4J2.setIcon(new ImageIcon(carta4j2));
							vencer(2);
							deck.compra();
							regra.aumentaNumeroDeCartas(2);
						} else {
							JOptionPane.showMessageDialog(null, "Você já tem cartas de mais!");
						}
						labelDinamica(2);
					}
				}

				if (radioJ3.isSelected() == true && radioJ3.isEnabled() == true) {
					if (regra.placarJogador[3] < 21) {

						if (regra.numerocartas(3) == 0) {
							carta1j3 = deck.getImagem();
							lblCarta1J3.setIcon(new ImageIcon(carta1j3));
							vencer(3);
							deck.compra();
							regra.aumentaNumeroDeCartas(3);
						} else if (regra.numerocartas(3) == 1) {
							carta2j3 = deck.getImagem();
							lblCarta2J3.setIcon(new ImageIcon(carta2j3));
							vencer(3);
							deck.compra();
							regra.aumentaNumeroDeCartas(3);
						} else if (regra.numerocartas(3) == 2) {
							carta3j3 = deck.getImagem();
							lblCarta3J3.setIcon(new ImageIcon(carta3j3));
							vencer(3);
							deck.compra();
							regra.aumentaNumeroDeCartas(3);
						} else if (regra.numerocartas(3) == 3) {
							carta4j3 = deck.getImagem();
							lblCarta4J3.setIcon(new ImageIcon(carta4j3));
							vencer(3);
							deck.compra();
							regra.aumentaNumeroDeCartas(3);
						} else {
							JOptionPane.showMessageDialog(null, "Você já tem cartas de mais!");
						}
						labelDinamica(3);
					}
				}
				// JOGADOR NUMERO 4

				if (radioJ4.isSelected() == true && radioJ4.isEnabled() == true) {

					carta1j4 = deck.getImagem();
					if (regra.numerocartas(4) == 0) {
						carta1j4 = deck.getImagem();
						lblCarta1J4.setIcon(new ImageIcon(carta1j4));
						vencer(4);
						deck.compra();
						regra.aumentaNumeroDeCartas(4);
					} else if (regra.numerocartas(4) == 1) {
						carta2j4 = deck.getImagem();
						lblCarta2J4.setIcon(new ImageIcon(carta2j4));
						vencer(4);
						deck.compra();
						regra.aumentaNumeroDeCartas(4);
					} else if (regra.numerocartas(4) == 2) {
						carta3j4 = deck.getImagem();
						lblCarta3J4.setIcon(new ImageIcon(carta3j4));
						vencer(4);
						deck.compra();
						regra.aumentaNumeroDeCartas(4);
					} else if (regra.numerocartas(4) == 3) {
						carta4j4 = deck.getImagem();
						lblCarta4J4.setIcon(new ImageIcon(carta4j4));
						vencer(4);
						deck.compra();
						regra.aumentaNumeroDeCartas(4);
					} else {
						JOptionPane.showMessageDialog(null, "Você já tem cartas de mais!");
					}
					labelDinamica(4);
				}
			}

		});

		// -- placar
		radioJ1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				labelDinamica(1);
			}
		});

		radioJ2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				labelDinamica(2);
			}
		});

		radioJ3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				labelDinamica(3);
			}
		});
		radioJ4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				labelDinamica(4);
			}
		});
		// === Terminar jogo ==
		btnTerminar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contarPlacar();
				radioJ1.setEnabled(false);
				contarPlacar();
			}

		});
		btnTerminar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contarPlacar();
				radioJ2.setEnabled(false);
				contarPlacar();
			}
		});
		btnTerminar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contarPlacar();
				radioJ3.setEnabled(false);
				contarPlacar();
			}
		});
		btnTerminar4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				contarPlacar();
				radioJ4.setEnabled(false);
				contarPlacar();

			}
		});
		// Recomeçar
		btnRecomecar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mp3.stop();
				menu.main(null);
				frmBlackjackJoe.dispose();

			}
		});
		labelDinamica(1);
	}

}
