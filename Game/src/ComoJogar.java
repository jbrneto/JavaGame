import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Rectangle;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ComoJogar extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ComoJogar(Dimension screen) {
		setTitle("Rings Of Saturn - Como Jogar");
		setBounds((int) screen.getHeight()/2, (int) screen.getWidth()/2 - 608, 672, 608);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new LineBorder(Color.GREEN, 2));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblSinglePlayer = new JLabel("SINGLE PLAYER");
		lblSinglePlayer.setBackground(Color.BLACK);
		lblSinglePlayer.setFont(new Font("Quartz MS", Font.BOLD, 30));
		lblSinglePlayer.setForeground(Color.GREEN);
		lblSinglePlayer.setBounds(10, 10, 636, 50);
		contentPanel.add(lblSinglePlayer);
		{
			JLabel lblUseAsTeclas = new JLabel("Use as teclas direcionais para mover-se e barra de espa\u00E7o para atirar.");
			lblUseAsTeclas.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUseAsTeclas.setForeground(Color.GREEN);
			lblUseAsTeclas.setBounds(10, 53, 535, 35);
			contentPanel.add(lblUseAsTeclas);
		}
		{
			JLabel label = new JLabel("");
			label.setToolTipText("CURIOSO? CLIQUE 2 VEZES!");
			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() >= 2) {
						Labirinto lb = new Labirinto();
						lb.setVisible(true);
					}
				}
			});
			label.setIcon(new ImageIcon(ComoJogar.class.getResource("/img/teclas.png")));
			label.setBounds(20, 94, 145, 91);
			contentPanel.add(label);
		}
		{
			JLabel lblVocVenceSe = new JLabel("Voc\u00EA Vence se:");
			lblVocVenceSe.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVocVenceSe.setForeground(Color.GREEN);
			lblVocVenceSe.setBounds(171, 86, 108, 35);
			contentPanel.add(lblVocVenceSe);
		}
		{
			JLabel lblSobreviverPor = new JLabel("Sobreviver por 10 Minutos.");
			lblSobreviverPor.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSobreviverPor.setForeground(Color.GREEN);
			lblSobreviverPor.setBounds(167, 132, 200, 25);
			contentPanel.add(lblSobreviverPor);
		}
		{
			JLabel lblEANave = new JLabel("e a Nave M\u00E3e n\u00E3o for destruida.");
			lblEANave.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEANave.setForeground(Color.GREEN);
			lblEANave.setBounds(167, 160, 214, 35);
			contentPanel.add(lblEANave);
		}
		{
			JLabel lblVocPerdeSe = new JLabel("Voc\u00EA Perde se:");
			lblVocPerdeSe.setForeground(Color.GREEN);
			lblVocPerdeSe.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVocPerdeSe.setBounds(432, 99, 108, 35);
			contentPanel.add(lblVocPerdeSe);
		}
		{
			JLabel lblForAtingidoPor = new JLabel("For atingido por um mete\u00F3ro.");
			lblForAtingidoPor.setForeground(Color.GREEN);
			lblForAtingidoPor.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblForAtingidoPor.setBounds(432, 132, 200, 25);
			contentPanel.add(lblForAtingidoPor);
		}
		{
			JLabel lblDeixarANave = new JLabel("Deixar a Nave M\u00E3e ser destruida.");
			lblDeixarANave.setForeground(Color.GREEN);
			lblDeixarANave.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDeixarANave.setBounds(432, 165, 224, 25);
			contentPanel.add(lblDeixarANave);
		}
		
		JLabel lblMultiPlayer = new JLabel("MULTI PLAYER");
		lblMultiPlayer.setBackground(Color.BLACK);
		lblMultiPlayer.setForeground(Color.GREEN);
		lblMultiPlayer.setFont(new Font("Quartz MS", Font.BOLD, 30));
		lblMultiPlayer.setBounds(10, 204, 636, 50);
		contentPanel.add(lblMultiPlayer);
		
		JLabel lblUsaAsTeclas = new JLabel("- Usa as teclas direcionais para mover-se e barra de espa\u00E7o para atirar.");
		lblUsaAsTeclas.setForeground(Color.GREEN);
		lblUsaAsTeclas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsaAsTeclas.setBounds(20, 265, 535, 35);
		contentPanel.add(lblUsaAsTeclas);
		
		JLabel lblPlayer = new JLabel("PLAYER 1:");
		lblPlayer.setForeground(Color.GREEN);
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlayer.setBounds(10, 241, 535, 35);
		contentPanel.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("PLAYER 2:");
		lblPlayer_1.setForeground(Color.GREEN);
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlayer_1.setBounds(10, 302, 535, 35);
		contentPanel.add(lblPlayer_1);
		
		JLabel lblusaWasdPara = new JLabel("- Usa as teclas WASD para mover-se e a tecla ENTER para atirar.");
		lblusaWasdPara.setForeground(Color.GREEN);
		lblusaWasdPara.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblusaWasdPara.setBounds(20, 330, 535, 35);
		contentPanel.add(lblusaWasdPara);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ComoJogar.class.getResource("/img/wasd.jpg")));
		label.setBounds(10, 371, 231, 151);
		contentPanel.add(label);
		
		JLabel lblVenceQuem = new JLabel("Vence quem:");
		lblVenceQuem.setForeground(Color.GREEN);
		lblVenceQuem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVenceQuem.setBounds(251, 372, 108, 35);
		contentPanel.add(lblVenceQuem);
		
		JLabel lblOVencedorSer = new JLabel("O vencedor ser\u00E1 aquele que sobreviver por mais tempo.");
		lblOVencedorSer.setForeground(Color.GREEN);
		lblOVencedorSer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOVencedorSer.setBounds(251, 404, 395, 35);
		contentPanel.add(lblOVencedorSer);
		
		JLabel lblAoFinalDe = new JLabel("Ao final de 5 Minutos o vencedor ser\u00E1 quem tiver mais");
		lblAoFinalDe.setForeground(Color.GREEN);
		lblAoFinalDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAoFinalDe.setBounds(251, 433, 395, 35);
		contentPanel.add(lblAoFinalDe);
		
		JLabel lblPontos = new JLabel("pontos.");
		lblPontos.setForeground(Color.GREEN);
		lblPontos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPontos.setBounds(251, 463, 395, 25);
		contentPanel.add(lblPontos);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		separator.setForeground(Color.GREEN);
		separator.setBounds(10, 196, 646, 10);
		contentPanel.add(separator);
		
		JLabel lbluseATecla = new JLabel("***Use a tecla P para Pausar o Jogo.");
		lbluseATecla.setForeground(Color.GREEN);
		lbluseATecla.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbluseATecla.setBounds(10, 521, 535, 35);
		contentPanel.add(lbluseATecla);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.GREEN, 2));
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOK.setFont(new Font("Quartz MS", Font.BOLD, 15));
				btnOK.setForeground(Color.GREEN);
				btnOK.setBackground(Color.BLACK);
				btnOK.setActionCommand("Cancel");
				buttonPane.add(btnOK);
			}
		}
	}
}
