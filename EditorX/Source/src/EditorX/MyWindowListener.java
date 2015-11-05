package EditorX;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
/**
* class MyWindowListener - This class implements WindowListener. 
* Fields: 
*   ed - FrameEditorTxTd.
*   cl - CListeners.
* Methods:
*   MyWindowListener()
*   windowClosing()  
*/
public class MyWindowListener extends WindowAdapter implements WindowListener 
{ 	/**
	  *  Creates an instance of the FrameEditorTxT class. */ 
	FrameEditorTxT ed;
	 /**
	  *  Creates an instance of the CListeners class. */ 
  CListeners cl;
  /**
   * Defines the constructor of MyWindowListener class.
   * @param ed
   */
	MyWindowListener(FrameEditorTxT ed){
	this.ed=ed;
}
	/**
	 * Implements windowClosing method.
	 * @param e
	 */
	public void windowClosing(WindowEvent e) {
		if (ed.m_Undo.canUndo()) {
			int iReponse = JOptionPane.showConfirmDialog(ed.txtPane, "Attention, le document actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant de quitter le programme ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
			if (iReponse == JOptionPane.YES_OPTION) {
				cl.saveAsFile();
			}
			else if (iReponse == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		else {
			int iReponse = JOptionPane.showConfirmDialog(ed.txtPane, "Attention, le document actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant de quitter le programme ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
			if (iReponse == JOptionPane.YES_OPTION) {
				cl.save();
			}
			else if (iReponse == JOptionPane.CANCEL_OPTION) {
				return;
			}
				}
		ed.dispose();}

}