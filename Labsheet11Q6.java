import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q6 extends Frame implements ActionListener {
    TextField idField, nameField, salaryField;
    Choice deptChoice, desigChoice;
    CheckboxGroup genderGroup;
    Checkbox maleBox, femaleBox;
    TextArea outputArea;
    Button submitBtn, clearBtn;

    public Labsheet11Q6() {
        setTitle("Employee Registration Form");
        setSize(450, 550);
        setLayout(new FlowLayout());

        add(new Label("Employee ID:"));
        idField = new TextField(25);
        add(idField);

        add(new Label("Employee Name:"));
        nameField = new TextField(25);
        add(nameField);

        add(new Label("Department:"));
        deptChoice = new Choice();
        deptChoice.add("HR");
        deptChoice.add("Engineering");
        deptChoice.add("Sales");
        deptChoice.add("Finance");
        add(deptChoice);

        add(new Label("Designation:"));
        desigChoice = new Choice();
        desigChoice.add("Manager");
        desigChoice.add("Developer");
        desigChoice.add("Analyst");
        desigChoice.add("Intern");
        add(desigChoice);

        add(new Label("Salary:"));
        salaryField = new TextField(25);
        add(salaryField);

        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        maleBox = new Checkbox("Male", genderGroup, true);
        femaleBox = new Checkbox("Female", genderGroup, false);
        add(maleBox);
        add(femaleBox);

        submitBtn = new Button("Submit");
        clearBtn = new Button("Clear");
        add(submitBtn);
        add(clearBtn);

        outputArea = new TextArea(10, 40);
        outputArea.setEditable(false);
        add(outputArea);

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String id = idField.getText();
            String name = nameField.getText();
            String dept = deptChoice.getSelectedItem();
            String desig = desigChoice.getSelectedItem();
            String salary = salaryField.getText();
            String gender = genderGroup.getSelectedCheckbox().getLabel();

            String record = "ID: " + id + "\nName: " + name + "\nDepartment: " + dept + 
                            "\nDesignation: " + desig + "\nSalary: " + salary + "\nGender: " + gender + "\n------------------------------------\n";
            outputArea.append(record);
        } else if (e.getSource() == clearBtn) {
            idField.setText("");
            nameField.setText("");
            salaryField.setText("");
            deptChoice.select(0);
            desigChoice.select(0);
            genderGroup.setSelectedCheckbox(maleBox);
            outputArea.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q6();
    }
}
