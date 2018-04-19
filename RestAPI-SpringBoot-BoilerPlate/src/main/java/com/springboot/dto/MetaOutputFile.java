package com.springboot.dto;

public class MetaOutputFile {

    public String outputFileName;
    public String outputFileType;
    
	public MetaOutputFile() {}
	public MetaOutputFile(String outputFileName, String outputFileType) {
		this.outputFileName = outputFileName;
		this.outputFileType = outputFileType;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	public String getOutputFileType() {
		return outputFileType;
	}
	public void setOutputFileType(String outputFileType) {
		this.outputFileType = outputFileType;
	}
	@Override
	public String toString() {
		return "outputFileName=" + outputFileName + ", outputFileType=" + outputFileType;
	}
}