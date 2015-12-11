public class HexaEngine extends CalcEngine {

    public HexaEngine() {
        super();
    }

    public void numberPressed(int number, String mode) {
        if (buildingDisplayValue) {
            if (mode.equals("Deci")) {
                // Incorporate this digit.
                displayValue = displayValue * 10 + number;
            } else if (mode.equals("Hexa")) {
                // Incorporate this digit.
                displayValue = displayValue * 16 + number;
            }
        } else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
    }
}
