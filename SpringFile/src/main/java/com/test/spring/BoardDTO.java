package com.test.spring;

import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {

	private String seq;
	private String title;
	private String regdate;
	private List<FileDTO> files;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public List<FileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}
	
}
