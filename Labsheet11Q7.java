import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q7 extends JFrame implements ActionListener {
    JTextField tempField;
    JRadioButton cToFRadio, fToCRadio;
    ButtonGroup radioGroup;
    JButton convertBtn, clearBtn;
    JLabel resultLabel;

    public Labsheet11Q7() {
        setTitle("Temperature Converter");
        setSize(320, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTemp = new JLabel("Temperature:");
        lblTemp.setBounds(30, 30, 90, 25);
        add(lblTemp);
        tempField = new JTextField();
        tempField.setBounds(130, 30, 130, 25);
        add(tempField);

        cToFRadio = new JRadioButton("Celsius to Fahrenheit", true);
        fToCRadio = new JRadioButton("Fahrenheit to Celsius");
        cToFRadio.setBounds(30, 70, 200, 25);
        fToCRadio.setBounds(30, 100, 200, 25);
        radioGroup = new ButtonGroup();
        radioGroup.add(cToFRadio);
        radioGroup.add(fToCRadio);
        add(cToFRadio);
        add(fToCRadio);

        convertBtn = new JButton("Convert");
        clearBtn = new JButton("Clear");
        convertBtn.setBounds(40, 140, 100, 30);
        clearBtn.setBounds(160, 140, 100, 30);
        add(convertBtn);
        add(clearBtn);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(30, 190, 230, 25);
        add(resultLabel);

        convertBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn) {
            try {
                double val = Double.parseDouble(tempField.getText());
                if (cToFRadio.isSelected()) {
                    double f = (val * 9.0 / 5.0) + 32;
                    resultLabel.setText("Result: " + f + " °F");
                } else {
                    double c = (val - 32) * 5.0 / 9.0;
                    resultLabel.setText("Result: " + c + " °C");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric temperature.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            tempField.setText("");
            cToFRadio.setSelected(true);
            resultLabel.setText("Result: ");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q7();
