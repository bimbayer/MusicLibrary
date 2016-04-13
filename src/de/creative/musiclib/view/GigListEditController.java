package de.creative.musiclib.view;

import de.creative.musiclib.MainApp;
import de.creative.musiclib.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class GigListEditController {
	@FXML
	private TableView<Song> songTable;
	@FXML
	private TableColumn<Song, String> songNameColumn;
	@FXML
	private TableColumn<Song, String> tonartColumn;

	@FXML
	private TableColumn<Song, String> singerColumn;
	private MainApp mainApp;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		songNameColumn.setCellValueFactory(cellData -> cellData.getValue().songNameProperty());
		tonartColumn.setCellValueFactory(cellData -> cellData.getValue().tonartProperty());
		singerColumn.setCellValueFactory(cellData -> cellData.getValue().singerProperty());

		// Clear person details.
		songTable.getSelectionModel().select(1);

		// Listen for selection changes and show the person details when
		// changed.
//		songTable.getSelectionModel().selectedItemProperty()
//				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		songTable.setItems(mainApp.getSongData());
	}

	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Songlibrary");
		alert.setHeaderText("About");
		alert.setContentText("Author: Tim Bayer");

		alert.showAndWait();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}
}
