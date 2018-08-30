/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_2_Mash_javaFX.JavaFXApplicationTitledPane.src.javafxapplication;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class JavaFXApplication extends Application {     
  
    public static void main(String[] args) {
        Application.launch(JavaFXApplication.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Тестирование GUI-компонентов");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();        
        
        TitledPane tp =new TitledPane();
        tp.setLayoutX(10);
        tp.setLayoutY(10);             
        tp.setCursor(Cursor.CROSSHAIR);
        tp.setStyle("-fx-border-width:4pt;-fx-border-color:olive;");
        //tp.setPrefWidth(300);
        tp.setTooltip(new Tooltip("Мои изображения"));
        //tp.setAnimated(false);
        //tp.setCollapsible(false);         
       
        Label label = new Label("Изображения"); 
        label.setCursor(Cursor.CLOSED_HAND);
        label.setPrefSize(300,30); 
        label.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:black;-fx-background-color:#e6e6fa;");       
        label.setAlignment(Pos.CENTER);
        tp.setGraphic(label);        
        
        Image im=new Image(this.getClass().getResource("image.JPG").toString());
        ImageView imv=new ImageView(im);
        imv.setPreserveRatio(true);
        imv.setFitHeight(250);
        imv.setFitWidth(250);         
        tp.setContent(imv);
        
        root.getChildren().add(tp);        
    }
}
