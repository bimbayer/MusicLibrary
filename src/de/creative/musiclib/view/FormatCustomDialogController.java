package de.creative.musiclib.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormatCustomDialogController {

	@FXML
	private Button cancelCustomButton;

	@FXML
	private Button okCustomButton;

	@FXML
	private TextField songCountField;

	@FXML
	private ComboBox<String> pauseCombo;
	private Stage dialogStage;

	private int[] selectedInputs = new int[2];

	@FXML
	private void initialize() {

		pauseCombo.getItems().clear();
		pauseCombo.getItems().addAll("Keine Pause", "Eine Pause", "Zwei Pausen", "Drei Pausen");

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
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		// if (isInputValid()) {
		// song.setSongName(songNameField.getText());
		// song.setAuthor(authorField.getText());
		// song.setSinger(singerCombo.getSelectionModel().getSelectedItem());
		// song.setChordsIntro(introField.getText());
		// song.setChordsVerse(verseField.getText());
		// song.setChordsRefrain(chorusField.getText());
		// song.setPublishYear(Integer.parseInt(yearField.getText()));
		// song.setChordsBridge(bridgeField.getText());
		// song.setChordsPreRefrain(preChorusField.getText());
		// song.setTonart(tonartCombo.getSelectionModel().getSelectedItem());
		// // TODO: Integer Prüfung einfügen!
		// song.setKapo(Integer.parseInt(kapoField.getText()));
		//
		// okClicked = true;
		// dialogStage.close();
		// }
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	public int[] selectInputs() {
		// TODO Auto-generated method stub
		return null;
	}
}
