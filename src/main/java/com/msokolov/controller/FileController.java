package com.msokolov.controller;

import com.msokolov.model.Record;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class FileController {

	@FXML private TableView<Record> fileView;
	@FXML private TableColumn<Record, String> fileNameColumn;
	@FXML private TableColumn<Record, String> fileDescColumn;
	@FXML private TextField fileSearch;
	private ObservableList<Record> fileData = FXCollections.observableArrayList();

	@FXML private TableView<Record> fieldView;
	@FXML private TableColumn<Record, String> fieldNameColumn;
	@FXML private TableColumn<Record, String> fieldDescColumn;
	@FXML private TextField fieldSearch;
	private ObservableList<Record> fieldData = FXCollections.observableArrayList();

	private MainController mainController;
	
	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Window getWindow() {
		return fileSearch.getScene().getWindow();
	}
	
	public void initialize() {
		System.out.println("FileController.initialize");

		fileData.add(new Record("ACN", "This is ACN"));
		fileData.add(new Record("DEP", "This is DEP"));
		fileData.add(new Record("LN", "This is LN"));

		fieldData.add(new Record("ACN", "This is ACN"));
		fieldData.add(new Record("DEP", "This is DEP"));
		fieldData.add(new Record("LN", "This is LN"));

		initializeTableView(fileView, fileNameColumn, fileDescColumn, fileData, fileSearch);
		initializeTableView(fieldView, fieldNameColumn, fieldDescColumn, fieldData, fieldSearch);
	}

	private void initializeTableView(TableView<Record> tableView,
									 TableColumn<Record, String> column1, 
									 TableColumn<Record, String> column2,
									 ObservableList<Record> data,
									 TextField searchField) {

		column1.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		column2.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

		
		FilteredList<Record> filteredList = new FilteredList<>(data, p -> true);
		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(table -> {
				// If filter text is empty, display all file records.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare name and description of every record with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (table.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches name.
				} else if (table.getDescription().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches description.
				}
				return false; // Does not match.
			});
		});

		SortedList<Record> sortedData = new SortedList<>(filteredList);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedData);
	}
}
