package de.creative.musiclib.view;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import de.creative.musiclib.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;

/**
 * The controller for the birthday statistics view.
 * 
 */
public class SingerStatisticsController {

	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private PieChart pieChart;

	@FXML
	private CategoryAxis xAxis;

	private ObservableList<String> singerNames = FXCollections.observableArrayList();

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Get an array with the English month names.
		String[] months = { "Lars", "Isabella", "Till", "Fabio", "Mehrstimmig" };
		// Convert it to a list and add it to our ObservableList of months.
		singerNames.addAll(Arrays.asList(months));

		// Assign the month names as categories for the horizontal axis.
		xAxis.setCategories(singerNames);
	}

	/**
	 * Sets the persons to show the statistics for.
	 * 
	 * @param persons
	 */
	public void setPersonData(List<Song> persons) {
		// Count the number of people having their birthday in a specific month.
		int[] songCounter = new int[5];
		for (Song p : persons) {
			int singer = singerNames.indexOf(p.getSinger());
			songCounter[singer]++;
		}

		XYChart.Series<String, Integer> seriesBar = new XYChart.Series<>();
		ObservableList<Data> seriesPie = FXCollections.observableArrayList();
		// Create a XYChart.Data object for each month. Add it to the series.
		for (int i = 0; i < songCounter.length; i++) {
			seriesBar.getData().add(new XYChart.Data<>(singerNames.get(i), songCounter[i]));
			seriesPie.add(new PieChart.Data(singerNames.get(i), songCounter[i]));
		}

		barChart.getData().add(seriesBar);

		pieChart.setData(seriesPie);
		pieChart.setLegendSide(Side.LEFT);
		pieChart.setClockwise(false);
		pieChart.setLabelsVisible(false);
	}
}