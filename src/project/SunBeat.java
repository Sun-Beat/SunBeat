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


public class SunBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private Image mainScreen = new ImageIcon(Main.class.getResource("../Images/mainScreen.png")).getImage();
	private Image loadingScreen = new ImageIcon(Main.class.getResource("../Images/gameRuleScreen.png")).getImage();
	private Image gameScreen=  new ImageIcon(Main.class.getResource("../Images/GameScreen.png")).getImage();
	private Image selectImage = new ImageIcon(Main.class.getResource("../Images/kill this love.png")).getImage();


	private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../Images/startBtn.png"));
	private ImageIcon darkStartBtn = new ImageIcon(Main.class.getResource("../Images/darkStartBtn.png"));
	private ImageIcon ruleBtn = new ImageIcon(Main.class.getResource("../Images/ruleBtn.png"));
	private ImageIcon darkruleBtn = new ImageIcon(Main.class.getResource("../Images/darkruleBtn.png"));
	private ImageIcon rankBtn = new ImageIcon(Main.class.getResource("../Images/rankBtn.png"));
	private ImageIcon darkRankBtn = new ImageIcon(Main.class.getResource("../Images/darkRankBtn.png"));

	private JButton startbtn = new JButton(startBtn);
	private JButton darkstartbtn = new JButton(darkStartBtn);
	private JButton rulebtn = new JButton(ruleBtn);
	private JButton darkrulebtn = new JButton(darkruleBtn);
	private JButton rankbtn = new JButton(rankBtn);
	private JButton darkrankbtn = new JButton(darkRankBtn);


	private boolean isMainScreen, isLoadingScreen, isGameScreen;  
	
	public SunBeat() {
		setTitle("SunBeat");
		setUndecorated(true);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		init();
	}
	
	private void init() { 
		
		startbtn.setBounds(300, 250, 240, 500);
		startbtn.setBorderPainted(false);
		startbtn.setOpaque(false);
		startbtn.setContentAreaFilled(false);
		startbtn.setFocusPainted(false);
		
		
		startbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				startbtn.setIcon(darkStartBtn);
				startbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startbtn.setIcon(startBtn);
				startbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startbtn.setVisible(false); 
				rulebtn.setVisible(false);
				rankbtn.setVisible(false);
				isMainScreen = true;
				mainScreen = new ImageIcon(Main.class.getResource("../Images/GameScreen.png")).getImage();
			}
		});

		add(startbtn);

		rulebtn.setBounds(530, 250, 240, 500);
		rulebtn.setBorderPainted(false);
		rulebtn.setOpaque(false);
		rulebtn.setContentAreaFilled(false);
		rulebtn.setFocusPainted(false);
		rulebtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				rulebtn.setIcon(darkruleBtn);
				rulebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rulebtn.setIcon(ruleBtn);
				rulebtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startbtn.setVisible(true); 
				startbtn.setBounds(888, 350, 350, 500);
				rulebtn.setVisible(false);
				rankbtn.setVisible(false);
				mainScreen = new ImageIcon(Main.class.getResource("../Images/loadingScreen.png")).getImage();

				
			}
		});
		add(rulebtn);

		rankbtn.setBounds(770, 250, 240, 500);
		rankbtn.setBorderPainted(false);
		rankbtn.setOpaque(false);
		rankbtn.setContentAreaFilled(false);
		rankbtn.setFocusPainted(false);
		rankbtn.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				rankbtn.setIcon(darkRankBtn);
				rankbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				rankbtn.setIcon(rankBtn);
				rulebtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(rankbtn);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, this);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(mainScreen,0,0,this);
		if (isMainScreen) {
			g.drawImage(selectImage, 400, 250, this);
		}
		if (isLoadingScreen) {
			g.drawImage(loadingScreen, 0, 0, this);
		}
		if(isGameScreen) {
			g.drawImage(gameScreen,0,0,this);
		}
		paintComponents(g); 
		this.repaint();
	}
}