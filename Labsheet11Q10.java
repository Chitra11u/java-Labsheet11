import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q10 extends JFrame implements ActionListener {
    JTextField accField, nameField, balanceField, amountField;
    JButton depositBtn, withdrawBtn, checkBtn, clearBtn;
    double currentBalance = 1000.0;

    public Labsheet11Q10() {
        setTitle("Mini Banking Application");
        setSize(350, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblAcc = new JLabel("Account Number:");
        lblAcc.setBounds(30, 20, 110, 25);
        add(lblAcc);
        accField = new JTextField();
        accField.setBounds(150, 20, 140, 25);
        add(accField);

        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 55, 110, 25);
        add(lblName);
        nameField = new JTextField();
        nameField.setBounds(150, 55, 140, 25);
        add(nameField);

        JLabel lblBalance = new JLabel("Current Balance:");
        lblBalance.setBounds(30, 90, 110, 25);
        add(lblBalance);
        balanceField = new JTextField(String.valueOf(currentBalance));
        balanceField.setBounds(150, 90, 140, 25);
        balanceField.setEditable(false);
        add(balanceField);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(30, 125, 110, 25);
        add(lblAmount);
        amountField = new JTextField();
        amountField.setBounds(150, 125, 140, 25);
        add(amountField);

        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        checkBtn = new JButton("Check Balance");
        clearBtn = new JButton("Clear");

        depositBtn.setBounds(30, 170, 130, 25);
        withdrawBtn.setBounds(170, 170, 130, 25);
        checkBtn.setBounds(30, 205, 130, 25);
        clearBtn.setBounds(170, 205, 130, 25);

        add(depositBtn);
        add(withdrawBtn);
        add(checkBtn);
        add(clearBtn);

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        checkBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBtn) {
            JOptionPane.showMessageDialog(this, "Current Balance: $" + currentBalance, "Balance Inquiry", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == depositBtn) {
            try {
                double amt = Double.parseDouble(amountField.getText());
                if (amt <= 0) {
                    JOptionPane.showMessageDialog(this, "Enter a valid positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                currentBalance += amt;
                balanceField.setText(String.valueOf(currentBalance));
                JOptionPane.showMessageDialog(this, "Successfully Deposited $" + amt, "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == withdrawBtn) {
            try {
                double amt = Double.parseDouble(amountField.getText());
                if (amt <= 0) {
                    JOptionPane.showMessageDialog(this, "Enter a valid positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (amt > currentBalance) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    currentBalance -= amt;
                    balanceField.setText(String.valueOf(currentBalance));
                    JOptionPane.showMessageDialog(this, "Successfully Withdrew $" + amt, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            accField.setText("");
            nameField.setText("");
            amountField.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q10();
    }
}
