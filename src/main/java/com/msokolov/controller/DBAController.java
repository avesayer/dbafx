package com.msokolov.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.msokolov.model.Field;
import com.msokolov.model.Table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DBAController implements Initializable {

	private ObservableList<Table> tableData = FXCollections.observableArrayList();

	@FXML
	private TextField tableSearchField;

	@FXML
	private TableView<Table> tblView;

	@FXML
	private TableView<Field> fieldView;

	@FXML
	private TableColumn<Table, String> tableColumnName;

	@FXML
	private TableColumn<Table, String> tableColumnDesc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("DBAController.initialize");

		tableColumnName.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
        tableColumnDesc.setCellValueFactory(new PropertyValueFactory<Table, String>("description"));

		tableData.add(new Table("ACN", "This is ACN"));
		tblView.setItems(tableData);

		ObservableList<Table> view = tblView.getItems();
		view.forEach(e -> System.out.println(e.getName() + " " + e.getDescription()));

	}

	public void updateAllAction() {
		System.out.println("updateAllAction");

		ObservableList<Table> view = tblView.getItems();
		view.forEach(e -> System.out.println(e.getName() + " " + e.getDescription()));
	}

	public void settingsAction() throws Exception {
		System.out.println("settingsAction");

		Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(tableSearchField.getScene().getWindow());

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/settings.fxml")));
        stage.setScene(scene);
        stage.show();
	}

	public void updateEnvironmentAction() {
		System.out.println("updateEnvironmentAction");
		
	}
	public void updateTableAction() {
		System.out.println("updateTableAction");
	}
}
