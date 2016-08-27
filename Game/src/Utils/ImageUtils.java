package Utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ImageUtils {

	public static ImageIcon resizeImageIcon(String diretorio){
		return resizeImageIcon(diretorio,20,20);
	}

	public static ImageIcon resizeImageIcon(String diretorio, int width, int heigt){
		ImageIcon iconMaterial = new ImageIcon(ImageUtils.class.getClassLoader().getResource(diretorio));
		return new ImageIcon(iconMaterial.getImage().getScaledInstance(width,heigt,100));
	}

	public static ImageIcon resizeImageIcon(ImageIcon iconMaterial, int width, int heigt){
		return new ImageIcon(iconMaterial.getImage().getScaledInstance(width,heigt,100));
	}

	public static String getImagePath(){
		String imagePath = "";
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Selecione uma Imagem");
		chooser.setDialogType(JFileChooser.OPEN_DIALOG); 
		chooser.showOpenDialog(chooser);
		File file = chooser.getSelectedFile();
		if(file!=null){
			imagePath = file.getAbsolutePath();
		}
		return imagePath;
	}

	public static Image getImage(String caminho) throws IOException{
		Image image = null;
		File sourceimage = new File(caminho);
		image = ImageIO.read(sourceimage);
		return image;
	}

	public BufferedImage createBufferedImage(Image image){
		BufferedImage bi = new BufferedImage(100, 170,BufferedImage.TYPE_INT_RGB);

		Graphics2D g = bi.createGraphics();
		g.drawImage(image, 0, 0, null);
		return bi;
	}

	public static ImageIcon arrayToImage(byte[] data) throws IOException{
		ImageIcon i = new ImageIcon(data);  
		return i;
	}
}
