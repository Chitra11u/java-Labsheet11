import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q3 extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn, resetBtn;

    public Labsheet11Q3() {
        setTitle("Student Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(120, 30, 130, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(120, 70, 130, 25);
        add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(30, 110, 90, 25);
        add(loginBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(135, 110, 90, 25);
        add(resetBtn);

        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("student") && password.equals("password123")) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetBtn) {
            userField.setText("");
            passField.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q3();
    }
}
