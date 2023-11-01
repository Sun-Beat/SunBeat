package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SunBeat extends JFrame {
   private Image screenImage;
   private Graphics screenGraphic;

   private Image mainScreen = new ImageIcon(Main.class.getResource("../images/mainScreen.png")).getImage();
   private Image loadingScreen = new ImageIcon(Main.class.getResource("../images/gameRuleScreen.png")).getImage();
   private Image gameScreen = new ImageIcon(Main.class.getResource("../images/GameScreen.png")).getImage();
   
   private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../images/startBtn.png"));
   private ImageIcon darkStartBtn = new ImageIcon(Main.class.getResource("../images/darkStartBtn.png"));
   private ImageIcon ruleBtn = new ImageIcon(Main.class.getResource("../images/ruleBtn.png"));
   private ImageIcon darkruleBtn = new ImageIcon(Main.class.getResource("../images/darkruleBtn.png"));
   private ImageIcon rankBtn = new ImageIcon(Main.class.getResource("../images/rankBtn.png"));
   private ImageIcon darkRankBtn = new ImageIcon(Main.class.getResource("../images/darkRankBtn.png"));
   private ImageIcon RightBtn = new ImageIcon(Main.class.getResource("../images/rightBtn.png"));
   private ImageIcon LeftBtn = new ImageIcon(Main.class.getResource("../images/leftBtn.png"));
   private ImageIcon darkRightBtn = new ImageIcon(Main.class.getResource("../images/darkRightBtn.png"));
   private ImageIcon darkLeftBtn = new ImageIcon(Main.class.getResource("../images/darkLeftBtn.png"));
   private ImageIcon easyBtn = new ImageIcon(Main.class.getResource("../images/easyBtn.png"));
   private ImageIcon hardBtn = new ImageIcon(Main.class.getResource("../images/hardBtn.png"));
   private ImageIcon darkHardBtn = new ImageIcon(Main.class.getResource("../images/darkHardBtn.png"));
   private ImageIcon darkEasyBtn = new ImageIcon(Main.class.getResource("../images/darkEasyBtn.png"));
   private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();
   private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
   private JButton startbtn = new JButton(startBtn);
   private JButton darkstartbtn = new JButton(darkStartBtn);
   private JButton quitButton = new JButton(quitButtonBasicImage);
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
   private JButton backButton = new JButton(backButtonBasicImage);
   private boolean isMainScreen, isLoadingScreen, isGameScreen;
public static Game game;

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
      addKeyListener(new KeyListener());
      introMusic.start();

      trackList.add(new Track("kill this love.png", "title kill this love.png", "Kill This Love Selected.mp3",
            "Kill This Love.mp3", "Kill This Love"));
      trackList.add(new Track("beethoven virus.png", "title beethoven virus.png", "Beethoven Virus Selected.mp3",
            "Beethoven Virurs.mp3",   "Beethoven Virurs"));
      trackList.add(
            new Track("dangerously.png", "title dangerously.png", "Dangerously Selected.mp3", "Dangerously.mp3","Dangerously"));

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
//            Music selectedMusic = new Music("Kill This Love Selected.mp3",true);
//            selectedMusic.start();
            introMusic.close();
            selectedTrack(0);
            startbtn.setVisible(false);
            rulebtn.setVisible(false);
            rankbtn.setVisible(false);
            isMainScreen = true;
            mainScreen = new ImageIcon(Main.class.getResource("../images/GameScreen.png")).getImage();
            rightbtn.setVisible(true);
            leftbtn.setVisible(true);
            easybtn.setVisible(true);
            hardbtn.setVisible(true);

         }
      });

      add(startbtn);
      
      quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

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
            mainScreen = new ImageIcon(Main.class.getResource("../images/loadingScreen.png")).getImage();

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
 				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
 				buttonEnteredMusic.start();
 				gameStart(nowSelected, "Easy");
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
        	 Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Hard");
         }
      });
      add(hardbtn);

      backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);
   }

   public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}


   public void screenDraw(Graphics2D g) {
		g.drawImage(mainScreen, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen)
		{
			game.screenDraw(g);
		}
		paintComponents(g);
		this.repaint();
	}
	

   public void selectedTrack(int nowSelected) {
      if (selectedMusic != null)
         selectedMusic.close();
      titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
            .getImage();
      selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
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
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftbtn.setVisible(false);
		rightbtn.setVisible(false);
		easybtn.setVisible(false);
		hardbtn.setVisible(false);
		mainScreen = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
	}
	public void backMain() {
		isMainScreen = true;
		leftbtn.setVisible(true);
		rightbtn.setVisible(true);
		easybtn.setVisible(true);
		hardbtn.setVisible(true);
		mainScreen = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		backButton.setVisible(false);
		selectedTrack(nowSelected);
		isGameScreen = false;
		//game.close();
	}

	public void enterMain() {
		startbtn.setVisible(false);
		quitButton.setVisible(false);
		mainScreen = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		isMainScreen = true;
		leftbtn.setVisible(true);
		rightbtn.setVisible(true);
		easybtn.setVisible(true);
		hardbtn.setVisible(true);
		//introMusic.close();
		selectedTrack(0);
	}
}