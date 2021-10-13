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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

/**
 *
 * @author Mohammad
 */
public class FoodController implements Initializable {

    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gridPane.getChildren().forEach((node) -> {
            node.setOnMouseClicked((MouseEvent event) -> {
                Pane pane = (Pane) node;
                VBox vBox = (VBox) pane.getChildren().get(0);
                Label name = (Label) vBox.getChildren().get(1);
                Label price = (Label) vBox.getChildren().get(2);
                String type = "Food";
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "",
                        ButtonType.CANCEL,
                        ButtonType.APPLY);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("MyStyle.css").toExternalForm());
                alert.initStyle(StageStyle.TRANSPARENT);
                alert.setDialogPane(dialogPane);
                
                alert.setHeaderText("Do you want to buy this food?");
                alert.setContentText("Food : "+name.getText()
                        +"\nPrice : "+price.getText());
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.APPLY) {
                    
                        ListProdect.list.add(new Prodect(type,
                                name.getText(),
                                Float.parseFloat(price.getText().split(" ")[0])));
                }

            });
        });
    }

}
