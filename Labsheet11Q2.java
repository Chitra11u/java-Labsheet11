import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q2 extends Frame implements ActionListener {
    TextField num1Field, num2Field, resultField;
    Button addBtn, subBtn, mulBtn, divBtn;

    public Labsheet11Q2() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setLayout(new FlowLayout());

        add(new Label("Number 1:"));
        num1Field = new TextField(15);
        add(num1Field);

        add(new Label("Number 2:"));
        num2Field = new TextField(15);
        add(num2Field);

        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        add(new Label("Result:"));
        resultField = new TextField(15);
        resultField.setEditable(false);
        add(resultField);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1Field.getText());
            double n2 = Double.parseDouble(num2Field.getText());
            double res = 0;

            if (e.getSource() == addBtn) {
                res = n1 + n2;
                resultField.setText(String.valueOf(res));
            } else if (e.getSource() == subBtn) {
                res = n1 - n2;
                resultField.setText(String.valueOf(res));
            } else if (e.getSource() == mulBtn) {
                res = n1 * n2;
                resultField.setText(String.valueOf(res));
            } else if (e.getSource() == divBtn) {
                if (n2 == 0) {
                    resultField.setText("Error: Division by zero");
                } else {
                    res = n1 / n2;
                    resultField.setText(String.valueOf(res));
                }
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q2();
    }
}
