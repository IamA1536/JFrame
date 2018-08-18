package QQ_login_Test;

import java.awt.Color;
import java.awt.Image;

public class QQ_login {
	public static void main(String[] args) {
		QQ_login l = new QQ_login();
		l.Show();
	}

	public void Show() {
		javax.swing.JFrame jfr = new javax.swing.JFrame();
		jfr.setSize(450, 450);
		jfr.setTitle("QQ登录界面（伪）");
		jfr.setLocationRelativeTo(null);
		jfr.setResizable(false);
		
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		jfr.setLayout(fl);
		
		javax.swing.ImageIcon img = new javax.swing.ImageIcon("F:\\ForMe\\Personal\\JavaEx\\JFrame\\img\\1.jpg");
		img.setImage(img.getImage().getScaledInstance(360 , 211 , Image.SCALE_DEFAULT));
		
		javax.swing.JLabel jl = new javax.swing.JLabel(img);
		jfr.add(jl);
		
		javax.swing.ImageIcon img2 = new javax.swing.ImageIcon("F:\\ForMe\\Personal\\JavaEx\\JFrame\\img\\2.1.jpg");
		img2.setImage(img2.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		
		javax.swing.JLabel jl1 = new javax.swing.JLabel(img2);
		jfr.add(jl1);
		
		java.awt.Dimension dm =new java.awt.Dimension(210, 35);
		javax.swing.JTextField jt = new javax.swing.JTextField();
		jt.setText("请输入用户名……");
		jt.setPreferredSize(dm);
		jfr.add(jt);
		
		java.awt.Dimension dm1=new java.awt.Dimension(75, 35);
		javax.swing.JLabel jle1 = new javax.swing.JLabel("注册账号");
//		javax.swing.JLabel jle1 = new javax.swing.JLabel("<html><u>注册账号</u><html>");加下划线
		jle1.setPreferredSize(dm1);
		Color co = new Color(39,134,228);
		jle1.setForeground(co);
		jfr.add(jle1);
		
		javax.swing.JTextField jt1 = new javax.swing.JTextField();
		jt1.setText("请输入密码……");
		jt1.setPreferredSize(dm);
		jfr.add(jt1);
		
		javax.swing.JLabel jle2 = new javax.swing.JLabel("忘记密码");
//		javax.swing.JLabel jle2 = new javax.swing.JLabel("<html><u>忘记密码</u><html>");
		jle2.setPreferredSize(dm1);
		jle2.setForeground(co);
		jfr.add(jle2);
		
		java.awt.Dimension dm3= new java.awt.Dimension(300, 90);
		javax.swing.JPanel jp = new javax.swing.JPanel();
		jp.setPreferredSize(dm3);
//		jp.setBackground(Color.BLUE);
		jp.add(jt);
		jp.add(jle1);
		jp.add(jt1);
		jp.add(jle2);
		jfr.add(jp);
		
		javax.swing.JCheckBox jcb = new javax.swing.JCheckBox("自动登录");
		Color co1=new Color(141,145,149);
		jcb.setForeground(co1);
		javax.swing.JCheckBox jcb1 = new javax.swing.JCheckBox("记住密码");
		jcb1.setForeground(co1);
		jfr.add(jcb);
		jfr.add(jcb1);
		
		javax.swing.JButton jbt = new javax.swing.JButton("登陆");
		java.awt.Dimension dm2 = new java.awt.Dimension(300, 30);
		jbt.setPreferredSize(dm2);
		jfr.add(jbt);
		
		Buttom_Action bt = new Buttom_Action(jt, jt1);
		jbt.addActionListener(bt);
		
		jfr.setDefaultCloseOperation(3);
		jfr.setVisible(true);
	}
	
}
