package simple_Drawer_0522;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer_ver_2 extends JPanel {

	private Shape[] sp = new Shape[100];

	public static void main(String[] args) {
		new Drawer_ver_2().show_Drawer();
	}

	public void show_Drawer() {
		JFrame jfr = new JFrame();
		jfr.setTitle("Painter");
		jfr.setSize(1500, 1200);
		jfr.setLocationRelativeTo(null);
		jfr.getContentPane().setBackground(new Color(255, 255, 255));
		jfr.getContentPane().setVisible(true);
		// jfr.setResizable(false);
		jfr.setDefaultCloseOperation(3);

		FlowLayout f1 = new FlowLayout();
		jfr.setLayout(f1);

		JPanel jpc = new JPanel();
		Dimension dmC = new Dimension(1500, 50);
		jpc.setBackground(new Color(255, 255, 255));
		jpc.setPreferredSize(dmC);
		jpc.setLayout(f1);

		String[] Str = { "直线", "矩形", "圆形", "椭圆", "三角形", "多边形", "画笔", "橡皮擦" };
		Color[] Col = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
				Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.WHITE };
		JButton[] JCB = new JButton[13];
		JButton[] JSB = new JButton[8];

		Font f = new Font("黑体", Font.PLAIN, 18);

		for (int i = 0; i < 13; i++) {
			JCB[i] = new JButton();
			JCB[i].setPreferredSize(new Dimension(49, 49));
			JCB[i].setBackground(Col[i]);
			jpc.add(JCB[i]);
		}

		jfr.add(jpc);

		for (int i = 0; i < Str.length; i++) {
			JSB[i] = new JButton(Str[i]);
			JSB[i].setPreferredSize(new Dimension(93, 50));
			JSB[i].setBackground(new Color(255, 255, 255));
			JSB[i].setFont(f);
			jpc.add(JSB[i]);
		}

		Dimension jps = new Dimension(700, 50);
		JPanel jpS = new JPanel();
		jpS.setBackground(new Color(255, 255, 255));
		jpS.setPreferredSize(jps);

		jfr.add(jpS);

//		Dimension jpDB = new Dimension(1500, 997);
//		JPanel Drawing_board = this;
		this.setBackground(new Color(255, 255, 255));
//		this.setPreferredSize(jpDB);
		jfr.add(this);

		Draw_Listener Drawer = new Draw_Listener();

		for (int i = 0; i < 13; i++) {
			JCB[i].addActionListener(new Change_Drawer(Drawer, JCB[i], true));
		}

		for (int i = 0; i < 8; i++) {
			JSB[i].addActionListener(new Change_Drawer(Drawer, JSB[i], false));
		}

		jfr.setVisible(true);
		// 组件在窗体的可见之前加入，画笔在窗体的可见之后。

		Graphics g = this.getGraphics();
		Drawer.setGra(g);
		this.addMouseListener(Drawer);

		sp = Drawer.getShape();

	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < sp.length; i++) {
			if (sp[i] == null)
				break;
			sp[i].rePaint();
			System.out.println("重绘图形: " + sp[i].getStr() + "颜色: " + sp[i].getColor().getRed());
		}
	}

}
