package EditorX;

import java.io.File;
import javax.swing.filechooser.*;
/**
* class RTFFileFilter - This class is an RTF file filter. 
* Fields: 
*   No Fields.
* Methods:
*   RTFFileFilter()
*   getDescription()  
*/
public class RTFFileFilter extends FileFilter {
	/**
	 * Defines the constructor of RTFFileFilter class.
	 */
	public RTFFileFilter() {
		super();
	}
	/**
	 * Implements accept method
	 * @param f
	 * @return boolean
	 */
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = f.getName();
        if (extension.endsWith(".rtf")) {
        	return true;
        }
        else {
        	return false;
        }
    }
    /**
     * Implements getDescription method
     * @return String
     */
    public String getDescription() {
    	return "Fichier RTF";
    }

}
