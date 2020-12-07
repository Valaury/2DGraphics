package Rectangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FxRectangle extends Application {
    private double stageHt, stageWd, midX, midY;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("working with FX rectangle");
        
        //create a group, all GUI elements will be added to this group
        //the group is then added to primaryStage
        Group grp = new Group();
        Scene newScene = new Scene(grp, 450, 400, Color.WHITE);
        Rectangle rect = new Rectangle();
        Rectangle rect1 = new Rectangle();
        stageHt = newScene.getHeight();
        stageWd = newScene.getWidth();
        rect.setHeight(70);
        rect.setWidth(250);
        rect.setFill(Color.DARKMAGENTA);
        
        rect1.setHeight(10);
        rect1.setWidth(10);
        rect1.setFill(Color.BEIGE);
        
        //put rectangle in the centre
        midX = (stageWd - rect.getWidth()) / 2;
        midY = (stageHt - rect.getHeight()) /2;
        rect.setX(midX);         
        rect.setY(midY);
        rect1.setX(midX/2);
        rect1.setY(midY/2);
        grp.getChildren().add(rect);
        
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
