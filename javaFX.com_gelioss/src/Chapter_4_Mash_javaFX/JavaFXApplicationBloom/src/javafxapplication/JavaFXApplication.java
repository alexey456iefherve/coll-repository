/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_4_Mash_javaFX.JavaFXApplicationBloom.src.javafxapplication;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class JavaFXApplication extends Application {

    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);  
        
        final Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        btn.setText("Next");
        btn.setPrefSize(100,30);
        btn.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white;-fx-background-color: #a0522d;-fx-border-width: 3px; -fx-border-color:#f4a460 #800000 #800000 #f4a460;");
        final Bloom bloom=new Bloom();
        bloom.setThreshold(0.3);         
       
        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
               btn.setEffect(bloom);
            }
        });
        btn.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                btn.setEffect(null);
            }
        });         
        
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
