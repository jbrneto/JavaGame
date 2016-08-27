import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Interface.JLabelRotate;
import Utils.ImageUtils;


public class Nave extends javax.swing.JFrame {

	private JLabelRotate jButtonPersonagem;

	private boolean done = true;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		Nave inst = new Nave();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);

		//JTrayIcon tray = new JTrayIcon(inst,ImageUtils.resizeImageIcon("Imagem/nave2.png",42,42).getImage(),"Game das Naves");
	}

	public Nave() {
		super();
		initGUI();
	}

	private void initGUI() {

		try {
			this.setTitle("Nave");
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);

			this.addKeyListener(new MultiKeyPressListener());

			{
				jButtonPersonagem = new JLabelRotate("Imagem/nave2.png",0);
				getContentPane().add(jButtonPersonagem);
				jButtonPersonagem.setBounds(167, 179, 70, 70);
				jButtonPersonagem.setFocusable(false);
				jButtonPersonagem.setName("personagem");

			}
			pack();
			this.setSize(389, 270);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private class Tiro extends Thread{

		public void run(){

			JLabel tiro = new JLabel();
			tiro.setOpaque(true);
			tiro.setBackground(new Color(212,58,187));
			tiro.setBounds(jButtonPersonagem.getLocation().x+jButtonPersonagem.getWidth()/2-10, jButtonPersonagem.getLocation().y, 20, 45);
			getContentPane().add(tiro);

			while(done){

				tiro.setLocation(tiro.getLocation().x, tiro.getLocation().y-5);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if(tiro.getLocation().y+tiro.getHeight()<=0)
					break;
			}
		}
	}


	private class MultiKeyPressListener implements KeyListener {

		private final Set<Integer> pressed = new HashSet<Integer>();

		MultiKeyPressListener(){
			new Reload();
		}
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			pressed.add(e.getKeyCode());
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

				while(true){

					try {

						//Percorrendo teclas
						for (int keyCode : pressed) {

							Rectangle rec = jButtonPersonagem.getBounds();

							if(keyCode==37){
								rec = new Rectangle(jButtonPersonagem.getLocation().x-10, jButtonPersonagem.getLocation().y,jButtonPersonagem.getWidth(), jButtonPersonagem.getHeight());
								jButtonPersonagem.setBounds(rec);
							}
							if(keyCode==38){
								rec = new Rectangle(jButtonPersonagem.getLocation().x, jButtonPersonagem.getLocation().y-10,jButtonPersonagem.getWidth(), jButtonPersonagem.getHeight());
								jButtonPersonagem.setBounds(rec);
							}
							if(keyCode==39){
								rec = new Rectangle(jButtonPersonagem.getLocation().x+10, jButtonPersonagem.getLocation().y,jButtonPersonagem.getWidth(), jButtonPersonagem.getHeight());
								jButtonPersonagem.setBounds(rec);
							}
							if(keyCode==40){
								rec = new Rectangle(jButtonPersonagem.getLocation().x, jButtonPersonagem.getLocation().y+10,jButtonPersonagem.getWidth(), jButtonPersonagem.getHeight());
								jButtonPersonagem.setBounds(rec);
							}

							if(keyCode==68){
								double angulo = jButtonPersonagem.getAngle();
								angulo = angulo + 0.1;
								jButtonPersonagem.setAngle(angulo);
							}

							if(keyCode==32)
								new Tiro().start();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}

}