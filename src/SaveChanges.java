import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/* Saves changes to disk. Implementation of "ctrl+s" functionality. */
class SaveChanges extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 719469598287636933L;
	JLabel tf;
	JButton save, dsave, cancel;
	JPanel Ptf, Pbtn;
	private JNotePad NtPad;
	
	SaveChanges(Frame parent , String title , boolean mode)
	{
		super(parent, title, mode);
		this.NtPad = (JNotePad) parent;
		setSize(370, 140);
		setLocation(parent.getX() + 100, parent.getY() + 150);
		setLayout(new BorderLayout());
		setResizable(false);

		tf = new JLabel("Do you want to save changes to " + parent.getTitle() + "?");
		tf.setForeground(Color.blue);
		tf.setFont(new Font("Calibre", Font.PLAIN, 15));

		Ptf = new JPanel();
		Ptf.setBackground(Color.WHITE);
		Ptf.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
		Ptf.add(tf);
		add(Ptf, BorderLayout.CENTER);

		save = new JButton("Save");
		save.setMnemonic('S');
		dsave = new JButton("Don't Save");
		dsave.setMnemonic('n');
		cancel = new JButton("Cancel");
		cancel.setMnemonic('C');

		save.addActionListener(this);
		dsave.addActionListener(this);
		cancel.addActionListener(this);

		Pbtn = new JPanel();
		Pbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		Pbtn.add(save);
		Pbtn.add(dsave);
		Pbtn.add(cancel);

		add(Pbtn, BorderLayout.SOUTH);
		// pack();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String m = ae.getActionCommand();
		if( m.equalsIgnoreCase( "Save" ) )
		{
			dispose();
			// open file dialog in save mode
			FileDialog fd = new FileDialog(NtPad, "Save As", FileDialog.SAVE);
			// fd.setLocation( NtPad.getX()+100 , NtPad.getY()+150 );
			fd.setVisible(true);
		}
		else if( m.equalsIgnoreCase( "Don't Save" ) )
		{
			dispose();
			JNotePad.saved = 1;
			// NtPad.setTitle("Untitle");
			// make text area null and change the title of the JNotepad
		}
		else if( m.equalsIgnoreCase( "Cancel" ) )
		{
			dispose();
		}
	}
}
