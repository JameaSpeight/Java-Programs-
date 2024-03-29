import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI application for RationalNumber
 * 
 * @author Jessica Young Schmidt
 * @author Grace Barnhill
 * @author Jamea Speight
 */
public class RationalNumberGUI extends JFrame implements ActionListener {
    /** Label for Numerator 1 */
    private JLabel num1Label;
    /** Text field for Numerator 1 */
    private JTextField num1Text;
    /** Label for Denominator 1 */
    private JLabel den1Label;
    /** Text field for Denominator 1 */
    private JTextField den1Text;
    /** Label for Numerator 2 */
    private JLabel num2Label;
    /** Text field for Numerator 2 */
    private JTextField num2Text;
    /** Label for Denominator 2 */
    private JLabel den2Label;
    /** Text field for Denominator 2 */
    private JTextField den2Text;
    /** Label for Answer */
    private JLabel ansLabel;
    /** Text field for Answer */
    private JTextField ansText;
    /** Button for Add */
    private JButton addButton;
    /** Button for Subtract */
    private JButton subtractButton; 
    /** Button for Multiply */
    private JButton multiplyButton;
    /** Button for Divide */
    private JButton divideButton;

    /**
     * Default constructor
     */
    public RationalNumberGUI() {
        super("Rational Number GUI");
        setSize(500, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a JPanel
        JPanel panel = new JPanel(new GridLayout(7, 2));
        // Add JPanel to the frame
        add(panel);

        num1Label = new JLabel("Numerator 1");
        panel.add(num1Label);
        num1Text = new JTextField(1);
        panel.add(num1Text);

        den1Label = new JLabel("Denominator 1");
        panel.add(den1Label);
        den1Text = new JTextField(2);
        panel.add(den1Text);

        num2Label = new JLabel("Numerator 2");
        panel.add(num2Label);
        num2Text = new JTextField(3);
        panel.add(num2Text);

        den2Label = new JLabel("Denominator 2");
        panel.add(den2Label);
        den2Text = new JTextField(4);
        panel.add(den2Text);

        ansLabel = new JLabel("Answer");
        panel.add(ansLabel);
        ansText = new JTextField(5);
        panel.add(ansText);

        addButton = new JButton("Add");
        panel.add(addButton);

        subtractButton = new JButton("Subtract");
        panel.add(subtractButton);

        multiplyButton = new JButton("Multiply");
        panel.add(multiplyButton);

        divideButton = new JButton("Divide");
        panel.add(divideButton);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setVisible(true);
        ansText.setEditable(false);
    }

    /**
     * Performs specific action(s) based on the event that occurs
     * 
     * @param e event that occurred
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.add(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
        }
        if (e.getSource() == subtractButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.subtract(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
        }
        if (e.getSource() == multiplyButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.multiply(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
        }
        if (e.getSource() == divideButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.divide(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
        }
    }

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        new RationalNumberGUI();
    }
}

