
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipCalculatorController {

    @FXML
    private TextField billAmountField;

    @FXML
    private TextField tipPercentageField;

    @FXML
    private Label tipAmountLabel;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void calculateTip() {
        try {
            double billAmount = Double.parseDouble(
                billAmountField.getText().trim());

            double tipPercentage = Double.parseDouble(
                tipPercentageField.getText().trim());

            if (!Double.isFinite(billAmount)
                    || !Double.isFinite(tipPercentage)
                    || billAmount < 0 || tipPercentage < 0) {
                throw new NumberFormatException();
            }

            double tipAmount =
                billAmount * tipPercentage / 100;

            tipAmountLabel.setText(
                String.format("Tip Amount: $%.2f", tipAmount));

            errorMessageLabel.setText("");

        } catch (NumberFormatException e) {
            errorMessageLabel.setText(
                "Error: Invalid input. Please enter numbers.");
            tipAmountLabel.setText("");
        }
    }

    @FXML
    private void reset() {
        billAmountField.clear();
        tipPercentageField.clear();
        tipAmountLabel.setText("");
        errorMessageLabel.setText("");
    }
}
