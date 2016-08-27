import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

import Interface.JPanelImage;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Game2 extends JFrame {

	private JPanelImage contentPane;
	private Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	private JSplitPane splitPane;
	private JPanel panelPlayer2;
	private JPanel panelPlayer1;
	private JLabel nave1;
	private JLabel nave2;
	private Menu menu;
	private MultiKeyPressListener multiKeyPressListener;
	private boolean aux = true;
	private boolean pause = false;
	private ImageIcon explosion = Utils.ImageUtils.resizeImageIcon("img/explosion.png");
	private ImageIcon torpedo = new ImageIcon(getClass().getResource("img/torpedo.png"));
	private JLabel labelPontos1;
	private JLabel labelPontos2;
	private JLabel labelVida1;
	private JLabel labelVida2;
	private JLabel lblP1;
	private JLabel lblPontos;
	private JLabel lblVida1;
	private JLabel lblPontos2;
	private JLabel lblVida2;
	private JLabel lblPause;
	private JLabel lblTime;
	private JButton button;

	public Game2(String localNave1 , String localNave2, Menu menu) {
		this.menu = menu;
		setTitle("Rings Of Saturn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 679, 564);
		contentPane = new JPanelImage();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackgroundImage(new ImageIcon(Game.class.getResource("img/fundo.jpg")));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{125, 44, 125, 44, 0, 0};
		gbl_contentPane.rowHeights = new int[]{25, 865, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblP1 = new JLabel("PLAYER 1");
		lblP1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP1.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblP1 = new GridBagConstraints();
		gbc_lblP1.insets = new Insets(0, 0, 5, 5);
		gbc_lblP1.gridx = 0;
		gbc_lblP1.gridy = 0;
		contentPane.add(lblP1, gbc_lblP1);

		lblPause = new JLabel("");
		lblPause.setFont(new Font("Quartz MS", Font.BOLD, 30));
		lblPause.setForeground(Color.RED);
		GridBagConstraints gbc_lblPause = new GridBagConstraints();
		gbc_lblPause.insets = new Insets(0, 0, 5, 5);
		gbc_lblPause.gridx = 1;
		gbc_lblPause.gridy = 0;
		contentPane.add(lblPause, gbc_lblPause);

		JLabel lblP2 = new JLabel("PLAYER 2");
		lblP2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP2.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblP2 = new GridBagConstraints();
		gbc_lblP2.insets = new Insets(0, 0, 5, 5);
		gbc_lblP2.gridx = 2;
		gbc_lblP2.gridy = 0;
		contentPane.add(lblP2, gbc_lblP2);

		lblTime = new JLabel("5:00");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setForeground(Color.RED);
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 3;
		gbc_lblTime.gridy = 0;
		contentPane.add(lblTime, gbc_lblTime);
		
		button = new JButton("VOLTAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause = true;
				int op = JOptionPane.showConfirmDialog(contentPane, "Se você voltar ao Menu, perderá seu jogo atual!\nAinda assim quer voltar ao Menu?", "Tem certeza que quer voltar?", JOptionPane.YES_NO_CANCEL_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					menu.setVisible(true);
					menu.restarMusic();
					dispose();
				}else pause = false;
			}
		});
		button.setForeground(Color.GREEN);
		button.setFont(new Font("Quartz MS", Font.BOLD, 15));
		button.setFocusable(false);
		button.setBackground(Color.BLACK);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 0;
		contentPane.add(button, gbc_button);

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOpaque(false);
		splitPane.setDividerSize(1);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.gridwidth = 5;
		gbc_splitPane.insets = new Insets(0, 0, 0, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		contentPane.add(splitPane, gbc_splitPane);

		panelPlayer2 = new JPanel();
		panelPlayer2.setOpaque(false);
		splitPane.setRightComponent(panelPlayer2);
		panelPlayer2.setLayout(null);

		nave2 = new JLabel("");
		nave2.setName("nave2");
		nave2.setIcon(new ImageIcon(Game.class.getResource(localNave2)));
		nave2.setBounds(67, 207, 64, 64);
		panelPlayer2.add(nave2);

		panelPlayer1 = new JPanel();
		panelPlayer1.setOpaque(false);
		splitPane.setLeftComponent(panelPlayer1);
		panelPlayer1.setLayout(null);

		nave1 = new JLabel("");
		nave1.setName("nave1");
		nave1.setIcon(new ImageIcon(Game.class.getResource(localNave1)));
		nave1.setBounds(118, 252, 64, 64);
		panelPlayer1.add(nave1);
		splitPane.setDividerLocation((int) (tela.getWidth()/2));

		labelPontos1 = new JLabel("0");
		labelPontos1.setForeground(Color.GREEN);
		labelPontos1.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPontos1.setBounds(106, 11, 64, 19);
		panelPlayer1.add(labelPontos1);

		labelVida1 = new JLabel("100");
		labelVida1.setForeground(Color.RED);
		labelVida1.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelVida1.setBounds(78, 41, 44, 19);
		panelPlayer1.add(labelVida1);

		lblPontos = new JLabel("PONTOS:");
		lblPontos.setForeground(Color.WHITE);
		lblPontos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPontos.setBounds(10, 11, 86, 14);
		panelPlayer1.add(lblPontos);

		lblVida1 = new JLabel("VIDA:");
		lblVida1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVida1.setForeground(Color.WHITE);
		lblVida1.setBounds(10, 41, 70, 14);
		panelPlayer1.add(lblVida1);
		
		labelPontos2 = new JLabel("0");
		labelPontos2.setForeground(Color.GREEN);
		labelPontos2.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPontos2.setBounds(97, 11, 55, 19);
		panelPlayer2.add(labelPontos2);

		labelVida2 = new JLabel("100");
		labelVida2.setForeground(Color.RED);
		labelVida2.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelVida2.setBounds(80, 36, 44, 19);
		panelPlayer2.add(labelVida2);

		lblPontos2 = new JLabel("PONTOS:");
		lblPontos2.setForeground(Color.WHITE);
		lblPontos2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPontos2.setBounds(10, 11, 77, 14);
		panelPlayer2.add(lblPontos2);

		lblVida2 = new JLabel("VIDA:");
		lblVida2.setForeground(Color.WHITE);
		lblVida2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVida2.setBounds(10, 36, 60, 14);
		panelPlayer2.add(lblVida2);
		

		setUndecorated(true);
		setSize(tela);
		setVisible(true);
		nave1.setLocation(panelPlayer1.getWidth()/2, panelPlayer1.getHeight()-nave1.getHeight());
		nave2.setLocation(panelPlayer2.getWidth()/2, panelPlayer2.getHeight()-nave2.getHeight());
		
		repaint();
		invalidate();

		
		multiKeyPressListener = new MultiKeyPressListener();
		this.addKeyListener(multiKeyPressListener);
		new RandomAsteroide1().start();
		new RandomAsteroide2().start();
		new Tempo().start();
	}
	//TODO MULTI KEY
	class MultiKeyPressListener implements KeyListener {

		private final Set<Integer> pressed = new HashSet<Integer>();

		MultiKeyPressListener(){
			new Reload();
		}
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==32) {
				new Fire1().start();
			}else if (e.getKeyCode() == 80) {
				pause = !pause;
				if (pause == true) {
					lblPause.setText("PAUSA");
				}else lblPause.setText("");
			}else if (e.getKeyCode()==10) {
				new Fire2().start();
			}else pressed.add(e.getKeyCode());
		}
		@Override
		public synchronized void keyReleased(KeyEvent e){
			pressed.remove(e.getKeyCode());
		}
		@Override
		public void keyTyped(KeyEvent e){}

		public class Reload extends Thread {

			public Reload(){
				this.setPriority(Thread.MIN_PRIORITY);
				this.start();
			}
			public void run(){
				while(aux){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (pause)
						continue;

					try {
						for (int keyCode : pressed) {

							if (aux == false) {
								//aux = true;
								multiKeyPressListener.restart();
							}
							//TODO MOVE O PLAYER 1
							if(keyCode==37){
								Rectangle r = new Rectangle(nave2.getLocation().x-5, nave2.getLocation().y , nave2.getWidth(), nave2.getHeight());
								if (r.getLocation().x >= 0) {
									nave2.setBounds(r);
								}
							}
							if(keyCode==38){
								Rectangle r = new Rectangle(nave2.getLocation().x, nave2.getLocation().y-5 , nave2.getWidth(), nave2.getHeight());
								if (r.getLocation().y >= 0) {
									nave2.setBounds(r);
								}
							}
							if(keyCode==39){
								Rectangle r = new Rectangle(nave2.getLocation().x+5, nave2.getLocation().y , nave2.getWidth(), nave2.getHeight());
								if (r.getLocation().x <= panelPlayer2.getWidth()-nave2.getWidth()) {
									nave2.setBounds(r);
								}
							}
							if(keyCode==40){
								Rectangle r = new Rectangle(nave2.getLocation().x, nave2.getLocation().y+5, nave2.getWidth(), nave2.getHeight());
								if (r.getLocation().y <= panelPlayer2.getHeight()-nave2.getHeight()) {
									nave2.setBounds(r);
								}
							}


							//TODO MOVE O PLAYER 2


							if (keyCode == 87) {
								Rectangle r = new Rectangle(nave1.getLocation().x, nave1.getLocation().y-5, nave1.getWidth(), nave1.getHeight());
								if (r.getLocation().y >= 0) {
									nave1.setBounds(r);
								}
							}
							if (keyCode==65) {
								Rectangle r = new Rectangle(nave1.getLocation().x-5, nave1.getLocation().y , nave1.getWidth(), nave1.getHeight());
								if (r.getLocation().x >= 0) {
									nave1.setBounds(r);
								}
							}
							if (keyCode==83) {

								Rectangle r = new Rectangle(nave1.getLocation().x, nave1.getLocation().y+5 , nave1.getWidth(), nave1.getHeight());
								if (r.getLocation().y <= panelPlayer1.getHeight()-nave1.getHeight()) {
									nave1.setBounds(r);
								}



							}
							if (keyCode==68) {
								Rectangle r = new Rectangle(nave1.getLocation().x+5, nave1.getLocation().y, nave1.getWidth(), nave1.getHeight());
								if (r.getLocation().x <= panelPlayer1.getWidth()-nave1.getWidth()) {
									nave1.setBounds(r);
								}

							}
						}
					} catch (Exception e) {}
				}
			}
		}
		public void restart() {
			pressed.clear();
		}
	}
	//TODO FIRE1
	private class Fire1 extends Thread{
		public void run(){
			while (aux) {
				JLabel fire =  new JLabel();
				fire.setName("tiro1");
				fire.setBounds(nave1.getLocation().x+nave1.getWidth()/2-8, nave1.getLocation().y, 16, 16);
				fire.setIcon(torpedo);
				panelPlayer1.add(fire);
				while (aux) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (pause)
						continue;

					fire.setLocation(fire.getLocation().x, fire.getLocation().y-5);
					if (fire.getLocation().y+fire.getHeight() <= 0) {
						getContentPane().remove(fire);
						return;
					}
					for (Component c : panelPlayer1.getComponents()) {
						if(c.getClass().equals(JLabel.class)){
							if ("asteroide1".equals(c.getName()) && c.getBounds().intersects(fire.getBounds())) {
								c.setVisible(false);
								panelPlayer1.remove(fire);
								panelPlayer1.remove(c);
								if (!(labelPontos1.getText().equals(""))) {
									labelPontos1.setText(Integer.parseInt(labelPontos1.getText())+10+"");
								}else labelPontos1.setText("10");
								repaint();
								invalidate();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								return;
							}
						}
					}
				}
				return;
			}
		}
	}
	//TODO FIRE 2
	private class Fire2 extends Thread{
		public void run(){
			while (aux) {
				JLabel fire =  new JLabel();
				fire.setName("tiro2");
				fire.setBounds(nave2.getLocation().x+nave2.getWidth()/2-8, nave2.getLocation().y, 16, 16);
				fire.setIcon(torpedo);
				panelPlayer2.add(fire);
				while (aux) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (pause)
						continue;

					fire.setLocation(fire.getLocation().x, fire.getLocation().y-5);
					if (fire.getLocation().y+fire.getHeight() <= 0) {
						getContentPane().remove(fire);
						return;
					}
					for (Component c : panelPlayer2.getComponents()) {
						if(c.getClass().equals(JLabel.class)){
							if ("asteroide2".equals(c.getName()) && c.getBounds().intersects(fire.getBounds())) {
								c.setVisible(false);
								panelPlayer2.remove(fire);
								panelPlayer2.remove(c);
								if (!(labelPontos2.getText().equals(""))) {
									labelPontos2.setText(Integer.parseInt(labelPontos2.getText())+10+"");
								}else labelPontos2.setText("10");
								repaint();
								invalidate();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								return;
							}
						}
					}
				}
				return;
			}
		}
	}
	//TODO RANDOM 1
	private class RandomAsteroide1 extends Thread{
		public void run(){
			while (aux) {
				int tempo = new Random().nextInt(300)+50;
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (pause)
					continue;

				new MoveAsteroide1().start();
			}
		}
	}
	//TODO RANDOM 2
	private class RandomAsteroide2 extends Thread{

		public void run(){
			while (aux) {
				int tempo = new Random().nextInt(500)+50;
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (pause)
					continue;

				new MoveAsteroide2().start();
			}
		}
	}
	//TODO MOVE 1
	private class MoveAsteroide1 extends Thread{
		public void run() {				

			JLabel asteroide = new JLabel();
			asteroide.setName("asteroide1");
			int tamanho = new Random().nextInt(56)+72;
			int posicao = new Random().nextInt(panelPlayer1.getWidth()-tamanho);
			asteroide.setBounds(posicao, 0-tamanho, tamanho, tamanho);
			int time = new Random().nextInt(100)+100;
			asteroide.setIcon(Utils.ImageUtils.resizeImageIcon("img/asteroid.png", tamanho, tamanho));
			panelPlayer1.add(asteroide);

			while (aux && asteroide.isVisible()) {

				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (pause)
					continue;

				asteroide.setLocation(asteroide.getLocation().x, asteroide.getLocation().y+30);
				if (asteroide.getBounds().intersects(nave1.getBounds())) {
					int lifeLoss = Integer.parseInt(labelVida1.getText()) - 25;
					if (lifeLoss <= 0) {
						aux = false;
						labelVida1.setText("0");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "VENCEDOR: Player 2!");
						reiniciar(false);
						return;
					}
					labelVida1.setText(lifeLoss+"");
					panelPlayer1.remove(asteroide);

					return;
				}
			}
		}
	}
	//TODO MOVE 2
	private class MoveAsteroide2 extends Thread{
		public void run() {				

			JLabel asteroide = new JLabel();
			asteroide.setName("asteroide2");
			int tamanho = new Random().nextInt(56)+72;
			int posicao = new Random().nextInt(panelPlayer2.getWidth()-tamanho);
			asteroide.setBounds(posicao, 0-tamanho, tamanho, tamanho);
			int time = new Random().nextInt(100)+100;
			asteroide.setIcon(Utils.ImageUtils.resizeImageIcon("img/asteroid.png", tamanho, tamanho));
			panelPlayer2.add(asteroide);

			while (aux && asteroide.isVisible()) {

				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (pause)
					continue;

				asteroide.setLocation(asteroide.getLocation().x, asteroide.getLocation().y+30);
				if (asteroide.getBounds().intersects(nave2.getBounds())) {
					int lifeLoss = Integer.parseInt(labelVida2.getText()) - 25;
					if (lifeLoss <= 0) {
						aux = false;
						labelVida2.setText("0");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "VENCEDOR: Player 1!");
						reiniciar(false);
						return;
					}
					labelVida2.setText(lifeLoss+"");
					panelPlayer2.remove(asteroide);
					repaint();
					invalidate();
					return;
				}
			}
		}
	}
	public void reiniciar(boolean timeOver){
		aux = false;
		long pontos1 = Long.parseLong(labelPontos1.getText());
		long pontos2 = Long.parseLong(labelPontos2.getText());
		
		if (timeOver) {
			if (pontos1 > pontos2) {
				JOptionPane.showMessageDialog(contentPane, "VENCEDOR: Player 1!");
			
			}else if (pontos2 > pontos1){
				JOptionPane.showMessageDialog(contentPane, "VENCEDOR: Player 2!");
				
			}else JOptionPane.showMessageDialog(contentPane, "EMPATE!");
		}
		JOptionPane.showMessageDialog(contentPane, "FIM DE JOGO\n"
				+ "\nPlayer 1:"
				+ "\n   Pontos: "+pontos1
				+ "\n   Vida: "+labelVida1.getText()
				+ "\nPlayer 2:"
				+ "\n   Pontos: "+pontos2
				+ "\n   Vida: "+labelVida2.getText()
				+ "\nTempo: "+lblTime.getText());
		
		menu.setVisible(true);
		dispose();
	}
	private class Tempo extends Thread{
		long time = 120000;
		Date date = new Date(time);
		public void run() {
			while (aux) {
				DateFormat df = new SimpleDateFormat("mm:ss");
				String newData = df.format(date);
				lblTime.setText(newData+"");
				if (time <= 0) {
					aux = false;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "ACABOU O TEMPO!");
					reiniciar(true);
					return;
				}
				try {
					time -= 1000;
					date.setTime(time);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}