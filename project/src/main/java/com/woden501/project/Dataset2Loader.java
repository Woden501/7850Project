package com.woden501.project;

import com.woden501.project.utilities.DatasetUtilities;

public class Dataset2Loader {
	private String fileContents;

	public Dataset2Loader(String fileContents) {
		super();
		this.fileContents = DatasetUtilities.getContents("Autism-Adult-Data.arff");
	}

	public String getFileContents() {
		return fileContents;
	}

	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
}
