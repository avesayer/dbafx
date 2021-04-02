package com.msokolov.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SettingsController {

	@FXML
	private Button okButton;
	
	public void okButtonAction() {
		System.out.println("okButton");
		
		Stage stage = (Stage) okButton.getScene().getWindow();
		
		stage.close();
	}
}
