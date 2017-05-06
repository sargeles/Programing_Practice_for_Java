package bishe;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SinFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1103672960512385353L;
	int[] xx = { 1, 2, 3, 4, 5, 6, 7 };
	int[] yy = { 10, 20, 30, 15, 62, 56, 30 };
	String X = "a", 
			Y = "b";

	public SinFrame(int[] x,int[] y,String a,String b) {
		xx=x;yy=y;X=a;Y=b;
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		SinPanel sinPanel = new SinPanel(xx, yy, X, Y);
		container.add(sinPanel, BorderLayout.CENTER);

		this.setTitle("宋浩的毕设程序成果图!");
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}

/*	public static void main(String[] args) {
		new SinFrame();
	}*/
}

class SinPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7824775143858893695L;
	int[] a;
	int[] b;
	String X, Y;

	SinPanel(int[] x, int[] y, String X, String Y) {
		a = x;
		b = y;
		this.X = X;
		this.Y = Y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double x;
		int y;

		Dimension panelSize = this.getSize();
		Location center = new Location(50, panelSize.height - 50);

		g.drawLine(center.x, center.y, panelSize.width - 50, center.y);
		g.drawLine(panelSize.width - 57, center.y - 5, panelSize.width - 50,
				center.y);
		g.drawLine(panelSize.width - 57, center.y + 5, panelSize.width - 50,
				center.y);
		g.setFont(new Font("ScanSerif", Font.BOLD, 12));
		g.drawString(X, panelSize.width - 70, center.y + 15);

		g.drawLine(center.x, center.y, center.x, 50);
		g.drawLine(center.x + 5, 55, center.x, 50);
		g.drawLine(center.x - 5, 55, center.x, 50);
		g.setFont(new Font("ScanSerif", Font.BOLD, 12));
		g.drawString(Y, center.x + 3, 53);

		double l = panelSize.width - 200;
		for (int i = 0; i < a.length; i++) {
			x = ((double) (i + 1) / a.length) * l + center.x;
			y = b[i];
			g.drawLine((int) x, center.y, (int) x, center.y - y);
			g.drawString("" + a[i], (int) x, center.y + 15);
			g.drawString("" + y, (int) x, center.y - y - 10);
		}
	}
}

class Location {
	public int x;
	public int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
