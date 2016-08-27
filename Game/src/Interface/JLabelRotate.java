package Interface;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Bruno Konzen Stahl
 * @since 19/09/2011
 */
public class JLabelRotate extends JLabel{

	private static final long serialVersionUID = 7671584422327205726L;
	
	private double angle;
	private String path;
	
	public JLabelRotate(){}
	public JLabelRotate(String path, double angle){
		setIcon(path, angle);
	}

	public void setIcon(String path, double angle){

		this.angle = angle;
		this.path = path;
		try {           
			URL url = this.getClass().getClassLoader().getResource(path);
			BufferedImage bufferedImage = ImageIO.read(url); // create a buffered image

			ImageIcon icon = new ImageIcon(bufferedImage);    

			int w= bufferedImage.getWidth();
			int h=bufferedImage.getHeight();

			AffineTransform tx = new AffineTransform();
			tx.rotate(angle,w / 2, h / 2);//(radian,arbit_X,arbit_Y)

			AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
			bufferedImage=op.filter(bufferedImage,null);//(sourse,destination)

			icon = new ImageIcon(bufferedImage);          
			this.setIcon(icon);
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
	
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angel){
		this.angle = angel;
		if(path!=null){
			setIcon(path,angel);
		}
		this.repaint();
	}
}