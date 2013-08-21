import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class About extends JDialog implements ActionListener 
{
    private static final long serialVersionUID = 6588020577033982416L;
	JTextArea abtnp;
	String str;
	JButton ok;

	About(Frame parent, String title, boolean mode)
	{
		super(parent, title, mode);
		setSize(380, 250);
		setLocation(parent.getX() + 100, parent.getY() + 150);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		abtnp = new JTextArea();
		abtnp.setBackground(getBackground());
		abtnp.setFont(new Font("Calibre", Font.BOLD, 12));
		abtnp.setEditable(false);

		str = "JNotepad™.\n"
				+ "Version 1.0.\n"
				+ "Copyrights © K.B.S. Naveen. All rights reserved® 2K11.\n"
				+ "\nThe JNotepad is protected by its trademark."
				+ "\nAny act of tampering the product or violating the copyrights\nis a punishable offence and will be dealt by the court of law."
				+ "\n\nReport bugs or suggestions at kbs.naveen09@gmail.com\n";
		abtnp.setText(str);
		add(abtnp);

		ok = new JButton("OK");
		ok.addActionListener(this);

		add(ok);
		// pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
}
