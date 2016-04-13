package de.creative.musiclib.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.creative.musiclib.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;

public class SongAnalysisController {
	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private LineChart<String, Integer> lineChart;

	@FXML
	private PieChart pieChart;

	@FXML
	private CategoryAxis xAxis;
	
@FXML
private Label headlineJahr;

@FXML
private Label headlineTonartRechts;
@FXML
private Label headlineTonartLinks;

	private ObservableList<String> tonarten = FXCollections.observableArrayList();

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Get an array with the English month names.
		String[] array_tonarten = { "C", "Cm", "C#", "C#m", "D", "Dm", "D#", "D#m", "E", "Em", "F", "Fm", "F#", "F#m",
				"G", "Gm", "G#", "G#m", "A", "Am", "A#", "A#m", "H", "Hm" };
		// Convert it to a list and add it to our ObservableList of months.
		tonarten.addAll(Arrays.asList(array_tonarten));

		// Assign the month names as categories for the horizontal axis.
		xAxis.setCategories(tonarten);
		headlineJahr.setText("Veröffentlichungsjahre der Songs");
		headlineTonartRechts.setText("Tonarten der Songs");
		headlineTonartLinks.setText("Tonarten der Songs");
	}

	/**
	 * Sets the persons to show the statistics for.
	 * 
	 * @param listOfSongs
	 */
	public void setPersonData(List<Song> listOfSongs) {
		// Count the number of people having their birthday in a specific month.
		int[] songCounter = new int[24];
		List<Integer> jahrLabel = new ArrayList<>();
		Map<Integer, Integer> jahrCounter = new HashMap<>();
		for (Song pSong : listOfSongs) {
			int songIndex = tonarten.indexOf(pSong.getTonart());
			songCounter[songIndex]++;
			if (jahrCounter.containsKey(pSong.getPublishYear())) {
				int a = jahrCounter.get(pSong.getPublishYear());
				a++;
				jahrCounter.remove(pSong.getPublishYear());
				jahrCounter.put(pSong.getPublishYear(), a);
			} else {
				jahrCounter.put(pSong.getPublishYear(), 1);
				jahrLabel.add(pSong.getPublishYear());
			}
		}

		XYChart.Series<String, Integer> seriesBar = new XYChart.Series<>();
		ObservableList<Data> seriesPie = FXCollections.observableArrayList();
		// Create a XYChart.Data object for each month. Add it to the series.
		for (int i = 0; i < songCounter.length; i++) {
			seriesBar.getData().add(new XYChart.Data<>(tonarten.get(i), songCounter[i]));
			seriesPie.add(new PieChart.Data(tonarten.get(i), songCounter[i]));
		}

		barChart.getData().add(seriesBar);

		pieChart.setData(seriesPie);
		pieChart.setLegendSide(Side.LEFT);
		pieChart.setClockwise(false);
		pieChart.setLabelsVisible(true);
		Collections.sort(jahrLabel);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		// series.setName("XYChart.Series");
		for (int pKey : jahrLabel) {
			String key = pKey + "";
			System.out.println(key);
			int value = jahrCounter.get(pKey);
			series.getData().add(new XYChart.Data<>(key, value));
		}
		lineChart.getData().add(series);
	}
}
