package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SunBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private Image mainScreen = new ImageIcon(Main.class.getResource("../Images/mainScreen.png")).getImage();
	private Image loadingScreen = new ImageIcon(Main.class.getResource("../Images/gameRuleScreen.png")).getImage();
	private Image gameScreen = new ImageIcon(Main.class.getResource("../Images/GameScreen.png")).getImage();

	private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../Images/startBtn.png"));
	private ImageIcon darkStartBtn = new ImageIcon(Main.class.getResource("../Images/darkStartBtn.png"));
	private ImageIcon ruleBtn = new ImageIcon(Main.class.getResource("../Images/ruleBtn.png"));
	private ImageIcon darkruleBtn = new ImageIcon(Main.class.getResource("../Images/darkruleBtn.png"));
	private ImageIcon rankBtn = new ImageIcon(Main.class.getResource("../Images/rankBtn.png"));
	private ImageIcon darkRankBtn = new ImageIcon(Main.class.getResource("../Images/darkRankBtn.png"));
	private ImageIcon RightBtn = new ImageIcon(Main.class.getResource("../Images/rightBtn.png"));
	private ImageIcon LeftBtn = new ImageIcon(Main.class.getResource("../Images/leftBtn.png"));
	private ImageIcon darkRightBtn = new ImageIcon(Main.class.getResource("../Images/darkRightBtn.png"));
	private ImageIcon darkLeftBtn = new ImageIcon(Main.class.getResource("../Images/darkLeftBtn.png"));
	private ImageIcon easyBtn = new ImageIcon(Main.class.getResource("../Images/easyBtn.png"));
	private ImageIcon hardBtn = new ImageIcon(Main.class.getResource("../Images/hardBtn.png"));
	private ImageIcon darkHardBtn = new ImageIcon(Main.class.getResource("../Images/darkHardBtn.png"));
	private ImageIcon darkEasyBtn = new ImageIcon(Main.class.getResource("../Images/darkEasyBtn.png"));

	private JButton startbtn = new JButton(startBtn);
	private JButton darkstartbtn = new JButton(darkStartBtn);
	private JButton rulebtn = new JButton(ruleBtn);
	private JButton darkrulebtn = new JButton(darkruleBtn);
	private JButton rankbtn = new JButton(rankBtn);
	private JButton darkrankbtn = new JButton(darkRankBtn);
	private JButton rightbtn = new JButton(RightBtn);
	private JButton leftbtn = new JButton(LeftBtn);
	private JButton darkleftbtn = new JButton(darkLeftBtn);
	private JButton darkrightbtn = new JButton(darkRightBtn);
	private JButton easybtn = new JButton(easyBtn);
	private JButton hardbtn = new JButton(hardBtn);
	private JButton darkhardbtn = new JButton(darkHardBtn);
	private JButton darkeasybtn = new JButton(darkEasyBtn);

	private boolean isMainScreen, isLoadingScreen, isGameScreen;

	ArrayList<Track> trackList = new ArrayList<Track>(); // 변수들을 담을 수 있는 하나의 배열

	private Image selectedImage;
	private Image titleImage;
	private Music selectedMusic;
	private int nowSelected = 0;

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
		Music introMusic = new Music("../music/intro.mp3", true);
		introMusic.start();

		trackList.add(new Track("kill this love.png", "title kill this love.png", "Kill This Love Selected.mp3",
				"Kill This Love.mp3"));
		trackList.add(new Track("beethoven virus.png", "title beethoven virus.png", "Beethoven Virus Selected.mp3",
				"Beethoven Virurs.mp3"));
		trackList.add(
				new Track("dangerously.png", "title dangerously.png", "Dangerously Selected.mp3", "Dangerously.mp3"));

		startbtn.setBounds(300, 250, 240, 500);
		startbtn.setBorderPainted(false);
		startbtn.setOpaque(false);
		startbtn.setContentAreaFilled(false);
		startbtn.setFocusPainted(false);
		rightbtn.setVisible(false);
		leftbtn.setVisible(false);
		easybtn.setVisible(false);
		hardbtn.setVisible(false);

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
//				Music selectedMusic = new Music("Kill This Love Selected.mp3",true);
//				selectedMusic.start();
				introMusic.close();
				selectedTrack(0);
				startbtn.setVisible(false);
				rulebtn.setVisible(false);
				rankbtn.setVisible(false);
				isMainScreen = true;
				mainScreen = new ImageIcon(Main.class.getResource("../Images/GameScreen.png")).getImage();
				rightbtn.setVisible(true);
				leftbtn.setVisible(true);
				easybtn.setVisible(true);
				hardbtn.setVisible(true);

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
				rankbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				new ranking();
			}
		});
		add(rankbtn);

		rightbtn.setBounds(1050, 65, 103, 700);
		rightbtn.setBorderPainted(false);
		rightbtn.setOpaque(false);
		rightbtn.setContentAreaFilled(false);
		rightbtn.setFocusPainted(false);
		rightbtn.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				rightbtn.setIcon(darkRightBtn);
				rightbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				rightbtn.setIcon(RightBtn);
				rightbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightbtn);

		leftbtn.setBounds(140, 65, 103, 700);
		leftbtn.setBorderPainted(false);
		leftbtn.setOpaque(false);
		leftbtn.setContentAreaFilled(false);
		leftbtn.setFocusPainted(false);
		leftbtn.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				leftbtn.setIcon(darkLeftBtn);
				leftbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				leftbtn.setIcon(LeftBtn);
				leftbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftbtn);

		easybtn.setBounds(395, 550, 200, 200);
		easybtn.setBorderPainted(false);
		easybtn.setOpaque(false);
		easybtn.setContentAreaFilled(false);
		easybtn.setFocusPainted(false);
		easybtn.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				easybtn.setIcon(darkEasyBtn);
				easybtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				easybtn.setIcon(easyBtn);
				easybtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(easybtn);

		hardbtn.setBounds(685, 550, 200, 200);
		hardbtn.setBorderPainted(false);
		hardbtn.setOpaque(false);
		hardbtn.setContentAreaFilled(false);
		hardbtn.setFocusPainted(false);
		hardbtn.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				hardbtn.setIcon(darkHardBtn);
				hardbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				hardbtn.setIcon(hardBtn);
				hardbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(hardbtn);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, this);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(mainScreen, 0, 0, this);
		if (isMainScreen) {
			g.drawImage(titleImage, 350, 200, this);
			g.drawImage(selectedImage, 400, 95, this);

		}
		if (isLoadingScreen) {
			g.drawImage(loadingScreen, 0, 0, this);
		}
		if (isGameScreen) {
			g.drawImage(gameScreen, 0, 0, this);
		}
		paintComponents(g);
		this.repaint();
	}

	public void selectedTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../Images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../Images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}
}