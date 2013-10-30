import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FontDialog1 extends JDialog implements ActionListener
{
	private static final long serialVersionUID = -6293844758514145337L;
	JLabel fnt , fstyle , size;
	Choice font , fntstyle , sizes;
	JButton ok,cancel;
	JPanel Pfnts,Pbtn;
	JNotePad NtPad;
	
	FontDialog1(Frame parent , String title , boolean mode)
	{
		super(parent , title , mode);
		this.NtPad = (JNotePad) parent;
		setSize(300, 180);
		setLocation(parent.getX()+100,parent.getY()+150);
		setLayout(new BorderLayout());
		setResizable(false);
		
		
		/* Create font label & fonts list and add them to panel */
		fnt = new JLabel("Font:");
		font = new Choice();
		font.setFont(new Font("Calibre", Font.PLAIN, 15));
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fnts = ge.getAvailableFontFamilyNames();
		for (int i = 0; i < fnts.length; i++)
		{
			font.add( fnts[i] );
		}
		font.select("Calibri"); // get current font and select.

		Pfnts = new JPanel();
		Pfnts.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		Pfnts.add(fnt);
		Pfnts.add(font);

		/* Create font Style label & fonts style list and add them to panel */
		fstyle = new JLabel("Font Style:");
		fntstyle = new Choice();
		fntstyle.setFont(new Font("Calibri", Font.PLAIN, 15));
		fntstyle.add("Regular");
		fntstyle.add("Bold");
		fntstyle.add("Italic");
		fntstyle.add("Bold Italic");
		fntstyle.select("Regular"); // get current font and select.

		Pfnts.add(fstyle);
		Pfnts.add(fntstyle);
				
		/* Create font size label & font sizes list and add them to panel */
		size = new JLabel("Size:");
		sizes = new Choice();
		sizes.setFont(new Font("Calibre", Font.PLAIN, 15));
		for (int i = 8; i < 73; i++)
		{
			sizes.add(""+i);
		}
		sizes.select("15"); // get current font and select.

		Pfnts.add(size);
		Pfnts.add(sizes);

		add(Pfnts, BorderLayout.CENTER);

		/* Create ok & cancle buttons and add to panel */

		ok = new JButton("OK");
		ok.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		Pbtn = new JPanel(new FlowLayout());
		Pbtn.add(ok);
		Pbtn.add(cancel);
		Pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(Pbtn, BorderLayout.SOUTH);

		// pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String m = ae.getActionCommand();
		if( m.equalsIgnoreCase( "OK" ) )
		{
			//set font to editor
			NtPad.txt.setFont( new Font( font.getSelectedItem() , fntstyle.getSelectedIndex() , sizes.getSelectedIndex()+8  ) );
			//System.out.println(Font.PLAIN +"-"+ Font.BOLD +"-"+ Font.ITALIC +"-"+ (Font.PLAIN | Font.ITALIC) );
			dispose();
			NtPad.mbar.updateUI();	//frustrated & struggled alot to get this!!!
		}
		else if( m.equalsIgnoreCase( "Cancel" ) )
		{
			dispose();
		}
		/*else if( m.equalsIgnoreCase( "Switch View" ) )
		{
			setVisible(false);*/
		//	FontDialog fnt = new FontDialog(NtPad/*.NFrame*/ , "Font" , true);
		//}
	}
}