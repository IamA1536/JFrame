package simple_Drawer_0520;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Color_Sharp implements ActionListener{

	private Draw_Listener DL;
	private Draw_Move DML;
	
	Color_Sharp(){
		
	}
	
	Color_Sharp(Draw_Listener DL, Draw_Move DML){
		this.DL = DL;
		this.DML = DML;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public Draw_Listener getDL() {
		return DL;
	}
	
	public Draw_Move getDML() {
		return DML;
	}
	
}
