package de.creative.musiclib.view;

import java.io.File;

import de.creative.musiclib.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 */
public class RootLayoutController {

	// Reference to the main application
	private MainApp mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		mainApp.getSongData().clear();
		mainApp.setSongFilePath(null);
	}

	/**
	 * Opens the Singer statistics.
	 */
	@FXML
	private void handleShowSingerStatistics() {
		mainApp.showSingerStatistics();
	}

	/**
	 * Opens the Song Analyse.
	 */
	@FXML
	private void handleShowSongAnalysis() {
		mainApp.showSongAnalysis();
	}

	/**
	 * Opens the Gig List View.
	 */
	@FXML
	private void handleShowGigList() {
		mainApp.showGiglistOverview();
	}

	/**
	 * Opens the Gig List View.
	 */
	@FXML
	private void handleShowBlockOverView() {
		mainApp.showBlockOverview();
	}
	/**
	 * Opens the Gig List View.
	 */
	@FXML
	private void handleShowSongOverView() {
		mainApp.showSongOverview();
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		System.out.println("HANDLEOPEN \n");
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			mainApp.loadSongDataFromFile(file);
		}
	}

	/**
	 * Saves the file to the person file that is currently open. If there is no
	 * open file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleSave() {
		File personFile = mainApp.getSongFilePath();
		if (personFile != null) {
			mainApp.saveSongDataToFile(personFile);
		} else {
			handleSaveAs();
		}
	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveSongDataToFile(file);
		}
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