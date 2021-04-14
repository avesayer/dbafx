package com.msokolov.controller;

import javafx.fxml.FXML;
import javafx.stage.Window;

public class MainController {

	@FXML
	private MenuBarController menuBarController;
	
	@FXML
	private FileController fileTabController;

	@FXML private void initialize() {
		menuBarController.injectMainController(this);
		menuBarController.injectFileController(fileTabController);
    }

	public Window getWindow() {
		return fileTabController.getWindow();
	}

}
