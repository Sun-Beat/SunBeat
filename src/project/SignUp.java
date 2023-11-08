package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JFrame {
<<<<<<< HEAD
	private Image screenImage;
	private Graphics screenGraphic;
	private Image firstScreen = new ImageIcon(Main.class.getResource("../Images/firstScreen.png")).getImage();

	private ImageIcon completebtn = new ImageIcon(Main.class.getResource("../Images/completebtn.png"));
	private ImageIcon darkcompleteBtn = new ImageIcon(Main.class.getResource("../Images/darkcompleteBtn.png"));
=======
    private Image screenImage;
    private Graphics screenGraphic;
    private Image firstScreen = new ImageIcon(Main.class.getResource("../Images/firstScreen.png")).getImage();
    
   private ImageIcon completebtn = new ImageIcon(Main.class.getResource("../Images/completebtn.png"));
   private ImageIcon darkcompleteBtn = new ImageIcon(Main.class.getResource("../Images/darkcompleteBtn.png"));
>>>>>>> 86b4bec0fa4dee19a51a2cdcf8f537dc51149399

   private JButton completeBtn = new JButton(completebtn);
   private JButton darkcompletebtn = new JButton(darkcompleteBtn);

	private JTextField idField;
	private JButton signUpButton;

<<<<<<< HEAD
	public SignUp() {
		completeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 사용자가 입력한 ID를 얻어옵니다.
				String userId = idField.getText();
=======
    public SignUp() {
       completeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 사용자가 입력한 ID를 얻어옵니다.
                String userId = idField.getText();
>>>>>>> 86b4bec0fa4dee19a51a2cdcf8f537dc51149399

				// 데이터베이스 연결 정보 설정
				String jdbcUrl = "jdbc:mysql://localhost:3306/sunbeat";
				String username = "root";
				String password = "0000";

				Connection connection = null;
				PreparedStatement preparedStatement = null;

				try {
					// 데이터베이스에 연결
					connection = DriverManager.getConnection(jdbcUrl, username, password);

					// SQL 쿼리 준비
					String sql = "INSERT INTO sunbeat (id) VALUES (?)"; // users 테이블에 ID를 저장
					preparedStatement = connection.prepareStatement(sql);

					// ? 자리에 사용자가 입력한 ID를 설정
					preparedStatement.setString(1, userId);

					// SQL 쿼리 실행
					int rowsAffected = preparedStatement.executeUpdate();

					if (rowsAffected > 0) {
						System.out.println("ID가 성공적으로 데이터베이스에 저장되었습니다.");
						// 성공 메시지 또는 원하는 동작 수행
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					// 오류 처리
				} finally {
					// 리소스 해제
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		setUndecorated(true);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		// Create a JPanel for input fields
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(469, 367, 500, 500);
		inputPanel.setOpaque(false);
		inputPanel.setLayout(null);
		add(inputPanel);

		// Create a JTextField for entering the ID
		idField = new JTextField("아이디를 작성해주세요");
		idField.setBounds(10, 10, 392, 60);
		idField.setOpaque(false);
		inputPanel.add(idField);

		Font koreanFont = new Font("맑은고딕", Font.PLAIN, 20);
		idField.setFont(koreanFont);

		completeBtn.setBounds(530, 250, 240, 500);
		completeBtn.setBorderPainted(false);
		completeBtn.setOpaque(false);
		completeBtn.setContentAreaFilled(false);
		completeBtn.setFocusPainted(false);

<<<<<<< HEAD
		completeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				completeBtn.setIcon(darkcompleteBtn);
				completeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				completeBtn.setIcon(completebtn);
				completeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new SunBeat();
			}
		});
=======
        Font koreanFont = new Font("맑은고딕", Font.PLAIN, 20); 
        idField.setFont(koreanFont);
        
        completeBtn.setBounds(530, 250, 240, 500);
        completeBtn.setBorderPainted(false);
        completeBtn.setOpaque(false);
        completeBtn.setContentAreaFilled(false);
      completeBtn.setFocusPainted(false);   
   
      completeBtn.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            completeBtn.setIcon(darkcompleteBtn);
            completeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            completeBtn.setIcon(completebtn);
            completeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }

         @Override
         public void mousePressed(MouseEvent e) {
         new SunBeat();
         }
      });
>>>>>>> 86b4bec0fa4dee19a51a2cdcf8f537dc51149399

      add(completeBtn);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, this);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(firstScreen, 0, 0, this);

<<<<<<< HEAD
		paintComponents(g);
		this.repaint();
	}

	public static void main(String[] args) {
		new SignUp();
	}

=======
        paintComponents(g);
        this.repaint();
    }
>>>>>>> 86b4bec0fa4dee19a51a2cdcf8f537dc51149399
}
