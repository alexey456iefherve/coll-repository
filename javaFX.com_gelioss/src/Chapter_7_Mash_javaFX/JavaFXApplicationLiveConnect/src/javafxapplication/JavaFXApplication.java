/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_7_Mash_javaFX.JavaFXApplicationLiveConnect.src.javafxapplication;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {
    
    private SimpleStringProperty sp=new SimpleStringProperty();
    
    public void setImage(String input){
        sp.setValue(input);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Изображения");  
        
        Group root = new Group();            
        Scene scene = new Scene(root, 400, 400, Color.BEIGE);        
        primaryStage.setScene(scene);
        primaryStage.show();         
        
        BorderPane borderPane = new BorderPane(); 
        borderPane.setLayoutX(20);
        borderPane.setLayoutY(30);
        Image im=new Image(this.getClass().getResource("image0.jpeg").toString());             
        final ImageView imv=new ImageView(im);        
        imv.setPreserveRatio(true);
        imv.setFitHeight(300);
        imv.setFitWidth(300);          
        imv.setSmooth(true);        
        imv.setCursor(Cursor.TEXT);              
        DropShadow effect=new DropShadow();
        effect.setOffsetX(10);
        effect.setOffsetY(10);  
        imv.setEffect(effect);        
        borderPane.setCenter(imv); 
        
        sp.addListener(new ChangeListener<String>(){
        @Override 
        public void changed(ObservableValue<? extends String> o,String oldVal, String newVal){
        Image im=new Image(this.getClass().getResource(sp.getValue()).toString());             
        imv.setImage(im);           
        }
      });     
       
        root.getChildren().addAll(borderPane);
    }
}
