import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q5 extends JFrame implements ActionListener {
    JTextField nameField;
    JComboBox<String> courseBox;
    JRadioButton maleBtn, femaleBtn;
    ButtonGroup genderGroup;
    JCheckBox sub1Box, sub2Box, sub3Box, sub4Box;
    JButton submitBtn, resetBtn;

    public Labsheet11Q5() {
        setTitle("Course Selection Form");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setBounds(30, 30, 100, 25);
        add(lblName);
        nameField = new JTextField();
        nameField.setBounds(140, 30, 180, 25);
        add(nameField);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(30, 70, 100, 25);
        add(lblCourse);
        String[] courses = {"Computer Science", "Information Technology", "Electronics", "Mechanical"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(140, 70, 180, 25);
        add(courseBox);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 110, 100, 25);
        add(lblGender);
        maleBtn = new JRadioButton("Male", true);
        femaleBtn = new JRadioButton("Female");
        maleBtn.setBounds(140, 110, 80, 25);
        femaleBtn.setBounds(230, 110, 80, 25);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        add(maleBtn);
        add(femaleBtn);

        JLabel lblSubjects = new JLabel("Subjects:");
        lblSubjects.setBounds(30, 150, 100, 25);
        add(lblSubjects);
        sub1Box = new JCheckBox("Java Programming");
        sub2Box = new JCheckBox("Data Structures");
        sub3Box = new JCheckBox("DBMS");
        sub4Box = new JCheckBox("Computer Networks");
        sub1Box.setBounds(140, 150, 180, 25);
        sub2Box.setBounds(140, 180, 180, 25);
        sub3Box.setBounds(140, 210, 180, 25);
        sub4Box.setBounds(140, 240, 180, 25);
        add(sub1Box);
        add(sub2Box);
        add(sub3Box);
        add(sub4Box);

        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        submitBtn.setBounds(90, 300, 90, 30);
        resetBtn.setBounds(200, 300, 90, 30);
        add(submitBtn);
        add(resetBtn);

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String course = (String) courseBox.getSelectedItem();
            String gender = maleBtn.isSelected() ? "Male" : "Female";
            StringBuilder subjects = new StringBuilder();
            if (sub1Box.isSelected()) subjects.append("Java Programming ");
            if (sub2Box.isSelected()) subjects.append("Data Structures ");
            if (sub3Box.isSelected()) subjects.append("DBMS ");
            if (sub4Box.isSelected()) subjects.append("Computer Networks ");

            String msg = "Name: " + name + "\nCourse: " + course + "\nGender: " + gender + "\nSubjects: " + subjects.toString();
            JOptionPane.showMessageDialog(this, msg, "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == resetBtn) {
            nameField.setText("");
            courseBox.setSelectedIndex(0);
            genderGroup.clearSelection();
            maleBtn.setSelected(true);
            sub1Box.setSelected(false);
            sub2Box.setSelected(false);
            sub3Box.setSelected(false);
            sub4Box.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q5();
    }
}
