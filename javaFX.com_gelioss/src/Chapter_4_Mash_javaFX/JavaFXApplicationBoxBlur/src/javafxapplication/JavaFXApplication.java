/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_4_Mash_javaFX.JavaFXApplicationBoxBlur.src.javafxapplication;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXApplication extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        
        BoxBlur blur=new BoxBlur();
        blur.setWidth(0.0);
        blur.setHeight(0.0);
        
        Button btn = new Button();
        btn.setLayoutX(50);
        btn.setLayoutY(100);
        btn.setPrefSize(200,20);
        btn.setText("Hello World!");
        btn.setStyle("-fx-font:bold 18pt Arial");
        btn.setEffect(blur);
        
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kvO = new KeyValue(btn.opacityProperty(), 0.0);
        KeyFrame kfO = new KeyFrame(Duration.millis(3000), kvO);
        KeyValue kvB = new KeyValue(blur.widthProperty(),50);
        KeyFrame kfB = new KeyFrame(Duration.millis(3000), kvB);
        timeline.getKeyFrames().addAll(kfO,kfB);        
        timeline.play();  
        
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
