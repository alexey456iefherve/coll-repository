package chapter8_javaFX_8.ChartApp1.src;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Listing 8-1
public class ChartApp1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PieChart pieChart = new PieChart();
        pieChart.setData(getChartData());
        primaryStage.setTitle("PieChart");

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private ObservableList<Data> getChartData() {
        ObservableList<Data> answer = FXCollections.observableArrayList();
        answer.addAll(new Data("java", 17.56),
                new Data("C", 17.06),
                new Data("C++", 8.25),
                new Data("C#", 8.20),
                new Data("ObjectiveC", 6.8),
                new Data("PHP", 6.0),
                new Data("(Visual)Basic", 4.76),
                new Data("Other", 31.37));
        return answer;
    }
}