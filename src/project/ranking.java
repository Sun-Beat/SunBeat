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

<<<<<<< HEAD
    private void saveScoreToDatabase() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/score"; 
        String username = "root"; 
        String password = "0000"; 
=======
		add(rankbtn);
	}
>>>>>>> 306164155ecf1993650a835d0cc3506c03b043f4

	public void screenDraw(Graphics g) {
		g.drawImage(ranking, 0, 0, this);

<<<<<<< HEAD
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "INSERT INTO score (user_id, score) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "점수가 저장되었습니다.");
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "오류 발생: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
             new ranking().setVisible(true);
          }
       });
    }
=======
		paintComponents(g);
		this.repaint();
	}
>>>>>>> 306164155ecf1993650a835d0cc3506c03b043f4
}
