package simple_Drawer_0520;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class simple_Drawer {
	public static void main(String[] args) {
		new simple_Drawer().show_Drawer();
	}
	
	public void show_Drawer() {
		JFrame jfr = new JFrame();
		jfr.setTitle("Painter");
		jfr.setSize(1500,1200);
		jfr.setLocationRelativeTo(null);
		jfr.getContentPane().setBackground(new Color(255,255,255));
		jfr.getContentPane().setVisible(true);
		jfr.setResizable(false);
		jfr.setDefaultCloseOperation(3);

		FlowLayout f1 = new FlowLayout();
		jfr.setLayout(f1);
		
		JPanel jpc = new JPanel();
		Dimension dmC = new Dimension(500,50);
		jpc.setBackground(new Color(255,255,255));
		jpc.setPreferredSize(dmC);
		jpc.setLayout(f1);
		
		Dimension dmc = new Dimension(93,50);
		JButton jpR = new JButton();
		jpR.setPreferredSize(dmC);
		jpR.setPreferredSize(dmc);
		jpR.setBackground(new Color(255,0,0));
		jpc.add(jpR);
	
		JButton jpG = new JButton();
		jpG.setPreferredSize(dmC);
		jpG.setPreferredSize(dmc);
		jpG.setBackground(new Color(0,255,0));
		jpc.add(jpG);
		
		JButton jpB = new JButton();
		jpB.setPreferredSize(dmC);
		jpB.setPreferredSize(dmc);
		jpB.setBackground(new Color(0,0,255));
		jpc.add(jpB);
		
		JButton jpW = new JButton();
		jpW.setPreferredSize(dmC);
		jpW.setPreferredSize(dmc);
		jpW.setBackground(new Color(255,255,255));
		jpc.add(jpW);
		
		JButton jpD = new JButton();
		jpD.setPreferredSize(dmC);
		jpD.setPreferredSize(dmc);
		jpD.setBackground(new Color(0,0,0));
		jpc.add(jpD);
		
		jfr.add(jpc);
		
		
		Dimension jps = new Dimension(700,50);
		JPanel jpS = new JPanel();
		jpS.setBackground(new Color(255,255,255));
		jpS.setPreferredSize(jps);
		
		Dimension jbS = new Dimension(93,40);
		Font f = new Font("黑体", Font.PLAIN, 14 );
		
		JButton jbL = new JButton("直线");
		jbL.setPreferredSize(jbS);
		jbL.setBackground(new Color(255,255,255));
		jbL.setFont(f);
		jpS.add(jbL);
		
		JButton jbRc = new JButton("矩形");
		jbRc.setPreferredSize(jbS);
		jbRc.setBackground(new Color(255,255,255));
		jbRc.setFont(f);
		jpS.add(jbRc);
		
		JButton jbO = new JButton("圆形");
		jbO.setPreferredSize(jbS);
		jbO.setBackground(new Color(255,255,255));
		jbO.setFont(f);
		jpS.add(jbO);
		
		JButton jbCr = new JButton("椭圆");
		jbCr.setPreferredSize(jbS);
		jbCr.setBackground(new Color(255,255,255));
		jbCr.setFont(f);
		jpS.add(jbCr);
		
		JButton jbTr = new JButton("三角形");
		jbTr.setPreferredSize(jbS);
		jbTr.setBackground(new Color(255,255,255));
		jbTr.setFont(f);
		jpS.add(jbTr);
		
		JButton jPen = new JButton("画笔");
		jPen.setFont(f);
		jPen.setBackground(new Color(255,255,255));
		jPen.setPreferredSize(jbS);
		jpS.add(jPen);
		
		JButton jEra = new JButton("橡皮擦");
		jEra.setFont(f);
		jEra.setBackground(new Color(255,255,255));
		jEra.setPreferredSize(jbS);
		jfr.add(jEra);
		jpS.add(jEra);
		
		jfr.add(jpS);
		
		Dimension jpDB = new Dimension(1500,997);
		JPanel Drawing_board = new JPanel();
		Drawing_board.setBackground(new Color(255,255,255));
		Drawing_board.setPreferredSize(jpDB);
		
		jfr.add(Drawing_board);
		
		jfr.setVisible(true);//组件在窗体的可见之前加入，画笔在窗体的可见之后。
		
		Graphics g = Drawing_board.getGraphics();
		Draw_Listener Draw_line = new Draw_Listener(g);
		Draw_Move Draw_Moveline = new Draw_Move(g);
		Drawing_board.addMouseListener(Draw_line);
		Drawing_board.addMouseListener(Draw_line);
		Drawing_board.addMouseMotionListener(Draw_Moveline);
		
		jpR.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(255,0,0)));
		jpG.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,255,0)));
		jpB.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,255)));
		jpW.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(255,255,255)));
		jpD.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		
		jbL.addActionListener(new Sharp_change(Draw_line , Draw_Moveline , 1));
		jbL.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		jbRc.addActionListener(new Sharp_change(Draw_line , Draw_Moveline , 2));
		jbRc.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		jbO.addActionListener(new Sharp_change(Draw_line , Draw_Moveline , 3));
		jbO.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		jbCr.addActionListener(new Sharp_change(Draw_line , Draw_Moveline , 4));
		jbCr.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		jbTr.addActionListener(new Sharp_change(Draw_line , Draw_Moveline , 5));
		jbTr.addActionListener(new Color_change(Draw_line , Draw_Moveline , new Color(0,0,0)));
		
		jPen.addActionListener(new Pen_change(Draw_line , Draw_Moveline));
		jEra.addActionListener(new Eraser_change(Draw_line , Draw_Moveline));
	}
	
}
