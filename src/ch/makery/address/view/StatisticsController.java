package ch.makery.address.view;

import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import ch.makery.address.model.convertedFigure;

/**
 * The controller for the birthday statistics view.
 * 
 * @author Marco Jakob
 */
public class StatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> typeNames = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        String[] types = {"Cirle", "Rectangle", "Trapezium"};
        // Convert it to a list and add it to our ObservableList of types.
        typeNames.addAll(Arrays.asList(types));

        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(typeNames);
    }

    /**
     * Sets the persons to show the statistics for.
     * 
     * @param persons
     */
    public void setPersonData(List<convertedFigure> persons) {
        // Count the number of people having their birthday in a specific month.
        int[] typeCounter = new int[3];
        for (convertedFigure p : persons) {
            String typeName = p.getType();
            int type = 0;
            for (int i = 0; i < typeNames.size(); i++) {
				if (typeName == typeNames.get(i)) {
					type = i;
				}
			}
            typeCounter[type]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < typeCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(typeNames.get(i), typeCounter[i]));
        }

        barChart.getData().add(series);
    }
}