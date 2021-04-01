package com.msokolov.controller;

import java.util.ArrayList;
import java.util.List;

import com.msokolov.model.Test;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestController {

	@FXML
	private TableView<Test> tblView;

	@FXML
	private TableColumn<Test, String> nameColumn;

	@FXML
	private TableColumn<Test, String> descColumn;


	@FXML
	public void initialize() {
		System.out.println("initialize");

		nameColumn.setCellValueFactory(new PropertyValueFactory<Test, String>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Test, String>("desc"));

		List<Test> list = new ArrayList<>();
		list.add(new Test("acn", "this is acn"));

		tblView.getItems().setAll(list);
	}
}
