package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JFrame {
    private Image screenImage;
    private Graphics screenGraphic;
    private Image firstScreen = new ImageIcon(Main.class.getResource("../Images/firstScreen.png")).getImage();
    
	private ImageIcon completebtn = new ImageIcon(Main.class.getResource("../Images/completebtn.png"));
	private ImageIcon darkcompleteBtn = new ImageIcon(Main.class.getResource("../Images/darkcompleteBtn.png"));

	private JButton completeBtn = new JButton(completebtn);
	private JButton darkcompletebtn = new JButton(darkcompleteBtn);

    private JTextField idField;
    private JButton signUpButton;

    public SignUp() {
        setUndecorated(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
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

        paintComponents(g);
        this.repaint();
    }
}
