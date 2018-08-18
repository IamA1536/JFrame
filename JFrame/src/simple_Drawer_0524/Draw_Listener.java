package simple_Drawer_0524;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.plaf.TreeUI;

public class Draw_Listener implements MouseMotionListener, ActionListener, MouseListener {
	private int x1, x2, y1, y2;
	private int len = -1;
	private Graphics g;
	private Color c = Color.BLACK;
	private String str, str1;
	private boolean b = false, em = true;
	// b用于控制是否为多边形绘制状态，em为是否空心。
	private Stroke st = new BasicStroke(1.0f);
	// Stroke用于设置绘制的线粗细。
	private Shape[] sp = new Shape[100000];

	Draw_Listener() {

	}

	public Shape[] getShape() {
		return sp;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public void mousePressed(MouseEvent e) {
		if (b) {
			Graphics2D g2 = (Graphics2D) g;// 强制转型。
			g2.setStroke(st);// 设置粗细
			x1 = e.getX();
			y1 = e.getY();
			// 记录鼠标按下的位置的位置。
		}
	}

	public void mouseReleased(MouseEvent e) {

		// 在鼠标释放时绘制出相应的图形。
		if (str.equals("直线")) {
			x2 = e.getX();
			y2 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			// 此方法是在两点之间绘画出直线。
			sp[++len] = new Shape(g, x1, y1, x2, y2, "直线", c, st, em);

		} else if (str.equals("多边形")) {
			// 绘制多边形，原理是释放点和上一个点之间绘制直线。
			if (b) {
				x2 = e.getX();
				y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);
				sp[++len] = new Shape(g, x1, y1, x2, y2, "直线", c, st, em);
				b = !b;// 使起点x1,y1保持不变。
			} else if (e.getClickCount() == 1) {
				// 在鼠标点击数为1时(单击)，会将当前位置与上一个位置的点连接。
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "直线", c, st, em);
				x2 = e.getX();
				y2 = e.getY();
				// 更换上一个点。
			} else if (e.getClickCount() == 2) {
				// 双击时，将鼠标位置点与上一个点及起点相连。
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "直线", c, st, em);
				g.drawLine(x1, y1, e.getX(), e.getY());
				sp[++len] = new Shape(g, x1, y1, e.getX(), e.getY(), "直线", c, st, em);
				b = !b;// 多边形绘制完成，使起点可以改变位置。
			}
		} else if (str.equals("矩形")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// 绘制一个空心的矩形，参数为起点x1,y1，宽度，高度。
			else
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// 填充一个实心矩形，其他同上述。
			sp[++len] = new Shape(g, x1, y1, x2, y2, "矩形", c, st, em);
		} else if (str.equals("圆形")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2), 0, 360);
			// 同矩形，但是为画椭圆，为了达成圆的效果，因此宽高一致。
			else
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
			// 填充一个实心椭圆。
			sp[++len] = new Shape(g, x1, y1, x2, y2, "圆形", c, st, em);
		} else if (str.equals("椭圆")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2), 0, 180);
			// 画椭圆
			else
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// 填充椭圆
			sp[++len] = new Shape(g, x1, y1, x2, y2, "椭圆", c, st, em);
		} else if (str.equals("三角形")) {
			x2 = e.getX();
			y2 = e.getY();
			int x[] = { x1, x2, Math.min(x1, x2) + Math.abs(x1 - x2) / 2, x1 };
			int y[] = { y1, y1, y2, y1 };
			if (em) {
				for (int i = 0; i < 3; i++) {
					g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
					// 空心三角形可以视为三条线组成。
					sp[++len] = new Shape(g, x[i], y[i], x[i + 1], y[i + 1], "直线", c, st, em);
				}
			} else {
				g.fillPolygon(x, y, 4);
				// 这个方法会依次按照x,y数组一一对应的位置首位前4位依次连线产生的多边形进行填充。
				sp[++len] = new Shape(g, x1, y1, x2, y2, "三角形", c, st, em);
			}
		}

	}

	public void mouseDragged(MouseEvent e) {
		if (str != null)
			if (str.equals("橡皮擦")) {
				g.setColor(Color.WHITE);
				g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
				// 在鼠标拖动的时候画与背景颜色一致的圆覆盖图形已达到橡皮擦的效果。
				sp[++len] = new Shape(g, e.getX() - 10, e.getY() - 10, e.getX() + 10, e.getY() + 10, "圆形", Color.WHITE,
						st, em);
			} else if (str.equals("画笔")) {
				g.setColor(c);
				g.drawLine(x1, y1, e.getX(), e.getY());
				// 不停的在鼠标移动的极微小的两点之间画线以达到画笔的效果。(也可以在鼠标位置画圆)
				sp[++len] = new Shape(g, x1, y1, e.getX(), e.getY(), "直线", c, st, em);
				x1 = e.getX();
				y1 = e.getY();
				// 更新鼠标上一个位置。
			}

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		em = true;
		// 根据不同的按钮加一判断来执行不同结果。
		b = true;
		str1 = e.getActionCommand();// 获取按钮上的字符串
		if (str1.equals("")) {
			// 文本为空，说明是改变颜色的按钮。
			// 获取当前点击的按钮对象
			JButton jbu = (JButton) e.getSource();
			// 获取按钮上的背景色
			c = jbu.getBackground();
			g.setColor(c);
		} else if (str1.length() > 1) {
			// 说明按钮上有多个字符，不是改变粗细的按钮。
			if (str1.equals("空心") || (str1.equals("实心"))) {
				if (str1.equals("空心"))
					em = true;
				else if (str1.equals("实心"))
					em = false;
			} else {
				if (str1.equals("橡皮擦") && (str1.equals("画笔")))
					b = false;
				else
					b = true;
				str = str1;// 改变当前绘制的图形。
			}
		} else {
			if (str1.equals("细")) {
				// 改变粗细。
				st = new BasicStroke(1.0f);
			} else if (str1.equals("中")) {
				st = new BasicStroke(5.0f);
			} else if (str1.equals("粗")) {
				st = new BasicStroke(10.0f);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
