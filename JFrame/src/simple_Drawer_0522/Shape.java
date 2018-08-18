package simple_Drawer_0522;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	private int x1, x2, y1, y2;
	private String str;
	private Color c=Color.BLACK;
	private Graphics g;

	public String getStr() {
		return str;
	}

	public Color getColor() {
		return c;
	}

	Shape(Graphics g, int x1, int y1, int x2, int y2, String str, Color c) {
		System.out.println("存入图形");
		this.g = g;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.str = str;
		this.c = c;
	}

	public void rePaint() {
		g.setColor(c);
		if (str.equals("直线")) {
			g.drawLine(x1, y1, x2, y2);
		} else if (str.equals("矩形")) {
			// g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2),
			// Math.abs(y1-y2));
			g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else if (str.equals("圆形")) {
			// g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2),
			// Math.abs(x1-x2));
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
		} else if (str.equals("椭圆")) {
			// g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2),
			// Math.abs(y1-y2));
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else if (str.equals("三角形")) {
			int[] x = { Math.min(x1, x2), Math.max(x1, x2), Math.min(x1, x2) + Math.abs(x1 - x2) / 2,
					Math.min(x1, x2) };
			int[] y = { Math.max(y1, y2), Math.max(y1, y2), Math.min(y1, y2), Math.max(y1, y2) };
			g.fillPolygon(x, y, 4);
		}
	}
}