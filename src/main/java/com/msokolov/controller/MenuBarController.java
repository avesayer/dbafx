package com.msokolov.controller;

import java.sql.SQLException;
import java.util.List;

import com.msokolov.model.Environment;
import com.msokolov.model.File;
import com.msokolov.service.SQLService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MenuBarController {

	private MainController mainController;
	private FileController fileController;
	
	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void injectFileController(FileController fileController) {
		this.fileController = fileController;
	}

	public void settingsAction() throws Exception {
		System.out.println("settingsAction");

		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(mainController.getWindow());

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Settings.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.showAndWait();

		SettingsController settingsController = (SettingsController) fxmlLoader.getController();
		
		Environment environment = settingsController.getEnvironment();
		System.out.println(environment);
		SQLService sqlService = new SQLService(environment.getAddress(), environment.getPort(), environment.getUser(), environment.getPassword());

		try {
			sqlService.connect();
			List<File> fileList = sqlService.getFileList();

			// System.out.println(fileList);
			fileController.updateFileList(fileList);
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
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
