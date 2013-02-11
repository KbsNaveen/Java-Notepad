import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FontDialog extends JDialog implements ActionListener
{
        private static final long serialVersionUID = 2258357071163651304L;
	JLabel fnt, fstyle, size;
	List font, fntstyle, sizes;
	JButton ok, cancel, AltView;
	JPanel Pfnt, Pstyle, Psize, Pbtn;
	JNotePad NtPad;
	
	FontDialog(Frame parent , String title , boolean mode)
	{
		super(parent, title, mode);
		this.NtPad = (JNotePad) parent;
		setSize(565, 280);
		setLocation(parent.getX() + 20, parent.getY() + 100);
		setLayout(new BorderLayout());
		setResizable(true);

		/* Create font label & fonts list and add them to panel */
		fnt = new JLabel("Font:");
		font = new List(7);
		font.setFont(new Font("Calibre", Font.PLAIN, 15));
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] fnts = ge.getAvailableFontFamilyNames();
		for (int i = 0; i < fnts.length; i++)
		{
			font.add( fnts[i] );
		}
		
		// font.select("Calibri"); //get current font and select.
		Pfnt = new JPanel(new FlowLayout());
		Pfnt.add(fnt);
		Pfnt.add(font);
		Pfnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(Pfnt, BorderLayout.WEST);

		/* Create font Style label & fonts style list and add them to panel */
		fstyle = new JLabel("Font Style:");
		fntstyle = new List(7);
		fntstyle.setFont(new Font("Calibri", Font.PLAIN, 15));
		fntstyle.add("Regular");
		fntstyle.add("Bold");
		fntstyle.add("Italic");
		fntstyle.add("Bold Italic");
		// fntstyle.select("Regular"); //get current font and select.

		Pstyle = new JPanel(new FlowLayout());
		Pstyle.add(fstyle);
		Pstyle.add(fntstyle);
		Pstyle.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(Pstyle, BorderLayout.CENTER);

		/* Create font size label & font sizes list and add them to panel */
		size = new JLabel("Size:");
		sizes = new List(7);
		sizes.setFont(new Font("Calibre", Font.PLAIN, 15));
		for (int i = 8; i < 73; i++) {
			sizes.add("" + i);
		}
		// sizes.select("15"); //get current font and select.
		Psize = new JPanel(new FlowLayout());
		Psize.add(size);
		Psize.add(sizes);
		Psize.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(Psize, BorderLayout.EAST);

		/* Create ok & cancle buttons and add to panel */
		AltView = new JButton("Switch View");
		AltView.addActionListener(this);
		ok = new JButton("OK");
		ok.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		Pbtn = new JPanel(new FlowLayout());
		Pbtn.add(AltView);
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
			// set font to editor
			NtPad.txt.setFont(new Font(font.getSelectedItem(), fntstyle.getSelectedIndex(), sizes.getSelectedIndex() + 8));
			dispose();
			NtPad.mbar.updateUI(); // frustrated alot to get this!!!
		}
		else if( m.equalsIgnoreCase( "Cancel" ) )
		{
			dispose();
		}
		else if( m.equalsIgnoreCase( "Switch View" ) )
		{
			setVisible(false);
			FontDialog1 fnt = new FontDialog1(NtPad, "Font", true);
		}
	}
}
