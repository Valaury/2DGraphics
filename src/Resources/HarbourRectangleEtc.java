/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author shubh
 */
public class HarbourRectangleEtc extends Application {
    private ImageView bridge0, bridge1, quit;
    private Rectangle clipRect0, clipRect1;
    private double moveBy = 0;
    private DoubleProperty coordXReal = new SimpleDoubleProperty(0);
    private FadeTransition fader;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        bridge0 = new ImageView(new Image(HarbourRectangleEtc.class.getResourceAsStream("/images/BWharbBridge.jpg")));
        
        clipRect0 = new Rectangle(400, 600);
        clipRect0.setArcHeight(20);
        clipRect0.setArcWidth(20);
        bridge0.setClip(clipRect0);
        
        bridge1 = new ImageView(new Image(HarbourRectangleEtc.class.getResourceAsStream("/images/harbBridge.JPG")));
        clipRect1 = new Rectangle(400, 600);
        clipRect1.setArcHeight(20);
        clipRect1.setArcWidth(20);
        bridge1.setClip(clipRect1);
        bridge1.setOpacity(0.0);
        fader = new FadeTransition(Duration.seconds(1), bridge1);
        fader.setFromValue(0.0);
        fader.setToValue(1.0);
        setDrag();
        closeApp();
        
        Pane root = new Pane();
        root.getChildren().addAll(bridge0, bridge1, quit);
        Scene myScene = new Scene(root, 800, 600);
        myScene.setFill(null);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    private void setDrag() {
        bridge0.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                moveBy = event.getSceneX() - coordXReal.getValue();
            }
        } );
        bridge0.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                coordXReal.set(event.getSceneX() - moveBy);
            }
        });
        bridge0.xProperty().bind(coordXReal);
        
        bridge1.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                moveBy = event.getSceneX() - coordXReal.getValue();
            }
        } );
        bridge1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                coordXReal.set(event.getSceneX() - moveBy);
            }
        });
        bridge1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              //  bridge1.setOpacity(1.0);
              fader.setRate(1.0);
              fader.play();
            }
        });
        bridge1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               // bridge1.setOpacity(0.0);
               fader.setRate(-1.0);
              fader.play();
            }
        });
        bridge1.xProperty().bind(coordXReal);
    }

    private void closeApp() {
        quit = new ImageView(new Image(HarbourRectangleEtc.class.getResourceAsStream("/images/close.png")));
        quit.setFitHeight(25);
        quit.setFitWidth(25);
        quit.setX(370);
        quit.setY(10);
        
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
