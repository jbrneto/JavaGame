import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Labirinto extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JButton cursor;
	private JLabel jLabel19;
	private JLabel jLabel18;
	private JLabel jLabel17;
	private JLabel jLabel16;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel6;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel4;
	private boolean aux = true;
	private MultiKeyPressListener multiKeyPressListener;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		Labirinto inst = new Labirinto();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public Labirinto() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setTitle("Labirinto");
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBackground(Color.BLACK);
				jLabel1.setOpaque(true);
				jLabel1.setBounds(0, 0, 374, 20);
				jLabel1.setForeground(Color.YELLOW);
				jLabel1.setFont(new Font("TIME", Font.BOLD, 20));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setOpaque(true);
				jLabel2.setBackground(Color.BLACK);
				jLabel2.setBounds(0, 88, 20, 136);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setOpaque(true);
				jLabel3.setBackground(Color.BLACK);
				jLabel3.setBounds(-5, 212, 378, 20);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setOpaque(true);
				jLabel5.setBackground(Color.BLACK);
				jLabel5.setBounds(259, 42, 70, 20);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setOpaque(true);
				jLabel4.setBackground(Color.BLACK);
				jLabel4.setBounds(353, 20, 20, 34);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setOpaque(true);
				jLabel8.setBackground(Color.BLACK);
				jLabel8.setBounds(353, 78, 20, 143);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setOpaque(true);
				jLabel7.setBackground(Color.BLACK);
				jLabel7.setBounds(221, 86, 65, 20);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setOpaque(true);
				jLabel9.setBackground(Color.BLACK);
				jLabel9.setBounds(171, 170, 159, 20);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setOpaque(true);
				jLabel10.setBackground(Color.BLACK);
				jLabel10.setBounds(216, 20, 20, 86);
			}
			{
				jLabel11 = new JLabel();
				getContentPane().add(jLabel11);
				jLabel11.setOpaque(true);
				jLabel11.setBackground(Color.BLACK);
				jLabel11.setBounds(310, 43, 20, 147);
			}
			{
				jLabel12 = new JLabel();
				getContentPane().add(jLabel12);
				jLabel12.setOpaque(true);
				jLabel12.setBackground(Color.BLACK);
				jLabel12.setBounds(171, 129, 140, 20);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setOpaque(true);
				jLabel6.setBackground(Color.BLACK);
				jLabel6.setBounds(171, 43, 20, 104);
			}
			{
				jLabel13 = new JLabel();
				getContentPane().add(jLabel13);
				jLabel13.setOpaque(true);
				jLabel13.setBackground(Color.BLACK);
				jLabel13.setBounds(128, 49, 20, 141);
			}
			{
				jLabel14 = new JLabel();
				getContentPane().add(jLabel14);
				jLabel14.setOpaque(true);
				jLabel14.setBackground(Color.BLACK);
				jLabel14.setBounds(0, 19, 20, 43);
			}
			{
				jLabel16 = new JLabel();
				getContentPane().add(jLabel16);
				jLabel16.setOpaque(true);
				jLabel16.setBackground(Color.BLACK);
				jLabel16.setBounds(95, 42, 53, 20);
			}
			{
				jLabel17 = new JLabel();
				getContentPane().add(jLabel17);
				jLabel17.setOpaque(true);
				jLabel17.setBackground(Color.BLACK);
				jLabel17.setBounds(20, 42, 27, 20);
			}
			{
				jLabel18 = new JLabel();
				getContentPane().add(jLabel18);
				jLabel18.setOpaque(true);
				jLabel18.setBackground(Color.BLACK);
				jLabel18.setBounds(42, 42, 20, 142);
			}
			{
				jLabel19 = new JLabel();
				getContentPane().add(jLabel19);
				jLabel19.setOpaque(true);
				jLabel19.setBackground(Color.BLACK);
				jLabel19.setBounds(86, 42, 20, 174);
			}
			{
				cursor = new JButton();
				getContentPane().add(cursor);
				cursor.setBounds(353, 57, 20, 20);
				cursor.setFocusable(false);
				cursor.setBackground(Color.RED);

			}
			pack();
			this.setSize(389, 270);

			JOptionPane.showMessageDialog(null, "Você terá 60 sec. para completar o labirinto!");
			new contar().start();
			
			multiKeyPressListener = new MultiKeyPressListener();
			this.addKeyListener(multiKeyPressListener);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class contar extends Thread{
		public void run(){
			int sec = 60;
			while (aux) {
				if (sec <= 0) {
					JOptionPane.showMessageDialog(null, "YOU LOSE!");
					cursor.setBounds(353,57, cursor.getWidth(), cursor.getHeight());
					aux = false;
					return;
				}
				sec --;
				jLabel1.setText(sec+"");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class MultiKeyPressListener implements KeyListener {

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

					for (int keyCode : pressed) {

						if (aux == false) {
							JOptionPane.showMessageDialog(null, "Você terá 60 sec. para completar o labirinto!");
							aux = true;
							new contar().start();
							
							multiKeyPressListener.restart();
						}
						
						if(keyCode==37){
							Rectangle r = new Rectangle(cursor.getLocation().x-2, cursor.getLocation().y , cursor.getWidth(), cursor.getHeight());
							if (!conflito(r)) {
								cursor.setBounds(r);
							}
						}
						if(keyCode==38){
							Rectangle r = new Rectangle(cursor.getLocation().x, cursor.getLocation().y-2 , cursor.getWidth(), cursor.getHeight());
							if (!conflito(r)) {
								cursor.setBounds(r);
							}
						}
						if(keyCode==39){
							Rectangle r = new Rectangle(cursor.getLocation().x+2, cursor.getLocation().y , cursor.getWidth(), cursor.getHeight());
							
							if (r.getLocation().x <= 353) {
								if (!conflito(r)) {
									cursor.setBounds(r);
								}
							}
						}
						if(keyCode==40){
							Rectangle r = new Rectangle(cursor.getLocation().x, cursor.getLocation().y+2, cursor.getWidth(), cursor.getHeight());
							if (!conflito(r)) {
								cursor.setBounds(r);
							}
						}
						if (cursor.getLocation().x <= -20) {
							aux = false;
							JOptionPane.showMessageDialog(null, "YOU WIN!");
							int op = JOptionPane.showConfirmDialog(null, "DESEJA RECOMECAR?", "Fim", JOptionPane.YES_NO_OPTION);
							if (op == JOptionPane.YES_OPTION) {
								jLabel1.setText("60");
								cursor.setBounds(353,57, cursor.getWidth(), cursor.getHeight());
							}else dispose();
						}
					}

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		public void restart() {
			pressed.clear();
		}
	}
	private boolean conflito(Rectangle r ){
		
		for (Component c : getContentPane().getComponents()) {
			if(c.getClass().equals(JLabel.class)){
				if (c.getBounds().intersects(r)) {
					return true;
				}
			}
		}
		return false;
	}
}
