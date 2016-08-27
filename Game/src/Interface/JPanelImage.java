package Interface;

import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * A JPanel that supports a background image
 * @author Guilherme Inocencio Keller
 */
public class JPanelImage extends JPanel {
    
	private static final long serialVersionUID = -1442648211375287454L;
	
	/** The background of Panel */
	private Icon backgroundImage;
    
    /** Creates a new instance of JPanelBackground */
    public JPanelImage() {
        super();
    }
    
    public JPanelImage(ImageIcon icon) {
        super();
        setBackgroundImage(icon);
    }
    
    /**
     * Overrided method to paint the Image in the background of panel.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if( this.getBackgroundImage() != null ){
            ImageIcon image = (ImageIcon) getBackgroundImage();
            g.drawImage(    image.getImage(), 
                            0, 
                            0, 
                            this.getWidth(), 
                            this.getHeight(), 
                            this );
        }
    }
    
    public Icon getBackgroundImage() {
        return backgroundImage;
    }
    
    public void setBackgroundImage(Icon backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}