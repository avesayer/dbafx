package com.msokolov.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

	@FXML private FileController fileTabController;

	@FXML private void initialize() {
		fileTabController.injectMainController(this);
    }

	public void settingsAction() throws Exception {
		System.out.println("settingsAction");

		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(fileTabController.getWindow());

		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Settings.fxml")));
		stage.setScene(scene);
		stage.showAndWait();
	}

	public void updateEnvironmentAction() {
		System.out.println("updateEnvironmentAction");

		// ObservableList<Table> view = tblView.getItems();
		// view.forEach(e -> System.out.println(e.getName() + " " + e.getDescription()));
	}

	public void updateTableAction() {
		System.out.println("updateTableAction");
	}
}
