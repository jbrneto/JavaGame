import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSplitPane;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Interface.JPanelImage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Game extends JFrame {

	private JPanel contentPane;
	private JPanelImage panelGame;
	private JPanel panelInfo;
	private JLabel nave;
	private JLabel labelPontos;
	private MultiKeyPressListener multiKeyPressListener;
	private boolean aux = true;
	private JLabel lblNaveMae;
	private JLabel labelVida;
	private ImageIcon explosion = Utils.ImageUtils.resizeImageIcon("img/explosion.png");
	private ImageIcon torpedo = new ImageIcon(getClass().getResource("img/torpedo.png"));
	private boolean pause = false;
	private JLabel labelPause;
	private Menu menu;
	private JButton btnSair;
	private JLabel lblTime;


	public Game(int dificuldade , String localNave , Menu menu) {
		repaint();
		invalidate();
		this.menu = menu;
		setTitle("Rings Of Saturn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);

		contentPane.add(splitPane, BorderLayout.CENTER);

		panelGame = new JPanelImage();
		splitPane.setRightComponent(panelGame);
		panelGame.setLayout(null);
		panelGame.setBackgroundImage(new ImageIcon(Game.class.getResource("img/fundo.jpg")));

		nave = new JLabel("");
		nave.setIcon(new ImageIcon(Game.class.getResource(localNave)));
		nave.setBounds(277, 455, 64, 64);
		nave.setName("nave");
		panelGame.add(nave);


		panelInfo = new JPanel();
		panelInfo.setForeground(Color.BLACK);
		panelInfo.setBackground(Color.BLACK);
		splitPane.setLeftComponent(panelInfo);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{0, 0};
		gbl_panelInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelInfo.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelInfo.setLayout(gbl_panelInfo);

		JLabel lblPontos = new JLabel("PONTOS:");
		lblPontos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPontos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPontos = new GridBagConstraints();
		gbc_lblPontos.insets = new Insets(0, 0, 5, 0);
		gbc_lblPontos.gridx = 0;
		gbc_lblPontos.gridy = 0;
		panelInfo.add(lblPontos, gbc_lblPontos);

		labelPontos = new JLabel("0");
		labelPontos.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPontos.setForeground(Color.GREEN);
		GridBagConstraints gbc_labelPontos = new GridBagConstraints();
		gbc_labelPontos.insets = new Insets(0, 0, 5, 0);
		gbc_labelPontos.gridx = 0;
		gbc_labelPontos.gridy = 1;
		panelInfo.add(labelPontos, gbc_labelPontos);

		lblNaveMae = new JLabel("NAVE M\u00C3E:");
		lblNaveMae.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNaveMae.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNaveMae = new GridBagConstraints();
		gbc_lblNaveMae.insets = new Insets(0, 0, 5, 0);
		gbc_lblNaveMae.gridx = 0;
		gbc_lblNaveMae.gridy = 2;
		panelInfo.add(lblNaveMae, gbc_lblNaveMae);

		labelVida = new JLabel("100");
		labelVida.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelVida.setForeground(Color.RED);
		GridBagConstraints gbc_labelVida = new GridBagConstraints();
		gbc_labelVida.insets = new Insets(0, 0, 5, 0);
		gbc_labelVida.gridx = 0;
		gbc_labelVida.gridy = 3;
		panelInfo.add(labelVida, gbc_labelVida);

		labelPause = new JLabel("");
		labelPause.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelPause.setForeground(Color.GREEN);
		GridBagConstraints gbc_labelPause = new GridBagConstraints();
		gbc_labelPause.insets = new Insets(0, 0, 5, 0);
		gbc_labelPause.gridx = 0;
		gbc_labelPause.gridy = 5;
		panelInfo.add(labelPause, gbc_labelPause);

		btnSair = new JButton("VOLTAR");
		btnSair.setFont(new Font("Quartz MS", Font.BOLD, 15));
		btnSair.setForeground(Color.GREEN);
		btnSair.setBackground(Color.BLACK);
		btnSair.setFocusable(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pause = true;
				int op = JOptionPane.showConfirmDialog(contentPane, "Se você voltar ao Menu, perderá seu jogo atual!\nAinda assim quer voltar ao Menu?", "Tem certeza que quer voltar?", JOptionPane.YES_NO_CANCEL_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					menu.setVisible(true);
					menu.restarMusic();
					dispose();
				}else pause = false;
			}
		});
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.BOTH;
		gbc_btnSair.insets = new Insets(0, 0, 5, 0);
		gbc_btnSair.gridx = 0;
		gbc_btnSair.gridy = 7;
		panelInfo.add(btnSair, gbc_btnSair);

		lblTime = new JLabel("10:00");
		lblTime.setFont(new Font("Quartz MS", Font.BOLD, 30));
		lblTime.setForeground(Color.RED);
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.SOUTH;
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 8;
		panelInfo.add(lblTime, gbc_lblTime);

		setUndecorated(true);

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		nave.setLocation(panelGame.getWidth()/2, panelGame.getHeight()-nave.getHeight());
		repaint();

		multiKeyPressListener = new MultiKeyPressListener();
		this.addKeyListener(multiKeyPressListener);
		new RandomAsteroide(dificuldade).start();
		new Tempo().start();
	}


	class MultiKeyPressListener implements KeyListener {

		private final Set<Integer> pressed = new HashSet<Integer>();

		MultiKeyPressListener(){
			new Reload();
		}
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==32) {
				new Fire().start();
			}else if (e.getKeyCode() == 80) {
				pause = !pause;
				if (pause == true) {
					labelPause.setText("PAUSA");
				}else labelPause.setText("");
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
						Thread.sleep(20);
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

							if(keyCode==37){
								Rectangle r = new Rectangle(nave.getLocation().x-5, nave.getLocation().y , nave.getWidth(), nave.getHeight());
								if (r.getLocation().x >= 0) {
									nave.setBounds(r);
								}
							}
							if(keyCode==38){
								Rectangle r = new Rectangle(nave.getLocation().x, nave.getLocation().y-5 , nave.getWidth(), nave.getHeight());
								if (r.getLocation().y >= 0) {
									nave.setBounds(r);
								}
							}
							if(keyCode==39){
								Rectangle r = new Rectangle(nave.getLocation().x+5, nave.getLocation().y , nave.getWidth(), nave.getHeight());
								if (r.getLocation().x <= panelGame.getWidth()-panelInfo.getWidth()) {
									nave.setBounds(r);
								}
							}
							if(keyCode==40){
								Rectangle r = new Rectangle(nave.getLocation().x, nave.getLocation().y+5, nave.getWidth(), nave.getHeight());
								if (r.getLocation().y <= panelGame.getHeight()-nave.getHeight()) {
									nave.setBounds(r);
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
	private class Fire extends Thread{
		public void run(){
			while (aux) {
				JLabel fire =  new JLabel();
				fire.setName("tiro");
				fire.setBounds(nave.getLocation().x+nave.getWidth()/2-8, nave.getLocation().y, 16, 16);
				fire.setIcon(torpedo);
				panelGame.add(fire);
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
					for (Component c : panelGame.getComponents()) {
						if(c.getClass().equals(JLabel.class)){
							if (("asteroide".equals(c.getName()) ||  "asteroideLateral".equals(c.getName()))&& c.getBounds().intersects(fire.getBounds())) {
								c.setVisible(false);
								panelGame.remove(fire);
								panelGame.remove(c);
								if (!(labelPontos.getText().equals(""))) {
									labelPontos.setText(Integer.parseInt(labelPontos.getText())+10+"");
								}else labelPontos.setText("10");
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
	private class RandomAsteroide extends Thread{

		int dificuldade;

		public RandomAsteroide(int dificuldade){
			this.dificuldade = dificuldade;
		}
		public void run(){
			while (aux) {
				int tempo = new Random().nextInt(dificuldade)+50;
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (pause)
					continue;
				if (tempo >= 470 && tempo <= 500) {
					new MoveAsteroide(true).start();
				}
				new MoveAsteroide(false).start();
			}
		}
	}
	private class MoveAsteroide extends Thread{
		boolean lateral;

		public MoveAsteroide(boolean l){
			lateral = l;
		}

		public void run() {				
			
			JLabel asteroide = new JLabel();
			int tamanho = new Random().nextInt(56)+72;
			int posicao;
			if (lateral) {
				posicao = nave.getLocation().y-tamanho+32;
				asteroide.setBounds(0-tamanho, posicao, tamanho, tamanho);
				asteroide.setName("asteroideLateral");
			}else {
				asteroide.setName("asteroide");
				posicao = new Random().nextInt(panelGame.getWidth()-tamanho);
				asteroide.setBounds(posicao, 0-tamanho, tamanho, tamanho);
			}
			int time = new Random().nextInt(100)+100;
			asteroide.setIcon(Utils.ImageUtils.resizeImageIcon("img/asteroid.png", tamanho, tamanho));
			panelGame.add(asteroide);

			while (aux && asteroide.isVisible()) {

				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (pause)
					continue;
				
				//TODO MOVIMENTACAO DE ASTEROIDE LATERAL
				
				if (lateral) {
					asteroide.setLocation(asteroide.getLocation().x+7, asteroide.getLocation().y);
					if (asteroide.getLocation().x >= panelGame.getWidth()) {
						panelGame.remove(asteroide);
						return;
					}
					else if (asteroide.getBounds().intersects(nave.getBounds())) {
						aux = false;
						panelGame.remove(asteroide);
						nave.setIcon(explosion);
						repaint();
						invalidate();
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						panelGame.remove(nave);
						repaint();
						invalidate();
						JOptionPane.showMessageDialog(contentPane, "Você foi atingido por um meteóro!");
						reiniciar();

						return;
					}
					for (Component c : panelGame.getComponents()) {
						if(c.getClass().equals(JLabel.class)){
							if ("asteroide".equals(c.getName()) && c.getBounds().intersects(asteroide.getBounds())) {
								c.setVisible(false);
								panelGame.remove(asteroide);
								panelGame.remove(c);
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

					//TODO MOVIMENTACAO DE ASTEROIDE VERTICAL
					
				}else{
					asteroide.setLocation(asteroide.getLocation().x, asteroide.getLocation().y+7);
					if (asteroide.getLocation().y+asteroide.getHeight() >= panelGame.getHeight()) {
						int lifeLoss = Integer.parseInt(labelVida.getText()) - 25;
						if (lifeLoss <= 0) {
							aux = false;
							labelVida.setText("0");
							JOptionPane.showMessageDialog(contentPane, "A Nave Mãe foi destruída!");
							reiniciar();
							return;
						}
						labelVida.setText(lifeLoss+"");
						panelGame.remove(asteroide);
						return;
					}
					else if (asteroide.getBounds().intersects(nave.getBounds())) {
						aux = false;
						panelGame.remove(asteroide);
						nave.setIcon(explosion);
						repaint();
						invalidate();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						panelGame.remove(nave);
						repaint();
						invalidate();
						JOptionPane.showMessageDialog(contentPane, "Você foi atingido por um meteóro!");
						reiniciar();

						return;
					}
				}
			}
		}
	}

	public void reiniciar(){
		aux = false;
		JOptionPane.showMessageDialog(contentPane, "Você Perdeu: \nPontos: "+labelPontos.getText()+"\nVida da Nave Mãe: "+labelVida.getText()+"\nTempo: "+lblTime.getText());
		menu.setVisible(true);
		menu.restarMusic();
		dispose();
	}
	private class Tempo extends Thread{
		long time = 0;
		Date date = new Date(time);
		public void run() {
			while (aux) {
				DateFormat df = new SimpleDateFormat("mm:ss");
				String newData = df.format(date);
				lblTime.setText(newData+"");
				if (time >= 60000) {
					aux = false;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "Você Venceu! \nPontos: "+labelPontos.getText()+"\nVida da Nave Mãe: "+labelVida.getText()+"\nTempo: "+lblTime.getText());
					menu.setVisible(true);
					menu.restarMusic();
					dispose();
				}
				try {
					time += 1000;
					date.setTime(time);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
