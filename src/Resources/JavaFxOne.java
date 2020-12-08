/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author shubh
 */
public class JavaFxOne extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Click me");
        Label lbl = new Label();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello world");
                lbl.setText("hello world");
            }
        });
        
        StackPane paneRoot = new StackPane();
        
        
        paneRoot.getChildren().add(btn);
        paneRoot.getChildren().add(lbl);
        
             
       Scene scene = new Scene(paneRoot, 500, 300);
   
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
