package de.creative.musiclib.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FormatDialogController {

	@FXML
	private RadioButton customRadioButton;

	@FXML
	private RadioButton emptyRadioButton;

	@FXML
	private RadioButton standardRadioButton;

	@FXML
	private Button okStandardButton;

	@FXML
	private Button cancelStandardButton;

	private boolean okClicked = false;

	private int selectedChoice;
	private Stage dialogStage;

	public int getSelectedChoice() {
		return selectedChoice;
	}

	@FXML
	private void initialize() {

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
			selectedChoice = checkRadioButtons();
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

	private int checkRadioButtons() {

		if (standardRadioButton.isPressed())
			return 0;

		if (customRadioButton.isPressed())
			return 1;

		if (emptyRadioButton.isPressed())
			return 2;

		return 0;
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (!customRadioButton.isPressed() && !emptyRadioButton.isPressed() && !standardRadioButton.isPressed()) {
			errorMessage += "No Option selected!\n";
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
