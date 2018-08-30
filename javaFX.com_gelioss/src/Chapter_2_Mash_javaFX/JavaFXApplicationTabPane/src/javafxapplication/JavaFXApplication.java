/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Chapter_2_Mash_javaFX.JavaFXApplicationTabPane.src.javafxapplication;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        
        TabPane tp=new TabPane();
        tp.setLayoutX(10);
        tp.setLayoutY(10);             
        tp.setCursor(Cursor.HAND);
        DropShadow effect=new DropShadow();
        effect.setOffsetX(8);
        effect.setOffsetY(8);
        tp.setEffect(effect);           
        tp.setStyle("-fx-border-width:4pt;-fx-border-color:olive;");
        tp.setPrefSize(300, 200);
        tp.setTooltip(new Tooltip("Панель с закладками"));
        tp.setSide(Side.TOP);
        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tp.setTabMinHeight(20);
        tp.setTabMinWidth(100);
        
        Tab tabP = new Tab("Изображения");             
        Group rootP = new Group();
        VBox vb=new VBox(50);        
        HBox hb=new HBox(20);
        hb.setLayoutX(50);
        Image im1= new Image(this.getClass().getResource("image1.jpeg").toString());
        ImageView imv1=new ImageView(im1);
        imv1.setFitHeight(100);
        imv1.setFitWidth(100); 
        imv1.setPreserveRatio(true);
        
        Image im2= new Image(this.getClass().getResource("image2.jpeg").toString());
        ImageView imv2=new ImageView(im2);
        imv2.setFitHeight(100);
        imv2.setFitWidth(100); 
        imv2.setPreserveRatio(true);
        hb.getChildren().addAll(new Group(),imv1, imv2);
        vb.getChildren().addAll(new Group(),hb);
        rootP.getChildren().add(vb);
        tabP.setContent(rootP); 
        
        Tab tabN = new Tab("Заметки");        
        Group rootN = new Group();
        tabN.setContent(rootN); 
        
        tp.getTabs().addAll(tabP,tabN);
        root.getChildren().add(tp);        
    }
}
