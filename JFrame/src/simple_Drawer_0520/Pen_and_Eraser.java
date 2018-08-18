package simple_Drawer_0520;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pen_and_Eraser implements ActionListener{
	
	private Draw_Listener DL;
	private Draw_Move DML;
	
	Pen_and_Eraser(){
		
	}
	
	Pen_and_Eraser(Draw_Listener DL, Draw_Move DML){
		this.DL = DL;
		this.DML = DML;
	}
	
	public void actionPerformed(ActionEvent e) {
		DL.setEra(false);
	}
	
	public Draw_Listener getDL() {
		return DL;
	}
	
	public Draw_Move getDML() {
		return DML;
	}
}
