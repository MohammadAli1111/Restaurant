/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import Model.ListProdect;
import Model.Prodect;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

/**
 *
 * @author Mohammad
 */
public class OrdersController implements Initializable {

    @FXML
    private TableView<Prodect> table;

    @FXML
    private Label totalPrice;

    @FXML
    private Label totalCount;

    @FXML
    void ApplyAction(ActionEvent event) {

    }

    @FXML
    void viewAction(ActionEvent event) {
        viewTable();
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            table.setOnMousePressed(event ->{
                    
                     Alert alert = new Alert(Alert.AlertType.WARNING,
                        "",
                        ButtonType.CANCEL,
                        ButtonType.APPLY);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("MyStyle.css").toExternalForm());
                alert.initStyle(StageStyle.TRANSPARENT);
                alert.setDialogPane(dialogPane);
                
                alert.setHeaderText("Do you want to delete the order?");
                
               Prodect prodect= table.getSelectionModel().getSelectedItem();
                alert.setContentText("Type : "+prodect.getType()
                        +"\nName : "+prodect.getName()
                        +"\nPrice : "+prodect.getPrice());
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.APPLY) {
                    
                        ListProdect.list.remove(prodect);
                       
                }
                   
                 viewTable();
            });
    }

    public void viewTable() {
        table.setItems(FXCollections.observableList(ListProdect.list));

        table.getStylesheets().add(getClass().getResource("MyStyle.css").toExternalForm());
        TableColumn Name = new TableColumn("Name");
        Name.setCellValueFactory(new PropertyValueFactory("Name"));

        TableColumn Type = new TableColumn("Type");
        Type.setCellValueFactory(new PropertyValueFactory("Type"));

        TableColumn Price = new TableColumn("Price");
        Price.setCellValueFactory(new PropertyValueFactory("Price"));

        table.getColumns().setAll(Type, Name, Price);
        
        //display count and Price
         int count = ListProdect.list.size();
        float total_Price = 0;
        for (Prodect prodect : ListProdect.list) {
            total_Price += prodect.getPrice();
        }

        totalPrice.setText("Total price : " + total_Price + " $");
        totalCount.setText("Total Count : " + count);
    }

}
