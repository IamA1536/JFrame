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
	// b���ڿ����Ƿ�Ϊ����λ���״̬��emΪ�Ƿ���ġ�
	private Stroke st = new BasicStroke(1.0f);
	// Stroke�������û��Ƶ��ߴ�ϸ��
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
			Graphics2D g2 = (Graphics2D) g;// ǿ��ת�͡�
			g2.setStroke(st);// ���ô�ϸ
			x1 = e.getX();
			y1 = e.getY();
			// ��¼��갴�µ�λ�õ�λ�á�
		}
	}

	public void mouseReleased(MouseEvent e) {

		// ������ͷ�ʱ���Ƴ���Ӧ��ͼ�Ρ�
		if (str.equals("ֱ��")) {
			x2 = e.getX();
			y2 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			// �˷�����������֮��滭��ֱ�ߡ�
			sp[++len] = new Shape(g, x1, y1, x2, y2, "ֱ��", c, st, em);

		} else if (str.equals("�����")) {
			// ���ƶ���Σ�ԭ�����ͷŵ����һ����֮�����ֱ�ߡ�
			if (b) {
				x2 = e.getX();
				y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);
				sp[++len] = new Shape(g, x1, y1, x2, y2, "ֱ��", c, st, em);
				b = !b;// ʹ���x1,y1���ֲ��䡣
			} else if (e.getClickCount() == 1) {
				// ���������Ϊ1ʱ(����)���Ὣ��ǰλ������һ��λ�õĵ����ӡ�
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "ֱ��", c, st, em);
				x2 = e.getX();
				y2 = e.getY();
				// ������һ���㡣
			} else if (e.getClickCount() == 2) {
				// ˫��ʱ�������λ�õ�����һ���㼰���������
				g.drawLine(x2, y2, e.getX(), e.getY());
				sp[++len] = new Shape(g, x2, y2, e.getX(), e.getY(), "ֱ��", c, st, em);
				g.drawLine(x1, y1, e.getX(), e.getY());
				sp[++len] = new Shape(g, x1, y1, e.getX(), e.getY(), "ֱ��", c, st, em);
				b = !b;// ����λ�����ɣ�ʹ�����Ըı�λ�á�
			}
		} else if (str.equals("����")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// ����һ�����ĵľ��Σ�����Ϊ���x1,y1����ȣ��߶ȡ�
			else
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// ���һ��ʵ�ľ��Σ�����ͬ������
			sp[++len] = new Shape(g, x1, y1, x2, y2, "����", c, st, em);
		} else if (str.equals("Բ��")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2), 0, 360);
			// ͬ���Σ�����Ϊ����Բ��Ϊ�˴��Բ��Ч������˿��һ�¡�
			else
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
			// ���һ��ʵ����Բ��
			sp[++len] = new Shape(g, x1, y1, x2, y2, "Բ��", c, st, em);
		} else if (str.equals("��Բ")) {
			x2 = e.getX();
			y2 = e.getY();
			if (em)
				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2), 0, 180);
			// ����Բ
			else
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			// �����Բ
			sp[++len] = new Shape(g, x1, y1, x2, y2, "��Բ", c, st, em);
		} else if (str.equals("������")) {
			x2 = e.getX();
			y2 = e.getY();
			int x[] = { x1, x2, Math.min(x1, x2) + Math.abs(x1 - x2) / 2, x1 };
			int y[] = { y1, y1, y2, y1 };
			if (em) {
				for (int i = 0; i < 3; i++) {
					g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
					// ���������ο�����Ϊ��������ɡ�
					sp[++len] = new Shape(g, x[i], y[i], x[i + 1], y[i + 1], "ֱ��", c, st, em);
				}
			} else {
				g.fillPolygon(x, y, 4);
				// ������������ΰ���x,y����һһ��Ӧ��λ����λǰ4λ�������߲����Ķ���ν�����䡣
				sp[++len] = new Shape(g, x1, y1, x2, y2, "������", c, st, em);
			}
		}

	}

	public void mouseDragged(MouseEvent e) {
		if (str != null)
			if (str.equals("��Ƥ��")) {
				g.setColor(Color.WHITE);
				g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
				// ������϶���ʱ���뱳����ɫһ�µ�Բ����ͼ���Ѵﵽ��Ƥ����Ч����
				sp[++len] = new Shape(g, e.getX() - 10, e.getY() - 10, e.getX() + 10, e.getY() + 10, "Բ��", Color.WHITE,
						st, em);
			} else if (str.equals("����")) {
				g.setColor(c);
				g.drawLine(x1, y1, e.getX(), e.getY());
				// ��ͣ��������ƶ��ļ�΢С������֮�仭���Դﵽ���ʵ�Ч����(Ҳ���������λ�û�Բ)
				sp[++len] = new Shape(g, x1, y1, e.getX(), e.getY(), "ֱ��", c, st, em);
				x1 = e.getX();
				y1 = e.getY();
				// ���������һ��λ�á�
			}

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		em = true;
		// ���ݲ�ͬ�İ�ť��һ�ж���ִ�в�ͬ�����
		b = true;
		str1 = e.getActionCommand();// ��ȡ��ť�ϵ��ַ���
		if (str1.equals("")) {
			// �ı�Ϊ�գ�˵���Ǹı���ɫ�İ�ť��
			// ��ȡ��ǰ����İ�ť����
			JButton jbu = (JButton) e.getSource();
			// ��ȡ��ť�ϵı���ɫ
			c = jbu.getBackground();
			g.setColor(c);
		} else if (str1.length() > 1) {
			// ˵����ť���ж���ַ������Ǹı��ϸ�İ�ť��
			if (str1.equals("����") || (str1.equals("ʵ��"))) {
				if (str1.equals("����"))
					em = true;
				else if (str1.equals("ʵ��"))
					em = false;
			} else {
				if (str1.equals("��Ƥ��") && (str1.equals("����")))
					b = false;
				else
					b = true;
				str = str1;// �ı䵱ǰ���Ƶ�ͼ�Ρ�
			}
		} else {
			if (str1.equals("ϸ")) {
				// �ı��ϸ��
				st = new BasicStroke(1.0f);
			} else if (str1.equals("��")) {
				st = new BasicStroke(5.0f);
			} else if (str1.equals("��")) {
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
