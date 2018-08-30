/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_4_Mash_javaFX.JavaFXApplicationColorAdjust.src.javafxapplication;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.TextAlignment;
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
        Scene scene = new Scene(root, 300, 250);
        
        final ColorAdjust effect=new ColorAdjust();
        effect.setBrightness(0.3);
        effect.setContrast(0.5);
        effect.setHue(0.5);
        effect.setSaturation(0.5);
        
        final ToggleButton btnOn = new ToggleButton("JavaFX");
        btnOn.setLayoutX(30);
        btnOn.setLayoutY(50);             
        btnOn.setCursor(Cursor.CLOSED_HAND);
        btnOn.setTextAlignment(TextAlignment.CENTER);         
        btnOn.setPrefSize(200,50);        
        btnOn.setStyle("-fx-base:#9900ff;-fx-font: bold italic 18pt Georgia;-fx-text-fill:white;");  
        btnOn.selectedProperty().addListener(new javafx.beans.value.ChangeListener<Boolean>() {
        public void changed(javafx.beans.value.ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
        if (new_val.equals(Boolean.TRUE)){  
        btnOn.setEffect(effect);   
        }
        if (new_val.equals(Boolean.FALSE)){            
        btnOn.setEffect(null);   
        }      
        }
    });
        
        root.getChildren().add(btnOn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
