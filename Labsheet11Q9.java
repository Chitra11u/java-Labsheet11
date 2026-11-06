import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q9 extends JFrame implements ActionListener {
    JTextField nameField, rollField, courseField;
    JRadioButton excBtn, vgoodBtn, goodBtn, avgBtn, poorBtn;
    ButtonGroup ratingGroup;
    JCheckBox teachBox, labBox, matBox, assignBox;
    JTextArea commentsArea;
    JButton submitBtn, resetBtn;

    public Labsheet11Q9() {
        setTitle("Student Feedback Form");
        setSize(420, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setBounds(30, 20, 100, 25);
        add(lblName);
        nameField = new JTextField();
        nameField.setBounds(140, 20, 210, 25);
        add(nameField);

        JLabel lblRoll = new JLabel("Roll Number:");
        lblRoll.setBounds(30, 55, 100, 25);
        add(lblRoll);
        rollField = new JTextField();
        rollField.setBounds(140, 55, 210, 25);
        add(rollField);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(30, 90, 100, 25);
        add(lblCourse);
        courseField = new JTextField();
        courseField.setBounds(140, 90, 210, 25);
        add(courseField);

        JLabel lblRating = new JLabel("Overall Rating:");
        lblRating.setBounds(30, 125, 100, 25);
        add(lblRating);
        excBtn = new JRadioButton("Excellent", true);
        vgoodBtn = new JRadioButton("Very Good");
        goodBtn = new JRadioButton("Good");
        avgBtn = new JRadioButton("Average");
        poorBtn = new JRadioButton("Poor");
        
        excBtn.setBounds(140, 125, 90, 20);
        vgoodBtn.setBounds(235, 125, 100, 20);
        goodBtn.setBounds(140, 145, 90, 20);
        avgBtn.setBounds(235, 145, 90, 20);
        poorBtn.setBounds(140, 165, 90, 20);

        ratingGroup = new ButtonGroup();
        ratingGroup.add(excBtn);
        ratingGroup.add(vgoodBtn);
        ratingGroup.add(goodBtn);
        ratingGroup.add(avgBtn);
        ratingGroup.add(poorBtn);

        add(excBtn); add(vgoodBtn); add(goodBtn); add(avgBtn); add(poorBtn);

        JLabel lblFeedback = new JLabel("Aspects:");
        lblFeedback.setBounds(30, 195, 100, 25);
        add(lblFeedback);
        teachBox = new JCheckBox("Teaching");
        labBox = new JCheckBox("Laboratory");
        matBox = new JCheckBox("Course Material");
        assignBox = new JCheckBox("Assignments");

        teachBox.setBounds(140, 195, 100, 20);
        labBox.setBounds(245, 195, 100, 20);
        matBox.setBounds(140, 215, 120, 20);
        assignBox.setBounds(245, 215, 110, 20);

        add(teachBox); add(labBox); add(matBox); add(assignBox);

        JLabel lblComments = new JLabel("Comments:");
        lblComments.setBounds(30, 250, 100, 25);
        add(lblComments);
        commentsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(commentsArea);
        scrollPane.setBounds(140, 250, 210, 70);
        add(scrollPane);

        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        submitBtn.setBounds(100, 340, 90, 30);
        resetBtn.setBounds(210, 340, 90, 30);
        add(submitBtn);
        add(resetBtn);

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();

            String rating = "Excellent";
            if (vgoodBtn.isSelected()) rating = "Very Good";
            else if (goodBtn.isSelected()) rating = "Good";
            else if (avgBtn.isSelected()) rating = "Average";
            else if (poorBtn.isSelected()) rating = "Poor";

            StringBuilder aspects = new StringBuilder();
            if (teachBox.isSelected()) aspects.append("Teaching ");
            if (labBox.isSelected()) aspects.append("Laboratory ");
            if (matBox.isSelected()) aspects.append("Course Material ");
            if (assignBox.isSelected()) aspects.append("Assignments ");

            String comments = commentsArea.getText();

            String msg = "Name: " + name + "\nRoll: " + roll + "\nCourse: " + course + 
                         "\nRating: " + rating + "\nAspects: " + aspects.toString() + "\nComments: " + comments;
            JOptionPane.showMessageDialog(this, msg, "Feedback Summary", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == resetBtn) {
            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            excBtn.setSelected(true);
            teachBox.setSelected(false);
            labBox.setSelected(false);
            matBox.setSelected(false);
            assignBox.setSelected(false);
            commentsArea.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q9();
    }
}
