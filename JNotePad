import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JNotePad extends JFrame
{
    private static final long serialVersionUID = 7280312501392491984L;
  JMenuBar mbar;
	JMenu file,edit,format,view,help;
	JMenuItem open,Goto;
	JCheckBoxMenuItem stsbar;
	TextArea txt;
	JPanel Sbar;
	static int saved = 1;
	
	JNotePad(String title)
	{
		super(title);
		setVisible(true);
		setLayout(new BorderLayout());
		setSize(600, 700);
		setLocation(350, 90);
		buildGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void buildGUI()
	{
		mbar = new JMenuBar();
		setJMenuBar(mbar);

		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem New/*,open*/,save,saveas,pgstup,print,Exit;
		file.add( New		= new JMenuItem("New       Ctrl+N", 'N') );
		file.add( open		= new JMenuItem("Open      Ctrl+O", 'O') );
		file.add( save		= new JMenuItem("Save      Ctrl+S", 'S') );
		file.add( saveas	= new JMenuItem("Save As         ", 'A') );
		file.addSeparator();
		file.add( pgstup	= new JMenuItem("Page Setup      ", 'U') );
		file.add( print		= new JMenuItem("Print                   Ctrl+P" , 'P') );
		file.addSeparator();
		file.add( Exit		= new JMenuItem("Exit             " , 'X') );
		
		FileMenuListener fl = new FileMenuListener(this);
		New.addActionListener(fl);
		open.addActionListener(fl);
		save.addActionListener(fl);
		saveas.addActionListener(fl);
		pgstup.addActionListener(fl);
		print.addActionListener(fl);
		Exit.addActionListener(fl);
		mbar.add(file);

		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem undo,cut,copy,paste,delete,find,replace/*,Goto*/,selectall,tmdt;
		edit.add( undo		= new JMenuItem("Undo                 Ctrl+Z", 'U') );
		edit.addSeparator();
		edit.add( cut		= new JMenuItem("Cut                  Ctrl+X", 'T') );
		edit.add( copy		= new JMenuItem("Copy                 Ctrl+C", 'C') );
		edit.add( paste		= new JMenuItem("Paste                Ctrl+V", 'V') );
		edit.add( delete	= new JMenuItem("Delete               Del", 'L') );
		edit.addSeparator();
		edit.add( find		= new JMenuItem("Find                 Ctrl+F" , 'F') );
		edit.add( replace	= new JMenuItem("Replace              Ctrl+H" , 'R') );
		edit.add( Goto		= new JMenuItem("Go To                Ctrl+G" , 'G') );
		edit.addSeparator();
		edit.add( selectall	= new JMenuItem("Select All           Ctrl+A" , 'A') );
		edit.add(tmdt		= new JMenuItem("Time/Date                 F5" , 'D') );
		
		EditMenuListener el = new EditMenuListener(this);
		undo.addActionListener(el);
		cut.addActionListener(el);
		copy.addActionListener(el);
		paste.addActionListener(el);
		delete.addActionListener(el);
		find.addActionListener(el);
		replace.addActionListener(el);
		Goto.addActionListener(el);
		selectall.addActionListener(el);
		tmdt.addActionListener(el);
		mbar.add(edit);
		
		FrmtViwMenuListener fvl = new FrmtViwMenuListener(this);
		
		format = new JMenu("Format");
		format.setMnemonic(KeyEvent.VK_O);
		JCheckBoxMenuItem wrdwrp;
		JMenuItem font;
		format.add(	wrdwrp	= new JCheckBoxMenuItem("Word Wrap         ") );
		wrdwrp.setMnemonic(KeyEvent.VK_W);
		format.add( font	= new JMenuItem("Font                      " , 'F') );
		
		wrdwrp.addItemListener(fvl);
		font.addActionListener(fvl);
		mbar.add(format);
		
		view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		view.add( stsbar	= new JCheckBoxMenuItem("Status Bar         ") );
		stsbar.setMnemonic(KeyEvent.VK_S);
		
		stsbar.addActionListener(fvl);
		mbar.add(view);
		
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem vwhlp,abtntpd;
		help.add( vwhlp		= new JMenuItem("View Help              " , 'H') );
		help.addSeparator();
		help.add( abtntpd	= new JMenuItem("About JNotepad         " , 'A') );
		
		HelpMenuListener hl = new HelpMenuListener(this);
		vwhlp.addActionListener(hl);
		abtntpd.addActionListener(hl);
		mbar.add(help);

		txt = new TextArea("", 40, 80, TextArea.SCROLLBARS_BOTH);
		txt.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(txt, BorderLayout.CENTER);
		txt.addKeyListener( new KeyListener()
								{
									public void keyPressed(KeyEvent arg0) { }
									public void keyReleased(KeyEvent arg0){ }
									public void keyTyped(KeyEvent arg0)
									{
										saved = 0;
									}									
								});
		
		Sbar = new JPanel();
		Sbar.setBackground(getBackground());
		
		/*JLabel lns;
		lns = new JLabel("Ln 1,Col 1");
		lns.setFont( new Font( "calibri" , Font.BOLD , 10) );
		lns.setBackground(Sbar.getBackground());
		Sbar.add(lns);//,new FlowLayout(FlowLayout.LEADING)); */
		
		add(Sbar,BorderLayout.SOUTH);
		resize(601, 701);
	}
}
