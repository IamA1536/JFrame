package simple_Drawer_0520;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Draw_Listener implements MouseListener{
	private int x1,x2,y1,y2;
	private Graphics g;
	private Color c;
	private int style = 1;
	private boolean b = true , eb = true;
	
	Draw_Listener(Graphics g){
		this.g = g;
	}
	
	public void mousePressed(MouseEvent e) {
		if ((b)&&(eb)) {
//			System.out.println(e.getX()+" "+e.getY()+" "+e.getClickCount());
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {
		g.setColor(c);
		if (eb) {
			if (style == 1) {
				if (b) {
//					System.out.println(e.getX()+" "+e.getY()+" "+e.getClickCount());
					x2 = e.getX();
					y2 = e.getY();
					g.drawLine(x1, y1, x2, y2);
					b = !b;
				}
				else 
				if (e.getClickCount() == 1){
					g.drawLine(x2, y2, e.getX(), e.getY());
					x2 = e.getX();
					y2 = e.getY();
				}
				else
				if (e.getClickCount() == 2) {
					g.drawLine(x2, y2, e.getX(), e.getY());
					g.drawLine(x1, y1, e.getX(), e.getY());
					b=!b;
				}
			}
			else
			if (style == 2) {
				g.drawRect(e.getX()-35, e.getY()-25, 70, 50);
//				g.fillRect(e.getX()-35, e.getY()-25, 70, 50);
			}
			else
			if (style == 3) {
				g.drawOval(e.getX()-25, e.getY()-25, 50, 50);
//				g.fillOval(e.getX()-25, e.getY()-25, 50, 50);
			}
			else
			if (style == 4) {
				g.drawOval(e.getX()-40, e.getY()-25, 80, 50);
//				g.fillOval(e.getX()-40, e.getY()-25, 80, 50);
			}
			else
			if (style == 5) {
				int x[] = {e.getX()-60 , e.getX()+60 , e.getX() , e.getX()-60};
				int y[] = {e.getY()+25 , e.getY()+25 , e.getY()-46 , e.getY()+24};
				g.fillPolygon(x, y, 4);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
//		System.out.println(x1+" "+x2+" "+y1+" "+y2);
//		System.out.println(e.getX()+" "+e.getY());
//		g.drawLine(x1, y1, e.getX(), e.getY());
//		g.drawLine(x2, y2, e.getX(), e.getY());
//		Color c =new Color(0,0,255);
//		g.setColor(c);
//		g.drawRect(e.getX()-50, e.getY(), 100, 100);
//		g.fillRect(e.getX()-50, e.getY(), 100, 100);
	}

	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}

	public void setColor(Color c) {
		this.c = c;
	}
	
	public void setStyle(int style) {
		this.style = style;
	}
	
	public void setEra(boolean eb) {
		this.eb = eb;
	}
}
