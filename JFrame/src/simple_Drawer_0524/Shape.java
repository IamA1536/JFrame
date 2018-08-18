package simple_Drawer_0524;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Shape {
	private int x1, x2, y1, y2;
	private String str;
	private Stroke st;
	private Color c=Color.BLACK;
	private boolean em;

	Shape(Graphics g, int x1, int y1, int x2, int y2, String str, Color c, Stroke st, boolean em) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.str = str;
		this.c = c;
		this.st = st;
		this.em = em;
	}

	public void rePaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(st);
		g.setColor(c);
		if (str.equals("直线")) {
			g.drawLine(x1, y1, x2, y2);
		} else if (str.equals("矩形")) {
			if (em) g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			else g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else if (str.equals("圆形")) {
			if (em) g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
			else g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
		} else if (str.equals("椭圆")) {
			if (em) g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			else g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else if (str.equals("三角形")) {
			if (em) {
				
			} else {
				int[] x = { Math.min(x1, x2), Math.max(x1, x2), Math.min(x1, x2) + Math.abs(x1 - x2) / 2,
						Math.min(x1, x2) };
				int[] y = { Math.max(y1, y2), Math.max(y1, y2), Math.min(y1, y2), Math.max(y1, y2) };
				g.fillPolygon(x, y, 4);
			}
		}
	}
}