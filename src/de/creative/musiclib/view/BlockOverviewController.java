package de.creative.musiclib.view;

import de.creative.musiclib.MainApp;
import de.creative.musiclib.model.Block;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BlockOverviewController {
	@FXML
	private TableView<Block> blockTable;
	@FXML
	private TableColumn<Block, String> blockNameColumn;

	@FXML
	private Label blockNameLabel;
	@FXML
	private Label song1Label;
	@FXML
	private Label song2Label;
	@FXML
	private Label song3Label;
	@FXML
	private Label song4Label;
	@FXML
	private Label song5Label;
	@FXML
	private Label song6Label;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BlockOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		blockNameColumn.setCellValueFactory(cellData -> cellData.getValue().blockNameProperty());

		// Clear person details.
		blockTable.getSelectionModel().select(1);
		// showPersonDetails(blockTable.getSelectionModel().getSelectedItem());

		// Listen for selection changes and show the person details when
		// changed.
		blockTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = blockTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			blockTable.getItems().remove(selectedIndex);
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
		blockTable.setItems(mainApp.getBlockData());
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param pBlock
	 *            the person or null
	 */
	private void showPersonDetails(Block pBlock) {
		if (pBlock != null) {
			// Fill the labels with info from the person object.
			blockNameLabel.setText(pBlock.getBlockName());
			song1Label.setText(pBlock.getSong1());
			song3Label.setText(pBlock.getSong3());
			song4Label.setText(pBlock.getSong4());
			song2Label.setText(pBlock.getSong2());
			song5Label.setText(pBlock.getSong5());
			song6Label.setText(pBlock.getSong6());
		} else {
			// Person is null, remove all the text.
			blockNameLabel.setText("");
			song1Label.setText("");
			song2Label.setText("");
			song3Label.setText("");
			song4Label.setText("");
			song5Label.setText("");
			song6Label.setText("");
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		System.out.println("NEW");
		Block tempBlock = new Block();
		boolean okClicked = mainApp.showBlockEditDialog(tempBlock);
		if (okClicked) {
			mainApp.getBlockData().add(tempBlock);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		Block selectedBlock = blockTable.getSelectionModel().getSelectedItem();
		if (selectedBlock != null) {
			boolean okClicked = mainApp.showBlockEditDialog(selectedBlock);
			if (okClicked) {
				showPersonDetails(selectedBlock);
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