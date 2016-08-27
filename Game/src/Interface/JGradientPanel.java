package Interface;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 *  @author Bruno Konzen Stahl
 *  @since 15/05/2008
 */
public class JGradientPanel extends JPanel{

	private static final long serialVersionUID = -9156713053128094175L;
	
	//---Constantes---
	private Color backgroundColor = Color.white;
	private Color gradientColor = Color.BLUE;
	private int profundidade = 300;

	public JGradientPanel(){
		setBackground(gradientColor);
	}
	
	public JGradientPanel(int profundidade) {
		this.profundidade=profundidade;
		setBackground(gradientColor);
	}
	
	public JGradientPanel(Color backgroundColor, Color gradientColor, int profundidade) {
		this.backgroundColor=backgroundColor;
		this.gradientColor=gradientColor;
		this.profundidade=profundidade;
		setBackground(gradientColor);
	}

	@Override
	public boolean isOpaque() {
		return false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		((Graphics2D)g).setPaint(new GradientPaint(getWidth()/2,profundidade,getBackground(),getWidth()/2,0,backgroundColor,false));
		g.setClip(null);
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(0,0,getWidth(),getHeight(),0 ,0);
		super.paintComponent(g);
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getGradientColor() {
		return gradientColor;
	}

	public void setGradientColor(Color gradientColor) {
		this.gradientColor = gradientColor;
	}
}