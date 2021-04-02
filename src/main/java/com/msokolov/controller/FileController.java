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

	private MainController mainController;

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

	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Window getWindow() {
		return fileSearch.getScene().getWindow();
	}
	
	public void initialize() {
		System.out.println("FileController.initialize");

		insertData();

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

		// tableView.setStyle("-fx-focus-color: transparent; -fx-font-size:14px;");

		SortedList<Record> sortedData = new SortedList<>(filteredList);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedData);
	}

	private void insertData() {
		
		fileData.add(new Record("ABPJNL", "Activate for Bill Pay Journal"));
		fileData.add(new Record("ACCTBENDTL", "Account Beneficiary Details"));
		fileData.add(new Record("ACCTTOEVENTS", "Account to Events"));
		fileData.add(new Record("ACH", "ACH Batch Information"));
		fileData.add(new Record("ACH1", "ACH Batch Description"));
		fileData.add(new Record("ACH2", "ACH Detail Information"));
		fileData.add(new Record("ACH2HIS", "ACH Detail History"));
		fileData.add(new Record("ACH2HISD", "ACH Detail History - Data Items"));
		fileData.add(new Record("ACHBCH", "ACH File Batch Header/Trailer"));
		fileData.add(new Record("ACHDTL", "ACH Detail Record"));
		fileData.add(new Record("ACHF", "Extract Recs for Outgoing Clearing Items"));
		fileData.add(new Record("ACHFIL", "ACH File Header & Trailer"));
		fileData.add(new Record("ACHINCB", "ACH Inclearing Batch Info"));
		fileData.add(new Record("ACHINCD", "ACH Inclearing Detail Info"));
		fileData.add(new Record("ACHINCDA", "ACH Addenda Information"));
		fileData.add(new Record("ACHINCF", "ACH Inclearing File Header"));
		fileData.add(new Record("ACHINCTMP", "ACH Inclearing Rpt - System Use"));
		fileData.add(new Record("ACHORIG", "Extract file count for ACH origination"));
		fileData.add(new Record("ACN", "Account file"));

		fieldData.add(new Record("ACN", "This is ACN"));
		fieldData.add(new Record("DEP", "This is DEP"));
		fieldData.add(new Record("LN", "This is LN"));
	}
}
