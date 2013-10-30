import java.awt.*;
import javax.swing.*;

/* Contains Find Dialog Box functionality. */
class Find extends JDialog
{
  private static final long serialVersionUID = -5872575303195802587L;
	protected JNotePad NtPad;
	JLabel find, Lcase;
	JTextField Tfind;
	JCheckBox Mcase;
	JButton findnxt, cancel;
	JPanel fnd, btns;

	Find(Frame parent , String title , boolean mode)
	{
		super(parent, title, mode);
		this.NtPad = (JNotePad) parent;
		setSize(350, 95);
		setLocation(parent.getX() + 100, parent.getY() + 150);
		setLayout(new BorderLayout());
		setResizable(false);

		find = new JLabel("Find What:");
		Tfind = new JTextField("", 15);
		Mcase = new JCheckBox();
		Lcase = new JLabel("Match case");

		fnd = new JPanel();
		fnd.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
		fnd.add(find);
		fnd.add(Tfind);
		fnd.add(Mcase);
		fnd.add(Lcase);
		add(fnd, BorderLayout.CENTER);

		findnxt = new JButton("Find Next");
		cancel = new JButton("Cancel");

		btns = new JPanel();
		btns.setLayout(new GridLayout(0, 1, 5, 5));
		btns.add(findnxt);
		btns.add(cancel);
		add(btns, BorderLayout.EAST);
		// pack();
	}
}
