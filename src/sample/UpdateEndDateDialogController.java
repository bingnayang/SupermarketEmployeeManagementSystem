package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.Datasource;

public class UpdateEndDateDialogController {
    @FXML
    private TextField endDateField;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;

    public void setFirstNameLabel(String first) {
        firstNameLabel.setText(first);
    }

    public void setLastNameLabel(String last) {
        lastNameLabel.setText(last);
    }

    public void processResults(int employeeID){
        String endDate = endDateField.getText().trim();
        Datasource.getInstance().updateEmployeeEndDate(employeeID,endDate);
    }

}
