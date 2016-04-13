package de.creative.musiclib.view;

import de.creative.musiclib.MainApp;
import de.creative.musiclib.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SongOverviewController {
	@FXML
	private TableView<Song> songTable;
	@FXML
	private TableColumn<Song, String> songNameColumn;
	@FXML
	private TableColumn<Song, String> tonartColumn;

	@FXML
	private TableColumn<Song, String> singerColumn;

	@FXML
	private Label songNameLabel;
	@FXML
	private Label authorLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Label singerLabel;
	@FXML
	private Label introLabel;
	@FXML
	private Label verseLabel;
	@FXML
	private Label preChorusLabel;
	@FXML
	private Label chorusLabel;
	@FXML
	private Label bridgeLabel;
	@FXML
	private Label kappoLabel;
	@FXML
	private Label tonartLabel;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public SongOverviewController() {
	}

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
		showPersonDetails(songTable.getSelectionModel().getSelectedItem());

		// Listen for selection changes and show the person details when
		// changed.
		songTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = songTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			songTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
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
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param pSong
	 *            the person or null
	 */
	private void showPersonDetails(Song pSong) {
		if (pSong != null) {
			// Fill the labels with info from the person object.
			songNameLabel.setText(pSong.getSongName());
			authorLabel.setText(pSong.getAuthor());
			singerLabel.setText(pSong.getSinger());
			introLabel.setText(pSong.getChordsIntro());
			chorusLabel.setText(pSong.getChordsRefrain());
			yearLabel.setText(Integer.toString(pSong.getPublishYear()));
			verseLabel.setText(pSong.getChordsVerse());
			preChorusLabel.setText(pSong.getChordsPreRefrain());
			bridgeLabel.setText(pSong.getChordsBridge());
			tonartLabel.setText(pSong.getTonart());
			kappoLabel.setText(Integer.toString(pSong.getKapo()));
		} else {
			// Person is null, remove all the text.
			songNameLabel.setText("");
			authorLabel.setText("");
			yearLabel.setText("");
			singerLabel.setText("");
			introLabel.setText("");
			verseLabel.setText("");
			preChorusLabel.setText("");
			chorusLabel.setText("");
			bridgeLabel.setText("");
			tonartLabel.setText("");
			kappoLabel.setText("");
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		System.out.println("NEW");
		Song tempPerson = new Song();
		boolean okClicked = mainApp.showSongEditDialog(tempPerson);
		if (okClicked) {
			mainApp.getSongData().add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		Song selectedPerson = songTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showSongEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
}