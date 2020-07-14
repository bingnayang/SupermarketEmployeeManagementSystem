package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import sample.model.Datasource;
import sample.model.Employee;
import sample.model.EmployeeInfo;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView employeeTable;

    @FXML
    public void listEmployeesInfo(){
        Task<ObservableList<EmployeeInfo>> task = new GetAllArtistsTask();
        employeeTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
    @FXML
    public void newEmployees(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(employeeTable.getScene().getWindow());
        dialog.setTitle("Add New Employee");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newEmployeeDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            NewEmployeeDialogController controller = fxmlLoader.getController();
            controller.processResults();
        }
        new Thread().start();
    }
    @FXML
    public void updateEmployeeEndDate(){
        final EmployeeInfo employee = (EmployeeInfo)employeeTable.getSelectionModel().getSelectedItem();
//        System.out.println(employee.getEmployee_Id());
        Task<Boolean> task = new Task<>() {
            @Override
            protected Boolean call() throws Exception {
                return Datasource.getInstance().updateEmployeeEndDate(employee.getEmployee_Id(),"2020/04/23");
            }
        };
        task.setOnSucceeded(e -> {
            if(task.valueProperty().get()){
                employeeTable.refresh();
            }
        });
        new Thread(task).start();
    }

}
class GetAllArtistsTask extends Task {
    @Override
    public ObservableList<EmployeeInfo> call(){
        return FXCollections.observableArrayList(Datasource.getInstance().queryEmployeeInfo());
    }
}
