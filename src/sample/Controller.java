package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.model.Datasource;
import sample.model.Employee;
import sample.model.EmployeeInfo;

public class Controller {
    @FXML
    private TableView employeeTable;

    @FXML
    public void listEmployeesInfo(){
        employeeTable.setVisible(true);
        Task<ObservableList<EmployeeInfo>> task = new GetAllArtistsTask();
        employeeTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

}
class GetAllArtistsTask extends Task {
    @Override
    public ObservableList<EmployeeInfo> call(){
        return FXCollections.observableArrayList(Datasource.getInstance().queryEmployeeInfo());
    }
}
