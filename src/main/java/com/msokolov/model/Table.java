package com.msokolov.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {
	
	private SimpleStringProperty name = new SimpleStringProperty("");
	private SimpleStringProperty description = new SimpleStringProperty("");

	public Table() {
		this("", "");
	}

	public Table(String name, String description) {
		this.name.set(name);
		this.description.set(description);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}

	public StringProperty nameProperty() {
        return name;
    }

	public StringProperty descriptionProperty() {
        return description;
    }
}
