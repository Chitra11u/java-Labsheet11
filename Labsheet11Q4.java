import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q4 extends JFrame implements ActionListener {
    JTextField engField, mathField, javaField, dbmsField, cnField;
    JButton calcBtn;
    JLabel resultLabel;

    public Labsheet11Q4() {
        setTitle("Student Marksheet GUI");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbl1 = new JLabel("English:");
        lbl1.setBounds(30, 30, 120, 25);
        add(lbl1);
        engField = new JTextField();
        engField.setBounds(160, 30, 130, 25);
        add(engField);

        JLabel lbl2 = new JLabel("Mathematics:");
        lbl2.setBounds(30, 70, 120, 25);
        add(lbl2);
        mathField = new JTextField();
        mathField.setBounds(160, 70, 130, 25);
        add(mathField);

        JLabel lbl3 = new JLabel("Java:");
        lbl3.setBounds(30, 110, 120, 25);
        add(lbl3);
        javaField = new JTextField();
        javaField.setBounds(160, 110, 130, 25);
        add(javaField);

        JLabel lbl4 = new JLabel("DBMS:");
        lbl4.setBounds(30, 150, 120, 25);
        add(lbl4);
        dbmsField = new JTextField();
        dbmsField.setBounds(160, 150, 130, 25);
        add(dbmsField);

        JLabel lbl5 = new JLabel("Computer Networks:");
        lbl5.setBounds(30, 190, 130, 25);
        add(lbl5);
        cnField = new JTextField();
        cnField.setBounds(160, 190, 130, 25);
        add(cnField);

        calcBtn = new JButton("Calculate Result");
        calcBtn.setBounds(90, 230, 150, 30);
        add(calcBtn);

        resultLabel = new JLabel("<html>Total: -<br>Percentage: -<br>Grade: -<br>Status: -</html>");
        resultLabel.setBounds(30, 270, 280, 80);
        add(resultLabel);

        calcBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double eng = Double.parseDouble(engField.getText());
            double math = Double.parseDouble(mathField.getText());
            double java = Double.parseDouble(javaField.getText());
            double dbms = Double.parseDouble(dbmsField.getText());
            double cn = Double.parseDouble(cnField.getText());

            if (eng < 0 || eng > 100 || math < 0 || math > 100 || java < 0 || java > 100 || dbms < 0 || dbms > 100 || cn < 0 || cn > 100) {
                JOptionPane.showMessageDialog(this, "Marks should be between 0 and 100.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double total = eng + math + java + dbms + cn;
            double percentage = total / 5.0;

            String status = "Pass";
            if (eng < 40 || math < 40 || java < 40 || dbms < 40 || cn < 40) {
                status = "Fail";
            }

            char grade = 'F';
            if (status.equals("Pass")) {
                if (percentage >= 90) grade = 'A';
                else if (percentage >= 80) grade = 'B';
                else if (percentage >= 70) grade = 'C';
                else if (percentage >= 60) grade = 'D';
                else grade = 'E';
            }

            resultLabel.setText("<html>Total: " + total + " / 500<br>Percentage: " + percentage + "%<br>Grade: " + grade + "<br>Status: " + status + "</html>");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric marks.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q4();
    }
}
