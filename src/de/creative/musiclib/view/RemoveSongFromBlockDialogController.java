package de.creative.musiclib.view;

import java.util.ArrayList;
import java.util.List;

import de.creative.musiclib.model.Block;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RemoveSongFromBlockDialogController {

	@FXML
	private Button cancelCustomButton;

	@FXML
	private Button okCustomButton;

	@FXML
	private Label blocknameLabel;

	@FXML
	private ComboBox<String> songCombo;
	private Stage dialogStage;
	private Block block;
	private boolean okClicked = false;
	private List<Integer> songList;

	@FXML
	private void initialize() {
		songList = new ArrayList<Integer>();
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	public void setBlock(Block pBlock) {
		block = pBlock;

		blocknameLabel.setText(block.getBlockName());

		songCombo.getItems().clear();

		if (block.getSong1().length() != 0) {
			songCombo.getItems().add(block.getSong1());
			songList.add(1);
		}
		if (block.getSong2().length() != 0) {
			songCombo.getItems().add(block.getSong2());
			songList.add(2);
		}
		if (block.getSong3().length() != 0) {
			songCombo.getItems().add(block.getSong3());
			songList.add(3);
		}
		if (block.getSong4().length() != 0) {
			songCombo.getItems().add(block.getSong4());
			songList.add(4);
		}
		if (block.getSong5().length() != 0) {
			songCombo.getItems().add(block.getSong5());
			songList.add(5);
		}
		if (block.getSong6().length() != 0) {
			songCombo.getItems().add(block.getSong6());
			songList.add(6);
		}
		songCombo.getSelectionModel().select(0);
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private void delete(int pIndex) {
		switch (pIndex) {

		case 1:
			block.setSong1("");
			block.setSong1transition("");
			break;
		case 2:
			block.setSong2("");
			block.setSong2transition("");
			break;
		case 3:
			block.setSong3("");
			block.setSong3transition("");
			break;
		case 4:
			block.setSong4("");
			block.setSong4transition("");
			break;
		case 5:
			block.setSong5("");
			block.setSong5transition("");
			break;
		case 6:
			block.setSong6("");
			block.setSong6transition("");
			break;
		default:
			break;
		}
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		switch (songCombo.getSelectionModel().getSelectedIndex()) {
		case 0:
			delete(songList.get(0));
			break;
		case 1:
			delete(songList.get(1));
			break;
		case 2:
			delete(songList.get(2));
			break;
		case 3:
			delete(songList.get(3));
			break;
		case 4:
			delete(songList.get(4));
			break;
		case 5:
			delete(songList.get(5));
			break;
		default:
			break;
		}

		okClicked = true;
		dialogStage.close();
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

}
