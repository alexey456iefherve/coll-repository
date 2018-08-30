/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_4_Mash_javaFX.JavaFXApplicationMotionBlur.src.javafxapplication;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


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
        Scene scene = new Scene(root, 500, 500);
        
        final MotionBlur mb = new MotionBlur();
        mb.setRadius(15.0);
        mb.setAngle(90.0);
        
        TitledPane tp =new TitledPane();
        tp.setLayoutX(10);
        tp.setLayoutY(10);             
        tp.setCursor(Cursor.CROSSHAIR);
        tp.setStyle("-fx-border-width:4pt;-fx-border-color:olive;");        
        tp.setTooltip(new Tooltip("Мои изображения"));
        tp.setExpanded(true);        
       
        Label label = new Label("Изображения"); 
        label.setCursor(Cursor.CLOSED_HAND);
        label.setPrefSize(300,30); 
        label.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:black;-fx-background-color:#e6e6fa;");       
        label.setAlignment(Pos.CENTER);
        tp.setGraphic(label);        
        
        Image im=new Image(this.getClass().getResource("image.JPG").toString());
        final ImageView imv=new ImageView(im);
        imv.setPreserveRatio(true);
        imv.setFitHeight(250);
        imv.setFitWidth(250);         
        tp.setContent(imv);
        
        tp.expandedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
             imv.setEffect(mb);             
        }
    });
        tp.heightProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) {
            if(new_val.doubleValue()==225.0) imv.setEffect(null);             
        }
    });
   
        root.getChildren().add(tp);     
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
