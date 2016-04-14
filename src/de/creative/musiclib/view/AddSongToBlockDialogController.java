package de.creative.musiclib.view;

import de.creative.musiclib.model.Block;
import de.creative.musiclib.model.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSongToBlockDialogController {

	@FXML
	private ComboBox<String> songombo;

	@FXML
	private ComboBox<String> positionCombo;

	@FXML
	private Button okStandardButton;

	@FXML
	private TextField songtransitionField;

	@FXML
	private Button cancelStandardButton;

	private boolean okClicked = false;

	private Block block;
	private Stage dialogStage;

	@FXML
	private void initialize() {
		positionCombo.getItems().clear();
		positionCombo.getItems().addAll("1", "2", "3", "4", "5", "6");
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setBlock(Block pBlock) {
		block = pBlock;
		
	}

	public void setSongData(ObservableList<Song> pSongData) {
		songombo.getItems().clear();
		for (Song pSong : pSongData) {
		songombo.getItems().add(pSong.getSongName());
		}

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
			switch (positionCombo.getSelectionModel().getSelectedItem()) {

			case "1":
				block.setSong1(songombo.getSelectionModel().getSelectedItem());
				block.setSong1transition(songtransitionField.getText());
				break;
			case "2":
				block.setSong2(songombo.getSelectionModel().getSelectedItem());
				block.setSong2transition(songtransitionField.getText());
				break;
			case "3":
				block.setSong3(songombo.getSelectionModel().getSelectedItem());
				block.setSong3transition(songtransitionField.getText());
				break;
			case "4":
				block.setSong4(songombo.getSelectionModel().getSelectedItem());
				block.setSong4transition(songtransitionField.getText());
				break;
			case "5":
				block.setSong5(songombo.getSelectionModel().getSelectedItem());
				block.setSong5transition(songtransitionField.getText());
				break;
			case "6":
				block.setSong6(songombo.getSelectionModel().getSelectedItem());
				block.setSong6transition(songtransitionField.getText());
				break;
			default:
				break;

			}

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
