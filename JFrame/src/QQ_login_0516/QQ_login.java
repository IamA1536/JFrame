package QQ_login_0516;

public class QQ_login {
	public static void main(String[] args) {
		QQ_login l = new QQ_login();		
		l.Show();
	}

	public void Show() {
		javax.swing.JFrame jfr = new javax.swing.JFrame();
		jfr.setSize(450, 250);//设置界面大小
		jfr.setTitle("登录界面");
		jfr.setLocationRelativeTo(null);
		jfr.setResizable(false);
		
		java.awt.FlowLayout fl = new java.awt.FlowLayout();//流式布局。
		jfr.setLayout(fl);//设置流式布局，现在是从上到下按添加的顺序依次摆放。
		
		java.awt.Dimension dm =new java.awt.Dimension(210, 35);//用于设置组件的宽和高的属性值
		javax.swing.JTextField jt = new javax.swing.JTextField();
		jt.setText("请输入用户名……");
		jt.setPreferredSize(dm);//设置宽高。
		jfr.add(jt);//将文本域添加到窗体中。
		
		java.awt.Dimension dm1=new java.awt.Dimension(75, 35);//设置标签尺寸
		javax.swing.JLabel jle1 = new javax.swing.JLabel("注册账号");//创建标签
		jle1.setPreferredSize(dm1);
		jfr.add(jle1);
		
		javax.swing.JTextField jt1 = new javax.swing.JTextField();
		jt1.setText("请输入密码……");
		jt1.setPreferredSize(dm);
		jfr.add(jt1);
		
		javax.swing.JLabel jle2 = new javax.swing.JLabel("忘记密码");
		jle2.setPreferredSize(dm1);
		jfr.add(jle2);
		
		java.awt.Dimension dm3= new java.awt.Dimension(300, 90);
		javax.swing.JPanel jp = new javax.swing.JPanel();//创建一个JPanel用于装各个组件
		jp.setPreferredSize(dm3);
		jp.add(jt);
		jp.add(jle1);
		jp.add(jt1);
		jp.add(jle2);
		jfr.add(jp);//将各个组件添加到JPanel内。
		
		
		javax.swing.JButton jbt = new javax.swing.JButton("登陆");
		java.awt.Dimension dm2 = new java.awt.Dimension(300, 30);//创建按钮
		jbt.setPreferredSize(dm2);
		jfr.add(jbt);
		
		Buttom_Action bt = new Buttom_Action(jt, jt1);
		jbt.addActionListener(bt);
		
		jfr.setDefaultCloseOperation(3);//设置退出后直接结束进程，不然还会在后台运行。
		jfr.setVisible(true);//令界面可视化，一般写在最后。
	}
	
}
