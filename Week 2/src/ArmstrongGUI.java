import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArmstrongGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Armstrong Number Checker");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter a number:");
        JTextField inputField = new JTextField(10);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("");

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    boolean result = ArmstrongChecker.isArmstrong(number);
                    resultLabel.setText(number + (result ? " is" : " is not") + " an Armstrong number.");
                    try {
                        DatabaseManager.initializeDatabase();
                        DatabaseManager.saveResult(number, result);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid integer.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
