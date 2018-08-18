package simple_Drawer_0520;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sharp_change extends Color_Sharp implements ActionListener{

	private int style;

	Sharp_change(){
		
	}
	
	Sharp_change(Draw_Listener DL , Draw_Move DML ,  int style){
		super(DL , DML);
		this.style = style;
	}
	
	public void actionPerformed(ActionEvent e) {
		getDL().setStyle(style);
		getDL().setEra(true);
		getDL().setEra(true);
		getDML().setB(false);
		getDML().setPen(false);
	}
	
}
