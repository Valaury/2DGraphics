package Rectangle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 *
 * @author Prince
 */
public class FxRectangle extends Application {

    int vCurrentRow = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane gPane = new GridPane();
        gPane.setHgap(5);
        gPane.setVgap(20);
        
        Button btnDrawRect = new Button();
        btnDrawRect.setPrefSize(250, 21);
        btnDrawRect.setText("Draw Rectangle");
        btnDrawRect.setOnAction((ActionEvent event) -> {
            Rectangle rectangle = new Rectangle(0, 0, 250, 150);
            rectangle.setFill(Color.BLACK);
            rectangle.setSmooth(true);
            rectangle.setArcHeight(25);
            rectangle.setArcWidth(25);
            gPane.addRow(vCurrentRow, rectangle);
            GridPane.setMargin(rectangle, new Insets(0,0,0,25));
            vCurrentRow++;
        });

        gPane.addRow(vCurrentRow, btnDrawRect);
        gPane.setMargin(btnDrawRect, new Insets(10,25,10,25));
        vCurrentRow++;

        Scene scene = new Scene(gPane, 300, 1000);
        primaryStage.setTitle("Rectangles");
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
