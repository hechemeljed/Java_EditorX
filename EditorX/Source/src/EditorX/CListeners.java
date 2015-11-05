package EditorX;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotUndoException;
/**
* class CListeners - This class manages events on buttons and menus. 
* Fields: 
*   ed - FrameEditorTxTd.
*   pc - PrintClass.
*   jfc - JFileChooser
*   groupCouleursFond - ButtonGroup
*   nomCouleur - String[]
*   couleur - Color[]
*   couleurFond[] - JRadioButtonMenuItem
*   word - String
*   length - int
*   option - int 
*   content - String
*   str - String
*   name - String
* Methods:
*   CListeners()
*   mouseClicked() 
*   itemStateChanged()
*   actionPerformed() 
*   undoableEditHappened()
*	caretUpdate()
*	refreshToolBar()
*	saveAsFile()
*	saveFile()
*	selectCombo()
*	isTextSelected()
*	setJTextPaneFont()
*	printFile()
*	findFile()
*	dateTime()
*	newFile()
*	openFile()
*	open()
*	quitFile()
*	saveAs()
*	save()
*/
	class CListeners extends MouseAdapter implements ItemListener, ActionListener, UndoableEditListener, CaretListener {
		 /** Creates an instance of the FrameEditorTxT class. */ 	
		FrameEditorTxT ed;
		/** Creates an instance of the PrintClass class. */
		PrintClass pc;
		/** Creates an instance of the JFileChooser class. */
		JFileChooser jfc; 
		
		ButtonGroup groupCouleursFond;
	    String[] nomCouleur = {"Blanc", "Noir", "Rouge", "Vert", "Bleu", "Jaune", "Orange", "Gris", "Gris pâle"};
	    Color[] couleur = {Color.white, Color.black, new Color(150, 0, 0), new Color(0, 150, 0), new Color(0, 0, 150), new Color(225, 225, 0), new Color(175, 100, 0), new Color(100, 100, 100), Color.lightGray};
	    JRadioButtonMenuItem couleurFond[];
	    String word;
	    int length;
	    int value;
	    int option; 
	    String content = null;
	    String str;
	    String name = null;
	    /**
	     * Defines the constructor of CListeners class.
	     * @param ed
	     */
	    public CListeners(FrameEditorTxT ed)
		{
			this.ed=ed;

		}
		
		/**
		 * Implements mouseClicked method
		 *  @param arg0
		 */
		public void mouseClicked(MouseEvent arg0) {		
			boolean bSelected = isTextSelected();
			Color oColor = JColorChooser.showDialog(ed.txtPane, "Sélectionnez une couleur de texte", ed.labelColor.getBackground());
			if (oColor != null) {
				ed.labelColor.setBackground(oColor);
			}
			setJTextPaneFont(ed.txtPane, bSelected, null, null, null, null, null, null, ed.labelColor.getBackground(), null);
		}
		/**
		 *  Implements itemStateChanged method
		 *  @param arg0
		 */
		public void itemStateChanged(ItemEvent arg0) {
			if (arg0.getStateChange() > 0) {
				boolean bSelected = isTextSelected();
				@SuppressWarnings("rawtypes")
				JComboBox cmbCombo = (JComboBox) arg0.getSource();
				if (cmbCombo.getName().compareTo("Polices") == 0) {
					setJTextPaneFont(ed.txtPane, bSelected, (String) cmbCombo.getSelectedItem(), null, null, null, null, null, null, null);
				}
				else if (cmbCombo.getName().compareTo("Taille") == 0) {
					setJTextPaneFont(ed.txtPane, bSelected, null, null, null, null, null, Integer.parseInt((String) cmbCombo.getSelectedItem()), null, null);
				}
			}
		}
		/**
		 *  Implements actionPerformed method
		 *  @param arg0
		 */
		public void actionPerformed(ActionEvent arg0) {
			Component oComponent = (Component) arg0.getSource();
			boolean bSelected = false;
			JButton oButton = null;
			String sName = oComponent.getName(); 
			if (oComponent instanceof JButton) {
				oButton = ((JButton) oComponent);
			}
			if (sName.compareTo(ed.BUTTON_NAME_BOLD) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, bSelected, null, null, null, null, null, null);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_ITALIC) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane,isTextSelected(), null, null, bSelected, null, null, null, null, null);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_UNDERLINE) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, null, null, bSelected, null, null, null, null);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_STRIKETHROUGH) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, null, null, null, bSelected, null, null, null);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_LEFT_ALIGN) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, null, null, null, null, null, null, StyleConstants.ALIGN_LEFT);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_RIGHT_ALIGN) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, null, null, null, null, null, null, StyleConstants.ALIGN_RIGHT);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_CENTER_ALIGN) == 0) {
				bSelected = !oButton.isSelected();
				oButton.setSelected(bSelected);
				setJTextPaneFont(ed.txtPane, isTextSelected(), null, null, null, null, null, null, null, StyleConstants.ALIGN_CENTER);
				refreshToolBar();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_UNDO) == 0) {
				try {
					if (ed.m_Undo.canUndo()) {
						ed.m_Undo.undo();
						ed.btnRedo.setEnabled(true);
					}
					if (!ed.m_Undo.canUndo()) {
						ed.btnUndo.setEnabled(false);
					}
				}
				catch (CannotUndoException e) {
					System.out.println("Impossible d'annuler : " + e.getMessage());
			        e.printStackTrace();
				}
			}
			else if (sName.compareTo(ed.BUTTON_NAME_REDO) == 0) {
				try {
					if (ed.m_Undo.canRedo()) {
						ed.m_Undo.redo();
						ed.btnRedo.setEnabled(true);
					}
					if (!ed.m_Undo.canRedo()) {
						ed.btnRedo.setEnabled(false);
					}
				}
				catch (CannotUndoException e) {
					System.out.println("Impossible de rétablir : " + e.getMessage());
			        e.printStackTrace();
				}
			}
			else if (sName.compareTo(ed.BUTTON_NAME_COPY) == 0 || sName.compareTo(ed.BUTTON_NAME_CUT) == 0) {
				try {
					StringSelection ss = new StringSelection(ed.txtPane.getSelectedText());
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				} catch( IllegalStateException e) {
					System.out.println("Le presse papier n'est pas disponible");
				}
				if (sName.compareTo(ed.BUTTON_NAME_CUT) == 0) {
					ed.txtPane.replaceSelection("");
				}
			}
			else if (sName.compareTo(ed.BUTTON_NAME_PASTE) == 0) {
				Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
				try {
					String sText = "";
					if( t!=null && t.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
						sText = (String)t.getTransferData(DataFlavor.stringFlavor);
					} 
					if (sText != "") {
						ed.txtPane.replaceSelection(sText);
					}
				} catch( UnsupportedFlavorException e1) {
					System.out.println("Format du presse papier inconnu");
				} catch( IOException e2 ) {
					System.out.println("Erreur d'Entrée/Sortie : " + e2.getMessage());
				}
			}
			else if (sName.compareTo(ed.BUTTON_NAME_FIND) == 0)
			{
				findFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_NEW) == 0) {
				newFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_SAVE_AS) == 0) {
				saveAsFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_SAVE) == 0) {
				saveFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_OPEN) == 0) {
				openFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_QUIT) == 0) {
				quitFile();
			}
			else if (sName.compareTo(ed.BUTTON_NAME_PRINT) == 0)
			{printFile();}
			else if (sName.compareTo(ed.BUTTON_NAME_DATE) == 0)
			{dateTime();}
			else if (sName.compareTo(ed.BUTTON_NAME_IMG) == 0)
			{
				 jfc = new JFileChooser();
			        FileNameExtensionFilter picture = new FileNameExtensionFilter("JPEG files (*.png)", "png");
			        jfc.setFileFilter(picture);
			        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			        if (jfc.showDialog(ed, "Insérer")!=JFileChooser.APPROVE_OPTION)  return;
			        name = jfc.getSelectedFile().getAbsolutePath();

			        // If no text is entered for the file name, refresh the dialog box
			        if (name==null) return;

			        try 
			        {
			            BufferedImage img = ImageIO.read(new File(name));
			            ImageIcon pictureImage = new ImageIcon(img);
			            ed.txtPane.insertIcon(pictureImage);
			        } 

			        catch (IOException e) 
			        {
			            JOptionPane.showMessageDialog(null, "Impossible de trouver le fichier: " + name);
			        }

			}
			else if (sName.compareTo(ed.BUTTON_NAME_ABOUT) == 0)
			{    JFrame frame = new JFrame("A Propos");
		    JPanel panel = new ShowImage();
		    frame.getContentPane().add(panel);
		    frame.setSize(500, 400);
		    frame.setVisible(true);
		    frame.setResizable(false);
		    frame.setLocation(200, 100);}
		}
		
		/**
		 *  Implements undoableEditHappened method
		 *  @param arg0
		 */
		public void undoableEditHappened(UndoableEditEvent arg0) {
			ed.m_Undo.addEdit(arg0.getEdit());
			ed.btnUndo.setEnabled(true);
			ed.btnRedo.setEnabled(false);
		}
		/**
		 *  Implements caretUpdate method
		 *  @param arg0
		 */
		public void caretUpdate(CaretEvent arg0) {
			refreshToolBar();
		}
		/**
		 * Implements refreshToolBar method
		 */
		@SuppressWarnings("unchecked")
		public void refreshToolBar() {
			AttributeSet oAttribute = ed.txtPane.getCharacterAttributes();
			if (StyleConstants.isBold(oAttribute)) {
				ed.btnGras.setSelected(true);
			}
			else {
				ed.btnGras.setSelected(false);
			}
			if (StyleConstants.isItalic(oAttribute)) {
				ed.btnItalic.setSelected(true);
			}
			else {
				ed.btnItalic.setSelected(false);
			}
			if (StyleConstants.isStrikeThrough(oAttribute)) {
				ed.btnBarre.setSelected(true);
			}
			else {
				ed.btnBarre.setSelected(false);
			}
			if (StyleConstants.isUnderline(oAttribute)) {
				ed.btnUnderlined.setSelected(true);
			}
			else {
				ed.btnUnderlined.setSelected(false);
			}
			ed.labelColor.setBackground(StyleConstants.getForeground(oAttribute));
			selectCombo(ed.comboPolice, (String) StyleConstants.getFontFamily(oAttribute));
			selectCombo(ed.comboSize, new Integer(StyleConstants.getFontSize(oAttribute)).toString());
		
			oAttribute = ed.txtPane.getParagraphAttributes();
			if (StyleConstants.getAlignment(oAttribute) == StyleConstants.ALIGN_LEFT) {
				ed.btnLeft.setSelected(true);
			}
			else {
				ed.btnLeft.setSelected(false);
			}
			if (StyleConstants.getAlignment(oAttribute) == StyleConstants.ALIGN_RIGHT) {
				ed.btnRight.setSelected(true);
			}
			else {
				ed.btnRight.setSelected(false);
			}
			if (StyleConstants.getAlignment(oAttribute) == StyleConstants.ALIGN_CENTER) {
				ed.btnCenter.setSelected(true);
			}
			else {
				ed.btnCenter.setSelected(false);
			}
		}
				/**
		 *  Implements saveAsFile method
		 *  @see saveAs
		 *  @see save
		 */
		public void saveAsFile() {
		      /* Calls the saveAs() method. */
		       saveAs(""); 
		}
		/**
		 *  Implements saveFile method
		 *  @see save
		 *  @see saveAs
		 */
		public void saveFile()
		{	
			if(name == null)
		       {
		         /* Calls the saveAs() method. */
		          saveAs(""); 
		       }
		       else
		       {
		         /* Calls the save() method. */
		          save();
		       }
		}
		public void selectCombo(JComboBox<String> oCombo, String elem) {
			for (int i = 0; i < oCombo.getItemCount(); i++) {
				if (oCombo.getItemAt(i).compareTo(elem) == 0) {
					oCombo.setSelectedIndex(i);
					return;
				}
			}
		}
		/**
		 *  Implements isTextSelected method
		 * @return boolean
		 */
		public boolean isTextSelected() {
			return (ed.txtPane.getSelectedText() == null);
		}
		/**
		 *  Implements setJTextPaneFont method
		 * @param jtp
		 * @param bAllText
		 * @param sFontName
		 * @param bBold
		 * @param bItalic
		 * @param bUnderline
		 * @param bStrikeThrough
		 * @param iSize
		 * @param oColor
		 * @param iAlignment
		 */
		public static void setJTextPaneFont(JTextPane jtp, boolean bAllText, String sFontName, Boolean bBold, Boolean bItalic, Boolean bUnderline, Boolean bStrikeThrough, Integer iSize, Color oColor, Integer iAlignment) {
			
	        MutableAttributeSet attrs = jtp.getInputAttributes();

	        if (sFontName != null) {
	        	StyleConstants.setFontFamily(attrs, sFontName);
	        }
	        if (bBold != null) {
	        	StyleConstants.setBold(attrs, bBold);
	        }
	        if (bItalic != null) {
	        	StyleConstants.setItalic(attrs, bItalic);
	        }
	        if (iSize != null) {
	        	StyleConstants.setFontSize(attrs, iSize);
	        }
	        if (oColor != null) {
	        	StyleConstants.setForeground(attrs, oColor);
	        }
	        if (bUnderline != null) {
	        	StyleConstants.setUnderline(attrs, bUnderline);
	        }
	        if (bStrikeThrough != null) {
	        	StyleConstants.setStrikeThrough(attrs, bStrikeThrough);
	        }
	        
	        StyledDocument doc = jtp.getStyledDocument();

	        if (!bAllText) {
	        	// on modifie uniquement le texte sélectionné
	        	int iStart = jtp.getSelectionStart();
	        	doc.setCharacterAttributes(iStart, jtp.getSelectionEnd() - iStart, attrs, false);
	        }
	        else {
	        	// on modifie le style du jtext lui même
	        	jtp.setCharacterAttributes(attrs, false);
	        }
	        
	        if (iAlignment != null) {
	        	StyleConstants.setAlignment(attrs, iAlignment);
	        	doc.setParagraphAttributes(jtp.getSelectionStart(), jtp.getSelectionEnd() - jtp.getSelectionStart(), attrs, false);
	        }
	    }
		/**
		 * Implements printFile method
		 * @see PrintClass
		 */
	    public void printFile()
	    {
	         /* 
	         Creates an instance of the PrintClass that inputs the ed.area component and ed 
	         object of the Editor class as parameters. 
	         */
	          pc = new PrintClass(ed.txtPane, ed);
	         /* Calls the print() method. */
	          pc.print();
	    }
	    /**
	     * Implements findFile method
	     */
	    public void findFile()
	      { length = ed.txtPane.getDocument().getLength();
	          try
	       {
	        /* Shows a word input dialog box. */
	      word = JOptionPane.showInputDialog("Tapez le mot à trouver");
	         while(ed.txtPane.getDocument().getText(0, length).indexOf(word) == -1)
	         {
	         /* Shows a message dialog box. */
	       JOptionPane.showMessageDialog(null,"Mot introuvable!","Résultat",JOptionPane.WARNING_MESSAGE);
	      word = JOptionPane.showInputDialog(" Type the word to find");
	 }
	       /* Selects the word in the text area. */ 
	         ed.txtPane.select(ed.txtPane.getDocument().getText(0, length).indexOf(word),
	        		ed.txtPane.getDocument().getText(0, length).indexOf(word) + word.length());
	 }
	  catch(Exception ex)
	 {
	         /* Shows an error message dialog box. */
	     JOptionPane.showMessageDialog
	    (null,"Rechercher annulée","Annulation",JOptionPane.WARNING_MESSAGE);
	   }
	  }
	    /**
	     * Implements dateTime method
	     */
		@SuppressWarnings("deprecation")
		public void dateTime()
	    {
	      /* Creates an object of the Date class. */
	       Date d = new Date();
	        str = d.toLocaleString(); 
	      /* Appends the date and time in the text area. */
	       ed.append(str);
	    }
				/**
		 * Implements newFile method
		 */
		public void newFile()
		{
			  if(ed.m_Undo.canUndo())
		      {
		         if(ed.m_Undo.canUndo())
		         {
		            /* Shows a Confirm dialog box. */
		            option = JOptionPane.showConfirmDialog(null,"Vous voulez  enregistrer le fichier ?");
		            if(option == 0)
		            {
		               /* Calls the saveAs() method. */
		                saveAs("");
		               /* Sets the text area to be NULL. */ 
		                ed.txtPane.setText("");
		             }
		             
		             if(option == 1)
		             {
		                ed.txtPane.setText("");
		             }
		          }
		          else
		          {
		            /* Shows a Confirm dialog box. */
		            option = JOptionPane.showConfirmDialog(null,"Vous voulez  enregistrer le fichier ?");
		            if(option == 0)
		            {
		               /* Calls the save() method. */
		               save();
		               ed.txtPane.setText("");
		             }
		             if(option == 1)
		             {
		                ed.txtPane.setText("");
		             }
		          }
		       }
		       else
		       {
		          ed.txtPane.setText("");
		       }
		      /* Sets the title of the main window. */
		       ed.setTitle("Nouveau Fichier - Text Editor");
		}
		/**
		 * Implements openFile method
		 * @see open
		 */
	    public void openFile()
	      {
			if (ed.m_Undo.canUndo()) {
				int iReponse = JOptionPane.showConfirmDialog(ed.txtPane, "Attention, le document actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant d'ouvrir un autre document ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
				if (iReponse == JOptionPane.YES_OPTION) {
					saveAsFile();
				}
				else if (iReponse == JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
			open("");
	    }
	    /**
		 *  Implements Open method
		 * @param sFileName
		 * @see openFile
		 */
		public void open(String sFileName ) {
			try
			{
				if (sFileName.compareTo("") == 0) {
					jfc = new JFileChooser();
					jfc.setFileFilter(new RTFFileFilter());
					jfc.showOpenDialog(ed.txtPane);
					File oFichier = jfc.getSelectedFile();
					if (oFichier != null) {
						sFileName = oFichier.getAbsolutePath();
						if (!sFileName.endsWith(".rtf")) {
							sFileName = sFileName + ".rtf";
						}
					}
				}
				FileInputStream input = new FileInputStream(sFileName);
				ed.txtPane.setText("");
				ed.m_Rtf.read(input, ed.m_Document, 0);
	   	        input.close();
	   	     ed.m_Undo.die();
	            content = ed.txtPane.getText();
	            name = jfc.getSelectedFile().getPath();
			    /* Sets the title of the window */
		        ed.setTitle(jfc.getSelectedFile().getAbsolutePath() + " - Text Editor");
		        str = jfc.getSelectedFile().getAbsolutePath();
			}
			catch (Exception ex) {System.out.println("Impossible de charger le document : " + ex.toString());}

	     
		}
		/**
		 * Implements quitFile method
		 */
	    public void quitFile()
	    {	if (ed.m_Undo.canUndo()) {
			int iReponse = JOptionPane.showConfirmDialog(ed.txtPane, "Attention, le document actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant de quitter le programme ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
			if (iReponse == JOptionPane.YES_OPTION) {
				saveAsFile();
			}
			else if (iReponse == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		else {
			int iReponse = JOptionPane.showConfirmDialog(ed.txtPane, "Attention, le document actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant de quitter le programme ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
			if (iReponse == JOptionPane.YES_OPTION) {
				save();
			}
			else if (iReponse == JOptionPane.CANCEL_OPTION) {
				return;
			}
				}
		ed.dispose();}
	    /**
	     * Implements saveAs method
	     * @param sFileName
	     */
	    public void saveAs(String sFileName ){
	    	try
			{
				if (sFileName.compareTo("") == 0) {
					 jfc = new JFileChooser(".");
					 jfc.setFileFilter(new RTFFileFilter());
					 jfc.showSaveDialog(ed.txtPane);
					File oFichier = jfc.getSelectedFile();
					if (oFichier.exists()) {
						if (JOptionPane.showConfirmDialog(ed.txtPane, "Le fichier existe déjà, voulez-vous l'écraser ?", "Confirmation de l'écrasement", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
							return;
						}
					}
					if (oFichier != null) {
						sFileName = oFichier.getAbsolutePath();
						if (!sFileName.endsWith(".rtf")) {
							sFileName = sFileName + ".rtf";
						}
					}
				}
				FileOutputStream output = new FileOutputStream(sFileName);
				ed.m_Rtf.write(output, ed.m_Document, 0, ed.m_Document.getLength());
	   	        output.flush();
	   	        output.close();
	            content = ed.txtPane.getText();
	            name = jfc.getSelectedFile().getPath();
			    /* Sets the title of the window */
		        ed.setTitle(jfc.getSelectedFile().getAbsolutePath() + " - Text Editor");
		        str = jfc.getSelectedFile().getAbsolutePath();
			}
			catch (Exception ex) {System.out.println("Impossible de sauvegarder le docuement : " + ex.toString());}	    	

	      
	    }
	    /**
		 * Implements save method
		 */
		public void save()
		{
			try
			{
				
				File oFichier = jfc.getSelectedFile();
				FileOutputStream output = new FileOutputStream(oFichier);
				ed.m_Rtf.write(output, ed.m_Document, 0, ed.m_Document.getLength());
	   	        output.flush();
	   	        output.close();
	            content = ed.txtPane.getText();
	            name = jfc.getSelectedFile().getPath();
			    /* Sets the title of the window */
		        ed.setTitle(jfc.getSelectedFile().getAbsolutePath() + " - Text Editor");
		        str = jfc.getSelectedFile().getAbsolutePath();
			}
			catch (Exception ex) {System.out.println("Impossible de sauvegarder le docuement : " + ex.toString());}	    	


		      
		   }

	    
	}
