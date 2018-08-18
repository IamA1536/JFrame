package simple_Drawer_0520;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Draw_Move implements MouseMotionListener {
	private Graphics g;
	private int x1, y1, x2, y2;
	private boolean b = false, pen = false, p = true;
	private Color c;

	Draw_Move(Graphics g) {
		this.g = g;
	}

	public void mouseDragged(MouseEvent e) {
		if ((b) && (!pen)) {
			g.setColor(new Color(255, 255, 255));
			g.drawOval(e.getX() - 10, e.getY() - 10, 20, 20);
			g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
		} else if (pen) {
			g.setColor(c);
			if (p) {
				x1 = e.getX();
				y1 = e.getY();
				p = !p;
			}
			;
			final Timer timer = new Timer();
			TimerTask task = new TimerTask() {

				public void run() {
					x2 = e.getX();
					y2 = e.getY();
					if (!p) {
						Graphics2D g1 = (Graphics2D) g;
						g1.setStroke(new BasicStroke());
						g.drawLine(x1, y1, x2, y2);
						p = !p;
					}
				}
			};
			timer.schedule(task, 10);

			// g.drawOval(e.getX()-3, e.getY()-3, 6 , 6);
			// g.fillOval(e.getX()-3, e.getY()-3, 6 , 6);
		}

	}

	public void mouseMoved(MouseEvent e) {
		// final Timer timer=new Timer();
		// TimerTask task = new TimerTask() {
		//
		// public void run() {
		// x1 = e.getX();
		// y1 = e.getY();
		// }
		// };
		//
		// timer.schedule(task, 100);
		// g.setColor(new Color(100,100,100));
		// g.drawRect(e.getX(), e.getY(), 5, 5);
		// g.fillRect(e.getX(), e.getY(), 5, 5);
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public void setPen(boolean pen) {
		this.pen = pen;
	}

	public void setColor(Color c) {
		this.c = c;
	}
}
