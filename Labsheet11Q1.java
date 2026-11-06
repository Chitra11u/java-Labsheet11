import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q1 extends Frame implements ActionListener {
    TextField nameField, rollField, courseField;
    CheckboxGroup genderGroup;
    Checkbox maleBox, femaleBox;
    Choice semChoice;
    Button submitBtn, resetBtn;
    Label outputLabel;

    public Labsheet11Q1() {
        setTitle("Student Registration Form");
        setSize(400, 450);
        setLayout(new FlowLayout());

        add(new Label("Student Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Roll Number:"));
        rollField = new TextField(20);
        add(rollField);

        add(new Label("Course:"));
        courseField = new TextField(20);
        add(courseField);

        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        maleBox = new Checkbox("Male", genderGroup, true);
        femaleBox = new Checkbox("Female", genderGroup, false);
        add(maleBox);
        add(femaleBox);

        add(new Label("Semester:"));
        semChoice = new Choice();
        semChoice.add("1st");
        semChoice.add("2nd");
        semChoice.add("3rd");
        semChoice.add("4th");
        semChoice.add("5th");
        semChoice.add("6th");
        semChoice.add("7th");
        semChoice.add("8th");
        add(semChoice);

        submitBtn = new Button("Submit");
        resetBtn = new Button("Reset");
        add(submitBtn);
        add(resetBtn);

        outputLabel = new Label("                                                                                ");
        add(outputLabel);

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();
            String gender = genderGroup.getSelectedCheckbox().getLabel();
            String sem = semChoice.getSelectedItem();
            outputLabel.setText("Name: " + name + ", Roll: " + roll + ", Course: " + course + ", Gender: " + gender + ", Sem: " + sem);
        } else if (e.getSource() == resetBtn) {
            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            genderGroup.setSelectedCheckbox(maleBox);
            semChoice.select(0);
            outputLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q1();
    }
}
