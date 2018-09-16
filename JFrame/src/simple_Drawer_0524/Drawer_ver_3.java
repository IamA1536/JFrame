package simple_Drawer_0524;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Drawer_ver_3 extends JPanel {
	//���հ棬���ǵ�����
	private Shape[] sp = new Shape[100];

	public static void main(String[] args) {
		new Drawer_ver_3().show_Drawer();
	}

	public void show_Drawer() {
		JFrame jfr = new JFrame();
		jfr.setTitle("Painter");
		jfr.setSize(1750, 1250);
		jfr.setLocationRelativeTo(null);
		jfr.getContentPane().setBackground(Color.WHITE);
		jfr.getContentPane().setVisible(true);
		jfr.setDefaultCloseOperation(3);
		
		JPanel jpc = new JPanel();
		jpc.setBackground(Color.BLACK);
		jpc.setLayout(new FlowLayout());
		jpc.setPreferredSize(new Dimension(60, 0));
		JPanel jpc1 = new JPanel();
		jpc1.setBackground(Color.BLACK);

		String[] Str = { "ֱ��", "����", "Բ��", "��Բ", "������", "�����", "����", "��Ƥ��", "ϸ", "��", "��", "����", "ʵ��"};
		Color[] Col = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
				Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.WHITE };
		Font f = new Font("����", Font.PLAIN, 16);
		//����һЩ�����������Ƽ��Զ���һ���ӿڣ���Щ���ڷ��㴴���༭��ť��

		Draw_Listener draw = new Draw_Listener();
		for (int i = 0; i < Col.length; i++) {
			JButton jbu = new JButton();
			jbu.setPreferredSize(new Dimension(49, 49));
			jbu.setBackground(Col[i]);
			jpc.add(jbu);
			jbu.addActionListener(draw);
		}

		jfr.add(jpc,BorderLayout.WEST);//���岼�֣�JPanelĬ��Ϊ���岼�֡�

		for (int i = 0; i < Str.length; i++) {
			JButton jbu = new JButton(Str[i]);
			jbu.setPreferredSize(new Dimension(85, 50));
			jbu.setBackground(Color.WHITE);
			jbu.setFont(f);
			jpc1.add(jbu);
			jbu.addActionListener(draw);
		}

		jfr.add(jpc1,BorderLayout.NORTH);
		
		
		this.setBackground(Color.WHITE);
		jfr.add(this,BorderLayout.CENTER);

		jfr.setVisible(true);
		// ����ڴ���Ŀɼ�֮ǰ���룬�����ڴ���Ŀɼ�֮��

		Graphics g = this.getGraphics();
		draw.setG(g);
		this.addMouseListener(draw);
		this.addMouseMotionListener(draw);

		sp = draw.getShape();

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < sp.length; i++) {
			if (sp[i] == null)
				break;
			sp[i].rePaint(g);//�ػ�����Ļ��ʺ�ȡ�Ļ��ʲ�һ�������ܹ���
		}
	}

}
