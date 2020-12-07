/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RotatingImage;


import javafx.animation.RotateTransition;  
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;  
import javafx.stage.Stage;  
import javafx.util.Duration;  

public class Rotate_Transition extends Application {
    
     
   @Override  
    public void start(Stage primaryStage) throws Exception {  
        //Creating Rectangle   
        Rectangle rect = new Rectangle(200,100,200,200);  
        
        rect.setFill(Color.LIMEGREEN);  
        rect.setStroke(Color.HOTPINK);  
        rect.setStrokeWidth(5);  
          
        //Instantiating RotateTransition class   
        RotateTransition rotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        rotate.setAxis(Rotate.Z_AXIS);  
          
        // setting the angle of rotation   
        rotate.setByAngle(45);  
          
        //setting cycle count of the rotation   
        rotate.setCycleCount(100);  
          
        //Setting duration of the transition   
        rotate.setDuration(Duration.millis(1));  
          
        //the transition will be auto reversed by setting this to true   
        rotate.setAutoReverse(true);  
              
        //setting Rectangle as the node onto which the   
        // transition will be applied  
        rotate.setNode(rect);  
          
        //playing the transition   
        rotate.play();  
          
        //Configuring Group and Scene   
        Group root = new Group();  
        root.getChildren().add(rect);  
        Scene scene = new Scene(root,600,400,Color.BLACK);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Rotate Transition example");  
        primaryStage.show();  
          
    }  
    public static void main(String[] args) {  
        launch(args);  
    }  
  
}  