package EditorX;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
* class ShowImage - This class show an image in a Frame. 
* Fields: 
*   image - BufferedImage.
* Methods:
*   ShowImage()
*   paint()  
*/
public class ShowImage extends JPanel {

	private static final long serialVersionUID = 1L;
	BufferedImage  image;
	/**
	 * Defines the constructor of ShowImage class.
	 */
  public ShowImage() {
    try {
	 String imageName="logo_about.png";
	File input = new File(imageName);
	    image = ImageIO.read(input);
    } catch (IOException ie) {
      System.out.println("Error:"+ie.getMessage());
    }
  }
  /**
   *  Implements paint method.
   * @param g
   */
  public void paint(Graphics g) {
    g.drawImage( image, 0, 0, null);
  }

}