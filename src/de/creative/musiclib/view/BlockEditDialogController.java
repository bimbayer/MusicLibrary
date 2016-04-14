package de.creative.musiclib.view;

import de.creative.musiclib.model.Block;
import de.creative.musiclib.model.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BlockEditDialogController {

	@FXML
	private TextField blockNameField;
	@FXML
	private TextField song1transitionField;
	@FXML
	private TextField song2transitionField;
	@FXML
	private TextField song3transitionField;
	@FXML
	private TextField song4transitionField;
	@FXML
	private TextField song5transitionField;
	@FXML
	private TextField song6transitionField;
	@FXML
	private ComboBox<String> song1Combo;
	@FXML
	private ComboBox<String> song2Combo;
	@FXML
	private ComboBox<String> song3Combo;
	@FXML
	private ComboBox<String> song4Combo;
	@FXML
	private ComboBox<String> song5Combo;
	@FXML
	private ComboBox<String> song6Combo;

	private Stage dialogStage;
	private Block block;
	private boolean okClicked = false;
	private ObservableList<Song> songData;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

	}

	private void fillComboBox(ComboBox<String> pComboBox) {
		pComboBox.getItems().clear();
		pComboBox.getItems().add("");
		for (Song pSong : songData) {
			pComboBox.getItems().add(pSong.getSongName());
		}

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage, ObservableList<Song> pSongData) {
		this.dialogStage = dialogStage;
		this.songData = pSongData;

		fillComboBox(song1Combo);
		fillComboBox(song2Combo);
		fillComboBox(song3Combo);
		fillComboBox(song4Combo);
		fillComboBox(song5Combo);
		fillComboBox(song6Combo);
	}

	/**
	 * Sets the Block to be edited in the dialog.
	 * 
	 * @param pBlock
	 */
	public void setBlock(Block pBlock) {
		this.block = pBlock;

		blockNameField.setText(pBlock.getBlockName());
		song1Combo.getSelectionModel().select(pBlock.getSong1());
		song2Combo.getSelectionModel().select(pBlock.getSong2());
		song3Combo.getSelectionModel().select(pBlock.getSong3());
		song4Combo.getSelectionModel().select(pBlock.getSong4());
		song5Combo.getSelectionModel().select(pBlock.getSong5());
		song6Combo.getSelectionModel().select(pBlock.getSong6());
		
		song1transitionField.setText(pBlock.getSong1transition());
		song2transitionField.setText(pBlock.getSong2transition());
		song3transitionField.setText(pBlock.getSong3transition());
		song4transitionField.setText(pBlock.getSong4transition());
		song5transitionField.setText(pBlock.getSong5transition());
		song6transitionField.setText(pBlock.getSong6transition());
		
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
			block.setBlockName(blockNameField.getText());
			block.setSong1(song1Combo.getSelectionModel().getSelectedItem());
			block.setSong2(song2Combo.getSelectionModel().getSelectedItem());
			block.setSong3(song3Combo.getSelectionModel().getSelectedItem());
			block.setSong4(song4Combo.getSelectionModel().getSelectedItem());
			block.setSong5(song5Combo.getSelectionModel().getSelectedItem());
			block.setSong6(song6Combo.getSelectionModel().getSelectedItem());
			
			block.setSong1transition(song1transitionField.getText());
			block.setSong2transition(song2transitionField.getText());
			block.setSong3transition(song3transitionField.getText());
			block.setSong4transition(song4transitionField.getText());
			block.setSong5transition(song5transitionField.getText());
			block.setSong6transition(song6transitionField.getText());

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

		if (blockNameField.getText() == null || blockNameField.getText().length() == 0) {
			errorMessage += "No valid Block name!\n";
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