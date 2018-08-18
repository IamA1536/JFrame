package simple_Drawer_0520;

import java.awt.event.ActionEvent;

public class Eraser_change extends Pen_and_Eraser {

	Eraser_change(Draw_Listener DL , Draw_Move DML){
		super(DL , DML);
	}

	public void actionPerformed(ActionEvent e) {
		getDL().setEra(false);
		getDML().setB(true);
	}
	
}
