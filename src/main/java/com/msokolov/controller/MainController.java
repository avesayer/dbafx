package com.msokolov.controller;

import javafx.fxml.FXML;
import javafx.stage.Window;

public class MainController {

	@FXML private MenuBarController menuBarController;
	@FXML private FileController fileTabController;
	// @FXML private GlobalController globalTabController;

	@FXML private void initialize() {
		fileTabController.injectMainController(this);
		menuBarController.injectMainController(this);
    }

	public Window getWindow() {
		return fileTabController.getWindow();
	}

}
