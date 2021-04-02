package com.msokolov.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuBarController {

	private MainController mainController;
	
	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void settingsAction() throws Exception {
		System.out.println("settingsAction");

		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(mainController.getWindow());

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Settings.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.showAndWait();

		SettingsController settingsController = (SettingsController) fxmlLoader.getController();
		// System.out.println(settingsController.getEnvironment());
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
