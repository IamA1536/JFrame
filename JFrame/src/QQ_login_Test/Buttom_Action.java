package QQ_login_Test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Buttom_Action implements ActionListener{
	
	private JTextField uname;
	private JTextField pw;
	
	Buttom_Action(JTextField uname , JTextField pw){
		this.uname = uname;
		this.pw = pw;
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean b;
		
//		System.out.println(uname.getText()+" "+pw.getText());
		if ((uname.getText().equals("Admin"))&&(pw.getText().equals("201269"))) b = true;
		else b = false;
		show(b);
		
//		System.out.println("Success");
	}
	
	public void show(boolean b) {
		JFrame jfr = new JFrame();
		jfr.setSize(300, 200);
		jfr.setTitle("��ʾ");
		jfr.setLocationRelativeTo(null);
		jfr.setResizable(false);
//		jrf.setUndecorated(true);
		
		
		
		FlowLayout fl = new FlowLayout();
		jfr.setLayout(fl);
		
		JLabel jle1 = new JLabel();
		Dimension de = new Dimension(300,50);
		jle1.setPreferredSize(de);
		jfr.add(jle1);
		
		JLabel jlt = new JLabel();
		if (b) jlt.setText("��½�ɹ�����ӭ����Ա��");
		else jlt.setText("������û�������");
		jlt.setFont(new Font("",Font.BOLD,25));
		jfr.add(jlt);
		
		JLabel jle2 = new JLabel();
		jle2.setPreferredSize(de);
		jfr.add(jle2);
		
		jfr.setDefaultCloseOperation(3);
		jfr.setVisible(true);
		
	}
}
