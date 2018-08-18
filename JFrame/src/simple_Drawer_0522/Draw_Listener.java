package simple_Drawer_0522;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Draw_Listener implements MouseListener, MouseMotionListener, ActionListener {
	private int x1, x2, y1, y2;
	private int len = -1;
	private Graphics g;
	private Color c = Color.BLACK;
	private String str;
	private boolean b = true;
	private Shape[] sp = new Shape[100];

	Draw_Listener() {

	}

	public void mousePressed(MouseEvent e) {
		if (b) {
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {
		g.setColor(c);
		if (str.equals("直线")) {
			x2 = e.getX();
			y2 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			sp[++len] = new Shape(g, x1, y1, x2, y2, "直线", c);
		} else if (str.equals("多边形")) {
			if (b) {
				x2 = e.getX();
				y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);
				sp[++len] = new Shape(g, x1, y1, x2, y2, "直线", c);
				b = !b;
			} else if (e.getClickCount() == 1) {
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "直线", c);
				x2 = e.getX();
				y2 = e.getY();
			} else if (e.getClickCount() == 2) {
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "直线", c);
				g.drawLine(x1, y1, e.getX(), e.getY());
				sp[++len] = new Shape(g, x1, y1, e.getX(), e.getY(), "直线", c);
				b = !b;
			}
		} else if (str.equals("矩形")) {
			x2 = e.getX();
			y2 = e.getY();
			g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			sp[++len] = new Shape(g, x1, y1, x2, y2, "矩形", c);
		} else if (str.equals("圆形")) {
			x2 = e.getX();
			y2 = e.getY();
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
			sp[++len] = new Shape(g, x1, y1, x2, y2, "圆形", c);
		} else if (str.equals("椭圆")) {
			x2 = e.getX();
			y2 = e.getY();
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			sp[++len] = new Shape(g, x1, y1, x2, y2, "椭圆", c);
		} else if (str.equals("三角形")) {
			x2 = e.getX();
			y2 = e.getY();
			int x[] = { Math.min(x1, x2), Math.max(x1, x2), Math.min(x1, x2) + Math.abs(x1 - x2) / 2,
					Math.min(x1, x2) };
			int y[] = { Math.max(y1, y2), Math.max(y1, y2), Math.min(y1, y2), Math.max(y1, y2) };
			g.fillPolygon(x, y, 4);
			sp[++len] = new Shape(g, x1, y1, x2, y2, "三角形", c);
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		// System.out.println("使用橡皮擦");
		// if (str.equals("橡皮擦")) {
		// System.out.println("使用橡皮擦");
		// g.setColor(new Color(255, 255, 255));
		// g.drawOval(e.getX() - 10, e.getY() - 10, 20, 20);
		// g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
		// } else if (str.equals("画笔")) {
		// g.setColor(c);
		//
		// }

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void setColor(Color c) {
		this.c = c;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void setGra(Graphics g) {
		this.g = g;
	}

	public Shape[] getShape() {
		return sp;
	}

	public void actionPerformed(ActionEvent e) {

	}

}
