/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Swing_JavaFX.JavaApplicationSwing.putin_naval_medvrd.JavaFXApplicationTextArea.src.javafxapplication;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class JavaFXApplication extends Application {

    public static class Hotel {

        private StringProperty name;
        //        private StringProperty resort;
////        private StringProperty category;
        private DoubleProperty rate;

        public Hotel(String name, double rate) {
            this.name = new SimpleStringProperty (name);
//            this.resort = new SimpleStringProperty(resort);
//            this.category = new SimpleStringProperty(category);
            this.rate = new SimpleDoubleProperty (rate);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public String getName() {
            return name.getValue ();
        }

        //        public StringProperty resortProperty() {return resort;}
//        public String getResort(){
//            return resort.getValue();
//        }
//        public StringProperty categoryProperty() {return category;}
//        public String getCategory(){
//            return category.getValue();
//        }
        public DoubleProperty rateProperty() {
            return rate;
        }

        public Double getRate() {
            return rate.getValue ();
        }

    }
    public static void main(String[] args) {
        Application.launch(JavaFXApplication.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Тестирование GUI-компонентов");
        Group root = new Group();
        Scene scene = new Scene(root, 940, 500, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
        //Label
        Label label1=new Label("    Общая статистика\n\n\n" +
                "Ижедневная статистика");
        label1.setLayoutX(10);
        label1.setLayoutY(10);
        label1.setPrefSize(350, 350);
        label1.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:#000066;-fx-background-color:lightgrey;");
        label1.setAlignment(Pos.CENTER);


        //choceBox
        ObservableList<String> country = FXCollections.observableArrayList(
                "Lenta.ru","Tool.ru","Static.ru");
        ChoiceBox<String> choice = new ChoiceBox<String>(country);
        choice.setLayoutX(400);
        choice.setLayoutY(30);
        choice.setBlendMode(BlendMode.HARD_LIGHT);
        choice.setCursor(Cursor.CLOSED_HAND);
//        DropShadow effect=new DropShadow();
//        effect.setOffsetX(8);
//        effect.setOffsetY(8);
//        choice.setEffect(effect);
        choice.setStyle("-fx-text-fill:#000000;-fx-border-width:5pt;-fx-border-color:#d2691e;-fx-font:bold italic 14pt Georgia;");
        choice.setPrefSize(200, 50);
        choice.setTooltip(new Tooltip("Выберите сайт"));
        choice.getSelectionModel().selectFirst();
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String> () {
            public void changed (ObservableValue<? extends String> ov, String old_val, String new_val) {
                if(new_val.equals("Lenta.ru")){
//                    imvR.setVisible(true);
//                    imvU.setVisible(false);
//                    imvG.setVisible(false);
                }
                if(new_val.equals("Tool.ru")){
//                    imvU.setVisible(true);
//                    imvR.setVisible(false);
//                    imvG.setVisible(false);
                };
                if(new_val.equals("Static.ru")){
//                    imvG.setVisible(true);
//                    imvR.setVisible(false);
//                    imvU.setVisible(false);
                }
            } });
//        Label label=new Label("ТОР20 Отелей Турции");
//        label.setLayoutX(400);
//        label.setLayoutY(110);
//        label.setPrefSize(500, 30);
//        label.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:#000066;-fx-background-color:lightgrey;");
//        label.setAlignment(Pos.CENTER);

        //ListTable
        ObservableList<Hotel> hotels =
                FXCollections.observableArrayList(
//                        new Hotel("Amara Dolce Vita","Кемер","HV1",4.5),
//                        new Hotel("Club Boran Mare Beach","Кемер","HV1",4.7),
                        new Hotel("Путин В.В.",10000.0),
                        new Hotel("Медведев Д.Н.",9000.0),
                        new Hotel("Навальный А.А.",4000.0));

        TableView<Hotel> table = new TableView<Hotel>();
        table.setLayoutX(400);
        table.setLayoutY(150);
        table.setTableMenuButtonVisible(true);
        table.setCursor(Cursor.TEXT);
        table.setTooltip(new Tooltip("Общая статистика"));
        table.setStyle("-fx-font: 14pt Arial;");
        table.setPrefWidth(500);
        table.setPrefHeight(200);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn nameCol = new TableColumn("Имя");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Hotel,String>("name")
        );



//        TableColumn resortCol = new TableColumn("Количество упоминаний");
//        resortCol.setCellValueFactory(
//                new PropertyValueFactory<Hotel,String>("resort")
//        );


//        TableColumn categoryCol = new TableColumn("Категория");
//        categoryCol.setCellValueFactory(
//                new PropertyValueFactory<Hotel,String>("category")
//        );
//
        TableColumn rateCol = new TableColumn("Количество упоминаний");
        rateCol.setCellValueFactory(
                new PropertyValueFactory<Hotel,String>("rate")
        );
        rateCol.setPrefWidth(250);
        rateCol.setResizable(false);
        rateCol.setSortable(true);

        table.setItems(hotels);
        table.getColumns().addAll(nameCol, rateCol);
        //Button
        Button btn = new Button();
        btn.setLayoutX(710);
        btn.setLayoutY(40);
        btn.setText("Применить");
        btn.setCursor(Cursor.CLOSED_HAND);
        btn.setStyle("-fx-font: bold italic 14pt Georgia;-fx-text-fill: white;-fx-background-color: #a0522d;-fx-border-width: 3px; -fx-border-color:#f4a460 #800000 #800000 #f4a460;" );
        btn.setPrefSize(170,30);
        btn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
       System.out.println( label1.getText());
    }
});

        root.getChildren().add(label1);
        root.getChildren().add(btn);
        root.getChildren().add (choice);
//        root.getChildren().add(label);
        root.getChildren().add(table);

    }
}
