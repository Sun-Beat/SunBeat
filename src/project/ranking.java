package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ranking extends JFrame {
    private JTextField userIdField;
    private JTextField scoreField;
    private JButton saveButton;

    public ranking() {
        setTitle("게임 점수 저장");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        userIdField = new JTextField(10);
        scoreField = new JTextField(10);
        saveButton = new JButton("저장");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveScoreToDatabase();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("사용자 ID:"));
        panel.add(userIdField);
        panel.add(new JLabel("점수:"));
        panel.add(scoreField);
        panel.add(new JLabel()); // 빈 레이블
        panel.add(saveButton);

        add(panel);
    }

    private void saveScoreToDatabase() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/score"; 
        String username = "root"; 
        String password = "0000"; 

        int userId = Integer.parseInt(userIdField.getText());
        int score = Integer.parseInt(scoreField.getText());

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
}






