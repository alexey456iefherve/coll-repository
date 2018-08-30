/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_2_Mash_javaFX.JavaFXApplicationScrollPane.src.javafxapplication;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.util.*;
import javafx.scene.*;
import javafx.stage.*;


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
        
        Button btn = new Button();        
        btn.setTranslateY(20);
        btn.setText("Отправить");
        btn.setCursor(Cursor.CROSSHAIR);
        btn.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white;-fx-background-color: #a0522d;-fx-border-width: 3px; -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );       
        btn.setPrefSize(200,30); 
        
        ScrollPane sp=new ScrollPane();
        sp.setLayoutX(10);
        sp.setLayoutY(10);             
        sp.setCursor(Cursor.CLOSED_HAND);
        DropShadow effect=new DropShadow();
        effect.setOffsetX(8);
        effect.setOffsetY(8);
        sp.setEffect(effect);           
        sp.setStyle("-fx-border-width:4pt;-fx-border-color:olive;");
        sp.setPrefSize(150, 100);
        sp.setTooltip(new Tooltip("Отправка данных"));        
        sp.setContent(btn);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        //sp.setFitToWidth(true);        
        sp.setPannable(true);
        sp.setPrefViewportHeight(300);
        sp.setPrefViewportWidth(300);        
        
        root.getChildren().add(sp);        
    }
}
