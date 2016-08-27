import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface.JPanelImage;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;


public class Menu extends JFrame {

	private JPanelImage contentPane;
	private JLabel lblRingsOfSaturn;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel lblNave1;
	public String naveSingle = null;
	private JLabel lblNave2;
	private JLabel lblNave3;
	private JLabel lblEscolhaADificuldade;
	private JLabel lblSinglePlayer;
	private JLabel lblFacil;
	private JLabel lblMedio;
	private JLabel lblDificil;
	private int dificuldade = 0;
	private JLabel lblMultiPlayer;
	private JLabel lblEscolhaANave;
	private JLabel lblEscolhaANave_1;
	private JLabel lblNave4;
	private JLabel lblNave5;
	private JLabel lblNave6;
	private JLabel lblNave7;
	private JLabel lblNave8;
	private JLabel lblNave9;
	private JLabel lblEscolhaSuaNave;
	private boolean single;
	private String naveMulti1 = null;
	private String naveMulti2 = null;
	private JPanel panelSingle;
	private JPanel panelMulti;
	private JButton btnComo;
	private PlayerUtils musica = new PlayerUtils("musics/pirates8bit.mp3");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		musica.reproduzir();
		setTitle("Rings Of Saturn - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanelImage();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setBackgroundImage(new ImageIcon(Game.class.getResource("img/fundo-menu.jpg")));
		contentPane.setLayout(null);
		
		lblRingsOfSaturn = new JLabel("RINGS OF SATURN");
		lblRingsOfSaturn.setFont(new Font("Quartz MS", Font.BOLD | Font.ITALIC, 99));
		lblRingsOfSaturn.setForeground(Color.GREEN);
		lblRingsOfSaturn.setBounds(((int) screen.getWidth()/2) - 450, (int) (screen.getHeight()/10), 906, 143);
		contentPane.add(lblRingsOfSaturn);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (single == true) {
					if (naveSingle != null) {
						if (dificuldade != 0) {
							Game jogo = new Game(dificuldade,naveSingle, Menu.this);
							jogo.setVisible(true);
							jogo.toFront();
							setVisible(false);
						}else JOptionPane.showMessageDialog(contentPane, "Escolha uma dificuldade antes!");
					}else JOptionPane.showMessageDialog(contentPane, "Escolha sua nave antes!");
				}else if (single == false) {
					Game2 jogo = new Game2(naveMulti1, naveMulti2, Menu.this);
					jogo.setVisible(true);
					jogo.toFront();
					setVisible(false);
				}else JOptionPane.showMessageDialog(contentPane, "Escolha algum modo de jogo!");
			}
		});
		btnIniciar.setFont(new Font("Quartz MS", Font.PLAIN, 20));
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setBackground(Color.GREEN);
		btnIniciar.setBounds(709, 493, 200, 50);
		contentPane.add(btnIniciar);
		
		JButton btnSobre = new JButton("SOBRE");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Rings of Saturn:"
						+ "\nVersão 1.0"
						+ "\nDesenvolvedor João B. Rodrigues Neto"
						+ "\nLinguagem Java"
						+ "\n\nContato: jbbatistajoao@gmail.com"
						+ "\n\nSENAI");
			}
		});
		btnSobre.setForeground(new Color(0, 0, 0));
		btnSobre.setFont(new Font("Quartz MS", Font.PLAIN, 20));
		btnSobre.setBackground(Color.GREEN);
		btnSobre.setBounds(709, 661, 200, 50);
		contentPane.add(btnSobre);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.BLACK);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBackground(Color.GREEN);
		btnSair.setFont(new Font("Quartz MS", Font.PLAIN, 20));
		btnSair.setBounds(709, 741, 200, 50);
		contentPane.add(btnSair);
		
		panelSingle = new JPanel();
		panelSingle.setVisible(false);
		panelSingle.setOpaque(false);
		panelSingle.setBounds(49, 310, 635, 171);
		contentPane.add(panelSingle);
		panelSingle.setLayout(null);
		
		lblEscolhaSuaNave = new JLabel("ESCOLHA SUA NAVE:");
		lblEscolhaSuaNave.setBounds(10, 11, 285, 39);
		panelSingle.add(lblEscolhaSuaNave);
		lblEscolhaSuaNave.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		lblEscolhaSuaNave.setForeground(Color.GREEN);
		
		lblNave1 = new JLabel("");
		lblNave1.setBounds(20, 61, 64, 93);
		panelSingle.add(lblNave1);
		lblNave1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				lblNave2.setBorder(null);
				lblNave3.setBorder(null);
				lblNave1.setBorder(new LineBorder(Color.GREEN, 3));
				naveSingle = "/img/nave1.png";
			}
		});
		lblNave1.setIcon(new ImageIcon(Menu.class.getResource("/img/nave1.png")));
		
		lblNave2 = new JLabel("");
		lblNave2.setBounds(94, 61, 64, 93);
		panelSingle.add(lblNave2);
		lblNave2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblNave1.setBorder(null);
				lblNave3.setBorder(null);
				lblNave2.setBorder(new LineBorder(Color.GREEN, 3));
				naveSingle = "/img/nave2.png";
			}
		});
		
		lblNave2.setIcon(new ImageIcon(Menu.class.getResource("/img/nave2.png")));
		
		lblNave3 = new JLabel("");
		lblNave3.setBounds(168, 61, 64, 93);
		panelSingle.add(lblNave3);
		lblNave3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				lblNave1.setBorder(null);
				lblNave2.setBorder(null);
				lblNave3.setBorder(new LineBorder(Color.GREEN, 3));
				naveSingle = "/img/nave3.png";
			}
		});
		lblNave3.setIcon(new ImageIcon(Menu.class.getResource("/img/nave3.png")));
		
		lblEscolhaADificuldade = new JLabel("ESCOLHA A DIFICULDADE:");
		lblEscolhaADificuldade.setBounds(305, 11, 306, 39);
		panelSingle.add(lblEscolhaADificuldade);
		lblEscolhaADificuldade.setForeground(Color.GREEN);
		lblEscolhaADificuldade.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		lblEscolhaADificuldade.setBackground(Color.GREEN);
		
		lblFacil = new JLabel("Facil");
		lblFacil.setBounds(305, 61, 79, 31);
		panelSingle.add(lblFacil);
		lblFacil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblMedio.setBorder(null);
				lblDificil.setBorder(null);
				lblFacil.setBorder(new LineBorder(Color.GREEN, 3));
				dificuldade = 1000;
			}
		});
		lblFacil.setForeground(Color.GREEN);
		lblFacil.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		
		lblMedio = new JLabel("Medio");
		lblMedio.setBounds(394, 61, 107, 31);
		panelSingle.add(lblMedio);
		lblMedio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblDificil.setBorder(null);
				lblFacil.setBorder(null);
				lblMedio.setBorder(new LineBorder(Color.GREEN, 3));
				dificuldade = 700;
			}
		});
		lblMedio.setForeground(Color.GREEN);
		lblMedio.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		
		lblDificil = new JLabel("Dificil");
		lblDificil.setBounds(511, 61, 107, 31);
		panelSingle.add(lblDificil);
		lblDificil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblMedio.setBorder(null);
				lblFacil.setBorder(null);
				lblDificil.setBorder(new LineBorder(Color.GREEN, 3));
				dificuldade = 500;
			}
		});
		lblDificil.setForeground(Color.GREEN);
		lblDificil.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		
		panelMulti = new JPanel();
		panelMulti.setVisible(false);
		panelMulti.setOpaque(false);
		panelMulti.setBounds(934, 310, 525, 171);
		contentPane.add(panelMulti);
		panelMulti.setLayout(null);
		
		lblEscolhaANave = new JLabel("ESCOLHA A NAVE 1:");
		lblEscolhaANave.setBounds(10, 11, 285, 39);
		panelMulti.add(lblEscolhaANave);
		lblEscolhaANave.setForeground(Color.GREEN);
		lblEscolhaANave.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		
		lblEscolhaANave_1 = new JLabel("ESCOLHA A NAVE 2:");
		lblEscolhaANave_1.setBounds(274, 11, 241, 39);
		panelMulti.add(lblEscolhaANave_1);
		lblEscolhaANave_1.setForeground(Color.GREEN);
		lblEscolhaANave_1.setFont(new Font("Quartz MS", Font.PLAIN, 25));
		
		lblNave4 = new JLabel("");
		lblNave4.setBounds(10, 61, 64, 93);
		panelMulti.add(lblNave4);
		lblNave4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				naveMulti1 = "/img/nave1.png";
				lblNave4.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave5.setBorder(null);
				lblNave6.setBorder(null);
			}
		});
		lblNave4.setIcon(new ImageIcon(Menu.class.getResource("/img/nave1.png")));
		
		lblNave5 = new JLabel("");
		lblNave5.setBounds(84, 61, 64, 93);
		panelMulti.add(lblNave5);
		lblNave5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				naveMulti1 = "/img/nave2.png";
				lblNave5.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave4.setBorder(null);
				lblNave6.setBorder(null);
			}
		});
		lblNave5.setIcon(new ImageIcon(Menu.class.getResource("/img/nave2.png")));
		
		lblNave6 = new JLabel("");
		lblNave6.setBounds(158, 61, 64, 93);
		panelMulti.add(lblNave6);
		lblNave6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				naveMulti1 = "/img/nave3.png";
				lblNave6.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave4.setBorder(null);
				lblNave5.setBorder(null);
			}
		});
		lblNave6.setIcon(new ImageIcon(Menu.class.getResource("/img/nave3.png")));
		
		lblNave7 = new JLabel("");
		lblNave7.setBounds(274, 61, 64, 93);
		panelMulti.add(lblNave7);
		lblNave7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				naveMulti2 = "/img/nave1.png";
				lblNave7.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave8.setBorder(null);
				lblNave9.setBorder(null);
			}
		});
		lblNave7.setIcon(new ImageIcon(Menu.class.getResource("/img/nave1.png")));
		
		lblNave8 = new JLabel("");
		lblNave8.setBounds(348, 61, 64, 93);
		panelMulti.add(lblNave8);
		lblNave8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				naveMulti2 = "/img/nave2.png";
				lblNave8.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave7.setBorder(null);
				lblNave9.setBorder(null);
			}
		});
		lblNave8.setIcon(new ImageIcon(Menu.class.getResource("/img/nave2.png")));
		
		lblNave9 = new JLabel("");
		lblNave9.setBounds(422, 61, 64, 93);
		panelMulti.add(lblNave9);
		lblNave9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				naveMulti2 = "/img/nave3.png";
				lblNave9.setBorder(new LineBorder(Color.GREEN, 3));
				lblNave8.setBorder(null);
				lblNave7.setBorder(null);
			}
		});
		lblNave9.setIcon(new ImageIcon(Menu.class.getResource("/img/nave3.png")));
		
		lblSinglePlayer = new JLabel("SINGLE PLAYER");
		lblSinglePlayer.setBounds(39, 228, 349, 66);
		contentPane.add(lblSinglePlayer);
		lblSinglePlayer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				single = true;
				lblSinglePlayer.setBorder(new LineBorder(Color.GREEN, 3));
				lblMultiPlayer.setBorder(null);
				panelMulti.setVisible(false);
				panelSingle.setVisible(true);
			}
		});
		lblSinglePlayer.setFont(new Font("Quartz MS", Font.PLAIN, 40));
		lblSinglePlayer.setForeground(Color.GREEN);
		
		lblMultiPlayer = new JLabel("MULTI PLAYER");
		lblMultiPlayer.setBounds(934, 228, 349, 66);
		contentPane.add(lblMultiPlayer);
		lblMultiPlayer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				single = false;
				lblMultiPlayer.setBorder(new LineBorder(Color.GREEN, 3));
				lblSinglePlayer.setBorder(null);
				panelSingle.setVisible(false);
				panelMulti.setVisible(true);
			}
		});
		lblMultiPlayer.setForeground(Color.GREEN);
		lblMultiPlayer.setFont(new Font("Quartz MS", Font.PLAIN, 40));
		
		btnComo = new JButton("COMO JOGAR");
		btnComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComoJogar how = new ComoJogar(screen);
				how.setVisible(true);
			}
		});
		btnComo.setForeground(Color.BLACK);
		btnComo.setFont(new Font("Quartz MS", Font.PLAIN, 20));
		btnComo.setBackground(Color.GREEN);
		btnComo.setBounds(709, 579, 200, 50);
		contentPane.add(btnComo);
		
		setSize(screen);
		setVisible(true);
	}
	public void restarMusic(){
		musica.parar();
		musica.reproduzir();
	}
}
