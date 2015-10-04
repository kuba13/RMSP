package rmsp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private GridPane root;

    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private LineChart<Number, Number> chart;

    private void initComponents() {
        root = new GridPane();

        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        chart = new LineChart<Number, Number>(xAxis, yAxis);

        root.add(chart, 0, 0);
    }

    public void setValues(final Value[] data) {
        Platform.runLater(new Runnable() {
            public void run() {
                XYChart.Series valueSeries = new XYChart.Series();
                XYChart.Series confidenceMinSeries = new XYChart.Series();
                XYChart.Series confidenceMaxSeries = new XYChart.Series();

                valueSeries.setName("Value");
                confidenceMinSeries.setName("Confidence min");
                confidenceMaxSeries.setName("Confidence max");

                for (int i = 0; i < data.length; i++) {
                    valueSeries.getData().add(new XYChart.Data(i, data[i].getValue()));
                    confidenceMinSeries.getData().add(new XYChart.Data(i, data[i].getConfidenceMin()));
                    confidenceMaxSeries.getData().add(new XYChart.Data(i, data[i].getConfidenceMax()));
                }

                chart.getData().clear();
                chart.getData().addAll(confidenceMinSeries, valueSeries, confidenceMaxSeries);
            }
        });
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        initComponents();

        Generator generator = new Generator(this);
        generator.start();

        primaryStage.setTitle("RMSP");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
