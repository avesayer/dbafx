package com.msokolov.controller;

import com.msokolov.model.Environment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SettingsController {

	@FXML private TextField name;
	@FXML private TextField sqlServer;
	@FXML private TextField mtmPort;
	@FXML private TextField user;
	@FXML private PasswordField password;

	@FXML
	private Button okButton;
	
	public void okButtonAction() {
		System.out.println("okButton");
		
		Stage stage = (Stage) okButton.getScene().getWindow();
		
		stage.close();
	}

	public Environment getEnvironment() {
		return new Environment(name.getText(), sqlServer.getText(), mtmPort.getText(), user.getText(), password.getText());
	}
}
