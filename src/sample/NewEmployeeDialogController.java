package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.model.Datasource;
import sample.model.Employee;

import java.util.Date;
import java.util.List;

public class NewEmployeeDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField statusField;

    public void processResults(){
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String title = titleField.getText().trim();
        double salary = Double.parseDouble(salaryField.getText().trim());
        String startDate = startDateField.getText().trim();
        String status = statusField.getText().trim();

        Datasource.getInstance().insertNewEmployee(firstName,lastName,title,salary,startDate,status);

    }
}
