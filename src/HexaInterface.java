import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;


public class HexaInterface extends UserInterface {

    String mode;
    HexaEngine calc;

    public HexaInterface(HexaEngine engine) {
        super(engine);
        frame.setVisible(false);
        calc = engine;
        makeFrame();
        frame.setVisible(true);
        mode = "Deci";
    }

    /**
     * Make the frame for the user interface.
     */
    private void makeFrame() {
        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
        addButton(buttonPanel, "D");
        addButton(buttonPanel, "E");
        addButton(buttonPanel, "F");

        JCheckBox check = new JCheckBox("Hexa");
        check.addActionListener(this);
        buttonPanel.add(check);

        addButton(buttonPanel, "A");
        addButton(buttonPanel, "B");
        addButton(buttonPanel, "C");
        buttonPanel.add(new JLabel(" "));

        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");
        addButton(buttonPanel, "CE");

        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");
        addButton(buttonPanel, "?");

        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");
        buttonPanel.add(new JLabel(" "));

        addButton(buttonPanel, "0");
        addButton(buttonPanel, "+");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "=");

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }


    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("0") ||
                command.equals("1") ||
                command.equals("2") ||
                command.equals("3") ||
                command.equals("4") ||
                command.equals("5") ||
                command.equals("6") ||
                command.equals("7") ||
                command.equals("8") ||
                command.equals("9") ||
                command.equals("A") ||
                command.equals("B") ||
                command.equals("C") ||
                command.equals("D") ||
                command.equals("E") ||
                command.equals("F")) {
            int number = 0;
            if (mode.equals("Deci")) {
                number = Integer.parseInt(command);
            } else {
                number = Integer.parseInt(command, 16);
            }

            calc.numberPressed(number, mode);
        } else if (command.equals("+")) {
            calc.plus();
        } else if (command.equals("-")) {
            calc.minus();
        } else if (command.equals("=")) {
            calc.equals();
        } else if (command.equals("CE")) {
            calc.clear();
        } else if (command.equals("?")) {
            showInfo();
        } else if (command.equals("Hexa")) {
            switchMode();
        }
        // else unknown command.

        redisplay();
    }

    protected void addButton(Container panel, String buttonText) {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
        if (buttonText.equals("A") ||
                buttonText.equals("B") ||
                buttonText.equals("C") ||
                buttonText.equals("D") ||
                buttonText.equals("E") ||
                buttonText.equals("F")) {

            button.setVisible(false);
        }
    }

    private void switchMode() {
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPanel innerPane = (JPanel) contentPane.getComponents()[1];
        Component[] elements = innerPane.getComponents();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] instanceof JButton) {
                JButton button = (JButton) elements[i];
                String label = button.getLabel();
                if (label.equals("A") ||
                        label.equals("B") ||
                        label.equals("C") ||
                        label.equals("D") ||
                        label.equals("E") ||
                        label.equals("F")) {

                    if (button.isVisible()) {
                        button.setVisible(false);
                        mode = "Deci";
                    } else {
                        button.setVisible(true);
                        mode = "Hexa";
                    }
                }
            }
        }
    }

    protected void redisplay() {
        if (mode.equals("Hexa")) {
            display.setText("" + Integer.toHexString(calc.getDisplayValue()));
        } else {
            display.setText("" + calc.getDisplayValue());
        }

    }

}
