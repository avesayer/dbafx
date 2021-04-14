package com.msokolov.model;

public class File {
	
	private String fileName;
	private String primaryKeys;
	private String description;
	private String globalName;
	private String globalReference;
	private String defaultDataItemList;
	private String requiredDataItemList;
	private String lastUpdated;
	private String userID;
	
	private String fileDocumentation = "";

	public File(String fileName, String primaryKeys, String description, String globalName, String globalReference,
			String defaultDataItemList, String requiredDataItemList, String lastUpdated, String userID,
			String fileDocumentation) {
		this.fileName = fileName;
		this.primaryKeys = primaryKeys;
		this.description = description;
		this.globalName = globalName;
		this.globalReference = globalReference;
		this.defaultDataItemList = defaultDataItemList;
		this.requiredDataItemList = requiredDataItemList;
		this.lastUpdated = lastUpdated;
		this.userID = userID;
		this.fileDocumentation = fileDocumentation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(String primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public String getGlobalReference() {
		return globalReference;
	}

	public void setGlobalReference(String globalReference) {
		this.globalReference = globalReference;
	}

	public String getDefaultDataItemList() {
		return defaultDataItemList;
	}

	public void setDefaultDataItemList(String defaultDataItemList) {
		this.defaultDataItemList = defaultDataItemList;
	}

	public String getRequiredDataItemList() {
		return requiredDataItemList;
	}

	public void setRequiredDataItemList(String requiredDataItemList) {
		this.requiredDataItemList = requiredDataItemList;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFileDocumentation() {
		return fileDocumentation;
	}

	public void setFileDocumentation(String fileDocumentation) {
		this.fileDocumentation = fileDocumentation;
	}

	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", description=" + description + "]\n";
	}

}
