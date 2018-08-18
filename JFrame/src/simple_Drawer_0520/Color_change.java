package simple_Drawer_0520;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Color_change extends Color_Sharp implements ActionListener{

	private Color c;
	
	Color_change(){
		
	}
	
	Color_change(Draw_Listener DL, Draw_Move DML, Color c){
		super(DL , DML);
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		getDL().setColor(c);
		getDML().setColor(c);
	}

}
