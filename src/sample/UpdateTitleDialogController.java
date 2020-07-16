package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.Datasource;

public class UpdateTitleDialogController {
    @FXML
    private TextField titleField;
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
        String newTitle = titleField.getText().trim();
        Datasource.getInstance().updateEmployeeTitle(newTitle,employeeID);
    }
}
