import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by amaridev on 27/11/15.
 * Package: PACKAGE_NAME for Exercise3.1_Calculator.
 */
public class HexUserInterface extends UserInterface {

    private HexEngine calc;

    public UserInterface(HexEngine engine)
    {
        super(engine);
        makeFrame();
    }

     private void makeFrame()
    {
        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");
        addButton(buttonPanel, "/");

        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");
        addButton(buttonPanel, "*");

        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");
        addButton(buttonPanel, "+");

        addButton(buttonPanel, "A");
        addButton(buttonPanel, "B");
        addButton(buttonPanel, "C");
        addButton(buttonPanel, "D");

        addButton(buttonPanel, "E");
        addButton(buttonPanel, "F");

        addButton(buttonPanel, "0");
        addButton(buttonPanel, "exp");
        addButton(buttonPanel, "C");
        addButton(buttonPanel, "-");

        addButton(buttonPanel, "hex/dec");
        buttonPanel.add(new JLabel(" "));
        buttonPanel.add(new JLabel(" "));
        addButton(buttonPanel, "=");

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }

}
