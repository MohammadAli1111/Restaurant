/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mohammad
 */
public class DashboardController implements Initializable {
    
    
    @FXML
    private AnchorPane root;

    
       
    private AnchorPane foods,drinks,orders;

    
    @FXML
    private Button buttonFoods;

    @FXML
    private Button buttonDrinks;

    @FXML
    private Button buttonOrders;
    
    private final String styleAction="-fx-background-color : #98B9FF;"+
                "-fx-text-fill:#010b20;"+
                "-fx-background-radius:20 0 0 20; ";
    private final String styleMenu="-fx-background-color :#010b20;"+
                "-fx-text-fill:#98B9FF;"+
                "-fx-background-radius:20 0 0 20; ";

    @FXML
    void closeAction(MouseEvent event) {
            System.exit(0);
    }

    @FXML
    void minimAction(MouseEvent event) {
          Stage stage= (Stage) root.getScene().getWindow();
          stage.setIconified(true);
    }

    @FXML
    void restoreAction(MouseEvent event) {
        Stage stage= (Stage) root.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }

    }
    
   
    @FXML
    void FoodsAction(ActionEvent event) throws IOException {
        buttonFoods.setStyle(styleAction);
        buttonDrinks.setStyle(styleMenu);
        buttonOrders.setStyle(styleMenu);
        root.getChildren().removeAll(foods,drinks,orders);
        root.getChildren().add(foods);
        
        
    }
    
    @FXML
    void DrinksAction(ActionEvent event) {
         buttonDrinks.setStyle(styleAction);
        buttonFoods.setStyle(styleMenu);
        buttonOrders.setStyle(styleMenu);
        root.getChildren().removeAll(foods,drinks,orders);
        root.getChildren().add(drinks);
    }

    

    @FXML
    void OrdersAction(ActionEvent event) throws IOException {
        buttonOrders.setStyle(styleAction);
        buttonDrinks.setStyle(styleMenu);
        buttonFoods.setStyle(styleMenu);
        root.getChildren().removeAll(foods,drinks,orders);
        root.getChildren().add(orders);
        
        
      
    }
    

  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            foods= FXMLLoader.load(getClass().getResource("Foods.fxml"));
            drinks = FXMLLoader.load(getClass().getResource("Drinks.fxml"));
            orders = FXMLLoader.load(getClass().getResource("Orders.fxml"));
            root.getChildren().add(foods);

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        
    }

    
}
