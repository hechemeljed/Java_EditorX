package EditorX;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.StyleContext;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.undo.UndoManager;
/**
* class FrameEditorTxT - This class builds the GUI application. 
* @author Hechem El Jed & Dorra Jrad
* @version 1.0.1
*/
public class FrameEditorTxT extends JFrame  {

	 /** Fields list */
	 JTextPane txtPane;
	 JLabel labelColor;
	 @SuppressWarnings("rawtypes")
	 JComboBox comboPolice;
	 JButton btnGras;
	 JButton btnItalic;
	 JButton btnUnderlined;
	 JButton btnBarre;
	 JButton btnCut;
	 JButton btnCopy;
	 JButton btnPaste;
	 JButton btnLeft;
	 JButton btnRight;
	 JButton btnCenter;
	 JButton btnUndo;
	 JButton btnRedo;
	 JButton btnNew;
	 JButton btnOpen;
	 JButton btnSaveAs;
	 JButton btnSave;
	 JButton btnPrint;
	 JMenuItem Cut_Menu;
	 JMenuItem Copy_Menu;
	 JMenu Edition_Menu ;
	 JPopupMenu Edition_Popup_Menu;
	 JMenu Insertion_Menu ;
	 JMenuItem Popup_Menu_Cut, Popup_Menu_Copy, Popup_Menu_Paste, Popup_Menu_SelectAll;
	 JComboBox<String> comboSize;
	 JLabel resultArea;
	 JRadioButtonMenuItem couleurFond[];
	 ButtonGroup groupCouleursFond;
	 String[] nomCouleur = {"Blanc", "Noir", "Rouge", "Vert", "Bleu", "Jaune", "Orange", "Gris", "Gris pâle"};
	 Color[] couleur = {Color.white, Color.black, new Color(150, 0, 0), new Color(0, 150, 0), new Color(0, 0, 150), new Color(225, 225, 0), new Color(175, 100, 0), new Color(100, 100, 100), Color.lightGray};
	 JMenu BgColor_Menu;
	 
	/** Button Image Files */
	public static final String BUTTON_IMAGE_FILE_REDO = "redo.png";
	public static final String BUTTON_IMAGE_FILE_UNDO = "undo.png";
	public static final String BUTTON_IMAGE_FILE_PASTE = "paste.png";
	public static final String BUTTON_IMAGE_FILE_COPY = "copier.png";
	public static final String BUTTON_IMAGE_FILE_CUT = "couper.png";
	public static final String BUTTON_IMAGE_FILE_SAVE_AS = "saveas.png";
	public static final String BUTTON_IMAGE_FILE_SAVE = "save.png";
	public static final String BUTTON_IMAGE_FILE_OPEN = "open.png";
	public static final String BUTTON_IMAGE_FILE_NEW = "new.png";
	public static final String BUTTON_IMAGE_FILE_RIGHT_ALIGN = "rightjustify.png";
	public static final String BUTTON_IMAGE_FILE_CENTER_ALIGN = "centerjustify.png";
	public static final String BUTTON_IMAGE_FILE_LEFT_ALIGN = "leftjustify.png";
	public static final String BUTTON_IMAGE_FILE_STRIKETHROUGH = "STRIKTHR.png";
	public static final String BUTTON_IMAGE_FILE_UNDERLINE = "UNDRLN.png";
	public static final String BUTTON_IMAGE_FILE_ITALIC = "ITL.png";
	public static final String BUTTON_IMAGE_FILE_BOLD = "bold.png";
	public static final String BUTTON_IMAGE_FILE_PRINT = "print.png";
	public static final String BUTTON_IMAGE_FILE_FIND = "find.png";
	public static final String BUTTON_IMAGE_FILE_SELECT_ALL = "select-all.png";
	public static final String BUTTON_IMAGE_FILE_TIME = "time.png";
	public static final String BUTTON_IMAGE_FILE_CREDIT = "credit.png";
	public static final String BUTTON_IMAGE_FILE_QUIT = "quit.png";
	public static final String BUTTON_IMAGE_FILE_ABOUT = "about.png";
	public static final String BUTTON_IMAGE_FILE_IMAGE = "image.png";
	
	public static final long serialVersionUID = 1L;
	/** Button Names */
	public  final String BUTTON_NAME_SAVE_AS = "Save As";
	public  final String BUTTON_NAME_SAVE = "Save";
	public  final String BUTTON_NAME_OPEN = "Open";
	public  final String BUTTON_NAME_NEW = "New";
	public  final String BUTTON_NAME_PASTE = "Paste";
	public  final String BUTTON_NAME_CUT = "Cut";
	public  final String BUTTON_NAME_COPY = "Copy";
	public  final String BUTTON_NAME_REDO = "Redo";
	public  final String BUTTON_NAME_UNDO = "Undo";
	public  final String BUTTON_NAME_CENTER_ALIGN = "Centre";
	public  final String BUTTON_NAME_RIGHT_ALIGN = "Droite";
	public  final String BUTTON_NAME_LEFT_ALIGN = "Gauche";
	public  final String BUTTON_NAME_STRIKETHROUGH = "Barre";
	public  final String BUTTON_NAME_UNDERLINE = "Souligne";
	public  final String BUTTON_NAME_ITALIC = "Italique";
	public  final String BUTTON_NAME_BOLD = "Gras";
	public  final String BUTTON_NAME_POLICE = "Polices";
	public  final String BUTTON_NAME_SIZE = "Taille";
	public  final String BUTTON_NAME_PRINT = "Imprimer";
	public  final String BUTTON_NAME_QUIT = "Quit";
	public  final String BUTTON_NAME_BG_COLOR = "Couleur du Font";
	public  final String BUTTON_NAME_FIND= "Rechercher";
	public  final String BUTTON_NAME_DATE= "Date/Heure";
	public  final String BUTTON_NAME_IMG= "Insérer Image";
	public  final String BUTTON_NAME_ABOUT= "A Propos";
	/**
	 * Creates an instance of the CListeners class.
	 * @see CListeners
	 */
	CListeners m_CListeners ;
	 /**
	  * Creates an instance of the UndoManager class.
	  * @see UndoManager
	  */
	UndoManager m_Undo = new UndoManager();
	/**
	 * Creates an instance of the DefaultStyledDocument class.
	 * @see DefaultStyledDocument
	 */
	DefaultStyledDocument m_Document;
	/**
	 * Creates an instance of the RTFEditorKit class.
	 * @see RTFEditorKit
	 */
	RTFEditorKit m_Rtf;
	
	/**
	 * Defines the constructor of FrameEditorTxT class.
	 * @param sTitle
	 */
	public FrameEditorTxT(String sTitle) {
		super();
		m_CListeners = new CListeners(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} 
		catch (Exception e) {
			System.out.println("FrmUsers.FrmUsers : impossible d'appliquer le thème du système");
		}

		JToolBar Display_ToolBar = createDisplayToolBar();
		JToolBar File_ToolBar = createFileToolBar();
		JPanel text_Panel = createTextPanel();

		JMenuBar Principal_Menu = createMenu();
		this.setJMenuBar(Principal_Menu);
		
		this.setLayout(new BorderLayout());
		JPanel panTools = new JPanel();
		JPanel panInfo = new JPanel();
		panTools.setLayout(new BorderLayout());
		panTools.add(Display_ToolBar, BorderLayout.SOUTH);
		panTools.add(File_ToolBar, BorderLayout.NORTH);
		panInfo.setLayout(new BorderLayout());		
		resultArea = new JLabel();
		panInfo.add(resultArea, BorderLayout.WEST);
		this.add(panTools, BorderLayout.NORTH);
		this.add(text_Panel, BorderLayout.CENTER);
		this.add(panInfo, BorderLayout.SOUTH);
        pack();
        setTitle(sTitle);
        setVisible(true);
        setSize(600, 500);
        setLocation(200, 100);
        
        txtPane.addCaretListener(new CaretListener(){
        	@Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                int row = 0, column=0;
                try {
					int length = txtPane.getDocument().getLength();
					String text = txtPane.getDocument().getText(0, length).replaceAll("\r", "");
					if(pos+1<=text.length()){
					    text = text.substring(0, pos+1);
					    column--;
					} 
					while (text.contains("\n")) {
					    row++;
					    int start = text.indexOf("\n");
					    if (text.length() - start >= 1) {
					        text = text.substring(start+1, text.length());
					    }
					}
					column += text.length();
					resultArea.setText(" Ligne : "+row + "     " +"Colonne : "+ column +"        "+ "Position du curseur : " + pos);
				} catch (BadLocationException e1) {
					
					e1.printStackTrace();
				}
}

        	
        });
        
        txtPane.addMouseListener(
                new MouseAdapter() {
                   public void mousePressed(MouseEvent e) {
                      checkTrigger(e);
                   }
                   public void mouseReleased(MouseEvent e) {
                      checkTrigger(e);
                   }
                   private void checkTrigger(MouseEvent e) {
                      if (e.isPopupTrigger()) {
                         updatePopupOptions();
                         Edition_Popup_Menu.show(e.getComponent(), e.getX(), e.getY());
                      }
                   }
                }
             );
        this.addWindowListener(new MyWindowListener(this));
	}
	
	/**
	 *  Implements createFileToolBar method
	 * @return JToolBar
	 */
	public JToolBar createFileToolBar() {
		JToolBar toolFile = new JToolBar();
		
		btnNew = createButton(BUTTON_IMAGE_FILE_NEW, BUTTON_NAME_NEW);
		toolFile.add(btnNew);
		btnOpen = createButton(BUTTON_IMAGE_FILE_OPEN, BUTTON_NAME_OPEN);
		toolFile.add(btnOpen);
		btnSave = createButton(BUTTON_IMAGE_FILE_SAVE, BUTTON_NAME_SAVE);
		toolFile.add(btnSave);
		btnSaveAs = createButton(BUTTON_IMAGE_FILE_SAVE_AS, BUTTON_NAME_SAVE_AS);
		toolFile.add(btnSaveAs);
		btnPrint = createButton(BUTTON_IMAGE_FILE_PRINT, BUTTON_NAME_PRINT);
		toolFile.add(btnPrint);
		toolFile.addSeparator();
		btnCut = createButton(BUTTON_IMAGE_FILE_CUT, BUTTON_NAME_CUT);
		toolFile.add(btnCut);
		btnCopy = createButton(BUTTON_IMAGE_FILE_COPY, BUTTON_NAME_COPY);
		toolFile.add(btnCopy);
		btnPaste = createButton(BUTTON_IMAGE_FILE_PASTE, BUTTON_NAME_PASTE);
		toolFile.add(btnPaste);
		toolFile.addSeparator();
		btnUndo = createButton(BUTTON_IMAGE_FILE_UNDO, BUTTON_NAME_UNDO);
		toolFile.add(btnUndo);
		btnRedo = createButton(BUTTON_IMAGE_FILE_REDO, BUTTON_NAME_REDO);
		toolFile.add(btnRedo);
		toolFile.addSeparator();
		
		return toolFile;
	}
	/**
	 *  Implements createDisplayToolBar method
	 * @return JToolBar
	 */
	@SuppressWarnings("unchecked")
	public JToolBar createDisplayToolBar() {
		
		JToolBar panButtons = new JToolBar();
		
		btnGras = createButton(BUTTON_IMAGE_FILE_BOLD, BUTTON_NAME_BOLD);
	    panButtons.add(btnGras);
		
	    btnItalic = createButton(BUTTON_IMAGE_FILE_ITALIC, BUTTON_NAME_ITALIC);
		panButtons.add(btnItalic);
		
		btnUnderlined = createButton(BUTTON_IMAGE_FILE_UNDERLINE, BUTTON_NAME_UNDERLINE);
		panButtons.add(btnUnderlined);
	    
		btnBarre = createButton(BUTTON_IMAGE_FILE_STRIKETHROUGH, BUTTON_NAME_STRIKETHROUGH);
		panButtons.add(btnBarre);
		
		panButtons.addSeparator();
		
		btnLeft = createButton(BUTTON_IMAGE_FILE_LEFT_ALIGN, BUTTON_NAME_LEFT_ALIGN);
		panButtons.add(btnLeft);
		
		btnCenter = createButton(BUTTON_IMAGE_FILE_CENTER_ALIGN, BUTTON_NAME_CENTER_ALIGN);
		panButtons.add(btnCenter);
		
		btnRight = createButton(BUTTON_IMAGE_FILE_RIGHT_ALIGN, BUTTON_NAME_RIGHT_ALIGN);
		panButtons.add(btnRight);
		
		panButtons.addSeparator();
		// Font Family  
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    String [] sPolices = ge.getAvailableFontFamilyNames();
	    comboPolice = new JComboBox<String>();
	    comboPolice.setName(BUTTON_NAME_POLICE);
	    for ( int i = 0 ; i < sPolices.length ; i++ )
	    	comboPolice.addItem(sPolices[i]);
	    
	    comboPolice.setFocusable(false);
	    comboPolice.setPreferredSize(new Dimension(180, 24));
	    panButtons.add(comboPolice);
	    comboPolice.addItemListener(m_CListeners);
	    
	    panButtons.addSeparator();
		// Font Size
	    comboSize = new JComboBox<String>();
		comboSize.setName(BUTTON_NAME_SIZE);
		for (int i = 0 ; i < 100; i++)
			comboSize.addItem(new Integer((i * 2) + 6).toString());	
		comboSize.setSelectedIndex(3);
		comboSize.setFocusable(false);
		comboSize.setPreferredSize(new Dimension(64, 24));
		panButtons.add(comboSize);
		comboSize.addItemListener(m_CListeners);

		panButtons.addSeparator();
		// Font Color
		JPanel panColor = new JPanel();
		panColor.setPreferredSize(new Dimension(24, 24));
		panColor.setMaximumSize(new Dimension(24, 24));
		panColor.setBorder(BorderFactory.createLoweredBevelBorder());
		panColor.setLayout(new BorderLayout());
		labelColor = new JLabel();
		labelColor.setOpaque(true);
		labelColor.setBackground(Color.BLACK);
		panColor.add(labelColor, BorderLayout.CENTER);
		panButtons.add(panColor);
		labelColor.addMouseListener(m_CListeners);
		
		panButtons.addSeparator();
		
		return panButtons;
	}
	/**
	 * Implements createTextPanel method
	 * @return JPanel
	 */
	public JPanel createTextPanel() {
		JPanel panText = new JPanel();
		m_Rtf  = new RTFEditorKit(); 
		StyleContext context  = new StyleContext();
		m_Document  = new DefaultStyledDocument(context);
		
		panText.setLayout(new BorderLayout());
		txtPane= new JTextPane();
		txtPane.setMargin(new Insets(30, 30, 30, 30));
		txtPane.addCaretListener(m_CListeners);
		txtPane.setPreferredSize(new Dimension(200, 400));
		txtPane.setEditorKit(m_Rtf);
		txtPane.setDocument(m_Document);
		
		Font oFont = new Font(txtPane.getFont().getFamily(), txtPane.getFont().getStyle(), 12);
		txtPane.setFont(oFont);
		txtPane.getDocument().addUndoableEditListener(m_CListeners);
		panText.add(txtPane);
		JScrollPane sclScroll = new JScrollPane(txtPane);
		panText.add(sclScroll);
		return panText;
	}
	/**
	 * Implements createMenu method 
	 * @return JMenuBar
	 */
	public JMenuBar createMenu() {
		JMenuBar Principal_Menu = new JMenuBar();
		// Fichier Menu //
		JMenu Fichier_Menu = new JMenu("Fichier");
		Principal_Menu.add(Fichier_Menu);
		// New MenuItem //
		JMenuItem New_Menu = new JMenuItem("Nouveau",new ImageIcon(BUTTON_IMAGE_FILE_NEW));
		New_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		New_Menu.setName(BUTTON_NAME_NEW);
		New_Menu.addActionListener(m_CListeners);
		// Open MenuItem //
		JMenuItem Open_Menu = new JMenuItem("Ouvrir",new ImageIcon(BUTTON_IMAGE_FILE_OPEN));
		Open_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		Open_Menu.setName(BUTTON_NAME_OPEN);
		Open_Menu.addActionListener(m_CListeners);
		// Save MenuItem //
		JMenuItem Save_Menu = new JMenuItem("Enregistrer",new ImageIcon(BUTTON_IMAGE_FILE_SAVE));
		Save_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		Save_Menu.setName(BUTTON_NAME_SAVE);
		Save_Menu.addActionListener(m_CListeners);
		// SaveAs MenuItem //
		JMenuItem SaveAs_Menu = new JMenuItem("Enregistrer Sous",new ImageIcon(BUTTON_IMAGE_FILE_SAVE_AS));
		SaveAs_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
		SaveAs_Menu.setName(BUTTON_NAME_SAVE_AS);
		SaveAs_Menu.addActionListener(m_CListeners);
		// Print MenuItem //
		JMenuItem Print_Menu = new JMenuItem("Imprimer",new ImageIcon(BUTTON_IMAGE_FILE_PRINT));
		Print_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		Print_Menu.setName(BUTTON_NAME_PRINT);
		Print_Menu.addActionListener(m_CListeners);
		// Quit MenuItem //
		JMenuItem Quit_Menu = new JMenuItem("Quitter",new ImageIcon(BUTTON_IMAGE_FILE_QUIT));
		Quit_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		Quit_Menu.setName(BUTTON_NAME_QUIT);
		Quit_Menu.addActionListener(m_CListeners);
        // BgColor Menu //
		BgColor_Menu = new JMenu("Couleur du fond");
		BgColor_Menu.setMnemonic('f');
		groupCouleursFond = new ButtonGroup();
		couleurFond = new JRadioButtonMenuItem[nomCouleur.length];
			     for (int i = 0; i < nomCouleur.length; i++) {
			        couleurFond[i] = new JRadioButtonMenuItem(nomCouleur[i]);
			        if (couleur[i] == txtPane.getBackground())
			           couleurFond[i].setSelected(true);
			        couleurFond[i].addActionListener(new ActionListener(){@Override
			            public void actionPerformed(ActionEvent e){ for (int i = 0; i < nomCouleur.length; i++) {
			                if (couleurFond[i] == e.getSource())
			                	txtPane.setBackground(couleur[i]);
			              }}});
        groupCouleursFond.add(couleurFond[i]);
        BgColor_Menu.add(couleurFond[i]);}
	      
     	Fichier_Menu.add(New_Menu);
     	Fichier_Menu.add(Open_Menu);
		Fichier_Menu.add(Save_Menu);
		Fichier_Menu.add(SaveAs_Menu);
		Fichier_Menu.addSeparator();
		Fichier_Menu.add(Print_Menu);
		Fichier_Menu.addSeparator();
		Fichier_Menu.add(BgColor_Menu);
		Fichier_Menu.addSeparator();
		Fichier_Menu.add(Quit_Menu);
		// Edition Menu //
		Edition_Menu = new JMenu("Edition");
		Principal_Menu.add(Edition_Menu);
		Edition_Menu.addMouseListener(
	    	         new MouseAdapter() {
	    	            public void mousePressed(MouseEvent e) {
	    	               updateMenuOptions();
	    	            }
	    	         }
	    	      );
		// Undo MenuItem //
		JMenuItem Undo_Menu = new JMenuItem("Annuler",new ImageIcon(BUTTON_IMAGE_FILE_UNDO));
		Undo_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		Undo_Menu.setName(BUTTON_NAME_UNDO);
		Undo_Menu.addActionListener(m_CListeners);
		// Redo MenuItem //
		JMenuItem Redo_Menu = new JMenuItem("Rétablir",new ImageIcon(BUTTON_IMAGE_FILE_REDO));
		Redo_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK));
		Redo_Menu.setName(BUTTON_NAME_REDO);
		Redo_Menu.addActionListener(m_CListeners);
		// Cut MenuItem //
		Cut_Menu = new JMenuItem("Couper",new ImageIcon(BUTTON_IMAGE_FILE_CUT));
		Cut_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		Cut_Menu.setName(BUTTON_NAME_CUT);
		Cut_Menu.addActionListener(m_CListeners);
		// Copy MenuItem //
		Copy_Menu = new JMenuItem("Copier",new ImageIcon(BUTTON_IMAGE_FILE_COPY));
		Copy_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		Copy_Menu.setName(BUTTON_NAME_COPY);
		Copy_Menu.addActionListener(m_CListeners);
		// Paste MenuItem
		JMenuItem Paste_Menu = new JMenuItem("Coller",new ImageIcon(BUTTON_IMAGE_FILE_PASTE));
		Paste_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
		Paste_Menu.setName(BUTTON_NAME_PASTE);
		Paste_Menu.addActionListener(m_CListeners);
		// Find MenuItem //
		JMenuItem Find_Menu = new JMenuItem("Rechercher",new ImageIcon(BUTTON_IMAGE_FILE_FIND));
		Find_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		Find_Menu.setName(BUTTON_NAME_FIND);
		Find_Menu.addActionListener(m_CListeners);
		// SelectAll MenuItem //
		JMenuItem SelectAll_Menu = new JMenuItem("Selectionner Tout",new ImageIcon(BUTTON_IMAGE_FILE_SELECT_ALL));
		SelectAll_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		SelectAll_Menu.addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e){txtPane.selectAll();}});
		
		Edition_Menu.add(Undo_Menu);
		Edition_Menu.add(Redo_Menu);
		Edition_Menu.addSeparator();
		Edition_Menu.add(Cut_Menu);
		Edition_Menu.add(Copy_Menu);
		Edition_Menu.add(Paste_Menu);
		Edition_Menu.addSeparator();
		Edition_Menu.add(Find_Menu);
		Edition_Menu.add(SelectAll_Menu);
		Edition_Menu.addSeparator();
		
		// Menu Insertion //
		Insertion_Menu= new JMenu("Insertion");
		Principal_Menu.add(Insertion_Menu);
		// DateTime MenuItem //
		JMenuItem DateTime_Menu = new JMenuItem("Date/Heure",new ImageIcon(BUTTON_IMAGE_FILE_TIME));
		DateTime_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		DateTime_Menu.setName(BUTTON_NAME_DATE);
		DateTime_Menu.addActionListener(m_CListeners);
		// InsertImage MenuItem
		JMenuItem InsertImage_Menu = new JMenuItem("Insérer Image",new ImageIcon(BUTTON_IMAGE_FILE_IMAGE));
		InsertImage_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		InsertImage_Menu.setName(BUTTON_NAME_IMG);
		InsertImage_Menu.addActionListener(m_CListeners);
		
		Insertion_Menu.add(DateTime_Menu);
		Insertion_Menu.add(InsertImage_Menu);
		// Propos Menu //
		JMenu mnuPropos = new JMenu("A Propos");
		Principal_Menu.add(mnuPropos);
		// Credits MenuItem //
		JMenuItem Credits_Menu = new JMenuItem("Credits",new ImageIcon(BUTTON_IMAGE_FILE_CREDIT));
		mnuPropos.add(Credits_Menu);
		Credits_Menu.addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e){JOptionPane.showMessageDialog(null,"Ce Projet EditorX est développé par :\n Hechem El Jed & Dorra Jrad \n\n Atelier JAVA - GL 2/3 2011-2012\n © Tous les droits sont réservés 2012. ","Credits",JOptionPane.INFORMATION_MESSAGE);}});
		// About MenuItem //
		JMenuItem About_Menu = new JMenuItem("A Propos",new ImageIcon(BUTTON_IMAGE_FILE_ABOUT));
		mnuPropos.add(About_Menu);
		About_Menu.setName(BUTTON_NAME_ABOUT);
		About_Menu.addActionListener(m_CListeners);

		// Edition Popup_Menu //
		Edition_Popup_Menu = new JPopupMenu();
		
		Popup_Menu_Cut = new JMenuItem("Couper");
		Popup_Menu_Cut.setMnemonic('C');
		Popup_Menu_Cut.setName(BUTTON_NAME_CUT);
		Popup_Menu_Cut.addActionListener(m_CListeners);
	    Edition_Popup_Menu.add(Popup_Menu_Cut);
	      
	    Popup_Menu_Copy = new JMenuItem("Copier");
	    Popup_Menu_Copy.setMnemonic('p');
	    Popup_Menu_Copy.setName(BUTTON_NAME_COPY);
	    Popup_Menu_Copy.addActionListener(m_CListeners);
	    Edition_Popup_Menu.add(Popup_Menu_Copy);
	    
	    Popup_Menu_Paste = new JMenuItem("Coller");
	    Popup_Menu_Paste.setMnemonic('o');
	    Popup_Menu_Paste.setName(BUTTON_NAME_PASTE);
	    Popup_Menu_Paste.addActionListener(m_CListeners);
	    Edition_Popup_Menu.add(Popup_Menu_Paste);
	    Edition_Popup_Menu.addSeparator();
	    
	    Popup_Menu_SelectAll = new JMenuItem("Selectionner tout");
	    Popup_Menu_SelectAll.setMnemonic('t');
	    Popup_Menu_SelectAll.addActionListener(new ActionListener(){@Override
	            public void actionPerformed(ActionEvent e){txtPane.selectAll();}});
	    Edition_Popup_Menu.add(Popup_Menu_SelectAll);
	    
		return Principal_Menu;
	}
	/**
	 * Implements createButton method  
	 * @return JButton
	 * @param sFileName,sName
	 */
	public JButton createButton(String sFileName, String sName) {
		JButton mButton = new JButton(new ImageIcon(sFileName));
		mButton.setMaximumSize(new Dimension(24, 24));
		mButton.setMargin(new Insets(15, 15, 15, 15));
		mButton.setName(sName);
		mButton.setFocusable(false);
		mButton.setPreferredSize(new Dimension(24, 24));
		mButton.setMinimumSize(new Dimension(24, 24));
		mButton.addActionListener(m_CListeners);
		return mButton;
	}
	/**
	 * Implements append method  
	 * @param s
	 */
	public void append(String s) {
		try {
			Document doc = txtPane.getDocument();
			doc.insertString(doc.getLength(), s + "\n", txtPane.getStyle("default"));
 
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Implements updateMenuOptions method
	 */
	public void updateMenuOptions() {
        if (txtPane.getSelectedText() == null) {
        	Cut_Menu.setEnabled(false);
        	Copy_Menu.setEnabled(false);
         
        }
        else {
        	Cut_Menu.setEnabled(true);
        	Copy_Menu.setEnabled(true);
       
        }
     }
	/**
	 * Implements updatePopupOptions method
	 */
	public void updatePopupOptions() {
	      if (txtPane.getSelectedText() == null) {
	    	  Popup_Menu_Cut.setEnabled(false);
	    	  Popup_Menu_Copy.setEnabled(false);
	      }
	      else {
	    	  Popup_Menu_Cut.setEnabled(true);
	    	  Popup_Menu_Copy.setEnabled(true);
	      }
	   }

	
}
