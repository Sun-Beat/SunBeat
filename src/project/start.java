//package project;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class start extends JFrame {
//    private Image screenImage;
//    private Graphics screenGraphic;
//    private Image startScreen = new ImageIcon(Main.class.getResource("../Images/loginScreen.png")).getImage();
//
//    private ImageIcon signinBtn = new ImageIcon(Main.class.getResource("../Images/signinBtn.png"));
//    private ImageIcon darkSigninBtn = new ImageIcon(Main.class.getResource("../Images/darkSigninBtn.png"));
//    private ImageIcon signupBtn = new ImageIcon(Main.class.getResource("../Images/signupBtn.png"));
//    private ImageIcon darkSignupBtn = new ImageIcon(Main.class.getResource("../Images/darkSignupBtn.png"));
//
//    private JButton signinbtn = new JButton(signinBtn);
//    private JButton darksigninbtn = new JButton(darkSigninBtn);
//    private JButton signupbtn = new JButton(signupBtn);
//    private JButton darksignupbtn = new JButton(darkSignupBtn);
//
//    public start() {
//        setTitle("SunBeat");
//        setUndecorated(true);
//        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//        setResizable(false);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//        setBackground(new Color(0, 0, 0, 0));
//        setLayout(null);
//
//        init();
//    }
//
//    private void init() {
//        signinbtn.setBounds(300, 250, 240, 500);
//        signinbtn.setBorderPainted(false);
//        signinbtn.setOpaque(false);
//        signinbtn.setContentAreaFilled(false);
//        signinbtn.setFocusPainted(false);
//        signupbtn.setBounds(400, 550, 240, 500);
//        signupbtn.setBorderPainted(false);
//        signupbtn.setOpaque(false);
//        signupbtn.setContentAreaFilled(false);
//        signupbtn.setFocusPainted(false);
//
//        signinbtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                signinbtn.setIcon(darkSigninBtn);
//                signinbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                signinbtn.setIcon(signinBtn);
//                signinbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//            }
//        });
//
//        signupbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                signup signup = new signup(); 
//                signup.setVisible(true); 
//                dispose();
//            }
//        });
//
//    }
//
//    
//    
//}
