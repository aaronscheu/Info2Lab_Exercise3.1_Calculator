/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator {

    private HexaEngine engine;
    // private UserInterface gui;
    private HexaInterface hexagui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator() {
        engine = new HexaEngine();
        // gui = new UserInterface(engine);
        hexagui = new HexaInterface(engine);
    }

    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show() {
        // gui.setVisible(true);
        hexagui.setVisible(true);
    }
}
