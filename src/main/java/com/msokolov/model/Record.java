package com.msokolov.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {
	
	private final StringProperty name;
	private final StringProperty description;

	public Record(String name, String description) {
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public StringProperty descriptionProperty() {
		return description;
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
}
