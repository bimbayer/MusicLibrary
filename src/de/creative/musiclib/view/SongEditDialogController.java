package de.creative.musiclib.view;

import de.creative.musiclib.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SongEditDialogController {

	@FXML
	private TextField songNameField;
	@FXML
	private TextField authorField;
	@FXML
	private TextField yearField;
	@FXML
	private ComboBox<String> singerCombo;
	@FXML
	private TextField introField;
	@FXML
	private TextField verseField;
	@FXML
	private TextField preChorusField;
	@FXML
	private TextField chorusField;
	@FXML
	private TextField bridgeField;
	@FXML
	private TextField kapoField;
	@FXML
	private ComboBox<String> tonartCombo;

	private Stage dialogStage;
	private Song song;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		singerCombo.getItems().clear();
		singerCombo.getItems().addAll("Lars", "Isabella", "Till", "Fabio", "Mehrstimmig");

		tonartCombo.getItems().clear();
		tonartCombo.getItems().addAll("C", "Cm", "C#", "C#m", "D", "Dm", "D#", "D#m", "E", "Em", "F", "Fm", "F#", "F#m",
				"G", "Gm", "G#", "G#m", "A", "Am", "A#", "A#m", "H", "Hm");
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the Song to be edited in the dialog.
	 * 
	 * @param pSong
	 */
	public void setSong(Song pSong) {
		this.song = pSong;

		songNameField.setText(pSong.getSongName());
		authorField.setText(pSong.getAuthor());
		singerCombo.getSelectionModel().select(pSong.getSinger());
		introField.setText(pSong.getChordsIntro());
		chorusField.setText(pSong.getChordsRefrain());
		yearField.setText(Integer.toString(pSong.getPublishYear()));
		verseField.setText(pSong.getChordsVerse());
		bridgeField.setText(pSong.getChordsBridge());
		preChorusField.setText(pSong.getChordsPreRefrain());
		tonartCombo.getSelectionModel().select(pSong.getTonart());
		kapoField.setText(Integer.toString(pSong.getKapo()));
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			song.setSongName(songNameField.getText());
			song.setAuthor(authorField.getText());
			song.setSinger(singerCombo.getSelectionModel().getSelectedItem());
			song.setChordsIntro(introField.getText());
			song.setChordsVerse(verseField.getText());
			song.setChordsRefrain(chorusField.getText());
			song.setPublishYear(Integer.parseInt(yearField.getText()));
			song.setChordsBridge(bridgeField.getText());
			song.setChordsPreRefrain(preChorusField.getText());
			song.setTonart(tonartCombo.getSelectionModel().getSelectedItem());
			// TODO: Integer Prüfung einfügen!
			song.setKapo(Integer.parseInt(kapoField.getText()));

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (songNameField.getText() == null || songNameField.getText().length() == 0) {
			errorMessage += "No valid Song name!\n";
		}

		// if (singerField.getText() == null || singerField.getText().length()
		// == 0) {
		// errorMessage += "No valid singer!\n";
		// }

		// if (tonartCombo.getText() == null || tonartCombo.getText().length()
		// == 0) {
		// errorMessage += "No valid postal code!\n";
		// }

		if (verseField.getText() == null || verseField.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		if (chorusField.getText() == null || chorusField.getText().length() == 0) {
			errorMessage += "No valid birthday!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}