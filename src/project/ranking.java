package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ranking extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private Image ranking = new ImageIcon(Main.class.getResource("../Images/rankingScreen.png")).getImage();

	private ImageIcon rankBtn = new ImageIcon(Main.class.getResource("../Images/rankBtn.png"));
	private ImageIcon darkRankBtn = new ImageIcon(Main.class.getResource("../Images/darkRankBtn.png"));
	
	private JButton rankbtn = new JButton(rankBtn);
	private JButton darkRankbtn = new JButton(darkRankBtn);
	
	public ranking() {
		setUndecorated(true);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, this);
		
		 
		rankbtn.setBounds(530, 250, 240, 500);
		rankbtn.setBorderPainted(false);
		rankbtn.setOpaque(false);
		rankbtn.setContentAreaFilled(false);
		rankbtn.setFocusPainted(false);	
		
		rankbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				rankbtn.setIcon(darkRankBtn);
				rankbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rankbtn.setIcon(rankBtn);
				rankbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			
			}
		});

		add(rankbtn);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(ranking, 0, 0, this);

		paintComponents(g);
		this.repaint();
	}
}
