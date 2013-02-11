import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* Implements Find & Replace functionality. */
class Replace extends Find
{
        private static final long serialVersionUID = 5197694313389997628L;
	JLabel replace;
	JTextField Treplace;
	JButton Breplace, replaceAll;
	
	Replace(Frame parent, String title, boolean mode)
	{
		super(parent, title, mode);
		this.NtPad = (JNotePad) parent;
		setSize(420, 150);
		// setLocation(parent.getX()+100,parent.getY()+150);

		Tfind.setColumns(18);
		replace = new JLabel("Replace With:");
		Treplace = new JTextField("", 18);

		fnd.remove(Mcase);
		fnd.remove(Lcase);
		fnd.add(replace);
		fnd.add(Treplace);
		fnd.add(Mcase);
		fnd.add(Lcase);

		Breplace = new JButton("Replace");
		replaceAll = new JButton("Replace All");

		btns.remove(cancel);
		btns.add(Breplace);
		btns.add(replaceAll);
		btns.add(cancel);
		// pack();
	}
}
