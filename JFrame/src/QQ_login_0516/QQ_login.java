package QQ_login_0516;

public class QQ_login {
	public static void main(String[] args) {
		QQ_login l = new QQ_login();		
		l.Show();
	}

	public void Show() {
		javax.swing.JFrame jfr = new javax.swing.JFrame();
		jfr.setSize(450, 250);//���ý����С
		jfr.setTitle("��¼����");
		jfr.setLocationRelativeTo(null);
		jfr.setResizable(false);
		
		java.awt.FlowLayout fl = new java.awt.FlowLayout();//��ʽ���֡�
		jfr.setLayout(fl);//������ʽ���֣������Ǵ��ϵ��°���ӵ�˳�����ΰڷš�
		
		java.awt.Dimension dm =new java.awt.Dimension(210, 35);//������������Ŀ�͸ߵ�����ֵ
		javax.swing.JTextField jt = new javax.swing.JTextField();
		jt.setText("�������û�������");
		jt.setPreferredSize(dm);//���ÿ�ߡ�
		jfr.add(jt);//���ı�����ӵ������С�
		
		java.awt.Dimension dm1=new java.awt.Dimension(75, 35);//���ñ�ǩ�ߴ�
		javax.swing.JLabel jle1 = new javax.swing.JLabel("ע���˺�");//������ǩ
		jle1.setPreferredSize(dm1);
		jfr.add(jle1);
		
		javax.swing.JTextField jt1 = new javax.swing.JTextField();
		jt1.setText("���������롭��");
		jt1.setPreferredSize(dm);
		jfr.add(jt1);
		
		javax.swing.JLabel jle2 = new javax.swing.JLabel("��������");
		jle2.setPreferredSize(dm1);
		jfr.add(jle2);
		
		java.awt.Dimension dm3= new java.awt.Dimension(300, 90);
		javax.swing.JPanel jp = new javax.swing.JPanel();//����һ��JPanel����װ�������
		jp.setPreferredSize(dm3);
		jp.add(jt);
		jp.add(jle1);
		jp.add(jt1);
		jp.add(jle2);
		jfr.add(jp);//�����������ӵ�JPanel�ڡ�
		
		
		javax.swing.JButton jbt = new javax.swing.JButton("��½");
		java.awt.Dimension dm2 = new java.awt.Dimension(300, 30);//������ť
		jbt.setPreferredSize(dm2);
		jfr.add(jbt);
		
		Buttom_Action bt = new Buttom_Action(jt, jt1);
		jbt.addActionListener(bt);
		
		jfr.setDefaultCloseOperation(3);//�����˳���ֱ�ӽ������̣���Ȼ�����ں�̨���С�
		jfr.setVisible(true);//�������ӻ���һ��д�����
	}
	
}
