/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LineProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author shubh
 */
public class FxLines extends Application {
    Line line1;
    Pane root = new Pane();
    int x1, x2, y1, y2;
    int delta = 12;
    @Override
    public void start(Stage primaryStage) {
        x1 = 20; x2 = 10; y1 =100; y2 = 150;
        Button btnLine = new Button();        
        btnLine.setText("Draw 1 line");
        btnLine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x1 += delta;
                y2 += delta;
                Line line = new Line(x1,y1,x2,y2);
                line.setStroke(Color.BLACK);
                line.setStrokeWidth(5);
                root.getChildren().add(line);
            }
        });    
        
        Button btnCircle = new Button("Draw Circle");
        btnCircle.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                x1 += delta;
                y2 += delta;
                Line line = new Line(x1,y1,x2,y2);
                line.setStroke(Color.RED);
                line.setStrokeWidth(5);
                root.getChildren().add(line);
            }
        });
        
        root.setStyle("-fx-background-color: #FAEBD7");
        root.getChildren().add(btnLine);
        
        Scene scene = new Scene(root, 300, 500);
        primaryStage.setTitle("Draw Lines");
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
