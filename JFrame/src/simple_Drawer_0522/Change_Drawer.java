package simple_Drawer_0522;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Change_Drawer implements ActionListener {

	private Draw_Listener DL;
	private JButton JBU;
	private boolean isColor;

	Change_Drawer() {

	}

	Change_Drawer(Draw_Listener DL, JButton JBU, boolean isColor) {
		this.DL = DL;
		this.JBU = JBU;
		this.isColor = isColor;
	}

	public void actionPerformed(ActionEvent e) {
		if (isColor)
			DL.setColor(JBU.getBackground());
		else
			DL.setStr(JBU.getText());
	}

}
